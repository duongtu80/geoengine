var map;

function Main() {
	// this.map = new Map();
	this.utils = new Utils();
	this.progressQueue = new ProgressQueue();
	this.settingWindow = initModelSetting();
	this.model = new Model();
	this.map = new Maps(-99.096349011162, 47.1, 14);

	this.init = function() {
		// this.map.init();
		this.map.initialize();

		this.mainPanel = new Ext.Panel( {
			title : '',
			collapsible : false,
			renderTo : 'mainPanel',
			width : 1000,
			// items : [ this.initMapPanel() ],
			items : [ {
				collapsible : false,
				layout : 'table',
				layoutConfig : {
					columns : 2
				},
				items : [ this.initMultipleMaps() ],
				tbar : this.initMapToolBar(),
				bbar : this.initMapStatusBar()
			}, {
				id : 'panelOutput',
				// title : 'Output',
				height : 460,
				xtype : 'panel',
				tbar : [ '-' ],
				collapsed : true,
				bbar : [ {
					text : 'Download',
					iconCls : 'downloadCls',
					scope : this,
					handler : this.downloadData
				}, {
					text : 'Calculate Water Surface',
					iconCls : 'downloadCls',
					scope : this,
					handler : this.calWaterSurface
				} ],
				html : '<div>Simulation result...</div>'
			} ],
			tbar : [ {
				text : '<b>EcoServ Simulation</b>'
			}, '->', {
				text : 'Land Cover Editor',
				iconCls : 'loadLandCoverCls',
				scope : this,
				handler : function() {
					window.open('~landcover.do');
				}
			}, {
				text : 'Login',
				iconCls : 'logginCls',
				scope : this,
				handler : function() {
					Ext.Msg.alert('Login...');
				}
			}, {
				text : 'Help',
				iconCls : 'helpCls',
				scope : this,
				handler : function() {
					window.open('http://ecoserv.pbworks.com/');
				}
			} ]
		});

		this.results = [];

		this.utils.init();
		this.progressQueue.init(this);
		this.model.init(this);
		this.map.resetExtent();

		// this.progressQueue.pushTask('test',
		// 'http://127.0.0.1:59080/ecoserv/_loadScenario.do', null, this,
		// this.initOutput);

		// this.map.map.setCenter(this.map.transformGeo(new OpenLayers.LonLat(
		// -99.096349011162, 47.103407185113)), 12);

		// this.progressQueue.pushProcess('Load catchments',
		// this.map.loadCatchments, null);
		// this.progressQueue.pushProcess('Load models', wetland.loadWpsModel,
		// null);
	};

	this.downloadData = function() {
		var _store = this.loadScenarioData();

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
			displayField : 'title'
		});

		var _win = new Ext.Window(
				{
					layout : 'fit',
					title : 'Download Simulation Result',
					width : 500,
					height : 200,
					closeAction : 'hide',
					plain : true,
					items : new Ext.FormPanel( {
						bodyStyle : 'padding:5px; background-color: #FFFFFF;',
						border : false,
						labelAlign : 'right',
						items : [ _combo ]
					}),

					buttons : [
							{
								text : 'Download',
								scope : this,
								handler : function() {
									var _val = _combo.store
											.getAt(_combo.selectedIndex);
									if (!_val) {
										Ext.Msg
												.alert('Warning',
														'Please select a item from the list');
										return;
									}
									window.open('_download.do?txt=' + _val
											.get('id'));
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
	};

	this.loadScenarioData = function() {
		var _data = [];

		var _toolbar = Ext.getCmp('panelOutput').getTopToolbar();
		var _t = _toolbar.find('isScenario', true);

		for ( var i = 0; i < _t.length; i++) {
			_data.push( [ _t[i].dataId, _t[i].text ]);
		}

		var _store = new Ext.data.ArrayStore( {
			idIndex : 0,
			fields : [ 'id', 'title' ],
			data : _data
		});

		return _store;
	};

	this.calWaterSurface = function() {
		var _store = this.loadScenarioData();

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
			displayField : 'title'
		});
		
		var _dateField = new Ext.form.DateField({
			fieldLabel : 'Date',
			width : 120
		});
		
		var _valueField = new Ext.form.DisplayField({
			fieldLabel : ' ',
			hidden: true,
			labelSeparator: '',
			width : 100
			});
		
		var _form = new Ext.FormPanel( {
			bodyStyle : 'padding:5px; background-color: #FFFFFF;',
			border : false,
			labelAlign : 'right',
			items : [ _combo, _dateField, _valueField, {
				fieldLabel : 'Map', 
				xtype: 'radiogroup',
				width : 150,
				items: [
		                {boxLabel: 'Left', name: 'map', inputValue: 'left', checked: true},
		                {boxLabel: 'Right', name: 'map', inputValue: 'right'}
		            ]
			} ]
		});

		var _win = new Ext.Window(
				{
					layout : 'fit',
					title : 'Calculate Water Surface',
					width : 500,
					height : 200,
					closeAction : 'hide',
					plain : true,
					items : _form,
					buttons : [
							{
								text : 'Calculate',
								scope : this,
								handler : function() {
									var _val = _combo.store
											.getAt(_combo.selectedIndex);
									if (!_val) {
										Ext.Msg
												.alert('Warning',
														'Please select a item from the list');
										return;
									}
									
									//* Change this to real value later
									var _waterTable = Math.floor(Math.random() * 15 * 100) / 100;
									
									_valueField.setValue(_waterTable + 'm');
									_valueField.setHeight(13);
									
									_valueField.show();
									
									console.debug('Scenario:' + _val.get('id'));
									console.debug('Date:' + _dateField.getValue());
									console.debug('Value:' + _valueField.getValue());
									console.debug('Map:' + _form.getForm().getValues().map);
									
									var _params = {'scenario': _val.get('id'), 'date': _dateField.getValue().getTime()};
									var _map = this.map.maps[0];
									if(_form.getForm().getValues().map == 'right')
										_map = this.map.maps[1];
									
									main.progressQueue.pushTask(
											'Calculate water surface',
											'_calWaterSurface.do', {
												param : Ext.encode(_params)
											}, _map, main.map.parseWaterTable);
									
//									_win.hide();
								}
							}, {
								text : 'Close',
								handler : function() {
									_win.hide();
								}
							} ]
				});
		_win.show();
	};

	this.initOutput = function(response) {
		var _p = Ext.decode(response.responseText);
		var _name = _p.scenarios[0];

		if (!this.chartParams) {
			this.chartParams = _p.params;
		}

		var _panel = Ext.getCmp('panelOutput');
		var _toolbar = _panel.getTopToolbar();

		var _t = _toolbar.find('text', _name);
		for ( var i = 0; i < _t.length; i++) {
			_toolbar.remove(_t[i]);
			_t[i].destroy();
		}
		this.results.remove(_name);

		// Add the result to result collection
		this.results.push(_name);
		_toolbar.add( {
			text : _name,
			pressed : true,
			isScenario : true,
			dataId : _p.id,
			scope : this,
			handler : function(b, e) {
				b.toggle();
				this.updateResult();
			}
		});

		this.updateResult();
	};

	this.updateResult = function() {
		var _panel = Ext.getCmp('panelOutput');
		var _toolbar = _panel.getTopToolbar();

		var _outputs = [];
		for ( var i = 0; i < this.results.length; i++) {
			_t = _toolbar.find('text', this.results[i]);
			if (_t.length > 0) {
				if (_t[0].pressed) {
					_outputs.push(_t[0].dataId);
				}
			}
		}

		var _html = '';
		if (_outputs.length == 0) {
			_html = '<div>No result has been selected</div>';
		} else {
			var _txt = '';
			_txt += '<tr><td class="chartCell" rowspan="4"><img class="chartSpider" src="_loadSpiders.do?' + Ext
					.urlEncode( {
						'txt' : _outputs.join(',')
					}) + '" /></td>';
			for ( var i = 0; i < this.chartParams.length; i++) {
				if (i % 3 == 0 && i > 0) {
					_txt += '<tr>';
				}
				_txt += '<td class="chartCell"><img class="chartImage " onclick="main.showChart(\''
						+ _outputs.join(',')
						+ '\', \''
						+ this.chartParams[i]
						+ '\');" class="chartImage" src="_loadParams.do?'
						+ Ext.urlEncode( {
							'param' : this.chartParams[i],
							'txt' : _outputs.join(',')
						}) + '"/></td>';
				if (i % 3 == 2) {
					_txt += '</tr>';
				}
			}
			_html = '<table class="chartPanel">' + _txt + '</table>';
		}

		_panel.body.update(_html);
		_panel.doLayout();

		if (_panel.collapsed == true && _outputs.length > 0) {
			_panel.expand(true);
		}
	};

	this.showChart = function(ids, param) {
		this.progressQueue.pushTask('Load Time Line Chart',
				'_loadParamData.do', {
					txt : ids,
					param : param
				}, this, function(response) {
					var _p = Ext.decode(response.responseText);

					var _data = new google.visualization.DataTable();

					// Add columns
				_data.addColumn('date', 'Date');

				var i = 0;
				for (i = 0; i < _p.columns.length; i++) {
					_data.addColumn('number', _p.columns[i]);
				}

				// Add rows
				_data.addRows(_p.data.length);

				var _r = 0;
				for (_r = 0; _r < _p.data.length; _r++) {
					_data.setValue(_r, 0, new Date(_p.data[_r][0]));

					for (i = 0; i < _p.columns.length; i++) {
						if (_p.data[_r][i] != -9999) {
							_data.setValue(_r, i + 1, _p.data[_r][i + 1]);
						}
					}
				}

				var _colors = _p.colors[i];

				var _panel = new Ext.FormPanel( {
					bodyStyle : 'padding:5px; background-color: #FFFFFF;',
					region : 'center',
					style : 'width: 100%; height: 100%;',
					border : false,
					items : []
				});

				var _win = new Ext.Window( {
					layout : 'border',
					title : 'Model Result',
					width : 700,
					height : 400,
					closeAction : 'hide',
					buttonAlign : 'right',
					plain : true,
					items : _panel,
					buttons : [ {
						text : 'Close',
						handler : function() {
							_win.hide();
						}
					} ]
				});
				_win.show();

				// Create chart
				var _chart = new google.visualization.AnnotatedTimeLine(
						document.getElementById(_panel.getId()));
				_chart.draw(_data, {
					displayAnnotations : true,
					colors : _colors
				});
			});
	};

	this.initOutputPanel = function() {
		this.mainPanel = new Ext.Panel( {
			title : 'Output',
			collapsible : false,
			layout : 'table',
			layoutConfig : {
				columns : 5
			},
			items : []
		});
	};

	this.initMultipleMaps = function() {
		var _panels = [];
		for ( var i = 0; i < this.map.maps.length; i++) {
			_panels.push(this.initMultipleMapPanel(this.map.maps[i]));
		}

		return _panels;
	};

	this.initMultipleMapPanel = function(map) {
		var mapPanel = new GeoExt.MapPanel( {
			id : map.id,
			// title : map.title,
			height : 400,
			width : 500,
			map : map,
			items : [ {
				xtype : 'gx_zoomslider',
				vertical : true,
				height : 100,
				x : 10,
				y : 20,
				plugins : new GeoExt.ZoomSliderTip()
			} ],
			tbar : [ {
				text : 'Layers',
				iconCls : 'layersCls',
				map : map,
				handler : function() {
					main.selectLandcover(this.map);
				}
			}, new Ext.Toolbar.Separator() ]
		});

		return mapPanel;
	};

	this.selectLandcover = function(map) {
		var _store = new Ext.data.JsonStore( {
			root : 'landcover',
			idProperty : 'id',
			fields : [ 'title', 'id' ],
			url : 'landcover/_listLand.do?username=' + username
		});
		_store.load();

		var _combo = new Ext.form.ComboBox( {
			fieldLabel : 'Land Cover',
			typeAhead : true,
			forceSelection : true,
			name : 'landcover',
			triggerAction : 'all',
			lazyRender : true,
			mode : 'local',
			store : _store,
			valueField : 'id',
			displayField : 'title'
		});

		var _win = new Ext.Window(
				{
					layout : 'fit',
					title : 'Load Land Cover Scenario',
					width : 500,
					height : 200,
					closeAction : 'hide',
					plain : true,
					items : new Ext.FormPanel( {
						bodyStyle : 'padding:5px; background-color: #FFFFFF;',
						border : false,
						labelAlign : 'right',
						items : [ _combo ]
					}),

					buttons : [
							{
								text : 'Load',
								scope : this,
								handler : function() {
									var _val = _combo.store
											.getAt(_combo.selectedIndex);
									if (!_val) {
										Ext.Msg
												.alert('Warning',
														'Please select a item from the list');
										return;
									}
									_win.hide();

									main.progressQueue.pushTask(
											'Load Land Cover Sceniaro',
											'landcover/_loadLand.do', {
												id : _val.get('id')
											}, map, main.map.parseLandcover);
								}
							}, {
								text : 'Close',
								handler : function() {
									_win.hide();
								}
							} ]
				});
		_win.show();
	};

	this.initMapPanel = function() {
		this.mapPanel = new GeoExt.MapPanel( {
			id : 'mapMain',
			height : 500,
			width : 1000,
			map : map,
			items : [ {
				xtype : "gx_zoomslider",
				vertical : true,
				height : 200,
				x : 10,
				y : 20,
				plugins : new GeoExt.ZoomSliderTip()
			} ]
		});

		return this.mapPanel;
	};

	this.initMapToolBar = function() {
		var _store = new Ext.data.JsonStore( {
			root : 'landcover',
			idProperty : 'id',
			fields : [ 'title', 'id' ],
			url : 'landcover/_listLand.do?username=' + username
		});
		_store.load();

		var _landcover = new Ext.form.ComboBox( {
			id : 'modelLandCover',
			fieldLabel : 'Land Cover',
			typeAhead : true,
			forceSelection : true,
			name : 'landcover',
			triggerAction : 'all',
			lazyRender : true,
			width : 120,
			mode : 'local',
			store : _store,
			valueField : 'title',
			displayField : 'title'
		});

		var _bar = new Ext.Toolbar( {
			title : 'Navigation',
			// columns : 9,
			defaults : {
				scale : 'small'
			},
			items : [ {
				title : ' ',
				xtype : 'buttongroup',
				// width : 200,
				// columns : 10,
				items : [ {
					title : 'Navigate',
					isTool : true,
					toolGroup : 'navigation',
					toolName : 'navigation',
					map : this.map,
					iconCls : 'mapPanCls',
					handler : this.toolInvoke
				}, new Ext.Toolbar.Separator(), {
					text : 'Reset',
					iconCls : 'mapResetExtentCls',
					scope : this,
					handler : function() {
						this.map.resetExtent();
					}
				}, {
					// text : 'Previous',
					iconCls : 'mapPreviousCls',
					scope : this,
					handler : function() {
						this.map.previousExtent();
					}
				}, {
					// text : 'Next',
					iconCls : 'mapNextCls',
					scope : this,
					handler : function() {
						this.map.nextExtent();
					}
				} /*
					 * , new Ext.Toolbar.Separator(), { text : 'Select', isTool :
					 * true, toolGroup : 'navigation', toolName :
					 * 'selectFeature', map : this.map, iconCls :
					 * 'mapZoomoutCls', handler : this.toolInvoke }
					 */]
			}, {
				title : ' ',
				// columns : 10,
				xtype : 'buttongroup',
				items : [ {
					text : 'Setting',
					iconCls : 'modelHydroCls',
					scope : this,
					handler : function() {
						this.settingWindow.show();
					}
				}, new Ext.Toolbar.Separator(), {
					text : 'Period:',
					xtype : 'tbtext'
				}, {
					id : 'modelRunStartDate',
					xtype : 'datefield',
					value : '1998-01-01'
				}, {
					text : '-',
					xtype : 'tbtext'
				}, {
					id : 'modelRunEndDate',
					value : '2002-12-01',
					xtype : 'datefield'
				}, new Ext.Toolbar.Separator(), {
					text : 'Region:',
					xtype : 'tbtext'
				}, {
					id : 'modelRunWetland',
					xtype : 'combo',
					width : 100,
					typeAhead : true,
					triggerAction : 'all',
					lazyRender : true,
					mode : 'local',
					store : new Ext.data.ArrayStore( {
						id : 0,
						fields : [ 'myId', 'displayText' ],
						data : [ [ 'basin1', 'Basin 1' ] ]
					}),
					value : 'basin1',
					valueField : 'myId',
					displayField : 'displayText'
				}, new Ext.Toolbar.Separator(), {
					text : 'Land Cover:',
					xtype : 'tbtext'
				}, _landcover, {
					text : 'Run',
					iconCls : 'modelWaterfowlCls',
					scope : this.model,
					handler : this.model.runModel
				} ]
			} ]
		});

		_bar.cascade(this.toolConnect, this);

		return _bar;
	};

	this.toolConnect = function(c) {
		if (c.isTool == true) {
			for ( var i = 0; i < this.map.maps[0].controls.length; i++) {
				var _c = this.map.maps[0].controls[i];
				if (_c.tid == c.toolName) {
					c.pressed = _c.active;
					// c.toggle(_c.active);

					_c.events.register("activate", c, this.activateEvent);
					_c.events.register("deactivate", c, this.deactivateEvent);

					break;
				}
			}
		}
	};

	this.activateEvent = function(object, element) {
		this.toggle(true);
	};

	this.deactivateEvent = function(object, element) {
		this.toggle(false);
	};

	this.toolInvoke = function() {
		// alert(this.toolGroup + '|' + this.toolName);
		for ( var i = 0; i < this.map.maps.length; i++) {
			var _m = this.map.maps[i];
			for ( var j = 0; j < _m.controls.length; j++) {
				if (_m.controls[j].group != this.toolGroup)
					continue;

				if (_m.controls[j].tid != this.toolName) {
					_m.controls[j].deactivate();
				} else {
					_m.controls[j].activate();
				}
			}
		}
	};

	this.initMapStatusBar = function() {
		// this.map.events.register("mousemove", this.map, function(e) {
		// var _panel = Ext.getCmp('statusCoordination');
		// if (_panel) {
		// var position = this.map.getLonLatFromPixel(e.xy).transform(
		// map.projection, map.displayProjection);
		// _panel.setText(position.lon.toFixed(3) + ', '
		// + position.lat.toFixed(3));
		// }
		// });

		return {
			defaultText : 'Ready',
			text : 'Ready',
			iconCls : 'x-status-valid',
			items : [ {
				text : 'Ready',
				width : 300,
				id : 'statusStatus',
				xtype : 'tbtext'
			}, '-', {
				text : '',
				width : 100,
				id : 'statusCoordination',
				xtype : 'tbtext'
			} ]
		};
	};
};

var main = new Main();
Ext.onReady(function() {
	main.init();
});