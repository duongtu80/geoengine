var map;

function Main() {
	// this.map = new Map();
	this.utils = new Utils();
	this.progressQueue = new ProgressQueue();
	this.settingWindow = initModelSetting();
	this.model = new Model();
	this.map = new Maps(-99.096349011162, 47.103407185113, 12);

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
			} ]
		});

		this.utils.init();
		this.progressQueue.init(this);
		this.model.init(this);

		this.map.resetExtent();

		this.progressQueue.pushTask('test',
				'http://127.0.0.1:59080/ecoserv/_loadScenario.do', null, this,
				this.initOutput);
		// this.map.map.setCenter(this.map.transformGeo(new OpenLayers.LonLat(
		// -99.096349011162, 47.103407185113)), 12);

		// this.progressQueue.pushProcess('Load catchments',
		// this.map.loadCatchments, null);
		// this.progressQueue.pushProcess('Load models', wetland.loadWpsModel,
		// null);
	};

	this.initOutput = function(response) {
		var _p = Ext.decode(response.responseText);

		var _txt = '';
		_txt += '<tr><td class="chartCell" rowspan="4"><img class="chartImage" src="_loadSpider.do?' + Ext.urlEncode({'txt': _p.id}) + '" /></td>';
		for ( var i = 0; i < _p.params.length; i++) {
			if(i%3 == 0 && i > 0){
				_txt += '<tr>';
			}
			_txt += '<td class="chartCell"><img class="chartImage" src="_loadParam.do?' + Ext.urlEncode( {
				'param' : _p.params[i], 'txt': _p.id
			}) + '"/></td>';
			if(i%3 == 2){
				_txt += '</tr>';
			}
		}

		var _html = '<table class="chartPanel">' + _txt + '</table>';
		var _panel = new Ext.Panel( {
			title : 'Output',
			heigth : 400,
			collapsible : false,
			// layout : 'table',
			// layoutConfig : {
			// columns : 5
			// },
			html : _html
		});

		this.mainPanel.add(_panel);
		this.mainPanel.doLayout();
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
			title : map.title,
			height : 350,
			width : 500,
			map : map,
			items : [ {
				xtype : 'gx_zoomslider',
				vertical : true,
				height : 100,
				x : 10,
				y : 20,
				plugins : new GeoExt.ZoomSliderTip()
			} ]
		});

		return mapPanel;
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
		var _bar = [ {
			// title : 'Navigation',
			xtype : 'buttongroup',
			// columns : 9,
			width : 200,
			defaults : {
				scale : 'small'
			},
			items : [ {
				text : 'Reset',
				iconCls : 'mapResetExtentCls',
				scope : this,
				handler : function() {
					this.map.resetExtent();
				}
			}, new Ext.Toolbar.Separator(), {
				text : 'Pan',
				iconCls : 'mapPanCls',
				scope : this,
				handler : function() {
					this.map.resetExtent();
				}
			}, new Ext.Toolbar.Separator(), {
				text : 'Previous',
				iconCls : 'mapPreviousCls',
				scope : this,
				handler : function() {
					this.map.resetExtent();
				}
			}, {
				text : 'Next',
				iconCls : 'mapNextCls',
				scope : this,
				handler : function() {
					this.map.resetExtent();
				}
			}, new Ext.Toolbar.Separator(), {
				text : 'Zoom',
				iconCls : 'mapZoominCls',
				scope : this,
				xtype : 'splitbutton',
				menu : [ {
					text : 'Zoomin',
					iconCls : 'mapZoominCls',
					scope : this,
					handler : function() {
						this.map.resetExtent();
					}
				}, {
					text : 'Zoomout',
					iconCls : 'mapZoomoutCls',
					scope : this,
					handler : function() {
						this.map.resetExtent();
					}
				} ]
			} ]
		}, {
			// title : 'Models',
			xtype : 'buttongroup',
			// columns : 10,
			defaults : {
				scale : 'small'
			},
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
				xtype : 'datefield'
			}, {
				text : '-',
				xtype : 'tbtext'
			}, {
				id : 'modelRunEndDate',
				xtype : 'datefield'
			}, new Ext.Toolbar.Separator(), {
				text : 'Wetland:',
				xtype : 'tbtext'
			}, {
				id : 'modelRunWetland',
				xtype : 'combo',
				typeAhead : true,
				triggerAction : 'all',
				lazyRender : true,
				mode : 'local',
				store : new Ext.data.ArrayStore( {
					id : 0,
					fields : [ 'myId', 'displayText' ],
					data : [ [ 'P1', 'P1' ], [ 2, 'item2' ] ]
				}),
				valueField : 'myId',
				displayField : 'displayText'
			}, {
				text : 'Run',
				iconCls : 'modelWaterfowlCls',
				handler : this.model.runModel
			} ]
		} ];

		return _bar;
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