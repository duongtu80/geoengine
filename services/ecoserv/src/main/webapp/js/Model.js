
function Model() {
	
	this.init = function(main) {
		this.main = main;
	};
	
	this.runModel = function() {
		var _startDate = Ext.getCmp('modelRunStartDate').getValue().getTime();
		var _endDate = Ext.getCmp('modelRunEndDate').getValue().getTime();
		var _basin = Ext.getCmp('modelRunWetland').getValue();
		var _landcover = Ext.getCmp('modelLandCover').getValue();
		
		if(isNaN(_startDate)){
			Ext.Msg.alert('Warning', 'No start date');
			return;
		}
		if(isNaN(_endDate)){
			Ext.Msg.alert('Warning', 'No ending date');
			return;
		}
		if(_endDate < _startDate){
			Ext.Msg.alert('Warning', 'Start date should be earlier than ending date');
			return;
		}
		
//		//DayMet has climate data available between 1980 to 2003
//		if(_startDate < (new Date(1980, 0, 1)).getTime()){
//			Ext.Msg.alert('Warning', 'No climate data before 1980. Please change your start date.');
//			return;
//		}
//		if(_endDate > (new Date(2003, 11, 31)).getTime()){
//			Ext.Msg.alert('Warning', 'No climate data later than 2003. Please change your end date.');
//			return;
//		}
//		
		if(_basin == undefined || _basin == ''){ // || this.basinLayer.selectedFeatures.length == 0){
			Ext.Msg.alert('Warning', 'No wetland catchment selected');
			return;
		}

		if(_landcover == undefined || _landcover == ''){ // || this.basinLayer.selectedFeatures.length == 0){
			Ext.Msg.alert('Warning', 'No land cover scenairo selected');
			return;
		}
		
		if(this.main.results.indexOf(_landcover) >= 0){
			Ext.Msg.confirm('Override', 'The land cover scenario has been used. Would you like to override the previous result?', function(btn, text){
			    if (btn == 'yes'){
					this.execute(_startDate, _endDate, _basin, _landcover);
			    }}, this);
			
			return;
		}

		this.execute(_startDate, _endDate, _basin, _landcover);

//		if(this.getItemFromCombox(dijit.byId('modelET')) == null){
//			alert('No ET model set');
//			return;
//		}
//
//		if(this.getItemFromCombox(dijit.byId('modelWaterTable')) == null){
//			alert('No water table model set');
//			return;
//		}
//
//		var _modelParam = {};
//		
//		_modelParam['ET'] = this.models[this.getItemFromCombox(dijit.byId('modelET')).id].saveSetting();
//		_modelParam['WaterTable'] = this.models[this.getItemFromCombox(dijit.byId('modelWaterTable')).id].saveSetting();
//
//		var _params = {
//				'startDate': _startDate,
//				'endDate': _endDate,
//				'basin': _basin,
//				'params': _modelParam
//			};
//		
//		wetland.progressBar.pushProgress('Executing model');
//		dojo.xhrGet({ //
//	        url: "model/waterLevelStart.do", 
//	        handleAs: "json",
//	        content: {"params": dojo.toJson(_params)},
//	        timeout: 60000,
//	        load: function(response, ioArgs) {
//				wetland.modelProcess = new ModelProcess();
//				wetland.modelProcess.start(response);
//				
////				alert(dojo.toJson(response));
////	   			glacier.progressBar.popProgress();
//	        },
//	        error: this.errorFunction
//		});
	};
	
	this.execute = function(startDate, endDate, basin, landCover) {
		var _params = {'startDate': startDate, 'endDate': endDate, 'landCover': landCover};
		
		main.progressQueue.pushTask(
				'Running simulating for ' + basin,
				'/ecoserv/_loadScenario.do', {param: Ext.encode(_params)}, this.main,
				this.main.initOutput);

//		var _form = new Ext.FormPanel(
//				{
//					bodyStyle : 'padding:5px; background-color: #FFFFFF;',
//					border : false,
//					labelAlign: 'right',
//					items : [ {fieldLabel: 'Start Date', name: 'startDate', xtype: 'datefield', value: new Date(startDate)},
//					          {fieldLabel: 'End Date', name: 'endDate', xtype: 'datefield', value: new Date(endDate)},
//					          {fieldLabel: 'Region', name: 'region', xtype: 'textfield', value: basin},
//					          {fieldLabel: 'Land Cover', name: 'landCover', xtype: 'textfield', value: landcover}
//					          ]
//				});
//		
//		var _win = new Ext.Window(
//				{
//					layout : 'fit',
//					title : 'Run model',
//					width : 500,
//					height : 200,
//					closeAction : 'hide',
//					plain : true,
//					items : _form,
//					buttons : [
//							{
//								text : 'Run',
//								scope: this,
//								handler : function() {
//									var _f = _form.getForm().getFieldValues();
//									var _params = {'startDate': startDate, 'endDate': endDate, 'landCover': _f.landCover};
//									
//
//									_win.hide();
//
//									main.progressQueue.pushTask(
//											'Running simulating for ' + _f.region,
//											'/ecoserv/_loadScenario.do', {param: Ext.encode(_params)}, main,
//											main.initOutput);
//								}
//							}, {
//								text : 'Close',
//								handler : function() {
//									_win.hide();
//								}
//							} ]
//				});
//		_win.show();
	};
};

