
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
	
	var layer2 = new OpenLayers.Layer.WMS("Wetland", "http://152.61.40.52:58080/geoserver/wms?", {layers: "wet:wetland", transparent: true});


	map.addLayer(layer);
	map.addLayer(layer2);
	
	var vlayer = new OpenLayers.Layer.Vector('Markers');
	map.addLayer(vlayer);
	
	map.addControl(new OpenLayers.Control.DataViewToolbar(vlayer));

	map.setCenter(new OpenLayers.LonLat(-99.10, 47.10), 2);
}

function changeExtentByBounds(pt){
	window.open('chart.do?pt=' + pt.toShortString(), 'chart');
}
