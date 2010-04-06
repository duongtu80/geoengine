function Maps(x, y, level) {
	this.defaultLocation = [ x, y ];
	this.defaultZoomLevel = level;
	this.maps = [];

	this.createStateControls = function(m) {
		m.addControl(new OpenLayers.Control.LayerSwitcher());
		m.addControl(new OpenLayers.Control.Navigation({group: 'navigation', tid: 'navigation'}));
		m.addControl(new OpenLayers.Control.ZoomBox({group: 'navigation', tid: 'zoomIn'}));
		m.addControl(new OpenLayers.Control.ZoomOut({group: 'navigation', tid: 'zoomOut'}));
		m.addControl(new OpenLayers.Control.SelectFeature(m.commonLayers.catchment, {
				clickout : false,
				group: 'navigation', 
				tid: 'selectFeature',
				toggle : true,
				multiple : false,
				hover : false,
				//	                toggleKey: "ctrlKey", // ctrl key removes from selection
				//	                multipleKey: "shiftKey", // shift key adds to selection
				box : false,
				onSelect : function(f) {
					//	    				alert(f);
					main.progressQueue.pushTask(
							'Load simulation result for ' + f.attributes['NAME'],
							'/ecoserv/_loadScenario.do', null, main,
							main.initOutput);
				}
			}));
	};

	this.initialize = function() {
		var options = {
			projection : new OpenLayers.Projection("EPSG:900913"),
			displayProjection : new OpenLayers.Projection("EPSG:4326"),
			units : "m",
			maxExtent : new OpenLayers.Bounds(-20037508.34, -20037508.34,
					20037508.34, 20037508.34),
			controls : [ 
			]
		};

		this.maps.push(this.createGoogleSatellite(options));
		this.maps.push(this.createGoogleTerrain(options));
//		this.maps.push(this.createGoogleTerrain(options));
		
		//Add common layers for analysis result
		this.addCommonLayers();
		
		this.histryControl = new OpenLayers.Control.NavigationHistory();
		this.maps[0].addControl(this.histryControl);
		
		//this.maps.push(this.createGoogleStreat(options));

		for ( var i = 0; i < this.maps.length; i++) {
			this.createStateControls(this.maps[i]);

			this.maps[i].events.register('move', this, this.zoomChange);

			this.maps[i].events.register('mousemove', this.maps[i],
					function(e) {
						var _cmp = Ext.getCmp('statusCoordination');
						if (_cmp) {
							var _geo = this.getLonLatFromPixel(e.xy).transform(
									this.projection, this.displayProjection);
							_cmp.setText(_geo.lon.toFixed(3) + ','
									+ _geo.lat.toFixed(3));
						}

					});
			// this.maps[i].events.register('zoomend', this, this.zoomChange);
		}
	};
	
	this.addCommonLayers = function(){
		for ( var i = 0; i < this.maps.length; i++) {
			var _m = this.maps[i];
			_m.commonLayers = {};
			
			//Add water surface layer
	        _default_style = OpenLayers.Util.extend({'fill':'#5588FF'}, OpenLayers.Feature.Vector.style['default']);
	        _default_style.fillColor = '#5588FF';
	        _default_style.strokeColor = '#5588CC';
	        _default_style.strokeWidth = 1;
	        
	        _selected_style = OpenLayers.Util.extend({'fill':'#2288FF'}, OpenLayers.Feature.Vector.style['default']);
	        _selected_style.fillColor = '#FF8855';
	        _selected_style.strokeColor = '#CCCC88';
	        _selected_style.strokeWidth = 2;

	        var _polyStyles = new OpenLayers.StyleMap({"default": _default_style, "select":_selected_style});

			var _waterLayer = new OpenLayers.Layer.Vector('Water', {'styleMap' : _polyStyles});
			_waterLayer.setOpacity(0.8);
			
			_m.addLayer(_waterLayer);
			_m.commonLayers['water'] = _waterLayer;
			
			//Add catchment layer
			var _catchment = new OpenLayers.Layer.GML(
					"Catchment",
					"/geoserver/ows?service=WFS&version=1.0.0&request=GetFeature&typeName=geo:basin&maxFeatures=50&outputFormat=GML2",
					{
						projection : new OpenLayers.Projection("EPSG:4326")
					});
			
			_m.addLayer(_catchment);
			_m.commonLayers['catchement'] = _catchment; 
		}
	}

	this.zoomChange = function(object, element) {
		for ( var i = 0; i < this.maps.length; i++) {
			if (this.maps[i].id != object.object.id) {
				if (this.maps[i].getZoom() != object.object.getZoom()
						|| (object.object.getCenter() != null && object.object
								.getCenter().equals(this.maps[i].getCenter()) == false)) {
					this.maps[i].moveTo(object.object.getCenter(),
							object.object.getZoom(), false, false);
				}
				// console.log('zoom in');
			}
		}
	};

	this.resetExtent = function() {
		this.setCenter(this.defaultLocation[0], this.defaultLocation[1],
				this.defaultZoomLevel);
	};
	
	this.nextExtent = function() {
		this.histryControl.nextTrigger();
	};

	this.previousExtent = function() {
		this.histryControl.previousTrigger();
	};

	this.setCenter = function(x, y, level) {
		var _cmp = Ext.getCmp('statusCoordination');
		if (_cmp) {
			_cmp.setText('Sample:' + x.toFixed(3) + ',' + y.toFixed(3));
		}

		for ( var i = 0; i < this.maps.length; i++) {
			var _pt1 = new OpenLayers.LonLat(x, y).transform(
					this.maps[i].displayProjection, this.maps[i].projection);
			var _pt2 = new OpenLayers.LonLat(x + this.boxWidth, y
					+ this.boxHeight).transform(this.maps[i].displayProjection,
					this.maps[i].projection);

			var _w = Math.abs(_pt2.lon - _pt1.lon) / 2;
			var _h = Math.abs(_pt2.lat - _pt1.lat) / 2;

			var _layer = this.maps[i].getLayersByName('Center')[0];
			_layer.removeFeatures(_layer.features);

			var _fs = [
					new OpenLayers.Feature.Vector(
							new OpenLayers.Geometry.LineString( [
									new OpenLayers.Geometry.Point(
											_pt1.lon - _w, _pt1.lat),
									new OpenLayers.Geometry.Point(
											_pt1.lon + _w, _pt1.lat) ])),
					new OpenLayers.Feature.Vector(
							new OpenLayers.Geometry.LineString( [
									new OpenLayers.Geometry.Point(_pt1.lon,
											_pt1.lat - _h),
									new OpenLayers.Geometry.Point(_pt1.lon,
											_pt1.lat + _h) ])) ];

			_layer.addFeatures(_fs);

			this.maps[i].setCenter(_pt1, level);
		}
	};

	this.createGoogleSatellite = function(options) {
		var map = new OpenLayers.Map(options);
//		map.id = 'map_google_sat';
		map.title = 'Satellite';

		var _layer = new OpenLayers.Layer.Google("Satellite", {
			type : G_HYBRID_MAP,
			numZoomLevels : 30,
			sphericalMercator : true
		});
		map.addLayer(_layer);
		
		map.addLayer(new OpenLayers.Layer.WMS(
				"Wetland","/geoserver/gwc/service/wms",
				{layers: 'geo:catchment', format:'image/png'}, {isBaseLayer: false}));

		var _center = new OpenLayers.Layer.Vector("Center");
		map.addLayer(_center);

		return map;
	};

	this.createGoogleStreat = function(options) {
		var map = new OpenLayers.Map(options);
//		map.id = 'map_google_str';
		map.title = 'Street';

		var _layer = new OpenLayers.Layer.Google("Street", {
			numZoomLevels : 30,
			sphericalMercator : true
		});

		map.addLayer(_layer);

		var _center = new OpenLayers.Layer.Vector("Center");
		map.addLayer(_center);

		return map;
	};

	this.createGoogleTerrain = function(options) {
		var map = new OpenLayers.Map(options);
//		map.id = 'map_google_ter';
		map.title = 'Terrain';

		var _layer = new OpenLayers.Layer.Google("Google Terrain", {
			type : G_PHYSICAL_MAP,
			numZoomLevels : 30,
			sphericalMercator : true
		});

		map.addLayer(_layer);

		var _center = new OpenLayers.Layer.Vector("Center");
		map.addLayer(_center);

		return map;
	};
	
	this.parseWaterTable = function(response) {
		var _layer = this.commonLayers.water; 
		_layer.removeFeatures(_layer.features);
		
		var _parse = new OpenLayers.Format.GeoJSON({internalProjection: this.projection, externalProjection: this.displayProjection});
		_layer.addFeatures(_parse.read(response.responseText));
	};
	
	this.parseLandcover = function(response) {
		if(this.landcover){
			this.removeLayer(this.landcover);
			delete this.landcover;
		}
		
		var layer_style = OpenLayers.Util.extend( {},
				OpenLayers.Feature.Vector.style['default']);
		layer_style.fillOpacity = 1;
		layer_style.strokeColor = "#333333";
		layer_style.strokeWidth = 0.2;

		var lookup = {
			0 : {
				fillColor : '#FFFFFF'
			},
			1 : {
				fillColor : '#308ee3'
			},
			2 : {
				fillColor : '#dde737'
			},
			3 : {
				fillColor : '#149441'
			},
			4 : {
				fillColor : '#abf95b'
			},
			5 : {
				fillColor : '#c96ee3'
			},
			6 : {
				fillColor : '#6f985c'
			}
		};

		var _styleMap = new OpenLayers.StyleMap( {
			'default' : layer_style
		});
		_styleMap.addUniqueValueRules("default", "land", lookup);

		var _data = Ext.util.JSON.decode(response.responseText);

		var vector = new OpenLayers.Layer.Vector("Land cover(" + _data.title + ')', {
			'styleMap' : _styleMap
		});
		vector.setOpacity(0.6);

		//Create and add pixels
//		var features = [];
//		var featureCol = [];
		vector.store = _data;
		
		var _parse = new OpenLayers.Format.GeoJSON({internalProjection: this.projection, externalProjection: this.displayProjection});
		var features = _parse.read(_data.data);
		vector.addFeatures(features);

//		var _pos = 0;
//		var startY = _data.maxy;
//		for ( var y = 0; y < _data.height; y++) {
//			var startX = _data.minx;
//			for ( var x = 0; x < _data.width; x++) {
//				if (_data.data[_pos] != 0) {
//					var poly = new OpenLayers.Bounds(startX, startY
//							- _data.celly, startX + _data.cellx, startY)
//							.toGeometry().transform(
//									this.displayProjection, this.projection);
//					var feature = new OpenLayers.Feature.Vector(poly, {
//						'v' : _data.data[_pos]
//					});
//					features.push(feature);
//					featureCol.push(feature);
//				} else {
//					featureCol.push(null);
//				}
//				_pos++;
//				startX += _data.cellx;
//			}
//			startY -= _data.celly;
//		}
//		vector.addFeatures(features);
//		vector.featureCol = featureCol;

		this.addLayer(vector);
		this.landcover = vector;
	};
	
}