
function WetlandModel (map){
	this.map = map;
	
	this.errorFunction = function(response, ioArgs){
    	alert('Error:' + response.message);
    	wetland.progressBar.popProgress();
	};
	
	this.models = {
			'ETModel': new WpsModel ('ETModel', dijit.byId('Setting.ETModel'),
					function() {
						var _p = {};
						if(!isNaN(dijit.byId('ETModel.Albedo').getValue())){
							_p['Albedo'] = dijit.byId('ETModel.Albedo').getValue();
						}

						if(!isNaN(dijit.byId('ETModel.WindSpeed').getValue())){
							_p['WindSpeed'] = dijit.byId('ETModel.WindSpeed').getValue();
						}

						if(!isNaN(dijit.byId('ETModel.Coefficient').getValue())){
							_p['Coefficient'] = dijit.byId('ETModel.Coefficient').getValue();
						}
						
						return {id: 'ETModel', params: _p};
					},
					function(params) {
						wetland.progressBar.pushProgress('Calculating ET');
						dojo.xhrGet({ //
					        url: "model/et.do", 
					        handleAs: "json",
					        content: params,
					        timeout: 60000,
					        load: function(response, ioArgs) {
					        	(new ModelResult()).addResultChartPanel(context, params, response);
					        	wetland.progressBar.popProgress();
					        },
					        error: wetland.errorFunction
						});
					}
				),
				'WaterTableModel': new WpsModel ('WaterTableModel', dijit.byId('Setting.WaterTableModel'),
						function() {
							var _p = {};
							if(!isNaN(dijit.byId('WaterTableModel.SaturationPrcp').getValue())){
								_p['SaturationPrcp'] = dijit.byId('WaterTableModel.SaturationPrcp').getValue();
							}
							
							return {id: 'WaterTableModel', params: _p};
						},
						function(params) {
							wetland.progressBar.pushProgress('Calculating Water Table');
							dojo.xhrGet({ //
						        url: "model/waterTable.do", 
						        handleAs: "json",
						        content: params,
						        timeout: 60000,
						        load: function(response, ioArgs) {
						        	(new ModelResult()).addResultChartPanel(context, params, response);
						        	wetland.progressBar.popProgress();
						        }
								,error: wetland.errorFunction
							});
						}
					)				
			};


	
	this.selectBasin = function() {
		while(this.basinLayer.selectedFeatures.length > 0){
			var _f = this.basinLayer.selectedFeatures.pop();
			_f.style = this.basinLayer.style;
			this.basinLayer.drawFeature(_f);
		}
		
		var _f = this.selectFeatureById(this.basinLayer, dijit.byId('listCatchment').item.fid);
		_f.style = this.basinLayer.selectedStyle;
		this.basinLayer.drawFeature(_f);
		
		this.basinLayer.selectedFeatures.push(_f);
//		this.map.zoomToExtent(_f.geometry.getBounds());
	};
	
	this.selectFeatureById = function(layer, fid){
		var i=0;
		for(i=0;i<layer.features.length;i++){
			var _f = layer.features[i];
			
			if(_f.fid == fid){
				return _f;
			}
		}
		return null;
	};

	this.selectFeatureByTag = function(layer, fld, v){
		var i=0;
		for(i=0;i<layer.features.length;i++){
			var _f = layer.features[i];
			
			if(_f.attributes[fld] == v){
				return _f;
			}
		}
		return null;
	};

	this.targetBasin = function(geometry) {
		alert(geometry);
//		while(this.basinLayer.selectedFeatures.length > 0){
//			var _f = this.basinLayer.selectedFeatures.pop();
//			_f.style = this.basinLayer.style;
//			this.basinLayer.drawFeature(_f);
//		}
//		
//		var _f = this.selectFeatureByTag(this.basinLayer, 'NAME', tag);
//		_f.style = this.basinLayer.selectedStyle;
//		this.basinLayer.drawFeature(_f);
		
//		this.basinLayer.selectedFeatures.push(_f);
//		this.map.zoomToExtent(_f.geometry.getBounds());
	};
	
	this.getItemFromCombox = function (com) {
		if(com.getValue() == null || com.getValue() == ''){
			return null;
		}
		
		if(com.item != null){
			return com.item;
		}
		
		return com.store._getItemByIdentity(com.getValue());
	}

	this.changeModel = function (modelId) {
//		alert(dijit.byId(modelId).getValue());
	}

	this.modelSetting = function (modelVal) {
		var _val = this.getItemFromCombox(dijit.byId(modelVal));
		if(_val != null){
			this.models[_val.id].dialog.show();
		}
		else{
			alert('No model selected.');
		}
	};
	
	this.saveSetting = function (modelId) {
		this.models[modelId].saveSetting()
	};
	
	this.loadWpsModel = function (){
		dojo.xhrGet({ //
	        url: "model/listWpsModel.do", 
	        handleAs: "json",
	        content: {
	        		'url': dijit.byId('txtWpsService').getValue()
	        	},
	        timeout: 60000,
	        load: function(response, ioArgs) {
	        	try{
	        		wetland.progressBar.pushProgress('Loading models');
	        		
		        	wetland.initModelList(response, 'et', 'modelET');
		        	wetland.initModelList(response, 'water table', 'modelWaterTable');
		        }
		        finally{
		        	wetland.progressBar.popProgress();
		        }
	        }
	        ,error: wetland.errorFunction
		});
	};
	
	this.initModelList = function(models, keyword, id){
		var _items = [];
		for(i=0;i<models.length;i++){
			for(j=0;j<models[i].keywords.length;j++){
				if(models[i].keywords[j].toLowerCase() == keyword.toLowerCase()){
					_items.push(models[i]);
				}
			}
		}
		
		var _store = new dojo.data.ItemFileReadStore({data: {'items': _items, 'identifier': 'name'}});
		dijit.byId(id).store = _store;
		
		if(_items.length > 0){
			dijit.byId(id).setValue(_items[0].name);
			dijit.byId(id).item = _items[0];
		}
	};
	
	this.selectWpsModel = function () {
		dijit.byId('dlgLoadWpsModel').show();
	};
	
	this.waterLevelExecute = function () {
		var _startDate = dijit.byId('startDate').getValue().getTime();
		var _endDate = dijit.byId('endDate').getValue().getTime();
		var _basin = dijit.byId('listCatchment').getValue();
		
		if(isNaN(_startDate)){
			alert('No start date');
			return;
		}
		if(isNaN(_endDate)){
			alert('No ending date');
			return;
		}
		if(_endDate < _startDate){
			alert('Start date should be earlier than ending date');
			return;
		}
		if(_basin == undefined || _basin == '' || this.basinLayer.selectedFeatures.length == 0){
			alert('No wetland catchment selected');
			return;
		}

		if(this.getItemFromCombox(dijit.byId('modelET')) == null){
			alert('No ET model set');
			return;
		}

		if(this.getItemFromCombox(dijit.byId('modelWaterTable')) == null){
			alert('No water table model set');
			return;
		}

		var _modelParam = {};
		
		_modelParam['ET'] = this.models[this.getItemFromCombox(dijit.byId('modelET')).id].saveSetting();
		_modelParam['WaterTable'] = this.models[this.getItemFromCombox(dijit.byId('modelWaterTable')).id].saveSetting();

		var _params = {
				'startDate': _startDate,
				'endDate': _endDate,
				'basin': _basin,
				'params': _modelParam
			};
		
		wetland.progressBar.pushProgress('Executing model');
		dojo.xhrGet({ //
	        url: "model/waterLevelStart.do", 
	        handleAs: "json",
	        content: {"params": dojo.toJson(_params)},
	        timeout: 60000,
	        load: function(response, ioArgs) {
				wetland.modelProcess = new ModelProcess();
				wetland.modelProcess.start(response);
				
//				alert(dojo.toJson(response));
//	   			glacier.progressBar.popProgress();
	        },
	        error: this.errorFunction
		});
	}
}

function WpsModel (id, dialog, saveSetting , execute) {
	this.id = id;
	this.dialog = dialog;
	this.saveSetting = saveSetting;
	this.execute = execute;
}

function ModelResult() {
   	this.panelDiv = document.createElement('div');

	this.closeResult = function() {
//		if(confirm('确定关闭该结果吗?') == true){
			dojo.byId('resultPanel').removeChild(this.parentNode.parentNode.parentNode);
//		}
	};
	
	this.createTitlePanel = function(title){
     	var _closeImg = document.createElement('img');
     	_closeImg.src = 'images/close.png';
     	_closeImg.onclick = this.closeResult;
     	_closeImg.className = 'closeImg';
     	
       	var _closeDiv = document.createElement("div");
       	_closeDiv.appendChild(_closeImg);
       	_closeDiv.style["textAlign"] = 'right';
       	
       	var _titleDiv = document.createElement('div');
       	_titleDiv.className = 'titleText';
       	_titleDiv.innerHTML = title;
       	
       	var _titlePanel = document.createElement('div');
       	_titlePanel.appendChild(_titleDiv);
       	_titlePanel.appendChild(_closeDiv);
       	_titlePanel.className = 'titlePanel';
       	
       	return _titlePanel;
	};
	
	this.addResultChartPanel = function(tags, titles, param){
		var _title = param.basin;
     	this.panelDiv.appendChild(this.createTitlePanel(_title));
     	
     	var _textDiv = document.createElement('div');
     	this.panelDiv.appendChild(_textDiv);
     	_textDiv.className = 'resultItem';
     	_textDiv.style["textAlign"] = 'right';
     	
     	var _linkDiv = document.createElement('a');
     	_textDiv.appendChild(_linkDiv);
     	_linkDiv.target = '_blank';
     	_linkDiv.className = 'resultLink';
     	_linkDiv.href = 'runoffView.do?code=' + param.id;
     	_linkDiv.innerHTML = 'View Data>>';
     	
     	var i = 0;
     	for(i=0;i<tags.length;i++){
	     	var _newImg = document.createElement("img");
	     	_newImg.src = "model/processChart.do?tag=" + tags[i] + "&date=" + ((new Date()).getTime() + 1) + "&id=" + param.id;
	     	this.panelDiv.appendChild(_newImg);
	     	this.panelDiv.className = 'resultPanel';
     	}

     	
     	dojo.byId('resultPanel').appendChild(this.panelDiv);
	};

	this.addResultTextPanel = function(tag, title, param){
     	var _txtDiv = document.createElement("div");
     	_txtDiv.className = 'textPanel';
     	_txtDiv.innerHTML = params.basin + ':' + r['val'];
     	
     	this.panelDiv.appendChild(this.createTitlePanel(context, params));
     	this.panelDiv.appendChild(_txtDiv);
     	this.panelDiv.className = 'resultPanel';
     	
     	dojo.byId('resultPanel').appendChild(this.panelDiv);
	};
}

function ModelProcess() {
	this.start = function(param){
		if(param.percent < 0){
			alert('Error:' + param.message);
			return;
		}

		this.param = param;
		
		if(this.timeout != undefined){
			window.clearTimeout(this.timeout);
		}
		
		this.timeout = window.setTimeout(this.checkProcess, 500);
	}
	
	this.checkProcess = function (){
//		alert(dojo.toJson(param));
		if(this.timeout != undefined){
			window.clearTimeout(this.timeout);
			this.timeout = undefined;
		}
		
		var _param = wetland.modelProcess.param;
		var _params = {'id': _param.id, 'date': (new Date()).getTime()};
		
		if(_param.percent >= 100){
			//如果执行完毕
			(new ModelResult()).addResultChartPanel(['ET', 'WaterLevel', 'Precipitation'], ['ET', 'Water Level', 'Precipitation'], _param);
//			(new ModelResult()).addResultChartPanel('Temperature', '气温', _param);
//			(new ModelResult()).addResultChartPanel('Precipitation', '降水', _param);
//			(new ModelResult()).addResultChartPanel('Runoff', '径流', _param);

			wetland.progressBar.popProgress();
//			alert('执行完毕' + _param.id);
		}
		else{
			wetland.progressBar.popProgress();
			wetland.progressBar.pushProgress(_param.percent + "% " + _param.message);
			
			dojo.xhrGet({ //
		        url: "model/processQuery.do", 
		        handleAs: "json",
		        content: _params,
		        timeout: 60000,
		        load: function(response, ioArgs) {
					wetland.modelProcess.start(response);
		        },
		        error: wetland.errorFunction
			});
		}
	}
}