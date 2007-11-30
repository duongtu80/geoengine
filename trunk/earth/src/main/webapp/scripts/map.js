var vlayer=null;

function initMap() {
    var _resolutions = [
//        1.40625, 
//        0.703125, 
//        0.3515625, 
        0.17578125, 
        0.087890625, 
        0.0439453125,
        0.02197265625, 
        0.010986328125, 
        0.0054931640625
//        0.00274658203125,
//        0.001373291015625, 
//        0.0006866455078125, 
//        0.00034332275390625,
//        0.000171661376953125, 
//        0.0000858306884765625, 
//        0.00004291534423828125,
//        0.00002145767211914062, 
//        0.00001072883605957031,
//        0.00000536441802978515, 
//        0.00000268220901489257
    ];
    
	var options = {
				resolutions: _resolutions,
//                minExtent: new OpenLayers.Bounds(-10, -10, 10, 10), 
//                maxExtent: new OpenLayers.Bounds(-180, -90, 180, 90), 
				'numZoomLevels': 7,
                controls: [new OpenLayers.Control.MouseDefaults()]
	          };

	OpenLayers.IMAGE_RELOAD_ATTEMPTS = 3;
	OpenLayers.Util.onImageLoadErrorColor = "transparent";

	var map = new OpenLayers.Map('map', options);
	
	map.addControl(new OpenLayers.Control.PanZoomBar());

	// create Virtual Earth layers
//	var layer = new OpenLayers.Layer.VirtualEarth(
//	    "Virtual Earth Raods",
//	    {'type': VEMapStyle.Road, 'sphericalMercator': true}
//	); 
	// create WMS layer

//    var layer = new OpenLayers.Layer.Google( "Google Satellite", {type: G_HYBRID_MAP, 'minZoomLevel':4,'maxZoomLevel':7} );
	var layer = new OpenLayers.Layer.WMS( "OpenLayers WMS", 
	        "http://labs.metacarta.com/wms/vmap0", {layers: 'basic'});

//	map.addControl(new OpenLayers.Control.LayerSwitcher({'ascending':false}));
	
	map.addLayer(layer);

	map.setCenter(new OpenLayers.LonLat(-100, 40), 0);
}

function changeExtentByBounds(bounds) {
	dojo.byId('minX').value = bounds.left.toFixed(2);
	dojo.byId('minY').value = bounds.bottom.toFixed(2);
	dojo.byId('maxX').value = bounds.right.toFixed(2);
	dojo.byId('maxY').value = bounds.top.toFixed(2);
}

function search(){
	if(vlayer.markers.length == 0){
		alert('No spatial extent');
		return;
	}
	
	var _bounds = vlayer.markers[0].bounds;
	var _start = dojo.byId('startDate').value;
	var _end = dojo.byId('endDate').value;
	
	var _url = 'process/search.do?minx=' + _bounds.left +
			 '&miny=' + _bounds.bottom +
			 '&maxx=' + _bounds.right + 
			 '&maxy=' + _bounds.top
	if(_start != ''){
		_url += '&start=' + _start;		
	}
	if(_end != ''){
		_url += '&end=' + _end;
	}

//	alert(_url);
	window.open(_url);
}