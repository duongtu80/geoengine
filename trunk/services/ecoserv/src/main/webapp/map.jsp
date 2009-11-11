<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="chrome=1">

<title>EcoServ (Prairie Pothole Models)</title>

<style type="text/css">
@IMPORT url("css/main.css");

@IMPORT url("css/map.css");

@IMPORT url("css/tbar.css");
</style>

<script
	src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=<s:property value="key" />"
	type="text/javascript"></script>

<!-- Load google ajax api -->
<script type='text/javascript' src='http://www.google.com/jsapi'></script>

<link rel="stylesheet" type="text/css"
	href="/public/ext/resources/css/ext-all.css">
<script type="text/javascript" src="/public/ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="/public/ext/ext-all.js"></script>
<!-- 
<script type="text/javascript" src="js/ux/wizardWindow.js"></script>
-->

<!-- Load OpenLayers library -->
<script type="text/javascript"
	src="/public/openlayers/lib/OpenLayers.js"></script>
<script type="text/javascript" src="/public/GeoExt/script/GeoExt.js"></script>
<script type="text/javascript" src="js/Utils.js"></script>
<script type="text/javascript" src="js/ProgressQueue.js"></script>
<script type="text/javascript" src="js/ModelSetting.js"></script>
<script type="text/javascript" src="js/Map.js"></script>
<script type="text/javascript" src="js/Maps.js"></script>
<script type="text/javascript" src="js/Model.js"></script>
<script type="text/javascript" src="js/Main.js"></script>

<script type="text/javascript" 
src="http://ajax.googleapis.com/ajax/libs/chrome-frame/1/CFInstall.min.js"> </script>
<SCRIPT type="text/javascript">
	CFInstall.check({
	    node: "placeholder"
	  });

	var username = 'test';
	google.load('visualization', '1', {'packages':['annotatedtimeline']});
</SCRIPT>

</head>
<body>
<div id="placeholder"></div>
<div id="bodyPanel">
<div id="topPanel"></div>
<div id="mainPanel"></div>
<div id="bottomPanel" style="height: 120px; text-align: center; padding-top: 10px;">
	<a href="http://www.usgs.gov/"><img class="imgLogo" src="img/logo/usgs-logo.gif" /></a>
	<a href="http://www.usgs.gov/"><img class="imgLogo" src="img/logo/usda-logo.jpg" /></a>
	<a href="http://www.usgs.gov/"><img class="imgLogo" src="img/logo/NRCS-logo.jpg" /></a>
	<a href="http://www.usgs.gov/"><img class="imgLogo" src="img/logo/us-fish-wildlife-logo.jpg" /></a>
	<a href="http://www.usgs.gov/"><img class="imgLogo" src="img/logo/CAS-logo.jpg	" /></a>
	<a href="http://www.usgs.gov/"><img class="imgLogo" src="img/logo/FSA-logo.jpg" /></a>
	<a href="http://www.usgs.gov/"><img class="imgLogo" src="img/logo/NASA-logo.gif" /></a>
	<a href="http://www.usgs.gov/"><img class="imgLogo" src="img/logo/TNC-logo.jpg" /></a>
	<a href="http://www.umd.edu/"><img class="imgLogo" src="img/logo/UMD-logo.jpg" /></a>
</div>
</div>
</body>
</html>