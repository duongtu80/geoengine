<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Map</title>
<style type="text/css">
	@IMPORT url("css/common.css");
	@IMPORT url("css/map.css");
</style>
<style type="text/css">
    @import "http://o.aolcdn.com/dojo/1.0.0/dijit/themes/tundra/tundra.css";
    @import "http://o.aolcdn.com/dojo/1.0.0/dojo/dojo.css"
</style>
<script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0.0/dojo/dojo.xd.js"></script>

<script type="text/javascript">
   dojo.require("dojo.parser");
   dojo.require("dijit.form.DateTextBox");
   dojo.require("dijit.form.NumberTextBox");
   dojo.require("dijit.form.Button");
</script>

<style type="text/css">
	@IMPORT url("controls/css/style.css");
</style>
<!-- 
<script type="text/javascript" src="lib/OpenLayers.js"></script>
 -->
<script src='http://dev.virtualearth.net/mapcontrol/v3/mapcontrol.js'></script>
<script type="text/javascript" src="http://www.openlayers.org/api/OpenLayers.js" ></script>
<script type="text/javascript" src="controls/js/Navigation.js" ></script>
<script type="text/javascript" src="controls/js/SearchFeature.js" ></script>
<script type="text/javascript" src="controls/js/DataViewToolbar.js" ></script>
<script type="text/javascript" src="scripts/map.js"></script>
</head>
<body onload="initMap();" class="tundra" style="font-size: 13px;">
	<div class="bodywrap">
		<jsp:include page="inc/top.jsp"></jsp:include>
		<div id="mainPanel">
			<table style="width:100%;border-width: 0px;" cellpadding="0" cellspacing="0">
			<tr>
				<td id="leftPanel">
					<div id="map"></div>
				</td>
				<td id="rightPanel">
					<div style="border: 1px solid #AAAAAA; height: 100%;text-align: left;">
						<div>Sea level: <input type="text" dojoType="dijit.form.NumberTextBox" id="sealevel" > </div>
						<button dojoType="dijit.form.Button" id="search" onclick="search();">Search</button>
						<div style="height: 185px; border: 1px solid #AAAAAA; overflow: auto;">
							<div id="resultPanel" style="visibility: visible;height: 10px;"></div>
						</div>
					</div>
				</td>
			</tr>
			</table>
		</div>
		<jsp:include page="inc/tail.jsp"></jsp:include>
	</div>
</body>
</html>