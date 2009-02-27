<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Prairie Pothole Models</title>
<style type="text/css">
	@IMPORT url("css/common.css");
	@IMPORT url("css/map.css");
</style>
<style type="text/css">
    @import "/public/dojo/dijit/themes/tundra/tundra.css";
</style>
<script type="text/javascript" src="/public/dojo/dojo/dojo.js" djConfig="parseOnLoad:true"></script>

<script type="text/javascript">
	dojo.require("dijit.form.TextBox");
	dojo.require("dijit.form.DateTextBox");
	dojo.require("dijit.form.NumberTextBox");
	dojo.require("dijit.form.ValidationTextBox");
	dojo.require("dijit.form.Button");
	dojo.require("dijit.form.ComboBox");
	dojo.require("dijit.form.CheckBox");
	dojo.require("dijit.Dialog");
	dojo.require("dojo.data.ItemFileReadStore");
	dojo.require("dijit.layout.ContentPane");
	dojo.require("dijit.layout.TabContainer");
	dojo.require("dijit.form.Slider");
	dojo.require("dijit.layout.AccordionContainer");
</script>

<style type="text/css">
	@IMPORT url("controls/css/style.css");
</style>

<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=<s:property value="key" />" type="text/javascript"></script>

<script type="text/javascript" src="/public/openlayers/OpenLayers.js" ></script>
<script type="text/javascript" src="scripts/LayerSwitcher.js"></script>
<script type="text/javascript" src="scripts/models.js"></script>
<script type="text/javascript" src="scripts/map.js"></script>

<SCRIPT type="text/javascript">
	dojo.addOnLoad(initMap);
</SCRIPT>

</head>
<body class="tundra" style="font-size: 12px;">
	<div class="bodywrap">
		<jsp:include page="inc/top.jsp"></jsp:include>
		<div id="mainPanel">
			<table style="width:100%;border-width: 0px;" cellpadding="0" cellspacing="0">
			<tr>
				<td id="leftPanel">
					<div id="map">
						<div id="progressPanel" class="progressReady">
							<div id="progressText">Ready</div>
						</div>
						<div style="position: absolute;z-index: 5000;">
							<div id="waterLevelPanel" style="position: absolute;margin-left: 100px;margin-top: 0px;width: 560px; height: 0px; background-color: #EEEEEE;visibility: hidden; overflow: hidden;">
								Date <input id='dateWaterLevel' value="1990-01-01" dojoType='dijit.form.DateTextBox' trim="true" style="width: 80px;" onchange="changeWaterLevel();" />
								Water Level <input id='valWaterLevel' value="0" dojoType='dijit.form.TextBox' trim="true" style="width: 60px;" />
								Animation Type <select id='listAnimationType' dojoType="dijit.form.ComboBox" style="width: 100px;height: 15px;">
									<option value="1">daily</option>
					                <option value="7" selected="selected">weekly</option>
					                <option value="[month]" >monthly</option>
					                <option value="[year]">yearly</option>
								</select>
								<button id='btnStartAnimation' dojoType="dijit.form.Button" style="height: 20px;" onclick="wetland.waterAnimation.switchAnimation();">Start</button>
							</div>
						</div>
					</div>
				</td>
				<td id="rightPanel">
					<div dojoType="dijit.layout.AccordionContainer" duration="200" style="margin 0px; width: 276px; height: 430px; overflow: hidden">
						<div dojoType="dijit.layout.AccordionPane" selected="true" title="Wetland Hydrology">
							<div class="blockTitle">Introduction</div>
							<div style="border-bottom: 1px solid #999999; padding: 3px;">
								<img src="images/waterlevel.gif"></img>
								<div style="text-align: right;"><a href="#">Read more</a></div>
							</div>

							<div class="blockTitle">Parameters</div>
							<div class="viewItem"><div class="viewTitle1">Wetland</div><div><input id="listCatchment" jsId='listCatchment' dojoType="dijit.form.ComboBox" style="width: 150px;" onchange="wetland.selectBasin();"></input></div></div>
		
							<div class="viewItem"><div class="viewTitle1">Period</div>
								<input type="text" id='startDate' value="1990-01-01" dojoType='dijit.form.DateTextBox' trim="true" style="width: 90px;" /> -
								<input type="text" id='endDate' value="1999-12-31" dojoType='dijit.form.DateTextBox' trim="true" style="width: 90px;" />
							</div>

							<div class="blockBody" style="border: 1px solid #EEEEEE; margin: 1px; padding: 2px;">
								<button dojoType="dijit.form.Button" onclick="wetland.waterLevelExecute();">Simulate</button>
							</div>
<!-- 
							<div>
								<span id="divLoadMapTest" class="resultLink" processId="1111111">Load on Map</span>
							</div>
 -->
						</div>
						<div dojoType="dijit.layout.AccordionPane" selected="false" title="Models Setting">
							<div style="padding: 2px; margin-top: 5px;">DayMet<input dojoType='dijit.form.TextBox' id="txtDayMet" style="width: 200px; margin-left: 5px;" value="http://www.daymet.org/getRawData.do?lon=%f&amp;lat=%f"></input></div>
							<hr/>
							
							<button dojoType="dijit.form.Button" onclick="wetland.selectWpsModel();">Load Models</button>
							<div class="blockBody" style="border: 1px solid #EEEEEE; margin: 1px; padding: 2px;">
								<div class="viewItem"><div class="viewTitle">ET</div><input id="modelET" dojoType="dijit.form.ComboBox" style="width: 160px;" onchange="wetland.changeModel('modelET');"></input><a class="settingParameter" href="#" onclick="wetland.modelSetting('modelET');">Change</a></div>
							</div>
							<div class="blockBody" style="border: 1px solid #EEEEEE; margin: 1px; padding: 2px;">
								<div class="viewItem"><div class="viewTitle">Water Table</div><input id="modelWaterTable" dojoType="dijit.form.ComboBox" style="width: 160px;" onchange="wetland.changeModel('modelWaterTable');"></input><a class="settingParameter" href="#" onclick="wetland.modelSetting('modelWaterTable');">Change</a></div>
							</div>
							<div class="blockBody" style="border: 1px solid #EEEEEE; margin: 1px; padding: 2px;">
								<div class="viewItem"><div class="viewTitle">Water Region</div><input id="modelWaterRegion" dojoType="dijit.form.ComboBox" style="width: 160px;" onchange="wetland.changeModel('modelWaterRegion');"></input><a class="settingParameter" href="#" onclick="wetland.modelSetting('modelWaterRegion');">Change</a></div>
							</div>
						</div>
					</div>
				</td>
			</tr>
			</table>
			<div id="resultPanel">
		</div>
		<jsp:include page="inc/tail.jsp"></jsp:include>
	</div>	
					
	<div id="dlgLoadWpsModel" dojoType="dijit.Dialog" title="Load Models" execute="wetland.loadWpsModel();">
		<div class="viewItem"><div class="viewTitle">Model Service:</div><div id="txtWpsService" dojoType="dijit.form.TextBox" style="width: 300px;" value="/rest/wps"></div></div>
		<div style="line-height: 25px;"><button dojoType="dijit.form.Button" type="submit">Load</button></div>
	</div>

	<div id="Setting.ETModel" style="width: 300px;" dojoType="dijit.Dialog" title="ET Model Parameters" execute="wetland.saveSetting('ETModel');">
		<div class="viewItem"><div class="viewTitle2">Albedo</div><div id="ETModel.Albedo" dojoType="dijit.form.NumberTextBox"" style="width: 70px;" value="0.08"></div></div>
		<div class="viewItem"><div class="viewTitle2">Wind Speed</div><div id="ETModel.WindSpeed" dojoType="dijit.form.NumberTextBox"" style="width: 70px;" value="1"></div></div>
		<div class="viewItem"><div class="viewTitle2">Coefficient</div><div id="ETModel.Coefficient" dojoType="dijit.form.NumberTextBox"" style="width: 70px;" value="1.2"></div></div>
		
		<div style="line-height: 25px;"><button dojoType="dijit.form.Button" type="submit">Save</button></div>
	</div>
	<div id="Setting.WaterTableModel" style="width: 300px;" dojoType="dijit.Dialog" title="Water Table Model Parameters" execute="wetland.saveSetting('WaterTableModel');">
		<div class="viewItem"><div class="viewTitle2">Saturation Prcp</div><div id="WaterTableModel.SaturationPrcp" dojoType="dijit.form.NumberTextBox"" style="width: 70px;" value="0.003"></div></div>
		
		<div style="line-height: 25px;"><button dojoType="dijit.form.Button" type="submit">Save</button></div>
	</div>
	<div id="Setting.WaterRegionModel" style="width: 300px;" dojoType="dijit.Dialog" title="Water Region Model Parameters" execute="wetland.saveSetting('WaterRegionModel');">
		<div style="line-height: 25px;"><button dojoType="dijit.form.Button" type="submit">Save</button></div>
	</div>
</body>
</html>