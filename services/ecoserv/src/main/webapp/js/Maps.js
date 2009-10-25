function Maps(x, y, level) {
	this.defaultLocation = [x, y];
	this.defaultZoomLevel = level;
	this.maps = [];

	this.initialize = function() {
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

		// this.maps.push(this.createGoogleTerrain(options));
		this.maps.push(this.createGoogleSatellite(options));
		this.maps.push(this.createGoogleStreat(options));

		for ( var i = 0; i < this.maps.length; i++) {
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
	
	this.resetExtent = function(){
		this.setCenter(this.defaultLocation[0], this.defaultLocation[1], this.defaultZoomLevel);
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
		map.id = 'map_google_sat';
		map.title = 'Satellite';

		var _layer = new OpenLayers.Layer.Google("Satellite", {
			type : G_SATELLITE_MAP,
			numZoomLevels : 30,
			sphericalMercator : true
		});
		map.addLayer(_layer);

		var _center = new OpenLayers.Layer.Vector("Center");
		map.addLayer(_center);

		return map;
	};

	this.createGoogleStreat = function(options) {
		var map = new OpenLayers.Map(options);
		map.id = 'map_google_str';
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
		map.id = 'map_google_ter';
		map.title = 'Terrain';

		var _layer = new OpenLayers.Layer.Google("Google Terrain", {
			type : G_PHYSICAL_MAP,
			numZoomLevels : 30,
			sphericalMercator : true
		});

		map.addLayer(_layer);
		return map;
	};
}