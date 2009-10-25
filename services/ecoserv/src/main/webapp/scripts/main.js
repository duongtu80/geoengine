function initPanels() {
	var modelsPanel = new Ext.Panel( {
//		title : 'Models',
		collapsible : false,
		layout : 'table',
		layoutConfig : {
			columns : 2
		},
		renderTo : 'modelsPanel',
		width : 980,
		tbar : [ {
			title : 'Water',
			xtype : 'buttongroup',
			columns : 2,
			defaults : {
				scale : 'small'
			},
			items : [ {
				id: 'modelWaterStorage',
				text : 'Water Storage',
				iconCls : 'waterCls',
				handler : single_water_storage
			}, {
				text : 'Soil Erosion',
				iconCls : 'soilCls',
				handler : runModel
			}, {
				text : 'Water Quality (Nutrients)',
				iconCls : 'waterCls',
				handler : runModel
			}, {
				text : 'Ground Water',
				iconCls : 'waterCls',
				handler : runModel
			} ]
		}, {
			title : 'Plants, Soils, and GHG Emissions',
			xtype : 'buttongroup',
			columns : 2,
			defaults : {
				scale : 'small'
			},
			items : [ {
				text : 'Floristic Quality',
				iconCls : 'waterCls',
				handler : runModel
			}, {
				text : 'Biomass',
				iconCls : 'waterCls',
				handler : runModel
			}, {
				text : 'Carbon Sequestration',
				iconCls : 'waterCls',
				handler : runModel
			}, {
				text : 'Greenhouse Gases (GHG)',
				iconCls : 'waterCls',
				handler : runModel
			} ]
		}, {
			title : 'Wildlife',
			xtype : 'buttongroup',
			columns : 2,
			defaults : {
				scale : 'small'
			},
			items : [ {
				text : 'Amphibians',
				iconCls : 'waterCls',
				handler : runModel
			}, {
				text : 'Waterfowl',
				iconCls : 'waterCls',
				handler : runModel
			}, {
				text : 'Shorebirds',
				iconCls : 'waterCls',
				handler : runModel
			}, {
				text : 'Pollinators',
				iconCls : 'waterCls',
				handler : runModel
			} ]
		} ],
		items : []
	});
	
	new Ext.ToolTip({
        target: 'modelWaterStorage',
        width: 400,
        closable: true,
        autoLoad: {url: '/ecoserv/models/water_storage.html'},
        dismissDelay: 15000 // auto hide after 15 seconds
    });
}

function runModel(obj){
	Ext.Msg.alert(obj.text);
}
