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
		this.handler = new OpenLayers.Handler.Point( this,
							{done: this.searchFeature}, {keyMask: this.keyMask} );
	},

	/**
 	* Method: SearchFeature
 	*/
	searchFeature: function(geometry) {
		this.layer.eraseFeatures(this.layer.features);

		//this.layer.addFeatures(new OpenLayers.Feature.Vector(geometry));
		changeExtentByBounds(geometry);
	},

	CLASS_NAME: "OpenLayers.Control.SearchFeature"
});
