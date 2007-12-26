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
<!-- 
<style type="text/css">
    @import "http://o.aolcdn.com/dojo/1.0.2/dijit/themes/tundra/tundra.css";
    @import "http://o.aolcdn.com/dojo/1.0.2/dojo/dojo.css"
</style>
<script type="text/javascript" src="/dojo/dojo.xd.js" djConfig="parseOnLoad: true"></script>
 -->
<style type="text/css">
	@import "js/dojo.1.0.2/dijit/themes/tundra/tundra.css";
	@import "js/dojo.1.0.2/dojo/resources/dojo.css"
</style>

<script type="text/javascript" src="js/dojo.1.0.2/dojo/dojo.js.uncompressed.js"
            djConfig="parseOnLoad: true"></script>

<script type="text/javascript">
   dojo.require("dojo.parser");
   dojo.require("dijit.form.TextBox");
   dojo.require("dijit.form.DateTextBox");
   dojo.require("dijit.form.NumberTextBox");
   dojo.require("dijit.form.Button");
   dojo.require("dijit.form.ComboBox");
   dojo.require("dojo.data.ItemFileWriteStore");
   dojo.require("dojo.data.ItemFileReadStore");
</script>

<style type="text/css">
	@IMPORT url("controls/css/style.css");
</style>
<!-- 
<script type="text/javascript" src="http://www.openlayers.org/api/OpenLayers.js" ></script>
 -->
<script type="text/javascript" src="lib/OpenLayers.js"></script>
<script src='http://dev.virtualearth.net/mapcontrol/v3/mapcontrol.js'></script>
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
					<div id="map">
						<div id="processTip">ready</div>
					</div>
				</td>
				<td id="rightPanel">
					<div style="border: 1px solid #AAAAAA; height: 100%;text-align: left;">
						<div class="viewItem">
							<span style="width: 50px;padding: 1px;">WPS:</span>
							<input type="text" dojoType="dijit.form.TextBox" id="modelUrl" value="http://<%=request.getServerName() %>:<%=request.getServerPort() %>/web/wps" style="width: 160px;" />
							<button dojoType="dijit.form.Button" id="listModel" onclick="listModel();">List</button>
						</div>
						<div class="viewItem">
							<span style="width: 50px;padding: 1px;">Model:</span>
							<div dojoType="dijit.form.ComboBox" id="comModels" jsId="modelsList" style="width: 150px;"/>
						</div>
						<div class="viewItem"><span style="width: 50px;padding: 1px;">Cities:</span><input type="text" dojoType="dijit.form.TextBox" id="dataUrl" value="http://<%=request.getServerName() %>:18080/geoserver/wfs?version=1.0.0&" style="width: 225px;" /></div>
						<div class="viewItem"><span style="width: 50px;margin: auto;padding: 1px;">Sea level rise:</span><input type="text" dojoType="dijit.form.NumberTextBox" id="seaLevel" value='0' style="width: 50px;" /> meters</div>
						<div>
							<button dojoType="dijit.form.Button" id="search" onclick="search();">Run</button>
						</div>
						<div style="height: 235px; border: 1px solid #AAAAAA; overflow: auto;">
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