<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<title>Land Cover Editor</title>

<link rel="stylesheet" type="text/css" href="/public/ext/resources/css/ext-all.css">
<script type="text/javascript" src="/public/ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="/public/ext/ext-all.js"></script>

<script
	src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=<s:property value="key" />"
	type="text/javascript"></script>

<script type="text/javascript"
	src="/public/openlayers/lib/OpenLayers.js"></script>
<!-- 
<script type="text/javascript" src="http://www.openlayers.org/api/OpenLayers.js"></script>
 -->
<script type="text/javascript" src="/public/GeoExt/script/GeoExt.js"></script>
 
<link rel="stylesheet" type="text/css" href="css/landcover.css">
<script type="text/javascript" src="js/Landcover.js"></script>

<SCRIPT type="text/javascript">
	var username = 'test';
</SCRIPT>

</head>
<body style="margin: 0 auto 0 auto;">
<script type="text/javascript" 
src="http://ajax.googleapis.com/ajax/libs/chrome-frame/1/CFInstall.min.js"> </script>
 
<div id="placeholder"></div>

<script>
 CFInstall.check({
    node: "placeholder"/*,
    destination: "http://www.waikiki.com"*/
  });
</script>
<div style="display: table; width: 1000px; border: 1px solid #000000; margin-left: auto; margin-right: auto;">
	<div id="mapPanel"></div>
	<div id="zoomSlider"></div>
	<div style="background-image: url(img/EcoServ_Logo7.jpg); background-repeat: x-repeat; height: 100px;"></div>
	<div id="mainPanel">
	
	</div>
	<div style="heigth: 50px; "></div>
	<form id="frmDownloadTiff" action="landcover/~downloadGeoTIFF.do" method="post" target="_blank">
		<input id="txtTiffFormData" type="hidden" name="data" />
	</form>
</div>
</body>
</html>