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
	dojo.require("dojo.parser");
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
</script>

<style type="text/css">
	@IMPORT url("controls/css/style.css");
</style>
<script type="text/javascript" src="/public/openlayers/OpenLayers.js" ></script>
<script type="text/javascript" src="controls/js/Navigation.js" ></script>
<script type="text/javascript" src="controls/js/SearchFeature.js" ></script>
<script type="text/javascript" src="controls/js/DataViewToolbar.js" ></script>
<script type="text/javascript" src="scripts/models.js"></script>
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
						<div id="progressPanel" class="progressReady">
							<div id="progressText">Ready</div>
						</div>
						<div style="position: absolute;z-index: 3000;visibility: visible;">
							<div id="waterLevelPanel" style="position: absolute;margin-left: 100px;margin-top: 0px;width: 520px; height: 22px; background-color: #EEEEEE;">
								<div id="horizontalSlider" style="width: 400px;float: left;" dojoType="dijit.form.HorizontalSlider"
								   value="5" minimum="-10" maximum="10" discreteValues="11"
								   intermediateChanges="true"
								   onChange="dojo.byId('horizontalSlider').value = arguments[0];"
								   handleSrc="http://o.aolcdn.com/dojo/1.0.0/dijit/themes/tundra/images/preciseSliderThumb.png">
								</div>
								<div type="text" name="dateWaterLevel" style="width: 100px; height: 20px;" value="" dojoType="dijit.form.DateTextBox" />
							</div>
						</div>
					</div>
				</td>
				<td id="rightPanel">
					<div class="viewItem"><div class="viewTitle1">Wetland:</div><div><input id="listCatchment" jsId='listCatchment' dojoType="dijit.form.ComboBox" style="width: 150px;" onchange="wetland.selectBasin();"></input></div></div>

					<div class="blockTitle">Period</div>
					<div class="textBlock">
						Date <input type="text" id='startDate' value="1990-01-01" dojoType='dijit.form.DateTextBox' trim="true" style="width: 100px;" /> -
						<input type="text" id='endDate' value="1999-12-31" dojoType='dijit.form.DateTextBox' trim="true" style="width: 100px;" />
					</div>
					
					<button dojoType="dijit.form.Button" onclick="wetland.selectWpsModel();">Load Models</button>

					<div class="blockBody" style="border: 1px solid #EEEEEE; margin: 1px; padding: 2px;">
						<div class="viewItem"><div class="viewTitle">ET Parameters</div><input id="modelET" dojoType="dijit.form.ComboBox" style="width: 160px;" onchange="wetland.changeModel('modelET');"></input><a class="settingParameter" href="#" onclick="wetland.modelSetting('modelET');">Change</a></div>
					</div>
					<div class="blockBody" style="border: 1px solid #EEEEEE; margin: 1px; padding: 2px;">
						<div class="viewItem"><div class="viewTitle">Water Table Parameters</div><input id="modelWaterTable" dojoType="dijit.form.ComboBox" style="width: 160px;" onchange="wetland.changeModel('modelWaterTable');"></input><a class="settingParameter" href="#" onclick="wetland.modelSetting('modelWaterTable');">Change</a></div>
					</div>
					
					<div class="blockBody" style="border: 1px solid #EEEEEE; margin: 1px; padding: 2px;">
						<button dojoType="dijit.form.Button" onclick="wetland.waterLevelExecute();">Start Simulating</button>
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
	<div id="Setting.WaterTableModel" style="width: 300px;" dojoType="dijit.Dialog" title="Water Table Parameters" execute="wetland.saveSetting('WaterTableModel');">
		<div class="viewItem"><div class="viewTitle2">Saturation Prcp</div><div id="WaterTableModel.SaturationPrcp" dojoType="dijit.form.NumberTextBox"" style="width: 70px;" value="0.003"></div></div>
		
		<div style="line-height: 25px;"><button dojoType="dijit.form.Button" type="submit">Save</button></div>
	</div>
</body>
</html>