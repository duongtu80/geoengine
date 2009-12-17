<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="chrome=1">
<title>EcoServ (Prairie Pothole Models)</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/chrome-frame/1/CFInstall.min.js"> </script>

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
<script type="text/javascript">
	var username = 'test';
	google.load('visualization', '1', {'packages':['annotatedtimeline']});
</script>
</head>
<body>
<div id="placeholder"></div>
<script type="text/javascript">
	CFInstall.check({
	    node: "placeholder"
	  });
</script>
<div id="bodyPanel">
<div id="topPanel"></div>
<div id="mainPanel"></div>
<div id="bottomPanel"
	style="height: 120px; text-align: center; padding-top: 10px;">
<p style="text-align: center;"><a href="http://www.usgs.gov/"
	target="_blank"> <img src="img/logo/usgs-logo.gif" /> </a> <a
	href="http://www.usda.gov/" target="_blank"> <img
	src="img/logo/usda-logo.jpg" /> </a> <a href="http://www.nrcs.usda.gov/"
	target="_blank"> <img src="img/logo/NRCS-logo.jpg" /> </a> <a
	href="http://www.fsa.usda.gov/" target="_blank"> <img
	src="img/logo/FSA-logo.jpg" /> </a> <a target="_blank"
	href="http://www.ars.usda.gov/"> <img height="53" width="65"
	src="/f/1256850186/usda-ars_2.gif" /> </a> <a href="http://www.fws.gov/"
	target="_blank"> <img src="img/logo/us-fish-wildlife-logo.jpg" /> </a>
<a href="http://www.nature.org/" target="_blank"> <img
	src="img/logo/TNC-logo.jpg" /> </a> <a href="http://www.nasa.gov/"
	target="_blank"> <img src="img/logo/NASA-logo.gif" /> </a> <a
	href="http://english.cas.cn/" target="_blank"> <img
	src="img/logo/CAS-logo.jpg" /> </a> <a href="http://www.umd.edu/"
	target="_blank"> <img src="img/logo/UMD-logo.jpg" /> </a></p>
</div>
</div>
</body>
</html>