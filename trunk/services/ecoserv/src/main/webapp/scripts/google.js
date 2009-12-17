
function initialize() {
	if (GBrowserIsCompatible()) {
		var map = new GMap2(dojo.byId('map'));
		map.setCenter(new GLatLng(40, -100), 4);
        map.addControl(new GSmallMapControl());
        map.addControl(new GMapTypeControl());
        
//        var _kml = new GGeoXml("http://152.61.40.52:8080/web/process/positionKML.do?pathRow=47,27");
        var _kml = new GGeoXml("http://152.61.40.52:8080/web/cta.kml");
        map.addOverlay(_kml);
	}
}

