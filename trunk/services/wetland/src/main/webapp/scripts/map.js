var map = null;
var wetland = null;

function initMap() {
    var _resolutions = [
//        1.40625, 
//        0.703125, 
//        0.3515625, 
//        0.17578125, 
//        0.087890625, 
//        0.0439453125,
//        0.02197265625, 
//        0.010986328125, 
//        0.0054931640625
//        0.00274658203125,
//        0.001373291015625, 
//        0.0006866455078125, 
//        0.00034332275390625,
        0.000171661376953125, 
        0.0000858306884765625, 
        0.00004291534423828125,
        0.00002145767211914062, 
        0.00001072883605957031,
        0.00000536441802978515, 
        0.00000268220901489257
    ];
    
    var _progressBar = new ProgressBar();
    
	var options = {
				resolutions: _resolutions,
//                minExtent: new OpenLayers.Bounds(-10, -10, 10, 10), 
//                maxExtent: new OpenLayers.Bounds(-180, -90, 180, 90), 
				'numZoomLevels': 7,
                controls: [new OpenLayers.Control.MouseDefaults(), new OpenLayers.Control.PanZoomBar()]
	          };

	OpenLayers.IMAGE_RELOAD_ATTEMPTS = 3;
	OpenLayers.Util.onImageLoadErrorColor = "transparent";

	var map = new OpenLayers.Map('map', options);
	

	var layer =	new OpenLayers.Layer.WMS("Blue Marble", 
			["http://labs.metacarta.com/wms-c/Basic.py?","http://t2.labs.metacarta.com/wms-c/Basic.py?", "http://t1.labs.metacarta.com/wms-c/Basic.py?"], {layers: 'satellite'} 
	);
	
	var basinLayer = new OpenLayers.Layer.GML("Wetlands", "loadDataset.do?dataset=wetland");

	basinLayer.style = OpenLayers.Util.extend({'fill':'#5588FF'}, OpenLayers.Feature.Vector.style['default']);
	basinLayer.style.fillColor = '#5588FF';
	basinLayer.style.strokeColor = '#5588CC';
	basinLayer.style.strokeWidth = 1;
	
	basinLayer.selectedStyle = OpenLayers.Util.extend({'fill':'#2288FF'}, OpenLayers.Feature.Vector.style['default']);
	basinLayer.selectedStyle.fillColor = '#FF8855';
	basinLayer.selectedStyle.strokeColor = '#CCCC88';
	basinLayer.selectedStyle.strokeWidth = 2;
	
	basinLayer.events.register('beforefeatureadded', basinLayer, function(fs){
			fs.feature.style = basinLayer.style;
		}
	);
	
	basinLayer.events.register('loadend', basinLayer, function(fs){
			var _items = [];
			var i;
			for(i=0;i<fs.object.features.length;i++){
				_items.push({'name': fs.object.features[i].attributes['NAME'], 'fid': fs.object.features[i].fid});
			}
			
			var _store = new dojo.data.ItemFileReadStore({data: {items: _items}});
			
			listCatchment.store = _store;

			_progressBar.popProgress();
		});
	
	basinLayer.events.register('loadstart', basinLayer, function(fs){
			_progressBar.pushProgress('加载流域数据图层');
		});
	
	
	map.addLayer(layer);
	map.addLayer(basinLayer);
	
//	var vlayer = new OpenLayers.Layer.Vector('Markers');
//	map.addLayer(vlayer);

	waterLayer = new OpenLayers.Layer.Vector("Water");
	waterLayer.style = OpenLayers.Util.extend({'fill':'black'}, OpenLayers.Feature.Vector.style['default']);
	
	waterLayer.style.pointRadius = 3;
	waterLayer.style.strokeColor = '#3377FF';
	waterLayer.style.fillColor = '#5599FF';
	
	map.addLayer(waterLayer);
	
//	map.addControl(new OpenLayers.Control.DataViewToolbar(vlayer));
	map.setCenter(new OpenLayers.LonLat(-99.10, 47.10), 2);
	
	wetland = new WetlandModel(map);
//	wetland.siteLayer = siteLayer;
	wetland.basinLayer = basinLayer;
	wetland.waterLayer = waterLayer;
	wetland.progressBar = _progressBar;

//	dojo.byId('imgWaterTable').onload = chartLoaded;
//	goData(-1);
}


function ProgressBar() {
	this.queue = [];
	this.messagePanel = dojo.byId('progressPanel');
	this.messageDiv = dojo.byId('progressText');
	
	this.pushProgress = function(p){
		this.messagePanel.className = 'progressReady';

		if(this.queue.length > 0){
			alert('Busy...');
			return;
		}
		
//		if(this.queue.length >0){
//			this.queue = [];
//		}
//		
		this.queue.push(p);
		this.messageDiv.innerHTML = '';
		this.messageDiv.innerHTML = p + ' ...';
		this.messagePanel.className = 'progressRunning';
	};
	
	this.popProgress = function(){
		if(this.queue.length > 0){
			this.queue.pop();
			this.messagePanel.className = 'progressReady';
			this.messageDiv.innerHTML = 'Ready';
		}
	};
}

