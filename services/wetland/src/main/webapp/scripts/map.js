var map = null;
var wetland = null;

function loadCatchments(){
	wetland.basinLayer.removeFeatures(wetland.basinLayer.features);
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
}

function createDisasterSymbol(){
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
}

function ProgressBar() {
	this.queue = [];
	this.messagePanel = dojo.byId('progressPanel');
	this.messageDiv = dojo.byId('progressText');
	this.current = null;
	
	this.pushProgress = function(p){
		if(this.queue.length > 0){
			alert('Busy...');
			return;
		}
		
		this.pushProcess(p, null, null, null);
	};
	
	this.pushProcess = function(title, process, obj, params){
		this.queue.push({'title': title, 'process': process, 'object': obj, 'params': params});
		this.processQueue();
	};
	
	this.processQueue = function() {
		if(this.current == null && this.queue.length > 0){
			var _p = this.queue.pop();
			
			this.processProcess(_p);
		}
	};
	
	this.processProcess = function(p){
		this.current = p;
		
		this.messagePanel.className = 'progressReady';
		this.messageDiv.innerHTML = '';
		this.messageDiv.innerHTML = p.title + ' ...';
		this.messagePanel.className = 'progressRunning';
		
		if(p.process != null){
			if(p.params != null){
				p.process.apply(p.object, p.params);
			}
			else{
				p.process();
			}
		}
	};
	
	this.popProgress = function(){
		this.current = null;
		
		this.messagePanel.className = 'progressReady';
		this.messageDiv.innerHTML = '';

		this.processQueue();
	};
}

function changeWaterLevel(){
	if(wetland.waterAnimation != null){
		wetland.waterAnimation.changeDate();
	}
	else{
	}
}

function initMap() {
    var _resolutions = [
            		    156543.03390000001, 
            		    78271.516950000005, 
            		    39135.758475000002, 
            		    19567.879237500001, 
            		    9783.9396187500006, 
            		    4891.9698093750003, 
            		    2445.9849046875001, 
            		    1222.9924523437501, 
            		    611.49622617187504, 
            		    305.74811308593752, 
            		    152.87405654296876, 
            		    76.43702827148438,
            		    38.21851413574219, 
            		    19.109257067871095, 
            		    9.5546285339355475, 
            		    4.7773142669677737, 
            		    2.3886571334838869, 
            		    1.1943285667419434, 
            		    0.59716428337097172, 
            		    0.29858214168548586
            	    ];
                    
	 var _options = {
                projection: new OpenLayers.Projection("EPSG:900913"),
                displayProjection: new OpenLayers.Projection("EPSG:4326"),
                units: "m",
                resolutions: _resolutions,
                'maxExtent': new OpenLayers.Bounds(-20037508.34,-20037508.34,20037508.34,20037508.34), 
                'restrictedExtent': new OpenLayers.Bounds(-20037508.34,-20037508.34,20037508.34,20037508.34),
                'numZoomLevels': 9,
                controls: [new OpenLayers.Control.MouseDefaults(), new OpenLayers.Control.PanZoomBar()]
			};
    
    var _progressBar = new ProgressBar();
    
	OpenLayers.IMAGE_RELOAD_ATTEMPTS = 3;
	OpenLayers.Util.onImageLoadErrorColor = "transparent";

	map = new OpenLayers.Map('map', _options);
	
//	var _back_layer = new OpenLayers.Layer.Google("Google Map", {'type': G_SATELLITE_MAP, 'sphericalMercator': true, 'minZoomLevel': 13});
//	var _back_layer = new OpenLayers.Layer.Google("Google Map", {'type': G_PHYSICAL_MAP, 'sphericalMercator': true, 'minZoomLevel': 13});

	var _basin_layer = new OpenLayers.Layer.Vector("Catchments", {styleMap: createDisasterSymbol()});

	map.addLayers([
	               new OpenLayers.Layer.Google("Satellite", {'type': G_SATELLITE_MAP, 'sphericalMercator': true, 'minZoomLevel': 13}),
	               new OpenLayers.Layer.Google("Terrain", {'type': G_PHYSICAL_MAP, 'sphericalMercator': true, 'minZoomLevel': 13}),
	               new OpenLayers.Layer.Google("Normal", {'type': G_NORMAL_MAP, 'sphericalMercator': true, 'minZoomLevel': 13})
			 ]);

//	map.addLayers([
//	               new OpenLayers.Layer.WMS("US", "http://127.0.0.1/tilecache/tilecache.cgi", {layers: "us"}, {isBaseLayer: true})
//			 ]);

	map.addLayer(_basin_layer);
	
//	var vlayer = new OpenLayers.Layer.Vector('Markers');
//	map.addLayer(vlayer);

	var _water_layer = new OpenLayers.Layer.Vector("Water Extent");
	_water_layer.style = OpenLayers.Util.extend({'fill':'black'}, OpenLayers.Feature.Vector.style['default']);
	
	_water_layer.style.pointRadius = 3;
	_water_layer.style.strokeColor = '#3377FF';
	_water_layer.style.fillColor = '#5599FF';
//	_water_layer.setOpacity(1.0);
	
	map.addLayer(_water_layer);
	map.addControl(new GeoEngine.Control.LayerSwitcher());
	map.addControl(new OpenLayers.Control.ScaleLine());
	
	var _centerPt = new OpenLayers.LonLat(-99.10, 47.10);
	map.setCenter(_centerPt.transform(map.displayProjection, map.projection), 1);
//	map.setCenter(_centerPt.transform(map.displayProjection, map.projection), 14);
	
	wetland = new WetlandModel(map);
//	wetland.siteLayer = siteLayer;
	wetland.basinLayer = _basin_layer;
	wetland.waterLayer = _water_layer;
	wetland.progressBar = _progressBar;
	
	wetland.progressBar.pushProcess('Load catchments', loadCatchments, null);
	wetland.progressBar.pushProcess('Load models', wetland.loadWpsModel, null);

//	dojo.connect(dojo.byId('divLoadMapTest'), 'onclick', wetland, 'loadWaterLevelOnMap');
//	dojo.byId('divLoadMapTest').processId = '1111111';
}
