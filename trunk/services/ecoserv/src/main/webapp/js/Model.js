
function Model() {
	
	this.init = function(main) {
		this.main = main;
	};
	
	this.runModel = function() {
		var _startDate = Ext.getCmp('modelRunStartDate').getValue().getTime();
		var _endDate = Ext.getCmp('modelRunEndDate').getValue().getTime();
		var _basin = Ext.getCmp('modelRunWetland').getValue();
		
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
		
		//DayMet has climate data available between 1980 to 2003
		if(_startDate < (new Date(1980, 0, 1)).getTime()){
			Ext.Msg.alert('Warning', 'No climate data before 1980. Please change your start date.');
			return;
		}
		if(_endDate > (new Date(2003, 11, 31)).getTime()){
			Ext.Msg.alert('Warning', 'No climate data later than 2003. Please change your end date.');
			return;
		}
		
		if(_basin == undefined || _basin == '' || this.basinLayer.selectedFeatures.length == 0){
			Ext.Msg.alert('Warning', 'No wetland catchment selected');
			return;
		}

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
};

