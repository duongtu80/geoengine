<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
<script type="text/javascript">
	var wetlandWMS = '<s:property value="wetlandWMS"/>';
	var wetlandLayers = '<s:property value="wetlandLayers"/>';
</script>
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
					<div class="blockTitle">Data Parameters</div>
					<div class="textBlock">
						DayMet Service <input type="text" id='txtDayMetReader' value="http://www.daymet.org/getRawData.do?lon=%d&lat=%d" dojoType='dijit.form.TextBox' trim='true' required='true' style="width: 150px;" />
					</div>
					<div class="blockTitle">Period</div>
					<div class="textBlock">
						Date <input type="text" id='startDate' value="1990-01-01" dojoType='dijit.form.DateTextBox' trim="true" style="width: 100px;" /> -
						<input type="text" id='endDate' value="1999-12-31" dojoType='dijit.form.DateTextBox' trim="true" style="width: 100px;" />
					</div>
					<div class="blockTitle">ET Model Parameters</div>
					<div class="textBlock">
						Albedo <input type="text" id='txtAlbedo' value="0.08" dojoType='dijit.form.NumberTextBox' trim='true' required='true' style="width: 50px;" />
						Wind Speed <input type="text" id='txtWindSpeed' value="1" dojoType='dijit.form.NumberTextBox' trim='true' required='true' style="width: 50px;" />
					</div>
					<div class="textBlock">
						Coefficient <input type="text" id='txtCoefficient' value="1.2" dojoType='dijit.form.NumberTextBox' trim='true' required='true' style="width: 50px;" />
					</div>
					<div class="blockTitle">WaterTable Model Parameters</div>
					<div class="textBlock">
						Spill Point <input type="text" id='txtSpillPoint' value="3" dojoType='dijit.form.NumberTextBox' trim='true' required='true' style="width: 40px;" />
						Catchment Area <input type="text" id='txtCatchmentArea' value="3" dojoType='dijit.form.NumberTextBox' trim='true' required='true' style="width: 40px;" />
					</div>
					<div class="textBlock">
						Saturation Prcp <input type="text" id='txtSaturationPrcp' value="0.003" dojoType='dijit.form.NumberTextBox' trim='true' required='true' style="width: 50px;" />
					</div>
					<div class="textBlock">
						<button id='btnCalculateWaterTable' dojoType="dijit.form.Button" onclick="calculateWaterTable2();" disabled='true'>Calculate</button>
					</div>
					<div class="blockTitle">Water Calculate</div>
					<div class="textBlock">
						<span style="width: 50px;padding: 1px;">WPS:</span>
						<input type="text" dojoType="dijit.form.TextBox" id="modelUrl" value="http://<%=request.getServerName() %>:<%=request.getServerPort() %>/web/wps" style="width:200px;" />
					</div>
					<div class="textBlock">
						Date <input type="text" id="txtCurrentDate" dojoType="dijit.form.DateTextBox" trim="true" style="width: 80px;" onchange="searchWaterTable();"/>
						Water table <input type="text" id="txtWaterTable" dojoType="dijit.form.NumberTextBox" trim="true" style="width: 50px;"></input>
					</div>
					<div class="textBlock">
						<button id="btnGoAdd" dojoType="dijit.form.Button" onclick="waterRegionSet();">Calculate</button>
						<button id="btnGoAnimate" dojoType="dijit.form.Button" onclick="waterRegionAnimateStart();">Start</button>
					</div>
					<div id="divWaterRegion" style="visibility: hidden;">
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="position: relative;">
					<div id='divWetlandInfo' style='position: relative; top: 0px; visibility: hidden; background-color: #EEEEEE; line-height: 22px; padding-left: 10px;'>
						<div>
							Wetland: <div id='txtWetland' style="display: inline"></div>
						</div>
						<div>
							Location: <div id='txtLocation'  style="display: inline"></div>
						</div>
					</div>
					<div id='divWaterTableText' style='visibility: hidden;'><img id="imgWaterTable"/></div>
				</td>
			</tr>
			</table>
		</div>
		<jsp:include page="inc/tail.jsp"></jsp:include>
	</div>
</body>
</html>