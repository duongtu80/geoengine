var map;

function Map() {
	
	this.loadCatchments = function(){
		this.basinLayer.removeFeatures(this.basinLayer.features);
		var _params = {
				'dataset': 'basins'
			};
		
		dojo.xhrGet({
	        url: 'loadDataset.do', 
	        handleAs: "xml",
	        content: _params,
	        timeout: 60000,
	        load: function(response, ioArgs) {
				if(response != null){
					if(response.documentElement.nodeName == 'error'){
						alert(response.documentElement.childNodes[0].nodeValue);
					}
					else{
						var _options = {
								'internalProjection': map.projection,
								'externalProjection': map.displayProjection
							};
						
						var _gml = new OpenLayers.Format.GML(_options);
						var _fs = _gml.read(response);
						
						wetland.basinLayer.addFeatures(_fs);
						
						var _items = [];
						var i;
						for(i=0;i<_fs.length;i++){
							_items.push({'name': _fs[i].attributes['NAME'], 'fid': _fs[i].fid});
						}
						var _store = new dojo.data.ItemFileReadStore({data: {items: _items}});
						listCatchment.store = _store;
					}
				}
				else{
					alert('Failed to load basins.');
				}
				wetland.progressBar.popProgress();
	        }
			,error: function(response, ioArgs){
	        	alert('Failed to load basins.:' + response.message);
	        	wetland.progressBar.popProgress();
	        }
		});
	};

	this.createDisasterSymbol = function(){
		_default_style = OpenLayers.Util.extend({'fill':'#5588FF'}, OpenLayers.Feature.Vector.style['default']);
		_default_style.fillColor = '#5588FF';
		_default_style.strokeColor = '#5588CC';
		_default_style.strokeWidth = 1;
		
		_selected_style = OpenLayers.Util.extend({'fill':'#2288FF'}, OpenLayers.Feature.Vector.style['default']);
		_selected_style.fillColor = '#FF8855';
		_selected_style.strokeColor = '#CCCC88';
		_selected_style.strokeWidth = 2;

		var _polyStyles = new OpenLayers.StyleMap({"default": _default_style, "select":_selected_style});
		
		return _polyStyles;
	};

	this.init = function() {
		var options = {
			projection : new OpenLayers.Projection("EPSG:900913"),
			displayProjection : new OpenLayers.Projection("EPSG:4326"),
			units : "m",
			maxExtent : new OpenLayers.Bounds(-20037508.34, -20037508.34,
					20037508.34, 20037508.34),
			controls : [ new OpenLayers.Control.Navigation(),
					// new OpenLayers.Control.PanZoom(),
					new OpenLayers.Control.ArgParser(),
					new OpenLayers.Control.Attribution() ]
		};
	
		map = new OpenLayers.Map(options);
	
//		map.addLayers([
//		               new OpenLayers.Layer.Google("Satellite", {'type': G_SATELLITE_MAP, 'sphericalMercator': true, 'minZoomLevel': 13}),
//		               new OpenLayers.Layer.Google("Terrain", {'type': G_PHYSICAL_MAP, 'sphericalMercator': true, 'minZoomLevel': 13}),
//		               new OpenLayers.Layer.Google("Normal", {'type': G_NORMAL_MAP, 'sphericalMercator': true, 'minZoomLevel': 13})
//				 ]);

		var _layer = new OpenLayers.Layer.Google("Google Streat", {
			numZoomLevels : 30,
			sphericalMercator : true
		});
		
		map.addLayer(_layer);

//		var _basin_layer = new OpenLayers.Layer.Vector("Catchments", {styleMap: this.createDisasterSymbol()});
//		map.addLayer(_basin_layer);

//		var _water_layer = new OpenLayers.Layer.Vector("Water Extent");
//		_water_layer.style = OpenLayers.Util.extend({'fill':'black'}, OpenLayers.Feature.Vector.style['default']);
//		
//		_water_layer.style.pointRadius = 3;
//		_water_layer.style.strokeColor = '#3377FF';
//		_water_layer.style.fillColor = '#5599FF';
////		_water_layer.setOpacity(1.0);
//		
//		map.addLayer(_water_layer);
//		map.addControl(new GeoEngine.Control.LayerSwitcher());
		map.addControl(new OpenLayers.Control.ScaleLine());
		
//		map.basinLayer = _basin_layer;
//		map.waterLayer = _water_layer;
//		
		this.map = map;
	};

	this.transformGeo = function(geo) {
		return geo.transform(this.map.displayProjection, this.map.projection);
	};
	
	this.resetExtent = function() {
		this.map.setCenter(this
				.transformGeo(new OpenLayers.LonLat(
						-99.096349011162,
						47.103407185113)), 12);
	};
}
