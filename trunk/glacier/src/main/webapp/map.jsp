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
    @import "/public/dojo/dijit/themes/tundra/tundra.css";
    @import "/public/dojo/dojo/1.1.0/dojo/dojo.css"
</style>
<script type="text/javascript" src="/public/dojo/dojo/dojo.js" djConfig="parseOnLoad:true"></script>

<script type="text/javascript">
   dojo.require("dojo.parser");
   dojo.require("dijit.form.TextBox");
   dojo.require("dijit.form.DateTextBox");
   dojo.require("dijit.form.NumberTextBox");
   dojo.require("dijit.form.Button");
   dojo.require("dijit.form.ComboBox");
   dojo.require("dijit.Dialog");
   dojo.require("dojo.data.ItemFileWriteStore");
   dojo.require("dojo.data.ItemFileReadStore");
   dojo.require("dijit.layout.ContentPane");
   dojo.require("dijit.layout.TabContainer");
</script>

<script type="text/javascript" src="/public/openlayers/OpenLayers.js" ></script>
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
						<div id="processTip">ready</div>
					</div>
				</td>
				<td id="rightPanel">
					<div id="mainTabContainer" dojoType="dijit.layout.TabContainer" style="width:276px;height:450px">
						<div id="temperatureModel" dojoType="dijit.layout.ContentPane" title="Temperature">
							<div class="blockBody">
								<div class="viewItem" style="border: 1px solid #FF0000;"><div class="viewTitle">日期:</div><div id="temperatureDate" dojoType="dijit.form.DateTextBox" style="width: 100px;"></div></div>
								<div class="viewItem"><div class="viewTitle">搜索半径:</div><div id="temperatureMaxDistance" dojoType="dijit.form.NumberTextBox" style="width: 70px;"></div></div>
								<div class="viewItem"><div class="viewTitle">目标坐标:</div><div id="temperaturePointX" dojoType="dijit.form.NumberTextBox" style="width: 60px;"></div>-<div id="temperaturePointY" dojoType="dijit.form.NumberTextBox" style="width: 60px;"></div> <a href="#" onclick="temperaturePointSelect();" style="margin: 1px;">&lt;-地图选点</a></div>
								<div class="viewItem"><button dojoType="dijit.form.Button" onclick="invokeTemperatureModel();"> 计算 </button></div>
								<div id="temperateurePointSelectTip" dojoType="dijit.Dialog" title="提示" execute="temperaturePointSelectTip();">
									<div>请用鼠标在地图上选择目标位置</div>
									<div><input id="temperaturePointSelectTipCheck" dojotype="dijit.form.CheckBox" value="on" type="checkbox" /><label>下次不再提示</label></div>
									<div><button dojoType="dijit.form.Button" type="submit">确定</button></div>
								</div>
							</div>
						</div>
						<div id="precipitationModel" dojoType="dijit.layout.ContentPane" title="Precipitation">
							Once upon a time there was a dear little girl who was loved by
							every one who looked at her, but most of all by her grandmother,
							and there was nothing that she would not have given to the child.
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