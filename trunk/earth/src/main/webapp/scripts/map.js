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
	vlayer = new OpenLayers.Layer.Vector("Cities");

//	map.addControl(new OpenLayers.Control.LayerSwitcher({'ascending':false}));
	
	map.addLayer(layer);
	map.addLayer(vlayer);

	map.setCenter(new OpenLayers.LonLat(-100, 40), 0);
}

function search(){
	var _processTip = dojo.byId('processTip');
	_processTip.innerHTML = 'Loading...';
	_processTip.style.visibility = 'visible';
	
	dojo.xhrGet({ //
        // The following URL must match that used to test the server.
        url: "http://127.0.0.1:8080/earth/search.do", 
        handleAs: "xml",
        content: {
        	'url': dojo.byId('serviceUrl').value,
        	'seaLevel': dojo.byId('seaLevel').value
        },
        timeout: 20000, // Time in milliseconds
        // The LOAD function will be called on a successful response.
        load: function(response, ioArgs) { //
        	var _gml = new OpenLayers.Format.GML();
        	var _fs = _gml.read(response);
        	
        	vlayer.eraseFeatures(vlayer.features);
        	vlayer.addFeatures(_fs);

			_processTip.style.visibility = 'hidden';
        },

        // The ERROR function will be called in an error case.
        error: function(response, ioArgs) { //
			console.error("HTTP status code: ", ioArgs.xhr.status); //
//			alert('error:' + "HTTP status code: " + ioArgs.xhr.status);
			_processTip.style.innerHTML = 'error';
		}
	});
}