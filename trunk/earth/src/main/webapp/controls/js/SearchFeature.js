/**
 * @requires OpenLayers/Control.js
 * @requires OpenLayers/Feature/Vector.js
 *
 * Class: OpenLayers.Control.DrawFeature
 * Draws features on a vector layer when active.
 *
 * Inherits from:
 *  - <OpenLayers.Control>
 */
OpenLayers.Control.SearchFeature = OpenLayers.Class(OpenLayers.Control, {
	
	/**
 	* Property: layer
 	* {<OpenLayers.Layer.Vector>}
 	*/
	layer: null,
	type: OpenLayers.Control.TYPE_TOOL,

	/**
 	* Constructor: OpenLayers.Control.SearchFeature
 	* 
 	* Parameters:
 	* layer - {<OpenLayers.Layer.Vector>} 
 	* options - {Object} 
 	*/
	initialize: function(layer, options) {
		OpenLayers.Control.prototype.initialize.apply(this, [options]);

		this.layer = layer;
		this.handler = new OpenLayers.Handler.Box( this,
							{done: this.searchFeature}, {keyMask: this.keyMask} );
	},

	/**
 	* Method: SearchFeature
 	*/
	searchFeature: function(geometry) {
		this.layer.clearMarkers();
		
		var position = geometry
		if (position instanceof OpenLayers.Bounds) {
		}
		else{
			position = new OpenLayers.Bounds(position.x - 0.01, position.y - 0.01, position.x + 0.01, position.y + 0.01);
		}

		var minXY = this.map.getLonLatFromPixel(
						new OpenLayers.Pixel(position.left, position.bottom));
		var maxXY = this.map.getLonLatFromPixel(
						new OpenLayers.Pixel(position.right, position.top));
		var bounds = new OpenLayers.Bounds(minXY.lon, minXY.lat,
										   maxXY.lon, maxXY.lat);
		
		this.layer.addMarker(new OpenLayers.Marker.Box(bounds));
		changeExtentByBounds(bounds);
	},

	CLASS_NAME: "OpenLayers.Control.SearchFeature"
});
