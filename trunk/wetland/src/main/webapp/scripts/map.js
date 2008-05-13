var wetlandData;
var wetlandIndex = -1;
var waterLayer;
var waterlandCode;

function initMap() {
    var _resolutions = [
//        1.40625, 
//        0.703125, 
//        0.3515625, 
//        0.17578125, 
//        0.087890625, 
//        0.0439453125,
//        0.02197265625, 
//        0.010986328125, 
//        0.0054931640625
//        0.00274658203125,
//        0.001373291015625, 
//        0.0006866455078125, 
//        0.00034332275390625,
        0.000171661376953125, 
        0.0000858306884765625, 
        0.00004291534423828125,
        0.00002145767211914062, 
        0.00001072883605957031,
        0.00000536441802978515, 
        0.00000268220901489257
    ];
    
	var options = {
				resolutions: _resolutions,
//                minExtent: new OpenLayers.Bounds(-10, -10, 10, 10), 
//                maxExtent: new OpenLayers.Bounds(-180, -90, 180, 90), 
				'numZoomLevels': 7,
                controls: [new OpenLayers.Control.MouseDefaults(), new OpenLayers.Control.PanZoomBar()]
	          };

	OpenLayers.IMAGE_RELOAD_ATTEMPTS = 3;
	OpenLayers.Util.onImageLoadErrorColor = "transparent";

	var map = new OpenLayers.Map('map', options);
	

	var layer =	new OpenLayers.Layer.WMS("Blue Marble", 
			["http://labs.metacarta.com/wms-c/Basic.py?","http://t2.labs.metacarta.com/wms-c/Basic.py?", "http://t1.labs.metacarta.com/wms-c/Basic.py?"], {layers: 'satellite'} 
	);
	
	var layer2 = new OpenLayers.Layer.WMS("Wetland", wetlandWMS, {layers: wetlandLayers, transparent: true});


	map.addLayer(layer);
	map.addLayer(layer2);
	
	var vlayer = new OpenLayers.Layer.Vector('Markers');
	map.addLayer(vlayer);

	waterLayer = new OpenLayers.Layer.Vector("Water");
	waterLayer.style = OpenLayers.Util.extend({'fill':'black'}, OpenLayers.Feature.Vector.style['default']);
	
	waterLayer.style.pointRadius = 3;
	waterLayer.style.strokeColor = '#3377FF';
	waterLayer.style.fillColor = '#5599FF';
	
	map.addLayer(waterLayer);
	
	map.addControl(new OpenLayers.Control.DataViewToolbar(vlayer));
	map.setCenter(new OpenLayers.LonLat(-99.10, 47.10), 2);
	
	dojo.byId('imgWaterTable').onload = chartLoaded;
	goData(-1);
}

function changeExtentByBounds(pt){
//	dojo.byId('divWaterTableText').style.visibility = 'hidden';
//	dojo.byId('divWetlandInfo').style.visibility = 'hidden';
//	dojo.byId('imgWaterTable').src = null;

	var _processTip = dojo.byId('processTip');
	_processTip.innerHTML = 'loading...';

	dojo.xhrGet({ //
        url: "searchWetland.do", 
        handleAs: "json",
        content: {
        	'pt': pt.toShortString()
        },
        
        timeout: 60000,
        load: function(response, ioArgs) {
        	dojo.byId('txtWetland').innerHTML = response.code;
        	dojo.byId('txtLocation').innerHTML = response.pt;

			dojo.byId('divWetlandInfo').style.visibility = 'visible';

        	if(response.code != 'not found'){
        		dijit.byId('btnCalculateWaterTable').setDisabled(false);
        	}
        	else{
        		dijit.byId('btnCalculateWaterTable').setDisabled(true);
        	}
        	_processTip.innerHTML = 'finished';
        },
        error: function(response, ioArgs) { //
			console.error("HTTP status code: ", ioArgs.xhr.status); //
			_processTip.innerHTML = 'error';
		}
	});

//	window.open('chart.do?pt=' + pt.toShortString(), 'chart');
}

function chartLoaded() {
}

function calculateWaterTable(){
	dijit.byId('btnCalculateWaterTable').setDisabled(true);
	dijit.byId('btnCalculateWaterTable').setLabel('Calculating...');
	
	var _processTip = dojo.byId('processTip');
	_processTip.innerHTML = 'calculating water table ...';
	
	var _url = 'chartWaterTable.do?pt=' + dojo.byId('txtLocation').innerHTML;
	if(dojo.byId('txtAlbedo').value != ''){
		_url += '&waterTableModel.etModel.albedo=' + dojo.byId('txtAlbedo').value;
	}
	if(dojo.byId('txtWindSpeed').value != ''){
		_url += '&waterTableModel.etModel.windSpeed=' + dojo.byId('txtWindSpeed').value;
	}
	if(dojo.byId('txtCatchmentArea').value != ''){
		_url += '&waterTableModel.catchmentArea=' + dojo.byId('txtCatchmentArea').value;
	}
	if(dojo.byId('txtSaturationPrcp').value != ''){
		_url += '&waterTableModel.saturationPrcp=' + dojo.byId('txtSaturationPrcp').value;
	}
	if(dojo.byId('txtCoefficient').value != ''){
		_url += '&waterTableModel.etModel.coefficient=' + dojo.byId('txtCoefficient').value;
	}
	if(dojo.byId('txtSpillPoint').value != ''){
		_url += '&waterTableModel.spillPoint=' + dojo.byId('txtSpillPoint').value;
	}
	if(dojo.byId('startDate').value != ''){
		_url += '&startDate=' + dojo.byId('startDate').value;
	}
	if(dojo.byId('endDate').value != ''){
		_url += '&endDate=' + dojo.byId('endDate').value;
	}
	if(dojo.byId('txtDayMetReader').value != ''){
		_url += '&waterTableModel.dayMetReader.url=' + escape(dojo.byId('txtDayMetReader').value);
	}
	_url += '&time=' + (new Date()).getTime();
	
//	alert(formatDate(dijit.byId('startDate').value));
	alert(_url);
	dojo.byId('imgWaterTable').src = _url;
	//dojo.byId('imgWaterTable').src = 'chartWaterTable.do?pt=' + pt.toShortString();
}

function formatDate(d){
	return (d.getMonth() + 1) + "/" + d.getDate() + "/";
}

function calculateWaterTable2(){
	dijit.byId('btnCalculateWaterTable').setDisabled(true);
	dijit.byId('btnCalculateWaterTable').setLabel('Calculating...');
	goData(-1);
	
	var _processTip = dojo.byId('processTip');
	_processTip.innerHTML = 'calculating water table ...';
	
	var _content = {};
	
	_content['pt'] = dojo.byId('txtLocation').innerHTML;
	if(dojo.byId('txtAlbedo').value != ''){
		_content['waterTableModel.etModel.albedo'] = dojo.byId('txtAlbedo').value;
	}
	if(dojo.byId('txtWindSpeed').value != ''){
		_content['waterTableModel.etModel.windSpeed'] = dojo.byId('txtWindSpeed').value;
	}
	if(dojo.byId('txtCatchmentArea').value != ''){
		_content['waterTableModel.catchmentArea'] = dojo.byId('txtCatchmentArea').value;
	}
	if(dojo.byId('txtSaturationPrcp').value != ''){
		_content['waterTableModel.saturationPrcp'] = dojo.byId('txtSaturationPrcp').value;
	}
	if(dojo.byId('txtCoefficient').value != ''){
		_content['waterTableModel.etModel.coefficient'] = dojo.byId('txtCoefficient').value;
	}
	if(dojo.byId('txtSpillPoint').value != ''){
		_content['waterTableModel.spillPoint'] = dojo.byId('txtSpillPoint').value;
	}
	if(dojo.byId('startDate').value != ''){
		_content['startDate'] = dijit.byId('startDate').value.getTime();
	}
	if(dojo.byId('endDate').value != ''){
		_content['endDate'] = dijit.byId('endDate').value.getTime();
	}
	if(dojo.byId('txtDayMetReader').value != ''){
		_content['waterTableModel.dayMetReader.url'] = dojo.byId('txtDayMetReader').value;
	}
	_content['time'] = (new Date()).getTime();
	
//	alert(_content['startDate'] + '|' + _content['endDate']);

	dojo.xhrGet({ //
        url: "chartWaterTable.do", 
        handleAs: "json",
        content: _content,
        timeout: 60000,
        load: function(response, ioArgs) {
//        	alert(response.status);
        	if(response.status == 'finish'){
        		dojo.byId('imgWaterTable').src = "imageStream.do?code=" + response.code;

        		wetlandData = response.data;
	        	waterlandCode = dojo.byId('txtWetland').innerHTML;
	        	
        		if(wetlandData.size > 0){
//        			goData(0);
					var _d = new Date();
					_d.setTime(wetlandData.date[0]);

					dijit.byId('txtCurrentDate').setValue(_d);
//					dojo.byId('txtCurrentDate').value = (_d.getMonth() + 1)  + '/' +  _d.getDate() + '/' + _d.getYear();
        		}
        		
			 	dojo.byId('divWaterTableText').style.visibility = 'visible';
				dijit.byId('btnCalculateWaterTable').setLabel('Calculate');
				dijit.byId('btnCalculateWaterTable').setDisabled(false);
        	}

        	_processTip.innerHTML = 'finished';
        },
        error: function(response, ioArgs) { //
			console.error("HTTP status code: ", ioArgs.xhr.status); //
			_processTip.innerHTML = 'error';
		}
	});
}

function goData(idx){
	if(idx >= 0 && idx < wetlandData.size){
//		var _d = new Date();
//		_d.setTime(wetlandData.date[idx]);
		
//		setDateWidget1('txtCurrentDate', _d);	
//		dojo.byId('txtCurrentDate').value = (_d.getMonth() + 1)  + '/' +  _d.getDate() + '/' + _d.getYear();
		wetlandIndex = idx;
		dijit.byId('txtWaterTable').setValue(wetlandData.water[idx]);
//		dojo.byId('divWaterRegion').style.visibility = 'visible';
//		dijit.byId('btnGoNext').setDisabled(false);
	}
	else{
		dijit.byId('txtWaterTable').setValue(NaN);
//		dojo.byId('divWaterRegion').style.visibility = 'hidden';
//		dijit.byId('btnGoNext').setDisabled(true);
	}
//	dijit.byId('btnGoNext').setLabel('Calculate');
}

function goPrevious(){
	goData(wetlandIndex - 1);
}

function setDateWidget1(n, d){
		var _d = new Date();
		_d.setYear(1990);
		
		dijit.byId(n).value = _d;
		dojo.byId(n).value = (_d.getMonth() + 1)  + '/' +  _d.getDate() + '/' + _d.getYear();
}

//function goNext(){
//	dojo.xhrGet({
//        url: "test.jsp", 
//        handleAs: "json",
//        timeout: 20000,
//        load: function(response, ioArgs) { //
////        	var _gml = new OpenLayers.Format.GML();
////        	var _fs = _gml.read(response);
//        	
//        	var _json = new OpenLayers.Format.GeoJSON();
//        	var _fs = _json.read(response);
//        	
//        	waterLayer.eraseFeatures(waterLayer.features);
//        	waterLayer.addFeatures(_fs);
//        	
////			_processTip.style.visibility = 'hidden';
//        },
//
//        // The ERROR function will be called in an error case.
//        error: function(response, ioArgs) { //
//			console.error("HTTP status code: ", ioArgs.xhr.status); //
////			alert('error:' + "HTTP status code: " + ioArgs.xhr.status);
//		}
//	});
//}

function waterRegionClean(){
	waterLayer.eraseFeatures(waterLayer.features);
}

function waterRegionSet(){
	waterRegionClean();
	waterRegionAdd(true);
}

var _processing = false;
function waterRegionAdd(clear){
	if(wetlandIndex < 0){
		alert('Not found water table records.');
		return;
	}
	
	if(waterlandCode == '' || waterlandCode == 'not found'){
		alert('No wetland selected');
		return;
	}
	
	var _processTip = dojo.byId('processTip');
	_processing = true;
	_processTip.innerHTML = 'loading...';
	
//	dijit.byId('btnGoNext').setLabel('Calculating...');
//	dijit.byId('btnGoNext').setDisabled(true);
	
//	_processTip.style.visibility = 'visible';
	
	dojo.xhrGet({
        url: "waterRegion.do", 
        handleAs: "json",
        content: {
        	'modelUrl': dojo.byId('modelUrl').value,
        	'waterlandCode': waterlandCode,
        	'waterLevel': wetlandData.water[wetlandIndex]
        },
        timeout: 20000,
        load: function(response, ioArgs) { //
//        	var _gml = new OpenLayers.Format.GML();
//        	var _fs = _gml.read(response);
        	
        	var _json = new OpenLayers.Format.GeoJSON();
        	var _fs = _json.read(response);

			var _oldfs = [] 
			if(clear)
				_oldfs = waterLayer.features.slice();
//			for(_ofs in waterLayer.features){
//				_oldfs.add(_ofs);
//			}
			
        	if(_fs.length > 0){
	        	waterLayer.addFeatures(_fs);
        	}
        	else{
//        		alert('Water table too small.');
        	}
        	
        	if(clear)
        		waterLayer.removeFeatures(_oldfs);
        	
        	_processTip.innerHTML = 'finished';
//			_processTip.style.visibility = 'hidden';

//			dijit.byId('btnGoNext').setLabel('Calculate');
//			dijit.byId('btnGoNext').setDisabled(false);

			_processing = false;
        },

        // The ERROR function will be called in an error case.
        error: function(response, ioArgs) { //
			console.error("HTTP status code: ", ioArgs.xhr.status); //
//			alert('error:' + "HTTP status code: " + ioArgs.xhr.status);
			_processTip.innerHTML = 'error';
			_processing = false;
		}
	});
}

var timerId = -1;
function waterRegionAnimateStart(){
	if(timerId > 0){
		waterRegionAnimateEnd();
		dijit.byId('btnGoAnimate').setLabel('Start');
	}
	else{
		if(wetlandData == null || wetlandIndex < 0){
			alert('No water table records');
			return;
		}
		timerId = setInterval("updateWaterRegion()", 1000);
		dijit.byId('btnGoAnimate').setLabel('Stop');
	}
}

function waterRegionAnimateEnd(){
	if(timerId > 0){
		clearInterval(timerId);
	}
	timerId = -1;
}

function updateWaterRegion(){
	if(_processing == true){
		return;
	}
	if(wetlandIndex < wetlandData.size - 7){
		goData(wetlandIndex + 7);

		var _d = new Date();
		_d.setTime(wetlandData.date[wetlandIndex]);
		dijit.byId('txtCurrentDate').setValue(_d);
//		dojo.byId('txtCurrentDate').value = (_d.getMonth() + 1)  + '/' +  _d.getDate() + '/' + _d.getYear();
		
		waterRegionAdd(true);
	}
	else{
		waterRegionAnimateEnd();
	}
//	alert(_d.parse(dojo.byId("txtCurrentDate").value));
}

function searchWaterTable(){
	if(wetlandData == null){
		alert('No water table records');
		return;
	}
	
	var _d = dijit.byId("txtCurrentDate").getValue();
//	alert(_d);
//	var _d = new Date();
//	_d.setTime(Date.parse(dojo.byId("txtCurrentDate").value));
//	alert(_d.parse(dojo.byId("txtCurrentDate").value));
	for(var i=0;i<wetlandData.size;i++){
		var _v = new Date();
		_v.setTime(wetlandData.date[i]);
		
		if(_d.getYear() == _v.getYear() && _d.getMonth() == _v.getMonth() && _d.getDate() == _v.getDate()){
			goData(i);
			return;
		}
	}
	alert('No water table record');
}
