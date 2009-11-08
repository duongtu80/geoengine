var map, vector, vector2;
var controls_edit = [];

function loadLandCover(id) {
	vector.removeFeatures(vector.features);
	if (typeof vector2 != 'undefined') {
		map.removeLayer(vector2);
		delete vector2;
	}

	map.wait('Load Landcover');
	Ext.Ajax.request( {
		url : 'landcover/_loadLand.do?id=' + id,
		failure : function(response, opts) {
			map.unwait();
		},
		success : function(response, opts) {
			//Parse data
			var _data = Ext.util.JSON.decode(response.responseText);

			//Create and add pixels
			var features = [];
			var featureCol = [];
			vector.store = _data;

			var _pos = 0;
			var startY = _data.maxy;
			for ( var y = 0; y < _data.height; y++) {
				var startX = _data.minx;
				for ( var x = 0; x < _data.width; x++) {
					if (_data.data[_pos] != 0) {
						var poly = new OpenLayers.Bounds(startX, startY
								- _data.celly, startX + _data.cellx, startY)
								.toGeometry().transform(map.displayProjection,
										map.projection);
						var feature = new OpenLayers.Feature.Vector(poly, {
							'v' : _data.data[_pos]
						});
						features.push(feature);
						featureCol.push(feature);
					} else {
						featureCol.push(null);
					}
					_pos++;
					startX += _data.cellx;
				}
				startY -= _data.celly;
			}
			vector.addFeatures(features);
			vector.featureCol = featureCol;

			map.removeLayer(vector);
			//Add boundary layer
			vector2 = new OpenLayers.Layer.Boxes("LandcoverBox", {
				'displayInLayerSwitcher' : false,
				'visibility' : false
			});
			vector2.addMarker(new OpenLayers.Marker.Box(new OpenLayers.Bounds(
					_data.minx, _data.maxy - _data.height * _data.celly,
					_data.minx + _data.width * _data.cellx, _data.maxy),
					'#08a2fb', 1));
			map.addLayer(vector2);
			map.addLayer(vector);

			map.unwait();
			map.zoomToExtent(new OpenLayers.Bounds(_data.minx, _data.miny,
					_data.maxx, _data.maxy).transform(map.displayProjection,
					map.projection), true);
		}
	});
}

function mapInit() {
	var options = {
		projection : new OpenLayers.Projection("EPSG:900913"),
		displayProjection : new OpenLayers.Projection("EPSG:4326"),
		units : "m",
		maxExtent : new OpenLayers.Bounds(-20037508.34, -20037508.34,
				20037508.34, 20037508.34),
		controls : [ new OpenLayers.Control.Navigation() ]
	};

	map = new OpenLayers.Map(options);

	//Create functions for progressing
	map.wait = function(title) {
		this.waiting = Ext.Msg.wait(title + '...');
	};

	map.unwait = function() {
		if (this.waiting != null) {
			this.waiting.hide();
			this.waiting = null;
		}
	};

	var _layer = new OpenLayers.Layer.Google("Satellite", {
		type : G_SATELLITE_MAP,
		numZoomLevels : 30,
		sphericalMercator : true
	});
	map.addLayer(_layer);
	
	map.addLayer(new OpenLayers.Layer.GML(
			"Catchment",
			"/geoserver/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=geo:basin&maxFeatures=50&outputFormat=GML2",
			{
				projection : new OpenLayers.Projection("EPSG:4326")
			}));

	map.addControl(new OpenLayers.Control.LayerSwitcher());
	var layer_select = OpenLayers.Util.extend( {},
			OpenLayers.Feature.Vector.style['select']);
	layer_select.fillOpacity = 1;
	//    layer_select.strokeColor = "#634c0b";
	layer_select.strokeWidth = 0.5;
	layer_select.strokeColor = "#ffa218";
	layer_select.fillColor = "#ff6718";

	var layer_style = OpenLayers.Util.extend( {},
			OpenLayers.Feature.Vector.style['default']);
	layer_style.fillOpacity = 1;
	layer_style.strokeColor = "#333333";
	layer_style.strokeWidth = 0.2;

	var lookup = {
		0 : {
			fillColor : '#FFFFFF'
		},
		1 : {
			fillColor : '#308ee3'
		},
		2 : {
			fillColor : '#dde737'
		},
		3 : {
			fillColor : '#149441'
		},
		4 : {
			fillColor : '#abf95b'
		},
		5 : {
			fillColor : '#c96ee3'
		},
		6 : {
			fillColor : '#6f985c'
		}
	};

	var _styleMap = new OpenLayers.StyleMap( {
		'default' : layer_style,
		'select' : layer_select
	});
	_styleMap.addUniqueValueRules("default", "v", lookup);

	vector = new OpenLayers.Layer.Vector("Landcover", {
		'styleMap' : _styleMap
	});
	vector.setOpacity(0.6);

	vector.events.register("move", vector, function(object, element) {
		if (vector2)
			vector2.setVisibility(true);

		vector.display(false);
	});

	vector.events.register("moveend", vector, function(object, element) {
		if (vector2)
			vector2.setVisibility(false);

		vector.display(true);
	});

	map.addLayer(vector);

	toolSelection = new OpenLayers.Control.SelectFeature(vector, {
		clickout : false,
		toggle : false,
		multiple : true,
		hover : false,
		toggleKey : "ctrlKey", // ctrl key removes from selection
		multipleKey : "shiftKey", // shift key adds to selection
		box : true
	});

	magicSelection = new OpenLayers.Control( {
		'layer' : vector
	});
	magicSelection.handler = new OpenLayers.Handler.Click(magicSelection, {
		'click' : function(e) {
			map.wait('Select area');
			toolSelection.unselectAll.call(toolSelection);
			var _f = this.layer.getFeatureFromEvent(e);
			for ( var i = 0; i < this.layer.featureCol.length; i++) {
				var _ff = this.layer.featureCol[i];
				if (_ff != null && _ff.id == _f.id) {
					toolSelection.select.call(toolSelection, _ff);
					var _list = [ i ];
					this.selectNeighbor(i, this.layer.store, _list);
					break;
				}
			}
			map.unwait();
		}
	}, {
		'single' : true,
		'double' : false,
		'pixelTolerance' : 0,
		'stopSingle' : false,
		'stopDouble' : false
	});

	magicSelection.selectNeighbor = function(pos, store, list) {
		if (pos < 0)
			return;

		var _row = Math.floor(pos / store.width);
		var _col = pos % store.width;

		for ( var _r = (_row - 1 >= 0 ? _row - 1 : 0); _r <= (_row + 1 < store.height ? _row + 1
				: store.height - 1); _r++) {
			for ( var _c = (_col - 1 >= 0 ? _col - 1 : 0); _c <= (_col + 1 < store.width ? _col + 1
					: store.width - 1); _c++) {
				var _pos = _r * store.width + _c;
				if (_pos < 0 || _pos == pos)
					continue;
				if (_pos >= store.data.length)
					continue;
				if (store.data[_pos] == 0)
					continue;

				if (store.data[_pos] == store.data[pos]
						&& list.indexOf(_pos) < 0
						&& this.layer.featureCol[_pos]) {
					toolSelection.select.call(toolSelection,
							this.layer.featureCol[_pos]);
					list.push(_pos);

					//console.log(' add ' + Math.floor(_pos / store.width) + ' * ' + _pos % store.width);
					this.selectNeighbor(_pos, store, list);
				}
			}
		}

	};

	toolSelection.ctrl_id = 'select';
	magicSelection.ctrl_id = 'magic';

	toolSelection.title = 'Free';
	magicSelection.title = 'Magic';

	map.addControl(toolSelection);
	map.addControl(magicSelection);

	controls_edit.push(toolSelection);
	controls_edit.push(magicSelection);

	for ( var i = 0; i < controls_edit.length; i++) {
		controls_edit[i].events.register("activate", controls_edit[i],
				function(object, element) {
					Ext.getCmp('menu_editor_' + object.object.ctrl_id)
							.setIconClass(object.object.ctrl_id + 'Cls_s');
				});

		controls_edit[i].events.register("deactivate", controls_edit[i],
				function(object, element) {
					Ext.getCmp('menu_editor_' + object.object.ctrl_id)
							.setIconClass(object.object.ctrl_id + 'Cls');
				});
	}

	var mainPanel = new Ext.Panel( {
		title : 'Main',
		collapsible : false,
		layout : 'table',
		layoutConfig : {
			columns : 2
		},
		renderTo : 'mainPanel',
		width : 1000,
		items : [ initMapPanel() ]
	});

	map.setCenter(new OpenLayers.LonLat(-99.096349011162, 47.1)
			.transform(map.displayProjection, map.projection), 15);
}

function initMapPanel() {
	var clearAction = new Ext.Button( {
		text : 'Clear',
		iconCls : 'clearCls',
		handler : function() {
			clearSelection();
		}
	});

	var loadAction = new Ext.Button(
			{
				text : 'Load',
				iconCls : 'loadCls',
				handler : function() {
					var _store = new Ext.data.JsonStore( {
						root : 'landcover',
						idProperty : 'id',
						fields : [ 'title', 'id' ],
						url : 'landcover/_listLand.do?username=' + username
					});
					_store.load();

					var _combo = new Ext.form.ComboBox( {
						fieldLabel : 'Scenario',
						typeAhead : true,
						forceSelection : true,
						name : 'landcover',
						triggerAction : 'all',
						lazyRender : true,
						mode : 'local',
						store : _store,
						valueField : 'id',
						cls : 'align-right',
						displayField : 'title'
					});

					var _form = new Ext.FormPanel(
							{
								bodyStyle : 'padding:5px; background-color: #FFFFFF;',
								border : false,
								items : [ _combo ]
							});
					
					var _win = new Ext.Window(
							{
								layout : 'fit',
								title : 'Load Scenario',
								width : 500,
								height : 200,
								closeAction : 'hide',
								plain : true,
								items : _form,
								buttons : [
										{
											text : 'Load',
											handler : function() {
												var _val = _combo.store
														.getAt(_combo.selectedIndex);
												if (!_val) {
													Ext.Msg
															.alert('Warning',
																	'Please select a item from the list');
													return;
												}

												loadLandCover(_val.get('id'));
												_win.hide();
											}
										}, {
											text : 'Close',
											handler : function() {
												_win.hide();
											}
										} ]
							});
					_win.show();
				}
			});

	var saveAction = new Ext.Button( {
		text : 'Save',
		iconCls : 'saveCls',
		handler : function() {
			saveLandCover();
		}
	});

	var downloadAction = new Ext.Button( {
		text : 'GeoTIFF',
		iconCls : 'downloadCls',
		handler : function() {
			downloadLandCover();
		}
	});

	var changeLandActions = [];

	var landcoverTypes = [ "Water", "Developed", "Forest", "Grass", "Crop",
			"Wetland" ];
	var landcoverCls = [ "waterCls", "developedCls", "forestCls", "grassCls",
			"cropCls", "wetlandCls" ];
	var landcoverColors = [ "#308ee3", "#dde737", "#149441", "#abf95b",
			"#c96ee3", "#6f985c" ];

	for ( var i = 0; i < landcoverTypes.length; i++) {
		changeLandActions[i] = new Ext.Button( {
			text : '<span style="background-color:' + landcoverColors[i]
					+ ';">' + landcoverTypes[i] + '</span>',
			iconCls : landcoverCls[i],
			landcover : i + 1,
			handler : function() {
				changeCover(this.landcover);
			}
		});
	}

	var _editMenus = [];
	for ( var i = 0; i < controls_edit.length; i++) {
		_editMenus.push( {
			id : 'menu_editor_' + controls_edit[i].ctrl_id,
			text : controls_edit[i].title,
			iconCls : controls_edit[i].ctrl_id + 'Cls',
			xtype : 'button',
			control : controls_edit[i],
			handler : function() {
				if (typeof (this.control) != 'undefined'
						&& this.control != null)
					toggleEditControls(this.control);
			}
		});

	}

	_editMenus.push(clearAction);

	//loadLandCover(-1);

	var mapPanel = new GeoExt.MapPanel( {
		id : 'mapMain',
		height : 600,
		width : 1000,
		tbar : [ {
			title : 'Scenarios',
			xtype : 'buttongroup',
			columns : 2,
			defaults : {
				scale : 'small'
			},
			items : [ {
				text : 'New',
				iconCls : 'newCls',
				handler : function() {
					loadLandCover(-1);
				}
			}, loadAction, saveAction, downloadAction ]
		}, {
			title : 'Selection',
			xtype : 'buttongroup',
			columns : 2,
			items : _editMenus
		}, {
			title : 'Transform',
			xtype : 'buttongroup',
			columns : 3,
			items : changeLandActions
		} ],
		map : map,
		items : [ {
			xtype : "gx_zoomslider",
			vertical : true,
			height : 100,
			x : 10,
			y : 20,
			plugins : new GeoExt.ZoomSliderTip()
		} ]
	});

	return mapPanel;
}

function toggleEditControls(ctl) {
	for ( var i = 0; i < controls_edit.length; i++) {
		if (controls_edit[i] == ctl) {
			if (!ctl.active) {
				ctl.activate();
			} else {
				ctl.deactivate();
			}
		} else {
			controls_edit[i].deactivate();
		}
	}
}

function clearSelection() {
	toolSelection.unselectAll();
}

function changeCover(type) {
	//	alert(vector.selectedFeatures.length);
	for ( var i = 0; i < vector.selectedFeatures.length; i++) {
		vector.selectedFeatures[i].attributes.v = type;
	}
	clearSelection();
}

function saveLandCover() {
	if(vector && vector.store){
	}
	else{
		Ext.Msg.alert('Warning', 'No scenario has been found. Please create/load a scenario before saving');
		return;
	}
	
	var _form = new Ext.FormPanel( {
		border : false,
		items : [ {
			fieldLabel : 'Scenario',
			name : 'txtSaveTitle',
			xtype : 'textfield',
			grow: true,
			growMax: 350,
			growMin: 100
		}, {
			fieldLabel : 'Note',
			name : 'txtSaveNote',
			xtype : 'textarea',
			width : 350,
			height : 100
		} ]
	});
	
	var _win = new Ext.Window(
			{
				layout : 'fit',
				title : 'Save Land Cover Scenario',
				width : 500,
				height : 230,
				bodyStyle : 'padding:5px; background-color: #FFFFFF;',
				closeAction : 'hide',
				items : _form,
				buttons : [
						{
							text : 'Save',
							handler : function() {
								var _data = createLandCover();

								var _vals = _form.getForm().getValues();
								_data.title =  _vals['txtSaveTitle'];
								_data.note = _vals['txtSaveNote'];

								map.wait('Save landcover');
								Ext.Ajax
										.request( {
											params : {
												data : Ext.util.JSON
														.encode(_data),
												'username' : username
											},
											url : 'landcover/_saveLand.do',
											failure : function(response, opts) {
												map.unwait();
											},
											success : function(response, opts) {
												var _data = Ext.util.JSON
														.decode(response.responseText);
												vector.store.id = _data.id;

												map.unwait();
												Ext.Msg
														.alert('Save',
																'The land cover scenario has been saved successfully');
												_win.hide();
											}
										});
							}
						}, {
							text : 'Close',
							handler : function() {
								Ext.destroy('txtSaveTitle');
								Ext.destroy('txtSaveNote');

								_win.hide();
							}
						} ]
			});
	_win.show();
}

function downloadLandCover() {
	if(vector && vector.store){
	}
	else{
		Ext.Msg.alert('Warning', 'No scenario has been found. Please create/load a scenario before downloading');
		return;
	}

	Ext.getDom('txtTiffFormData').value = Ext.util.JSON.encode(this
			.createLandCover());

	Ext.getDom('frmDownloadTiff').submit();
}

function createLandCover() {
	var _data = {};

	_data.id = vector.store.id;
	_data.minx = vector.store.minx;
	_data.miny = vector.store.miny;
	_data.maxx = vector.store.maxx;
	_data.maxy = vector.store.maxy;

	_data.cellx = vector.store.cellx;
	_data.celly = vector.store.celly;
	_data.width = vector.store.width;
	_data.height = vector.store.height;
	_data.title = vector.store.title;
	_data.note = vector.store.note;

	var _params = [];
	for ( var i = 0; i < vector.featureCol.length; i++) {
		if (vector.featureCol[i] == null) {
			_params.push(0);
		} else {
			_params.push(vector.featureCol[i].attributes.v);
		}
	}
	_data.data = _params;

	return _data;
}

Ext.onReady(function() {
	mapInit();
});