
function GlacierModel (map){
	
	this.errorFunction = function(response, ioArgs){
    	alert('计算过程遇到异常:' + response.message);
    	glacier.progressBar.popProgress();
	};
	
	this.models = {
			'TemperatureModel': new WpsModel ('TemperatureModel', dijit.byId('Setting.TemperatureModel'),
					function() {
						var _p = {};
						if(!isNaN(dijit.byId('TemperatureModel.Power').getValue())){
							_p['Power'] = dijit.byId('TemperatureModel.Power').getValue();
						}

						if(!isNaN(dijit.byId('TemperatureModel.MaxCount').getValue())){
							_p['MaxCount'] = dijit.byId('TemperatureModel.MaxCount').getValue();
						}

						if(!isNaN(dijit.byId('TemperatureModel.MaxDistance').getValue())){
							_p['MaxDistance'] = dijit.byId('TemperatureModel.MaxDistance').getValue();
						}
						
						return {id: 'TemperatureModel', params: _p};
					},
					function(params) {
						glacier.progressBar.pushProgress('模型计算');
						dojo.xhrGet({ //
					        url: "model/temperatureIdw.do", 
					        handleAs: "json",
					        content: params,
					        timeout: 60000,
					        load: function(response, ioArgs) {
					        	(new ModelResult()).addResultChartPanel(context, params, response);
					   			glacier.progressBar.popProgress();
					        },
					        error: glacier.errorFunction
						});
					}
				),
			'TemperatureModelEx': new WpsModel ('TemperatureModelEx', dijit.byId('Setting.TemperatureModelEx'),
					function() {
						var _p = {};
						
						if(!isNaN(dijit.byId('TemperatureModelEx.Power').getValue())){
							_p['Power'] = dijit.byId('TemperatureModelEx.Power').getValue();
						}

						if(!isNaN(dijit.byId('TemperatureModelEx.MaxCount').getValue())){
							_p['MaxCount'] = dijit.byId('TemperatureModelEx.MaxCount').getValue();
						}

						if(!isNaN(dijit.byId('TemperatureModelEx.MaxDistance').getValue())){
							_p['MaxDistance'] = dijit.byId('TemperatureModelEx.MaxDistance').getValue();
						}

						if(!isNaN(dijit.byId('TemperatureModelEx.Stand').getValue())){
							_p['Stand'] = dijit.byId('TemperatureModelEx.Stand').getValue();
						}

						if(!isNaN(dijit.byId('TemperatureModelEx.Grads').getValue())){
							_p['Grads'] = dijit.byId('TemperatureModelEx.Grads').getValue();
						}
						
						return {id: 'TemperatureModelEx', params: _p};
					},
					function(params){
						glacier.progressBar.pushProgress('模型计算');
						dojo.xhrGet({ //
					        url: "model/temperatureIdwEx.do", 
					        handleAs: "json",
					        content: params,
					        timeout: 60000,
					        load: function(response, ioArgs) {
					        	(new ModelResult()).addResultChartPanel(context, params, response);
					   			glacier.progressBar.popProgress();
					        },
					        error: glacier.errorFunction
						});
					}
				),
			'PrecipitationModel': new WpsModel ('PrecipitationModel', dijit.byId('Setting.PrecipitationModel'),
					function(context, params) {
						var _p = {};
						
						if(!isNaN(dijit.byId('PrecipitationModel.Power').getValue())){
							_p['Power'] = dijit.byId('PrecipitationModel.Power').getValue();
						}

						if(!isNaN(dijit.byId('PrecipitationModel.MaxCount').getValue())){
							_p['MaxCount'] = dijit.byId('PrecipitationModel.MaxCount').getValue();
						}

						if(!isNaN(dijit.byId('PrecipitationModel.MaxDistance').getValue())){
							_p['MaxDistance'] = dijit.byId('PrecipitationModel.MaxDistance').getValue();
						}
						
						return {id: 'PrecipitationModel', params: _p};
					},
					function(params) {
						glacier.progressBar.pushProgress('模型计算');
						dojo.xhrGet({ //
					        url: "model/precipitationIdw.do", 
					        handleAs: "json",
					        content: params,
					        timeout: 60000,
					        load: function(response, ioArgs) {
					        	(new ModelResult()).addResultChartPanel(context, params, response);
					   			glacier.progressBar.popProgress();
					        },
					        error: glacier.errorFunction
						});
					}
				),
			'SnowDDFModel': new WpsModel ('SnowDDFModel', dijit.byId('Setting.SnowDDFModel'),
					function(context, params) {
						var _p = {};
						
						if(!isNaN(dijit.byId('SnowDDFModel.Power').getValue())){
							_p['Power'] = dijit.byId('SnowDDFModel.Power').getValue();
						}

						if(!isNaN(dijit.byId('SnowDDFModel.MaxCount').getValue())){
							_p['MaxCount'] = dijit.byId('SnowDDFModel.MaxCount').getValue();
						}

						if(!isNaN(dijit.byId('SnowDDFModel.MaxDistance').getValue())){
							_p['MaxDistance'] = dijit.byId('SnowDDFModel.MaxDistance').getValue();
						}
						
						return {id: 'SnowDDFModel', params: _p};
					},
					function(params){
						glacier.progressBar.pushProgress('模型计算');
						dojo.xhrGet({ //
					        url: "model/SnowDDFModel.do", 
					        handleAs: "json",
					        content: params,
					        timeout: 60000,
					        load: function(response, ioArgs) {
					        	(new ModelResult()).addResultTextPanel(context, params, response);
					   			glacier.progressBar.popProgress();
					        },
					        error: glacier.errorFunction
						});
					}
				),
			'IceDDFModel': new WpsModel ('IceDDFModel', dijit.byId('Setting.IceDDFModel'),
					function(context, params) {
						var _p = {};
						
						if(!isNaN(dijit.byId('IceDDFModel.Power').getValue())){
							_p['Power'] = dijit.byId('IceDDFModel.Power').getValue();
						}

						if(!isNaN(dijit.byId('IceDDFModel.MaxCount').getValue())){
							_p['MaxCount'] = dijit.byId('IceDDFModel.MaxCount').getValue();
						}

						if(!isNaN(dijit.byId('IceDDFModel.MaxDistance').getValue())){
							_p['MaxDistance'] = dijit.byId('IceDDFModel.MaxDistance').getValue();
						}
						
						return {id: 'IceDDFModel', params: _p};
					},
					function(params){
						glacier.progressBar.pushProgress('模型计算');
						dojo.xhrGet({ //
					        url: "model/IceDDFModel.do", 
					        handleAs: "json",
					        content: params,
					        timeout: 60000,
					        load: function(response, ioArgs) {
					        	(new ModelResult()).addResultTextPanel(context, params, response);
					   			glacier.progressBar.popProgress();
					        },
					        error: glacier.errorFunction
						});
					}
				),
			'RunoffModel': new WpsModel ('RunoffModel', dijit.byId('Setting.RunoffModel'),
					function(context, params) {
						var _p = {};
						
//						if(!isNaN(dijit.byId('RunoffModel.CellSize').getValue())){
//							_p['CellSize'] = dijit.byId('RunoffModel.CellSize').getValue();
//						}

						if(!isNaN(dijit.byId('RunoffModel.RainCritical').getValue())){
							_p['RainCritical'] = dijit.byId('RunoffModel.RainCritical').getValue();
						}

						if(!isNaN(dijit.byId('RunoffModel.SnowCritical').getValue())){
							_p['SnowCritical'] = dijit.byId('RunoffModel.SnowCritical').getValue();
						}

						if(!isNaN(dijit.byId('RunoffModel.SnowFrozenRatio').getValue())){
							_p['SnowFrozenRatio'] = dijit.byId('RunoffModel.SnowFrozenRatio').getValue();
						}
						
						return {id: 'RunoffModel', params: _p};
					},
					function(params){
						glacier.progressBar.pushProgress('模型计算');
						dojo.xhrGet({ //
					        url: "model/runoff.do", 
					        handleAs: "json",
					        content: params,
					        timeout: 60000,
					        load: function(response, ioArgs) {
					        	(new ModelResult()).addResultChartPanel(context, params, response);
					   			glacier.progressBar.popProgress();
					        },
					        error: glacier.errorFunction
						});
					}
				)
			};


	this.map = map;
	this.pointHandler = null;
	this.pointHandlerShowTip = true;
	this.temperatureModel = new TemperatureIdwModel();
	
	this.pointSelectTip = function(){
		this.pointHandlerShowTip = !dijit.byId('pointSelectTipCheck').getValue();
		this.pointSelectDo();
	};
	
	this.pointSelect = function(){
		if(this.pointHandlerShowTip){
			dijit.byId('pointSelectTip').show();
			return;
		}
		this.pointSelectDo();
	};
	
	this.pointSelectDo = function() {
		if(this.pointHandler == null){
			this.pointHandler = new OpenLayers.Control();
			this.pointHandler.siteLayer = this.siteLayer;
			
			OpenLayers.Util.extend(this.pointHandler,{ 
						draw: function() {
							this.handler = new OpenLayers.Handler.Point(this, 
										{"done": this.notice},
										{keyMask: OpenLayers.Handler.MOD_NONE});
						},
						notice: function (pt) {
							this.siteLayer.removeFeatures(this.siteLayer.features);
							this.siteLayer.addFeatures(new OpenLayers.Feature.Vector(pt));
						
							dijit.byId('pointX').setValue(pt.x);
							dijit.byId('pointY').setValue(pt.y);
							
							this.deactivate();
						}
					});
			
			this.map.addControl(this.pointHandler);
		}
		this.pointHandler.activate();
	};
	
	this.selectWfsDataSource = function(d){
		dijit.byId('dlgSelectWfsDataSource').show();
	};
	
	this.listWfsDataset = function() {
		var _content = {};
		_content['url'] = dijit.byId('txtWfsService').getValue()
//		_content['tag'] = (new Date()).getTime();
		
		dojo.xhrGet({ //
	        url: "wfsDatasets.do", 
	        handleAs: "json",
	        content: _content,
	        timeout: 60000,
	        load: function(response, ioArgs) {
	        	var _store = new dojo.data.ItemFileReadStore({data: response});
	        	dijit.byId('listWfsDataset').store = _store;
//	        	dijit.byId('listWfsDataset').setValue("");
	        	
//				alert(response.datasets);
	        },
	        error: function(response, ioArgs) { //
			}
		});
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
		this.map.zoomToExtent(_f.geometry.getBounds());
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
	
	this.changeModel = function (modelId) {
//		alert(dijit.byId(modelId).getValue());
	}
	
	this.getItemFromCombox = function (com) {
		if(com.getValue() == null || com.getValue() == ''){
			return null;
		}
		
		if(com.item != null){
			return com.item;
		}
		
		return com.store._getItemByIdentity(com.getValue());
	}

	this.modelSetting = function (modelVal) {
		var _val = this.getItemFromCombox(dijit.byId(modelVal));
		if(_val != null){
			this.models[_val.id].dialog.show();
		}
	}
	
	this.saveSetting = function (modelId) {
		this.models[modelId].saveSetting()
	}
	
	this.modelExecute = function (modelVal) {
		var _startYear = dijit.byId('startYear').getValue();
		var _endYear = dijit.byId('endYear').getValue();
		var _basin = dijit.byId('listCatchment').getValue();
		
		if(isNaN(_startYear)){
			alert('没有提供起始年份');
			return;
		}
		if(isNaN(_endYear)){
			alert('没有提供终止年份');
			return;
		}
		if(_endYear < _startYear){
			alert('起始年份必须小于或等于终止年份');
			return;
		}
		if(_basin == undefined || _basin == '' || this.basinLayer.selectedFeatures.length == 0){
			alert('没有选择目标流域');
			return;
		}
		
		var _item = this.getItemFromCombox(dijit.byId(modelVal));
		var _centerPt = this.basinLayer.selectedFeatures[0].geometry.getBounds().getCenterLonLat();
		var _model = this.models[_item.id];
		var _params = {
				'startYear': _startYear,
				'endYear': _endYear,
				'x': _centerPt.lon,
				'y': _centerPt.lat,
				'basin': _basin,
				'modelUrl': _item.url,
				'modelId': _model.id
			};
		
		_model.execute(_item, _params);
	}
	
	this.runoffModelExecute = function () {
		var _startYear = dijit.byId('startYear').getValue();
		var _endYear = dijit.byId('endYear').getValue();
		var _basin = dijit.byId('listCatchment').getValue();
		
		if(isNaN(_startYear)){
			alert('没有提供起始年份');
			return;
		}
		if(isNaN(_endYear)){
			alert('没有提供终止年份');
			return;
		}
		if(_endYear < _startYear){
			alert('起始年份必须小于或等于终止年份');
			return;
		}
		if(_basin == undefined || _basin == '' || this.basinLayer.selectedFeatures.length == 0){
			alert('没有选择目标流域');
			return;
		}
		
		var _centerPt = this.basinLayer.selectedFeatures[0].geometry.getBounds().getCenterLonLat();
		var _modelParam = {};
		
		_modelParam['Temperature'] = this.models[this.getItemFromCombox(dijit.byId('modelTemperature')).id].saveSetting();
		_modelParam['Precipitation'] = this.models[this.getItemFromCombox(dijit.byId('modelPrecipitation')).id].saveSetting();
		_modelParam['SnowDDF'] = this.models[this.getItemFromCombox(dijit.byId('modelSnowDdf')).id].saveSetting();
		_modelParam['IceDDF'] = this.models[this.getItemFromCombox(dijit.byId('modelIceDdf')).id].saveSetting();
		_modelParam['Runoff'] = this.models[this.getItemFromCombox(dijit.byId('modelRunoff')).id].saveSetting();

		var _params = {
				'startYear': _startYear,
				'endYear': _endYear,
				'x': _centerPt.lon,
				'y': _centerPt.lat,
				'basin': _basin,
				'date': (new Date()).getTime(),
				'param': dojo.toJson(_modelParam)
			};
		
		glacier.progressBar.pushProgress('启动远程模型');
		dojo.xhrGet({ //
	        url: "model/runoffStart.do", 
	        handleAs: "json",
	        content: _params,
	        timeout: 60000,
	        load: function(response, ioArgs) {
				glacier.modelProcess = new ModelProcess();
				glacier.modelProcess.start(response);
				
//				alert(dojo.toJson(response));
//	   			glacier.progressBar.popProgress();
	        },
	        error: this.errorFunction
		});
		
//		_model.execute(_item, _params);
	}
	
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
	        		glacier.progressBar.pushProgress('加载模型列表');
	        		
		        	glacier.initModelList(response, 'temperature', 'modelTemperature');
		        	glacier.initModelList(response, 'precipitation', 'modelPrecipitation');
		        	glacier.initModelList(response, 'snow', 'modelSnowDdf');
		        	glacier.initModelList(response, 'ice', 'modelIceDdf');
		        	glacier.initModelList(response, 'runoff', 'modelRunoff');
		        }
		        finally{
		        	glacier.progressBar.popProgress();
		        }
	        },
	        error: function(response, ioArgs) { //
	        	alert('模型加载失败');
			}
		});
	}
	
	this.initModelList = function(models, keyword, id){
		var _items = [];
		for(i=0;i<models.length;i++){
			for(j=0;j<models[i].keywords.length;j++){
				if(models[i].keywords[j] == keyword){
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
}

function ModelProcess() {
	this.start = function(param){
		if(param.percent < 0){
			alert('错误:' + param.message);
			return;
		}

		this.param = param;
		
		if(this.timeout != undefined){
			window.clearTimeout(this.timeout);
		}
		
		this.timeout = window.setTimeout(this.checkRunoffProcess, 500);
	}
	
	this.checkRunoffProcess = function (){
//		alert(dojo.toJson(param));
		if(this.timeout != undefined){
			window.clearTimeout(this.timeout);
			this.timeout = undefined;
		}
		
		var _param = glacier.modelProcess.param;
		var _params = {'id': _param.id, 'date': (new Date()).getTime()};
		
		if(_param.percent >= 100){
			//如果执行完毕
			(new ModelResult()).addResultChartPanel(['Runoff', 'Temperature', 'Precipitation'], ['径流', '气温', '降水'], _param);
//			(new ModelResult()).addResultChartPanel('Temperature', '气温', _param);
//			(new ModelResult()).addResultChartPanel('Precipitation', '降水', _param);
//			(new ModelResult()).addResultChartPanel('Runoff', '径流', _param);

			glacier.progressBar.popProgress();
//			alert('执行完毕' + _param.id);
		}
		else{
			glacier.progressBar.popProgress();
			glacier.progressBar.pushProgress(_param.percent + "% " + _param.message);
			
			dojo.xhrGet({ //
		        url: "model/runoffQuery.do", 
		        handleAs: "json",
		        content: _params,
		        timeout: 60000,
		        load: function(response, ioArgs) {
					glacier.modelProcess.start(response);
		        },
		        error: glacier.errorFunction
			});
		}
	}
}

function TemperatureIdwModel() {

	this.execute = function() {
		_date = dijit.byId('modelDate').getValue();
		_tX = dijit.byId('pointX').getValue();
		_tY = dijit.byId('pointY').getValue();
		_pow = dijit.byId('temperaturePow').getValue();
		
		_dist = dijit.byId('temperatureMaxDistance').getValue();
		_maxCount = dijit.byId('temperatureMaxCount').getValue();
		
		
		if(_date == undefined){
			alert('没有提供日期');
			return;
		}
		if(isNaN(_tX) || isNaN(_tY)){
			alert('没有提供目标坐标');
			return;
		}
		if(isNaN(_pow)){
			alert('没有提供指数');
			return;
		}
		
		var _content = {};
		_content['date'] = _date.getTime();
		_content['x'] = _tX;
		_content['y'] = _tY;
		_content['pow'] = _pow;
		
		if(!isNaN(_maxCount)){
			_content['maxCount'] = _maxCount;
		}
		if(!isNaN(_dist)){
			_content['maxDistance'] = _dist;
		}
		
		dojo.xhrGet({ //
	        url: "model/temperatureIdw.do", 
	        handleAs: "json",
	        content: _content,
	        timeout: 60000,
	        load: function(response, ioArgs) {
	//        	alert(response.status);
				alert(response.temperature);
	        },
	        error: function(response, ioArgs) { //
			}
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
     	_linkDiv.innerHTML = '查看数据>>';
     	
     	var i = 0;
     	for(i=0;i<tags.length;i++){
	     	var _newImg = document.createElement("img");
	     	_newImg.src = "model/runoffChart.do?tag=" + tags[i] + "&date=" + ((new Date()).getTime() + 1) + "&id=" + param.id;
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

