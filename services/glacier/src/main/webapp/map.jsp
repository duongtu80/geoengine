<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>冰川径流模型</title>
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
	dojo.require("dijit.form.ValidationTextBox");
	dojo.require("dijit.form.Button");
	dojo.require("dijit.form.ComboBox");
	dojo.require("dijit.form.CheckBox");
	dojo.require("dijit.Dialog");
	dojo.require("dojo.data.ItemFileReadStore");
	dojo.require("dijit.layout.ContentPane");
	dojo.require("dijit.layout.TabContainer");
</script>

<script type="text/javascript">
	var wmsMapUrl = '<s:property value="wmsMapUrl"/>';
	var wmsLayerName = '<s:property value="wmsLayerName"/>';
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
						<div id="progressPanel" class="progressReady"><div id="progressText">Ready</div></div>
					</div>
				</td>
				<td id="rightPanel">
					<div class="blockBody" style="border: 1px solid #EEEEEE; margin: 1px; padding: 2px;">
						<div class="viewItem"><div class="viewTitle1">日期</div><div id="startYear" dojoType="dijit.form.ValidationTextBox" regExp="\d{4}" invalidMessage="年份介于1960年至2000年" style="width: 70px;" value="1980"></div>-<div id="endYear" dojoType="dijit.form.ValidationTextBox" regExp="\d{4}" invalidMessage="年份介于1960年至2000年" style="width: 70px;" value="1990"></div></div>
						<div class="viewItem"><div class="viewTitle1">流域</div><div><input id="listCatchment" jsId='listCatchment' dojoType="dijit.form.ComboBox" style="width: 150px;" onchange="glacier.selectBasin();" /></div></div>
					</div>
					<button dojoType="dijit.form.Button" onclick="glacier.selectWpsModel();">加载模型</button>
					<div class="blockBody" style="border: 1px solid #EEEEEE; margin: 1px; padding: 2px;">
						<div class="blockBody" style="border: 1px solid #EEEEEE; margin: 1px; padding: 2px;">
							<div class="viewItem"><div class="viewTitle">气温插值</div><input id="modelTemperature" dojoType="dijit.form.ComboBox" style="width: 160px;" onchange="glacier.changeModel('modelTemperature');" /><a class="settingParameter" href="#" onclick="glacier.modelSetting('modelTemperature');">修改参数</a></div>
						</div>
						<div class="blockBody" style="border: 1px solid #EEEEEE; margin: 1px; padding: 2px;">
							<div class="viewItem"><div class="viewTitle">降水插值</div><input id="modelPrecipitation" dojoType="dijit.form.ComboBox"  style="width: 160px;" onchange="glacier.changeModel('modelPrecipitation');" /><a class="settingParameter" href="#" onclick="glacier.modelSetting('modelPrecipitation');">修改参数</a></div>
						</div>
						<div class="blockBody" style="border: 1px solid #EEEEEE; margin: 1px; padding: 2px;">
							<div class="viewItem"><div class="viewTitle">雪度日因子</div><input id="modelSnowDdf" dojoType="dijit.form.ComboBox"  style="width: 160px;" onchange="glacier.changeModel('modelSnowDdf');" /><a class="settingParameter" href="#" onclick="glacier.modelSetting('modelSnowDdf');">修改参数</a></div>
						</div>
						<div class="blockBody" style="border: 1px solid #EEEEEE; margin: 1px; padding: 2px;">
							<div class="viewItem"><div class="viewTitle">冰度日因子</div><input id="modelIceDdf" dojoType="dijit.form.ComboBox"  style="width: 160px;" onchange="glacier.changeModel('modelIceDdf');" /><a class="settingParameter" href="#" onclick="glacier.modelSetting('modelIceDdf');">修改参数</a></div>
						</div>
						<div class="blockBody" style="border: 1px solid #EEEEEE; margin: 1px; padding: 2px;">
							<div class="viewItem"><div class="viewTitle">径流模型</div><input id="modelRunoff" dojoType="dijit.form.ComboBox"  style="width: 160px;" onchange="glacier.changeModel('modelRunoff');" /><a class="settingParameter" href="#" onclick="glacier.modelSetting('modelRunoff');">修改参数</a></div>
						</div>
						<div class="blockBody" style="border: 1px solid #EEEEEE; margin: 1px; padding: 2px;">
							<button dojoType="dijit.form.Button" onclick="glacier.runoffModelExecute();">运行</button>
						</div>
					</div>
				</td>
			</tr>
			</table>
			<div id="resultPanel">
			</div>
		</div>
		<jsp:include page="inc/tail.jsp"></jsp:include>
	</div>
	<div id="dlgSelectWfsDataSource" dojoType="dijit.Dialog" title="选择数据源" execute="glacier.pointSelectTip();">
		<div class="viewItem"><div class="viewTitle">数据服务:</div><div style="float: left;"><div id="txtWfsService" dojoType="dijit.form.TextBox" style="width: 200px;" value="http://127.0.0.1:48080/geoserver/wfs"></div></div><div onclick="glacier.listWfsDataset();">加载</div></div>
		<div class="viewItem"><div class="viewTitle">数据集:</div><div id="listWfsDataset" dojoType="dijit.form.ComboBox"" jsId="modelsList" style="width: 100px;"></div></div>
		
		
		<div style="line-height: 25px;"><button dojoType="dijit.form.Button" type="submit">确定</button></div>
	</div>
	<div id="dlgLoadWpsModel" dojoType="dijit.Dialog" title="加载模型服务" execute="glacier.loadWpsModel();">
		<div class="viewItem"><div class="viewTitle">模型服务:</div><div id="txtWpsService" dojoType="dijit.form.TextBox" style="width: 300px;" value="http://127.0.0.1:59080/web/wps"></div></div>
		<div style="line-height: 25px;"><button dojoType="dijit.form.Button" type="submit">确定</button></div>
	</div>
	
	<div id="Setting.TemperatureModel" dojoType="dijit.Dialog" title="气温反距离插值参数" execute="glacier.saveSetting('TemperatureModel');">
		<div class="blockBody">
			<div class="viewItem"><div class="viewTitle2">指数:</div><div id="TemperatureModel.Power" dojoType="dijit.form.NumberTextBox" style="width: 70px;" value="2"></div></div>
			<div class="viewItem"><div class="viewTitle2">最大个数:</div><div id="TemperatureModel.MaxCount" dojoType="dijit.form.NumberTextBox" style="width: 70px;"></div> (置空忽略该参数)</div>
			<div class="viewItem"><div class="viewTitle2">搜索半径:</div><div id="TemperatureModel.MaxDistance" dojoType="dijit.form.NumberTextBox" style="width: 90px;"></div> (置空忽略该参数)</div>
			<div class="viewItem"><button dojoType="dijit.form.Button" type="submit">保存</button></div>
		</div>
	</div>
	<div id="Setting.TemperatureModelEx" dojoType="dijit.Dialog" title="气温修正反距离插值参数" execute="glacier.saveSetting('TemperatureModelEx');">
		<div class="blockBody">
			<div class="viewItem"><div class="viewTitle2">指数:</div><div id="TemperatureModelEx.Power" dojoType="dijit.form.NumberTextBox" style="width: 70px;" value="2"></div></div>
			<div class="viewItem"><div class="viewTitle2">最大个数:</div><div id="TemperatureModelEx.MaxCount" dojoType="dijit.form.NumberTextBox" style="width: 70px;"></div> (置空忽略该参数)</div>
			<div class="viewItem"><div class="viewTitle2">搜索半径:</div><div id="TemperatureModelEx.MaxDistance" dojoType="dijit.form.NumberTextBox" style="width: 90px;"></div> (置空忽略该参数)</div>
			<div class="viewItem"><div class="viewTitle2">标准高程:</div><div id="TemperatureModelEx.Stand" dojoType="dijit.form.NumberTextBox" style="width: 70px;" value="3000"></div>m</div>
			<div class="viewItem"><div class="viewTitle2">垂直递减率:</div><div id="TemperatureModelEx.Grads" dojoType="dijit.form.NumberTextBox" style="width: 90px;" value="-0.006"></div>°C/m</div>
			<div class="viewItem"><button dojoType="dijit.form.Button" type="submit">保存</button></div>
		</div>
	</div>
	<div id="Setting.PrecipitationModel" dojoType="dijit.Dialog" title="降水反距离插值参数" execute="glacier.saveSetting('PrecipitationModel');">
		<div class="blockBody">
			<div class="viewItem"><div class="viewTitle2">指数:</div><div id="PrecipitationModel.Power" dojoType="dijit.form.NumberTextBox" style="width: 70px;" value="2"></div></div>
			<div class="viewItem"><div class="viewTitle2">最大个数:</div><div id="PrecipitationModel.MaxCount" dojoType="dijit.form.NumberTextBox" style="width: 70px;"></div> (置空忽略该参数)</div>
			<div class="viewItem"><div class="viewTitle2">搜索半径:</div><div id="PrecipitationModel.MaxDistance" dojoType="dijit.form.NumberTextBox" style="width: 90px;"></div> (置空忽略该参数)</div>
			<div class="viewItem"><button dojoType="dijit.form.Button" type="submit">保存</button></div>
		</div>
	</div>
	<div id="Setting.SnowDDFModel" dojoType="dijit.Dialog" title="雪度日因子反距离插值参数" execute="glacier.saveSetting('SnowDDFModel');">
		<div class="blockBody">
			<div class="viewItem"><div class="viewTitle2">指数:</div><div id="SnowDDFModel.Power" dojoType="dijit.form.NumberTextBox" style="width: 70px;" value="2"></div></div>
			<div class="viewItem"><div class="viewTitle2">最大个数:</div><div id="SnowDDFModel.MaxCount" dojoType="dijit.form.NumberTextBox" style="width: 70px;"></div> (置空忽略该参数)</div>
			<div class="viewItem"><div class="viewTitle2">搜索半径:</div><div id="SnowDDFModel.MaxDistance" dojoType="dijit.form.NumberTextBox" style="width: 90px;"></div> (置空忽略该参数)</div>
			<div class="viewItem"><button dojoType="dijit.form.Button" type="submit">保存</button></div>
		</div>
	</div>
	<div id="Setting.IceDDFModel" dojoType="dijit.Dialog" title="冰度日因子反距离插值参数" execute="glacier.saveSetting('IceDDFModel');">
		<div class="blockBody">
			<div class="viewItem"><div class="viewTitle2">指数:</div><div id="IceDDFModel.Power" dojoType="dijit.form.NumberTextBox" style="width: 70px;" value="2"></div></div>
			<div class="viewItem"><div class="viewTitle2">最大个数:</div><div id="IceDDFModel.MaxCount" dojoType="dijit.form.NumberTextBox" style="width: 70px;"></div> (置空忽略该参数)</div>
			<div class="viewItem"><div class="viewTitle2">搜索半径:</div><div id="IceDDFModel.MaxDistance" dojoType="dijit.form.NumberTextBox" style="width: 90px;"></div> (置空忽略该参数)</div>
			<div class="viewItem"><button dojoType="dijit.form.Button" type="submit">保存</button></div>
		</div>
	</div>
	<div id="Setting.RunoffModel" dojoType="dijit.Dialog" title="冰川径流模型参数" execute="glacier.saveSetting('RunoffModel');">
		<div class="blockBody">
			<div class="viewItem"><div class="viewTitle2">降水临界值:</div><div id="RunoffModel.RainCritical" dojoType="dijit.form.NumberTextBox" style="width: 70px;" value="2"></div></div>
			<div class="viewItem"><div class="viewTitle2">融雪临界值:</div><div id="RunoffModel.SnowCritical" dojoType="dijit.form.NumberTextBox" style="width: 70px;" value="-0.5"></div></div>
			<div class="viewItem"><div class="viewTitle2">融水渗浸冻结率:</div><div id="RunoffModel.SnowFrozenRatio" dojoType="dijit.form.NumberTextBox" style="width: 70px;" value="0.1"></div></div>
			<div class="viewItem"><button dojoType="dijit.form.Button" type="submit">保存</button></div>
		</div>
	</div>
</body>
</html>