
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
	
	var layer2 = new OpenLayers.Layer.WMS("Wetland", "http://127.0.0.1:58080/geoserver/wms?", {layers: "wet:wetland", transparent: true});


	map.addLayer(layer);
	map.addLayer(layer2);
	
	var vlayer = new OpenLayers.Layer.Vector('Markers');
	map.addLayer(vlayer);
	
	map.addControl(new OpenLayers.Control.DataViewToolbar(vlayer));
	map.setCenter(new OpenLayers.LonLat(-99.10, 47.10), 2);
	
	dojo.byId('imgWaterTable').onload = chartLoaded;
}

function changeExtentByBounds(pt){
	dojo.byId('divWaterTableText').style.visibility = 'hidden';
	dojo.byId('divWetlandInfo').style.visibility = 'hidden';
	dojo.byId('imgWaterTable').src = null;

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
				_processTip.innerHTML = 'calculating water table ...';
				
				var _url = 'chartWaterTable.do?pt=' + pt.toShortString();
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
				if(dojo.byId('startDate').value != ''){
					_url += '&startDate=' + dojo.byId('startDate').value;
				}
				if(dojo.byId('endDate').value != ''){
					_url += '&endDate=' + dojo.byId('endDate').value;
				}
				
//				alert(_url);
				dojo.byId('imgWaterTable').src = _url;
				//dojo.byId('imgWaterTable').src = 'chartWaterTable.do?pt=' + pt.toShortString();
        	}
        	else{
   	        	_processTip.innerHTML = 'finished';
        	}
        },
        error: function(response, ioArgs) { //
			console.error("HTTP status code: ", ioArgs.xhr.status); //
			_processTip.innerHTML = 'error';
		}
	});

//	window.open('chart.do?pt=' + pt.toShortString(), 'chart');
}

function chartLoaded() {
	dojo.byId('divWaterTableText').style.visibility = 'visible';
	dojo.byId('processTip').innerHTML = 'finished';
}