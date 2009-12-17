var vlayer=null;
var mlayer=null;
var marker=null;

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
				'numZoomLevels': 7,
                controls: [new OpenLayers.Control.MouseDefaults()]
	          };

	OpenLayers.IMAGE_RELOAD_ATTEMPTS = 3;
	OpenLayers.Util.onImageLoadErrorColor = "transparent";

	var map = new OpenLayers.Map('map', options);
	
	map.addControl(new OpenLayers.Control.PanZoomBar());

	var layer =	new OpenLayers.Layer.WMS( "Blue Marble", 
                    ["http://labs.metacarta.com/wms-c/Basic.py?","http://t2.labs.metacarta.com/wms-c/Basic.py?", "http://t1.labs.metacarta.com/wms-c/Basic.py?"], {layers: 'satellite' } );
                    
	vlayer = new OpenLayers.Layer.Vector("samples");
	vlayer.events.register('click', vlayer, mousedown);
	
	mlayer = new OpenLayers.Layer.Markers("Popup");

	map.addLayer(layer);
	map.addLayer(vlayer);
	map.addLayer(mlayer);

	map.setCenter(new OpenLayers.LonLat(-100, 40), 0);
}

function search(){
	if(modelsList.item == null){
		alert('Please select a model');
		return;
	}
	
	if(modelsList.item.id != 'swamp.cities'){
		alert('Only supports Swamp Cities model');
		return;
	}
	
	var _processTip = dojo.byId('processTip');
	_processTip.innerHTML = 'loading...';
//	_processTip.style.visibility = 'visible';
	
	dojo.xhrGet({
        url: "search.do", 
        handleAs: "xml",
        content: {
        	'modelUrl': dojo.byId('modelUrl').value,
        	'dataUrl': dojo.byId('dataUrl').value,
        	'seaLevel': dojo.byId('seaLevel').value
        },
        timeout: 20000,
        load: function(response, ioArgs) { //
        	var _gml = new OpenLayers.Format.GML();
        	var _fs = _gml.read(response);
        	
        	vlayer.eraseFeatures(vlayer.features);
        	vlayer.addFeatures(_fs);
        	
        	_processTip.innerHTML = 'finished';
//			_processTip.style.visibility = 'hidden';
        },

        // The ERROR function will be called in an error case.
        error: function(response, ioArgs) { //
			console.error("HTTP status code: ", ioArgs.xhr.status); //
//			alert('error:' + "HTTP status code: " + ioArgs.xhr.status);
			_processTip.innerHTML = 'error';
		}
	});
}

function mousedown(evt) {
	var _layer = evt.object;
	var _f = _layer.getFeatureFromEvent(evt);
	
	if(marker != null){
		mlayer.map.removePopup(marker);
		marker.destroy();
		marker = null;
	}
	
	if(_f != null){
		var _processTip = dojo.byId('processTip');
		_processTip.innerHTML = 'loading...';

		dojo.xhrGet({ //
	        url: "detail.do", 
	        handleAs: "text",
	        content: {
	        	'id': _f.fid,
	        	'modelUrl': dojo.byId('modelUrl').value,
	        	'dataUrl': dojo.byId('dataUrl').value
	        },
	        
	        timeout: 60000,
	        load: function(response, ioArgs) {
				var _popup = new OpenLayers.Popup("test1",
					_layer.map.getLonLatFromPixel(evt.xy),
					new OpenLayers.Size(200, 100),
					'test popup', true);
					 
				_popup.setContentHTML(response);
				_popup.setOpacity(0.7);
				_popup.setBackgroundColor('#EEEEEE');
				
				marker = _popup;
				mlayer.map.addPopup(marker);
				
	        	_processTip.innerHTML = 'finished';
	        },
	        error: function(response, ioArgs) { //
				console.error("HTTP status code: ", ioArgs.xhr.status); //
				_processTip.innerHTML = 'error';
			}
		});
	}
//	OpenLayers.Event.stop(evt);
}

function listModel() {
	var _processTip = dojo.byId('processTip');
	_processTip.innerHTML = 'loading...';
	
	dojo.xhrGet({ //
        url: "listModel.do", 
        handleAs: "json",
        content: {
        	'modelUrl': dojo.byId('modelUrl').value
        },
        
        timeout: 60000,
        load: function(response, ioArgs) {
//        	var _items = modelsStore._getItemsArray();
//        	for(var i=0;i<_items.length;i++){
//        		modelsStore.deleteItem(_items[i]);
//        	}
        	
//        	for(var i=0;i<response.items.length;i++){
//        		modelsStore.newItem(response.items[i]);
//        	}
        	
        	var _modelStore = new dojo.data.ItemFileReadStore({data: response});
        	modelsList.store = _modelStore;
        	
        	modelsList.setValue("");
        	_modelStore.fetch({onItem: function(item, request){
        			if(modelsList.getValue() == ""){
	        			modelsList.setValue(item.name);
	        			modelsList.item = item;
        			}
        			modelsList.abort();
        		}});
        	
        	
     
//        	for(var _item : modelsStoreObj.getItems()){
//        		modelsStoreObj.deleteItem(_item);
//        	}
        	
//        	if (_combox == null){
//        		var _modelStore = new dojo.data.ItemFileReadStore({data: response});
//        		
//        	var _modelStore = new dojo.data.ItemFileReadStore({data: {identifier:'name', label:'label', items: [{name:'test1', label:'eeee'}]}});
//	        	var _list = dojo.byId('modelList');
//        		_combox = new dijit.form.ComboBox({store: _modelStore}, _list);        		
//        		_combox.setValue(reponse.items[0].name);
//        	}
//        	for(var i=0;i<response.items.length;i++){
//        		_modelStore.newItem({name: response.items[i].name, label: response.items[i].label});
//        	}
        	
//        	_combox.value = response.items[0].name;
        	
//        	var _list = dojo.byId('modelList');
        	
//        	_modelStore
//        	_modelStore.newItem({name: 'bar'});
//        	if(response.identifier == 'models'){
//	        	for(var i=0;i<response.items.length;i++){
//	        		var _option = new Option(response.items[i].label, response.items[i].value);
//	        		_list.add(_option, null);
//	        	}
//        	}
//        	else{
//        		alert(response.text);
//        	}
        	
	        _processTip.innerHTML = 'finished';
        },
        error: function(response, ioArgs) { //
			console.error("HTTP status code: ", ioArgs.xhr.status); //
			_processTip.innerHTML = 'error';
		}
	});
}
