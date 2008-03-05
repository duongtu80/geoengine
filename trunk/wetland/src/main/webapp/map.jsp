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
    @import "http://o.aolcdn.com/dojo/1.0.2/dijit/themes/tundra/tundra.css";
    @import "http://o.aolcdn.com/dojo/1.0.2/dojo/dojo.css"
</style>
<script type="text/javascript" src="http://o.aolcdn.com/dojo/1.0.2/dojo/dojo.xd.js"
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
<script type="text/javascript" src="http://www.openlayers.org/api/OpenLayers.js" ></script>
<script type="text/javascript" src="controls/js/Navigation.js" ></script>
<script type="text/javascript" src="controls/js/SearchFeature.js" ></script>
<script type="text/javascript" src="controls/js/DataViewToolbar.js" ></script>
<script type="text/javascript" src="scripts/map.js"></script>
</head>
<body onload="initMap();" class="tundra" style="font-size: 12px;">
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
					</div>
				</td>
			</tr>
			</table>
		</div>
		<jsp:include page="inc/tail.jsp"></jsp:include>
	</div>
</body>
</html>