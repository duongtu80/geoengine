
function GlacierModel (map){
	this.models = {
			'Glacier.TemperatureIdw': new WpsModel ('Glacier.TemperatureIdw', dijit.byId('Setting.Glacier.TemperatureIdw'),
					function() {
						
					}, 
					function(params) {
						if(!isNaN(dijit.byId('Glacier.TemperatureIdw.Pow').getValue())){
							params['pow'] = dijit.byId('Glacier.TemperatureIdw.Pow').getValue();
						}

						if(!isNaN(dijit.byId('Glacier.TemperatureIdw.MaxCount').getValue())){
							params['maxCount'] = dijit.byId('Glacier.TemperatureIdw.MaxCount').getValue();
						}

						if(!isNaN(dijit.byId('Glacier.TemperatureIdw.MaxDistance').getValue())){
							params['maxDistance'] = dijit.byId('Glacier.TemperatureIdw.MaxDistance').getValue();
						}
						
						dojo.xhrGet({ //
					        url: "model/temperatureIdw.do", 
					        handleAs: "json",
					        content: params,
					        timeout: 60000,
					        load: function(response, ioArgs) {
					        	alert(response);
					        },
						});
					}
				),
			'Glacier.PrecipitationIdw': new WpsModel ('Glacier.PrecipitationIdw', dijit.byId('Setting.Glacier.PrecipitationIdw'),
					function() {
						alert('valid ' + this.id);
					}, 
					function() {
						alert('execute ' + this.id);
					}
				),
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

	this.modelSetting = function (modelId) {
		this.models[dijit.byId(modelId).item.id].dialog.show();
//		dijit.byId('Setting.' + dijit.byId(modelId).item.id).show();
//		alert(dijit.byId(modelId).item.id);
	}
	
	this.saveSetting = function (modelId) {
		this.models[dijit.byId(modelId).item.id].dialog.show();
	}
	
	this.modelExecute = function (modelId) {
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
		var _model = this.models[dijit.byId(modelId).item.id];
		var _params = {
				'startYear': _startYear,
				'endYear': _endYear,
				'x': _centerPt.lon,
				'y': _centerPt.lat,
				'modelUrl': dijit.byId(modelId).item.url,
				'modelId': _model.id
			};
		
		_model.execute(_params);
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
	        	glacier.initModelList(response, 'temperature', 'modelTemperature');
	        	glacier.initModelList(response, 'precipitation', 'modelPrecipitation');
	        	glacier.initModelList(response, 'snow', 'modelSnowDdf');
	        	glacier.initModelList(response, 'ice', 'modelIceDdf');
	        	glacier.initModelList(response, 'runoff', 'modelRunoff');
	        },
//	        error: function(response, ioArgs) { //
//			}
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
		
		var _store = new dojo.data.ItemFileReadStore({data: {items: _items}});
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


