var win_models = {};

function single_water_storage() {
	init_single_water_storage().show();
}

function init_single_water_storage() {
	if ('single_water_storage' in win_models)
		return win_models['single_water_storage'];

	var _win = new Ext.Window( {
		layout : 'border',
		title : 'Single Water Storage',
		width : 700,
		height : 200,
		plain : true,
		closeAction : 'hide',
		plain : true,
		items : new Ext.FormPanel( {
			bodyStyle : 'padding:5px; background-color: #FFFFFF;',
			region : 'center',
			border : false,
			items : [ {
				fieldLabel : 'Start Date',
				xtype : 'datefield',
				name : 'startDate'
			}, {
				fieldLabel : 'Start Date',
				xtype : 'datefield',
				name : 'startDate'
			}, {
				title : 'Parameters',
				xtype : 'fieldset',
				collapsible : true,
				items : [ {
					fieldLabel : 'Climate Data',
					xtype : 'textfield',
					name : 'daymet',
					width : 450,
					value : 'http://www.daymet.org/getRawData.do?lon=%f&lat=%f'
				} ]
			} ]
		}),
		buttons : [ {
			text : 'Load',
			handler : function() {
				_win.hide();
			}
		}, {
			text : 'Close',
			handler : function() {
				_win.hide();
			}
		} ]
	});

	win_models['single_water_storage'] = _win;
	return win_models['single_water_storage'];
}
