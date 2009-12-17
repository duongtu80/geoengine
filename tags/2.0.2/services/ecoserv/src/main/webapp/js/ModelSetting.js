
function initModelSetting(){
	var tabs = new Ext.TabPanel(
			{
				activeTab : 0,
				frame : true,
				defaults : {
					autoHeight : true
				},
				items : [
						{
							title : 'Hydrology',
							xtype: 'panel',
							layout : 'table',
							iconCls: 'settingHydrologyCls',
							layoutConfig : {
								columns : 2,
								tableAttrs: {
									style: {
								        verticalAlign: 'top'
						        	}
						        }
							},
							defaults : {
								frame : false
							},
							items : [
									{
										bodyStyle : 'margin: 1px;padding:5px; border: 0px; line-height: 21px; background-color: #a1abc6;',
										width : 250,
										height: 450,
										html : '<img src="img/map/imgs/hcycle.png"></img><p>Wetland hydrological model simulates Evapotranspiration (ET), water table change, and water surface area dynamics in wetlands withing a given time period.</p><div style="text-align: right;"><a href="http://ecoserv.pbworks.com/Water-Storage" target="_blank">Read more</a></div>'
									}, {
										xtype : 'form',
										bodyStyle : 'padding:15px; border: 0px;',
										labelAlign: 'right',
										labelSeparator: '',
										labelWidth: 90,
										height: 450,
										defaults: {
											
										},
										items : [ {
											fieldLabel : 'DayMet',
											xtype : 'textfield',
											name : 'albedo',
											width: '250',
											value: 'http://www.daymet.org/getRawData.do?lon=%f&lat=%f'
										}, {
											fieldLabel : 'Albedo',
											xtype : 'textfield',
											name : 'albedo',
											value: '0.08'
										}, {
											fieldLabel : 'Wind Speed',
											xtype : 'textfield',
											name : 'windSped',
											value: '1'
										}, {
											fieldLabel : 'Coefficient',
											xtype : 'textfield',
											name : 'coefficient',
											value: '1.2'
										}, {
											fieldLabel : 'Saturation Prcp',
											xtype : 'textfield',
											name : 'saturationPrcp',
											value: '0.003'
										} ]
									} ]
						}, {
							title : 'Waterfowl',
							iconCls: 'settingWaterfowlCls',
							xtype: 'panel',
							layout : 'table',
							iconCls: 'settingHydrologyCls',
							layoutConfig : {
								columns : 2,
								tableAttrs: {
									style: {
								        verticalAlign: 'top'
						        	}
						        }
							},
							defaults : {
								frame : false
							},
							items : [
									{
										bodyStyle : 'margin: 1px;padding:5px; border: 0px; line-height: 21px; background-color: #a1abc6;',
										width : 252,
										height: 450,
										html : '<img src="img/map/imgs/WaterFowls.jpg"></img><p>Waterfowls model simulates the number of breeding pairs for waterfowl species defined by the wetland area</p><div style="text-align: right;"><a href="http://ecoserv.pbworks.com/Waterfowl" target="_blank">Read more</a></div> '
									}, {
										xtype : 'form',
										bodyStyle : 'padding:15px; border: 0px;',
										labelAlign: 'right',
										labelSeparator: '',
										labelWidth: 90,
										height: 450,
										defaults: {
											
										},
										items: []
									}]
						}, {
							title : 'Floristic',
							iconCls: 'settingFloristicCls',
							xtype: 'panel',
							layout : 'table',
							iconCls: 'settingHydrologyCls',
							layoutConfig : {
								columns : 2,
								tableAttrs: {
									style: {
								        verticalAlign: 'top'
						        	}
						        }
							},
							defaults : {
								frame : false
							},
							items : [
									{
										bodyStyle : 'margin: 1px;padding:5px; border: 0px; line-height: 21px; background-color: #a1abc6;',
										width : 250,
										height: 450,
										html : '<img src="img/map/tbar/Wetland_Continuum.jpg"></img><p>Floristic quality is a measure of the condition of the native plant community.  The two most common metrics of floristic quality are mean C and FQI (Floristic Quality Index).</p><div style="text-align: right;"><a href="http://ecoserv.pbworks.com/Floristic-Quality" target="_blank">Read more</a></div>'
									}, {
										xtype : 'form',
										bodyStyle : 'padding:15px; border: 0px;',
										labelAlign: 'right',
										labelSeparator: '',
										labelWidth: 90,
										height: 450,
										defaults: {
											
										},
										items: []
									}]
						} ]
			});

	var settingWindow = new Ext.Window( {
		closeAction : 'hide',
		layout : "fit",
		modal : true,
		plain : false,
		resizable : true,
		title : "Model Setting",
		height : 470,
		minHeight : 470,
		width : 650,
		minWidth : 650,
		items : [ tabs ],
		buttons : [{
			text : 'Close',
			handler: function() {
				settingWindow.hide();
			}
		} ]
	});
	
	return settingWindow;
}

// function modelSetting() {
// var testWizard = new Ext.ux.PowerWizard(
// {
// activeItem : 0,
// cancelHandler : function() {
//
// },
// submitHandler : function() {
// // Ext.Ajax
// // .request( {
// // url : "",
// // params : this
// // .getValues(),
// // callback : function(
// // options,
// // success,
// // response) {
// // if (success) {
// // Ext.Msg
// // .alert(
// // "Submission Complete",
// // "Thank you.");
// // }
// // }
// // });
// },
// items : [
// {
// id : "card-0",
// xtype : "panel",
// style : 'background-color: #FFFFF; padding: 10px;',
// html : '<div><div style="font-size: 13px; font-weight: bold; padding: 5px;">'
// + "Welcome to water storage simulation"
// + "</div><div><img src='img/waterlevel.gif'></img></div></div>"
// },
// {
// id : "card-1",
// title : "Form",
// xtype : "form",
// items : [ {
// layout : "table",
// layoutConfig : {
// columns : 4
// },
// items : [
// {
// xtype : 'label',
// frame : false,
// text : 'Period: '
// },
// {
// name : 'startDate',
// xtype : "datefield"
// },
// {
// xtype : 'label',
// frame : false,
// text : " - "
// },
// {
// name : 'endDate',
// xtype : "datefield"
// } ]
// } ]
// },
// {
// id : "card-2",
// xtype : 'form',
// title : 'ET Model',
// layout : 'form',
// defaults : {},
// items : [
// {
// fieldLabel : 'Albedo',
// xtype : 'textfield',
// name : 'albedo'
// },
// {
// fieldLabel : 'Wind Speed',
// xtype : 'textfield',
// name : 'windSpeed'
// },
// {
// fieldLabel : 'Coefficient',
// xtype : 'textfield',
// name : 'coefficient'
// } ]
// },
// {
// id : "card-3",
// xtype : 'form',
// title : 'Water Region Model',
// layout : 'form',
// defaults : {},
// items : [ {
// fieldLabel : 'Saturation Prcp',
// xtype : 'textfield',
// name : 'saturationPrcp'
// } ]
// } ]
// });
//
// var wizardWindow = new Ext.Window( {
// closeAction : 'hide',
// layout : "fit",
// modal : true,
// plain : false,
// resizable : true,
// title : "Water storage simulation",
// height : 400,
// minHeight : 400,
// width : 625,
// minWidth : 625,
//
// items : [ testWizard.source ]
// });
//
// wizardWindow.show();
// }
