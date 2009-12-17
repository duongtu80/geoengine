<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Land Cover Designer</title>

<style type="text/css">
#map{
	width: 700px;
	height: 500px;
	border: 1px solid #AAAAAA;
}
</style>

<script type="text/javascript" src="http://www.openlayers.org/api/OpenLayers.js"></script>
<script type="text/javascript" src="scripts/raster.js"></script>

</head>
<body onload="mapInit();">

<div id="maptoolbar">
	<input type="checkbox" onclick="toggleSelection(this.checked);">Select</input>
	<button onclick="clearSelection();">Clear Selection</button>
</div>

<div id="landcoverbar">
	<!-- 
	<button onclick="changeCover(0);">Current</button>
	-->
	<button onclick="changeCover(0);" style="background-color: #007f00">Tree</button>
	<button onclick="changeCover(1);" style="background-color: #92ff00">Grass</button>
	<button onclick="changeCover(2);" style="background-color: #ca9d9d">Crop</button>
	<button onclick="changeCover(3);" style="background-color: #0a70b1">Water</button>
</div>
<div id="map"></div>

</body>
</html>