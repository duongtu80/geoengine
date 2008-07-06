
function GlacierModel (map){
	this.models = {
			'Glacier.TemperatureIdw': new WpsModel ('Glacier.TemperatureIdw', dijit.byId('Setting.Glacier.TemperatureIdw'),
					function() {
						
					}, 
					function(context, params) {
						if(!isNaN(dijit.byId('Glacier.TemperatureIdw.Pow').getValue())){
							params['pow'] = dijit.byId('Glacier.TemperatureIdw.Pow').getValue();
						}

						if(!isNaN(dijit.byId('Glacier.TemperatureIdw.MaxCount').getValue())){
							params['maxCount'] = dijit.byId('Glacier.TemperatureIdw.MaxCount').getValue();
						}

						if(!isNaN(dijit.byId('Glacier.TemperatureIdw.MaxDistance').getValue())){
							params['maxDistance'] = dijit.byId('Glacier.TemperatureIdw.MaxDistance').getValue();
						}
						
						glacier.progressBar.pushProgress('模型计算');
						dojo.xhrGet({ //
					        url: "model/temperatureIdw.do", 
					        handleAs: "json",
					        content: params,
					        timeout: 60000,
					        load: function(response, ioArgs) {
					        	(new ModelResult()).addResultChartPanel(context, params, response);
					   			glacier.progressBar.popProgress();
					        }
						});
					}
				),
			'Glacier.TemperatureIdwEx': new WpsModel ('Glacier.TemperatureIdwEx', dijit.byId('Setting.Glacier.TemperatureIdwEx'),
					function() {
						
					}, 
					function(context, params) {
						if(!isNaN(dijit.byId('Glacier.TemperatureIdwEx.Pow').getValue())){
							params['pow'] = dijit.byId('Glacier.TemperatureIdwEx.Pow').getValue();
						}

						if(!isNaN(dijit.byId('Glacier.TemperatureIdwEx.MaxCount').getValue())){
							params['maxCount'] = dijit.byId('Glacier.TemperatureIdwEx.MaxCount').getValue();
						}

						if(!isNaN(dijit.byId('Glacier.TemperatureIdwEx.MaxDistance').getValue())){
							params['maxDistance'] = dijit.byId('Glacier.TemperatureIdwEx.MaxDistance').getValue();
						}

						if(!isNaN(dijit.byId('Glacier.TemperatureIdwEx.Stand').getValue())){
							params['stand'] = dijit.byId('Glacier.TemperatureIdwEx.Stand').getValue();
						}

						if(!isNaN(dijit.byId('Glacier.TemperatureIdwEx.Grads').getValue())){
							params['grads'] = dijit.byId('Glacier.TemperatureIdwEx.Grads').getValue();
						}
						
						glacier.progressBar.pushProgress('模型计算');
						dojo.xhrGet({ //
					        url: "model/temperatureIdwEx.do", 
					        handleAs: "json",
					        content: params,
					        timeout: 60000,
					        load: function(response, ioArgs) {
					        	(new ModelResult()).addResultChartPanel(context, params, response);
					   			glacier.progressBar.popProgress();
					        }
						});
					}
				),
			'Glacier.PrecipitationIdw': new WpsModel ('Glacier.PrecipitationIdw', dijit.byId('Setting.Glacier.PrecipitationIdw'),
					function() {
						
					}, 
					function(context, params) {
						if(!isNaN(dijit.byId('Glacier.PrecipitationIdw.Pow').getValue())){
							params['pow'] = dijit.byId('Glacier.PrecipitationIdw.Pow').getValue();
						}

						if(!isNaN(dijit.byId('Glacier.PrecipitationIdw.MaxCount').getValue())){
							params['maxCount'] = dijit.byId('Glacier.PrecipitationIdw.MaxCount').getValue();
						}

						if(!isNaN(dijit.byId('Glacier.PrecipitationIdw.MaxDistance').getValue())){
							params['maxDistance'] = dijit.byId('Glacier.PrecipitationIdw.MaxDistance').getValue();
						}
						
						glacier.progressBar.pushProgress('模型计算');
						dojo.xhrGet({ //
					        url: "model/precipitationIdw.do", 
					        handleAs: "json",
					        content: params,
					        timeout: 60000,
					        load: function(response, ioArgs) {
					        	(new ModelResult()).addResultChartPanel(context, params, response);
					   			glacier.progressBar.popProgress();
					        }
						});
					}
				),
			'Glacier.SnowDdfIdw': new WpsModel ('Glacier.SnowDdfIdw', dijit.byId('Setting.Glacier.SnowDdfIdw'),
					function() {
						
					}, 
					function(context, params) {
						if(!isNaN(dijit.byId('Glacier.SnowDdfIdw.Pow').getValue())){
							params['pow'] = dijit.byId('Glacier.SnowDdfIdw.Pow').getValue();
						}

						if(!isNaN(dijit.byId('Glacier.SnowDdfIdw.MaxCount').getValue())){
							params['maxCount'] = dijit.byId('Glacier.SnowDdfIdw.MaxCount').getValue();
						}

						if(!isNaN(dijit.byId('Glacier.SnowDdfIdw.MaxDistance').getValue())){
							params['maxDistance'] = dijit.byId('Glacier.SnowDdfIdw.MaxDistance').getValue();
						}
						
						glacier.progressBar.pushProgress('模型计算');
						dojo.xhrGet({ //
					        url: "model/snowDdfIdw.do", 
					        handleAs: "json",
					        content: params,
					        timeout: 60000,
					        load: function(response, ioArgs) {
					        	(new ModelResult()).addResultTextPanel(context, params, response);
					   			glacier.progressBar.popProgress();
					        }
						});
					}
				),
			'Glacier.IceDdfIdw': new WpsModel ('Glacier.IceDdfIdw', dijit.byId('Setting.Glacier.IceDdfIdw'),
					function() {
						
					}, 
					function(context, params) {
						if(!isNaN(dijit.byId('Glacier.IceDdfIdw.Pow').getValue())){
							params['pow'] = dijit.byId('Glacier.IceDdfIdw.Pow').getValue();
						}

						if(!isNaN(dijit.byId('Glacier.IceDdfIdw.MaxCount').getValue())){
							params['maxCount'] = dijit.byId('Glacier.IceDdfIdw.MaxCount').getValue();
						}

						if(!isNaN(dijit.byId('Glacier.IceDdfIdw.MaxDistance').getValue())){
							params['maxDistance'] = dijit.byId('Glacier.IceDdfIdw.MaxDistance').getValue();
						}
						
						glacier.progressBar.pushProgress('模型计算');
						dojo.xhrGet({ //
					        url: "model/iceDdfIdw.do", 
					        handleAs: "json",
					        content: params,
					        timeout: 60000,
					        load: function(response, ioArgs) {
					        	(new ModelResult()).addResultTextPanel(context, params, response);
					   			glacier.progressBar.popProgress();
					        }
						});
					}
				),
			'Glacier.Runoff': new WpsModel ('Glacier.Runoff', dijit.byId('Setting.Glacier.Runoff'),
					function() {
						
					}, 
					function(context, params) {
						if(!isNaN(dijit.byId('Glacier.Runoff.CellSize').getValue())){
							params['cellSize'] = dijit.byId('Glacier.Runoff.CellSize').getValue();
						}

						if(!isNaN(dijit.byId('Glacier.Runoff.RainCritical').getValue())){
							params['rainCritical'] = dijit.byId('Glacier.Runoff.RainCritical').getValue();
						}

						if(!isNaN(dijit.byId('Glacier.Runoff.SnowCritical').getValue())){
							params['snowCritical'] = dijit.byId('Glacier.Runoff.SnowCritical').getValue();
						}
						
						glacier.progressBar.pushProgress('模型计算');
						dojo.xhrGet({ //
					        url: "model/runoff.do", 
					        handleAs: "json",
					        content: params,
					        timeout: 60000,
					        load: function(response, ioArgs) {
					        	(new ModelResult()).addResultChartPanel(context, params, response);
					   			glacier.progressBar.popProgress();
					        }
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
		if(com.getValue() == null){
			return null;
		}
		
		if(com.item != null){
			return com.item;
		}
		
		return com.store._getItemByIdentity(com.getValue());
	}

	this.modelSetting = function (modelVal) {
		this.models[this.getItemFromCombox(dijit.byId(modelVal)).id].dialog.show();
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
		var i=0;
		for(i=0;i<models.length;i++){
			if(models[i].id.toLowerCase().indexOf(keyword.toLowerCase()) >= 0){
				_items.push(models[i]);
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
		if(confirm('确定关闭该结果吗?') == true){
			dojo.byId('resultPanel').removeChild(this.parentNode.parentNode.parentNode);
		}
	}
	
	this.createTitlePanel = function(context, params){
     	var _closeImg = document.createElement('img');
     	_closeImg.src = 'images/close.png';
     	_closeImg.onclick = this.closeResult;
     	_closeImg.className = 'closeImg';
     	
       	var _closeDiv = document.createElement("div");
       	_closeDiv.appendChild(_closeImg);
       	_closeDiv.style["textAlign"] = 'right';
       	
       	var _titleDiv = document.createElement('div');
       	_titleDiv.className = 'titleText';
       	_titleDiv.innerHTML = context['name'] + ":" + params['basin'];
       	
       	var _titlePanel = document.createElement('div');
       	_titlePanel.appendChild(_titleDiv);
       	_titlePanel.appendChild(_closeDiv);
       	_titlePanel.className = 'titlePanel';
       	
       	return _titlePanel;
	}
	
	this.addResultChartPanel = function(context, params, r){
     	var _newImg = document.createElement("img");
     	_newImg.src = "model/chartStream.do?code=" + r.code;
     	
     	this.panelDiv.appendChild(this.createTitlePanel(context, params));
     	this.panelDiv.appendChild(_newImg);
     	this.panelDiv.className = 'resultPanel';
     	
     	dojo.byId('resultPanel').appendChild(this.panelDiv);
	};

	this.addResultTextPanel = function(context, params, r){
     	var _txtDiv = document.createElement("div");
     	_txtDiv.className = 'textPanel';
     	_txtDiv.innerHTML = params['basin'] + ':' + r['val'];
     	
     	this.panelDiv.appendChild(this.createTitlePanel(context, params));
     	this.panelDiv.appendChild(_txtDiv);
     	this.panelDiv.className = 'resultPanel';
     	
     	dojo.byId('resultPanel').appendChild(this.panelDiv);
	};
}

