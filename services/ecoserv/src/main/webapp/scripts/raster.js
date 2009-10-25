

var map;

function mapInit() {
	map = new OpenLayers.Map('map');

    var options = {numZoomLevels: 3};

    var wms = new OpenLayers.Layer.WMS( "OpenLayers WMS",
            "http://labs.metacarta.com/wms/vmap0",
            {layers: 'basic'} );

    var layer_select = OpenLayers.Util.extend({}, OpenLayers.Feature.Vector.style['select']);
//    layer_select.fillOpacity = 0.8;
//    layer_select.strokeColor = "#634c0b";
    layer_select.strokeWidth = 0.5;
    layer_select.strokeColor = "#ffa218";
    layer_select.fillColor = "#ff6718";

    var layer_style = OpenLayers.Util.extend({}, OpenLayers.Feature.Vector.style['default']);
    layer_style.fillOpacity = 0.8;
    layer_style.strokeColor = "#333333";
    layer_style.strokeWidth = 0.2;
//
//    var style_blue = OpenLayers.Util.extend({}, layer_style);
//    style_blue.strokeColor = "#333333";
//    style_blue.fillColor = "blue";
//    style_blue.strokeWidth = 1;
//    
//    var style_red = OpenLayers.Util.extend({}, layer_style);
//    style_red.strokeColor = "#333333";
//    style_red.fillColor = "red";
//    style_red.strokeWidth = 1;
//    
    var features= [];
    var cellSize = 0.083;
    
    var lookup = {
    			0: {fillColor: '#007f00'},
    			1: {fillColor: '#92ff00'},
    			2: {fillColor: '#ca9d9d'},
    			3: {fillColor: '#0a70b1'}
    		};
    
	var _styleMap = new OpenLayers.StyleMap({'default': layer_style, 'select': layer_select});
	_styleMap.addUniqueValueRules("default", "v", lookup);
	
    vector = new OpenLayers.Layer.Vector("Test", {'styleMap': _styleMap});
    
    var startY = 40;
    for(var y = 0; y < 40; y++){
        var startX = -110;
    	for(var x = 0; x < 50; x++){
    	    var poly = new OpenLayers.Bounds(startX,startY-cellSize,startX+cellSize,startY).toGeometry();
//    	    var feature = new OpenLayers.Feature.Vector(poly, null);
    	    var feature = new OpenLayers.Feature.Vector(poly, {'path': x, 'row': y, 'v': 0});
    	    features.push(feature);
    		
    		startX += cellSize;
    	}
    	startY -= cellSize;
    }
    
    vector.addFeatures(features);
    
    map.addLayers([wms, vector]);

    toolSelection = new OpenLayers.Control.SelectFeature(
    		vector,
            {
                clickout: false, toggle: false,
                multiple: true, hover: false,
                toggleKey: "ctrlKey", // ctrl key removes from selection
                multipleKey: "shiftKey", // shift key adds to selection
                box: true
            }
        );
    
    map.addControl(new OpenLayers.Control.LayerSwitcher());
    map.addControl(toolSelection);
    
    map.zoomToMaxExtent();
}

function toggleSelection(select){
	if(select){
		toolSelection.activate();
	}
	else{
		toolSelection.deactivate();
	}
}

function clearSelection(){
	toolSelection.unselectAll();
}

function changeCover(type){
//	alert(vector.selectedFeatures.length);
	for(var i=0;i<vector.selectedFeatures.length;i++){
		vector.selectedFeatures[i].attributes.v = type;
	}
	clearSelection();
}