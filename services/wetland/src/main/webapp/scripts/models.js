
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
						dojo.xhrGet(
							{ //
						        url: "model/et.do", 
						        handleAs: "json",
						        content: params,
						        timeout: 60000,
						        load: function(response, ioArgs) {
						        	(new ModelResult()).addResultChartPanel(context, params, response);
						        	wetland.progressBar.popProgress();
						        },
						        error: wetland.errorFunction
							}
						);
					}
				)
				, 'WaterTableModel': new WpsModel ('WaterTableModel', dijit.byId('Setting.WaterTableModel'),
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
							}
						);
					}
				)				
				, 'WaterRegionModel': new WpsModel ('WaterRegionModel', dijit.byId('Setting.WaterRegionModel'),
						function() {
							var _p = {};
							
							return {id: 'WaterRegionModel', params: _p};
						}
						,null
				)
			};


	
	this.selectBasin = function() {
		while(this.basinLayer.selectedFeatures.length > 0){
			var _f = this.basinLayer.selectedFeatures.pop();
			_f.style = this.basinLayer.style;
			this.basinLayer.drawFeature(_f);
		}

		//Change style with the selected feature
		var _f = this.selectFeatureById(this.basinLayer, dijit.byId('listCatchment').item.fid);
		_f.style = this.basinLayer.styleMap.styles.select.defaultStyle;
		
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
		        	wetland.initModelList(response, 'et', 'modelET');
		        	wetland.initModelList(response, 'water table', 'modelWaterTable');
		        	wetland.initModelList(response, 'water region', 'modelWaterRegion');
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
	};
	
	this.loadWaterLevelOnMap = function(e){
		var _t = e.target;
		
		var _params = {'id': _t.processId};
		wetland.progressBar.pushProgress('Load water level');
		dojo.xhrGet({ //
//	        url: "test.txt",
	        url: "model/processData.do",
	        handleAs: "json",
	        content: _params,
	        timeout: 60000,
	        load: function(response, ioArgs) {
				wetland.progressBar.popProgress();
				
				if(wetland.waterAnimation){
					wetland.waterAnimation.clean();
				}
				
				if(response.date.length == 0)
					alert('No level');
				else{
					wetland.waterAnimation = new WaterLevelAnimation(response.inputs.basin, response.date, response.waterLevel);
					wetland.waterAnimation.show();
					wetland.waterAnimation.moveToPosition(0);
				}
			},
	        error: this.errorFunction
		});
	};
}

function WpsModel (id, dialog, saveSetting , execute) {
	this.id = id;
	this.dialog = dialog;
	this.saveSetting = saveSetting;
	this.execute = execute;
}

function ModelResult() {
   	this.panelDiv = document.createElement('div');
   	this.panelDiv.className = 'resultPanel';

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

     	var _viewDiv = document.createElement('span');
     	_textDiv.appendChild(_viewDiv);
//     	_viewDiv.target = '_blank';
     	_viewDiv.className = 'resultLink';
//     	_viewDiv.href = '#';
     	_viewDiv.processId = param.id;
     	_viewDiv.innerHTML = 'Animation on map';

     	var _spaceDiv = document.createElement('span');
     	_spaceDiv.innerHTML = '  ';
     	_textDiv.appendChild(_spaceDiv);

     	var _dataDiv = document.createElement('a');
     	_textDiv.appendChild(_dataDiv);
     	_dataDiv.target = '_blank';
     	_dataDiv.className = 'resultLink';
     	_dataDiv.href = 'model/processOutputExcel.do?id=' + param.id;
     	_dataDiv.innerHTML = 'Download results';
     	
     	dojo.connect(_viewDiv, "onclick", wetland, 'loadWaterLevelOnMap');
//     	_viewDiv.onclick = wetland.loadWaterLevelOnMap;

//     	var _linkDiv = document.createElement('a');
//     	_textDiv.appendChild(_linkDiv);
//     	_linkDiv.target = '_blank';
//     	_linkDiv.className = 'resultLink';
//     	_linkDiv.href = 'runoffView.do?code=' + param.id;
//     	_linkDiv.innerHTML = 'View Data>>';
     	
     	//Create chart panel
     	var _chartDiv = document.createElement("div");
     	_chartDiv.className = 'chartPanel';
     	_chartDiv.setAttribute('id', 'chart_' + param.id);
     	
     	this.panelDiv.appendChild(_chartDiv);
     	
     	//Load data for chart
		dojo.xhrGet({ //
	        url: "model/processData.do", 
	        handleAs: "json",
	        content: {id: param.id},
	        timeout: 60000,
	        load: function(response, ioArgs) {
	        	var _id = ioArgs.args.content.id;
	        	
	        	var _cols = [
	        	             {'id': 'eT', 'title': 'ET', 'color': '#CC6600'},
	        	             {'id': 'waterLevel', 'title': 'WaterLevel', 'color': '#0033FF'},
	        	             {'id': 'precipitation', 'title': 'Precipitation', 'color': '#666699'}
	        	             ];
	        	
	            var _data = new google.visualization.DataTable();
	            
	            //Add columns
	            _data.addColumn('date', 'Date');
	            
	            var i = 0;
	            for(i=0;i<_cols.length;i++){
	            	_data.addColumn('number', _cols[i].title);
	            }
	            
	            var _days = response.date;
	            //Add rows
	            _data.addRows(_days.length);
	            
	            var _r = 0;
	            for(_r=0;_r < _days.length;_r++){
	            	_data.setValue(_r, 0, new Date(_days[_r]));
	            	
	            	for(i=0;i<_cols.length;i++){
	            		_data.setValue(_r, i+1, response[_cols[i].id][_r]);
	            	}
	            }
	            
	            var _colors = [];
	            for(i=0;i<_cols.length;i++){
	            	_colors.push(_cols[i].color);
	            }
	            
	            //Create chart
	            var _chart = new google.visualization.AnnotatedTimeLine(document.getElementById('chart_' + _id));
	            _chart.draw(_data, {displayAnnotations: true, colors: _colors});
	        }
			,error: wetland.errorFunction
		});
     	
//     	var i = 0;
//     	for(i=0;i<tags.length;i++){
//	     	var _newImg = document.createElement("img");
//	     	_newImg.src = "model/processChart.do?tag=" + tags[i] + "&date=" + ((new Date()).getTime() + 1) + "&id=" + param.id;
//	     	this.panelDiv.appendChild(_newImg);
//	     	this.panelDiv.className = 'resultPanel';
//     	}
     	
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
			(new ModelResult()).addResultChartPanel(['eT,waterLevel,precipitation'], [''], _param);
			wetland.progressBar.popProgress();
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

function WaterLevelAnimation(basin, dates, levels) {
	this.panel = dojo.byId('waterLevelPanel');
	this.button = dijit.byId('btnStartAnimation');
	this.animationType = dijit.byId('listAnimationType');
	this.basin = basin;
	this.dates = dates;
	this.levels = levels;	
	this.timerId = -1;
	this.pos = -1;
	this.running = false;
	
	this.clean = function() {
		wetland.waterLayer.removeFeatures(wetland.waterLayer.features);
		this.panel.style.visibility = 'hidden';
		this.panel.style.height = '0px';
	};
	
	this.show = function() {
		this.panel.style.visibility = 'visible';
		this.panel.style.height = '26px';
	};
	
	this.moveToPosition = function(pos){
		if(this.running == true){
			return false;
		}
		
		var _pos = pos;
		if(_pos < 0){
			_pos = 0;
		}
		else if(_pos >= this.dates.length && this.dates.length > 0){
			_pos = this.dates.length-1;
			alert('The animation reached the end');
			
			return false;
		}
		if(_pos == this.pos){
			return false;
		}
		
		this.pos = _pos;
		
		dijit.byId('dateWaterLevel').setValue(new Date(this.dates[this.pos]));
		dijit.byId('valWaterLevel').setValue(this.levels[this.pos]);
		
		var _v = this.levels[this.pos];
		if(_v <= 0){
			wetland.waterLayer.removeFeatures(wetland.waterLayer.features);
			wetland.progressBar.popProgress();

			return true;
		}
		
		this.running = true;
		wetland.progressBar.pushProcess('Execute model', this.loadWaterLevel, this, [_v]);
		
		return true;
	};
	
	this.changeDate = function(){
		if(this.timerId > 0){
			return false;
		}
		
		var _t = dijit.byId('dateWaterLevel').getValue().getTime()
		
		var _p = this.findPosition(_t);
		if(_p != this.pos && _p >= 0){
			this.moveToPosition(_p);
			return true;
		}

		return false;
	};
	
	this.findPosition = function (v) {
		if(this.dates.length == 0){
			return -1;
		}
		
		var i;
		for(i=0;i<this.dates.length;i++){
			if(this.dates[i] == v){
				return i;
			}
		}
		
		if(v < this.dates[0])
			return 0;
		else if(v > this.dates[this.dates.length -1])
			return this.dates.length -1;
		else
			throw 'Failed to date:' + new Date(v);
	};
	
	this.loadWaterLevel = function(v){
		var _modelParam = {};
		_modelParam['WaterRegion'] = wetland.models[wetland.getItemFromCombox(dijit.byId('modelWaterRegion')).id].saveSetting();

		var _params = {
				'basin': this.basin,
				'level': v,
				'params': _modelParam
			};
		
		dojo.xhrGet({ //
	        url: "model/waterRegionStart.do", 
	        handleAs: "xml",
	        content: {"params": dojo.toJson(_params)},
	        timeout: 60000,
	        'load': function(response, ioArgs) {
				if(response != null){
					if(response.documentElement.nodeName == 'error'){
						alert(response.documentElement.childNodes[0].nodeValue);
					}
					else{
						var _options = {
								'internalProjection': map.projection,
								'externalProjection': map.displayProjection
							};
						
						var _gml = new OpenLayers.Format.GML(_options);
						var _fs = _gml.read(response);

						wetland.waterLayer.removeFeatures(wetland.waterLayer.features);
						wetland.waterLayer.addFeatures(_fs);
					}
				}
				else{
					alert('Failed to load basins.');
				}
				wetland.progressBar.popProgress();
				wetland.waterAnimation.running = false;
	        }
	        ,'error': function(response, ioArgs){
	        	wetland.errorFunction(response, ioArgs);
	        	wetland.waterAnimation.running = false;
	        	
	        	wetland.waterAnimation.stopAnimation();
	        }
		});
	};
	
	this.switchAnimation = function (){
		if(this.timerId > 0){
			this.stopAnimation();
		}
		else{
			this.startAnimation();
		}
	};
	
	this.startAnimation = function (){
		if(this.dates == null || this.levels == null){
			alert('No water table records');
			return;
		}
		
		this.timerId = setInterval("invokeTime()", 1000);
		this.button.setLabel('Stop');
	};
	
	this.stopAnimation = function (){
		if(this.timerId > 0){
			clearInterval(this.timerId);
		}
		this.timerId = -1;

		this.button.setLabel('Start');
	};
	
	this.processAnimation = function() {
		if(this.running == true)
			return false;
		
		if(this.pos < 0 || this.pos >= this.dates.length){
			return false;
		}
		
		var _animationType = this.animationType.getValue();
		var _jump = 0;
		
		var _d = new Date(this.dates[this.pos]);
		if(_animationType == 'weekly'){
			_jump = 7;
		}
		else if(_animationType == 'daily'){
			_jump = 1;
		}
		else if(_animationType == 'monthly'){
			var _month = _d.getMonth();
			if(_month == 0 || _month == 2 || _month == 4 || _month == 6 || _month == 7 || _month == 9 || _month == 11){
				_jump = 31;
			}
			else if(_month == 3 || _month == 5 || _month == 8 || _month == 10){
				_jump = 30;
			}
			else if(_month == 1 && this.isLeapYear(_d.getFullYear())){
				_jump = 29;
			}
			else if(_month == 1 && !this.isLeapYear(_d.getFullYear())){
				_jump = 28;
			}
			else{
				throw 'Unknown month type';
			}
		}
		else if(_animationType == 'yearly'){
			if(this.isLeapYear(_d.getFullYear())){
				_jump = 366;
			}
			else{
				_jump = 365;
			}
		}
		else{
			throw 'Unknown animation type:' + _animationType;
		}
		
		if(this.moveToPosition(this.pos + _jump) == false){
			this.stopAnimation();
		}
		return true;
	};
	
	this.isLeapYear = function(y){
		if((y % 400) == 0 || ((y % 4) == 0 && (y % 100) != 0)){
			return true;
		}
		else{
			return false;
		}
	};
}

function invokeTime(){
	wetland.waterAnimation.processAnimation.apply(wetland.waterAnimation);
}
