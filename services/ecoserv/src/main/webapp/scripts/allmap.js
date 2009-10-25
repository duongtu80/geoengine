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
                controls: [new OpenLayers.Control.MouseDefaults()]
	          };

	var map = new OpenLayers.Map('map', options);
	
	map.addControl(new OpenLayers.Control.PanZoomBar());
	var layer = new OpenLayers.Layer.WMS( "OpenLayers WMS", 
	        "http://labs.metacarta.com/wms/vmap0", {layers: 'basic'});

//	var tmlayer = new OpenLayers.Layer.WMS.Untiled("TM Path and Row", "/geoserver/wms?", {layers:'geo:tm_path_row',transparent:true, format:'image/gif'});
	
	map.addLayer(layer);
//	map.addLayers([layer, tmlayer]);
	var tm2layer = new OpenLayers.Layer.WFS("Fire Statistic", "/geoserver/wfs?", {typename: "geo:firestatistic"}, {extractAttributes: true});
	
	tm2layer.preFeatureInsert = function(feature) {
		feature.style.strokeWidth= '2';
		feature.style.strokeColor = 'white';
		var _op = feature.attributes['count'] / 20.0
		if(_op > 1){
			_op = 1;
		}
		feature.style.fillOpacity = _op; 
	}
	
	map.events.register('click', map, function(e){
			var _f = tm2layer.getFeatureFromEvent(e);
			if(_f != null){
				dojo.xhrGet({
					url: '../process/imageInfo.do?path=' + _f.attributes['path'] + '&row=' + _f.attributes['row'],
					handleAs: 'json',
					load: function(response, ioArgs) {
//						dojo.byId('resultPanel').innerHTML = '';
						
						var _txt = '<div>Path=' + _f.attributes['path'] + ' Row=' + _f.attributes['row'] + '</div>';
						for(var _len=0; _len<response.result.length; _len++){
							_d = response.result[_len];
							_txt += '<div class="resultItem"><a href="../manage/imageEdit.do?id=' + _d.id + '">' + _d.date + ',' + _d.sensor + ',' + _d.source + '</a></div>\n'; 
						}
						dojo.byId('resultPanel').innerHTML = _txt;
					},
					error: function(response, ioArgs) {
						alert('Error:' + ioArgs.xhr.status);
					}
				});
			}
			else{
				dojo.byId('resultPanel').innerHTML = '';
			}
		}
	);

	map.addLayer(tm2layer);

	map.setCenter(new OpenLayers.LonLat(_x, _y), 3);
}
