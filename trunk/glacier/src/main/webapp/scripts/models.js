
var temperatureHandler = null;
var showTip = true;

function invokeTemperatureModel() {
	_tDate = dijit.byId('temperatureDate').getValue();
	_tDist = dijit.byId('temperatureMaxDistance').getValue();
	
	if(_tDate == undefined){
		alert('没有提供日期');
		return;
	}
	if(isNaN(_tDist)){
		alert('没有提供最大搜索半径');
		return;
	}
	
	_tX = dijit.byId('temperaturePointX').getValue();
	_tY = dijit.byId('temperaturePointY').getValue();
	if(isNaN(_tX) || isNaN(_tY)){
		alert('没有提供目标坐标');
		return;
	}
	
	_content = {};
	_content['date'] = _tDate.getTime();
	_content['maxDistance'] = _tDist;
	_content['x'] = _tX;
	_content['y'] = _Y;
	
	dojo.xhrGet({ //
        url: "models/temperatureModel", 
        handleAs: "json",
        content: _content,
        timeout: 60000,
        load: function(response, ioArgs) {
//        	alert(response.status);
        	if(response.status == 'finish'){
        	}
        },
        error: function(response, ioArgs) { //
		}
	});
}

temperatureHandler = null;
function temperaturePointSelect(){
	if(showTip){
		dijit.byId('temperateurePointSelectTip').show();
		return;
	}
	if(temperatureHandler == null){
		temperatureHandler = new OpenLayers.Control();
		OpenLayers.Util.extend(temperatureHandler,{ 
					draw: function() {
						this.handler = new OpenLayers.Handler.Point(this, 
									{"done": this.notice},
									{keyMask: OpenLayers.Handler.MOD_NONE});
					},
					notice: function (pt) {
						dijit.byId('temperaturePointX').setValue(pt.x);
						dijit.byId('temperaturePointY').setValue(pt.y);
						
						this.deactivate();
					}
				});
		
		map.addControl(temperatureHandler);
	}
	temperatureHandler.activate();
}

function temperaturePointSelectTip(){
	showTip = !dijit.byId('temperaturePointSelectTipCheck').getValue();
	temperaturePointSelect();
}

