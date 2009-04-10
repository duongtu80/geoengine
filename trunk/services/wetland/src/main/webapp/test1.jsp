<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>Markers Layer Example</title>
    <link rel="stylesheet" href="http://www.openlayers.org/dev/theme/default/style.css" type="text/css" />
    <link rel="stylesheet" href="http://www.openlayers.org/dev/examples/style.css" type="text/css" />
    <script src="http://www.openlayers.org/dev/OpenLayers.js"></script>
    <script type="text/javascript">
        var map, layer;

        function init(){
            map = new OpenLayers.Map('map');
            layer = new OpenLayers.Layer.WMS( "OpenLayers WMS", 
                "http://labs.metacarta.com/wms/vmap0", {layers: 'basic'} );
                
            map.addLayer(layer);
            map.setCenter(new OpenLayers.LonLat(0, 0), 0);

            var newl = new OpenLayers.Layer.Text( "text", { location:"./eeeee3.txt"} );
            map.addLayer(newl);

            var markers = new OpenLayers.Layer.Markers( "Markers" );
            map.addLayer(markers);

            var size = new OpenLayers.Size(25,25);
            var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
            var icon = new OpenLayers.Icon('images/waterfowls/Gadwall.gif',size,offset);
            markers.addMarker(new OpenLayers.Marker(new OpenLayers.LonLat(0,0),icon));

            var halfIcon = icon.clone();
            markers.addMarker(new OpenLayers.Marker(new OpenLayers.LonLat(0,45),halfIcon));

            marker = new OpenLayers.Marker(new OpenLayers.LonLat(90,10),icon.clone());
            marker.setOpacity(0.2);
            marker.events.register('mousedown', marker, function(evt) { alert(this.icon.url); OpenLayers.Event.stop(evt); });
            markers.addMarker(marker); 
            map.addControl(new OpenLayers.Control.LayerSwitcher());
            map.zoomToMaxExtent();

            halfIcon.setOpacity(0.5);
        }
    </script>
  </head>

  <body onload="init()">
    <div id="title">Markers Layer Example</div>
    <div id="tags"></div>
    <div id="shortdesc">Show markers layer with different markers</div>
    <div id="map" class="smallmap"></div>
    <div id="docs">
        This is an example of an OpenLayers.Layers.Markers layer that shows some examples of adding markers.  Also demonstrated is registering a mousedown effect on a marker.
    </div>

  </body>
</html>
