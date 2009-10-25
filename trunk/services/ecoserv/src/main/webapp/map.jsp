<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- Avoid the incompatibilities with IE8 -->
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />

<title>EcoServ (Prairie Pothole Models)</title>

<style type="text/css">
@IMPORT url("css/main.css");

@IMPORT url("css/map.css");

@IMPORT url("css/tbar.css");
</style>

<script
	src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=<s:property value="key" />"
	type="text/javascript"></script>

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

</head>
<body>
<div id="bodyPanel">
<div id="topPanel"></div>
<div id="mainPanel"></div>
<div id="bottomPanel" style="height: 100px;">
	<img src="img/logo/usgs-logo.gif" />
	<img src="img/logo/usda-logo.jpg" />
	<img src="img/logo/NRCS-logo.jpg" />
	<img src="img/logo/us-fish-wildlife-logo.jpg" />
	<img src="img/logo/CAS-logo.jpg	" />
	<img src="img/logo/FSA-logo.jpg" />
	<img src="img/logo/NASA-logo.gif" />
	<img src="img/logo/TNC-logo.jpg" />
	<img src="img/logo/UMD-logo.jpg" />
</div>
</div>
</body>
</html>