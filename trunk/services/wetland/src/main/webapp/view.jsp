<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Data</title>
<style type="text/css">
@IMPORT url("css/common.css");

@IMPORT url("css/map.css");
</style>
<style type="text/css">
@import "/public/dojo/dijit/themes/tundra/tundra.css";
</style>
<script type="text/javascript" src="/public/dojo/dojo/dojo.js"
	djConfig="parseOnLoad:true"></script>

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

<STYLE type="text/css">
.cellTitle{
	background-color: #FFFFFF;
	font-weight: bold;
	text-align: center;
	border-width: 0px;
}

.cellDate {
	background-color: #CCFF99;
}

.cellValue1 {
	background-color: #99CCFF;
}

.cellValue2 {
	background-color: #CC99FF;
}

.cellValue3 {
	background-color: #99FFCC;
}

.panelTitle {
	font-family: Verdana, Sans Serif;
	font-size: 11px;
	line-height: 40px;
	border-bottom: 1px solid #0099EE;
}
</STYLE>

</head>
<body class="tundra">
<div class="bodywrap"><jsp:include page="inc/top.jsp"></jsp:include>
<div id="mainPanel">
<div class="panelTitle">Charts</div>
<div>
	<s:iterator value="{'eT', 'waterLevel', 'precipitation'}" status="row2">
		<img src="model/processChart.do?tag=<s:property />&id=<s:property value="code" />&date=<s:property value="(new java.util.Date()).time + #row2.index" />" ></img>
	</s:iterator>
</div>
<div class="panelTitle">Data</div>
<table style="width: 500px; font-size: 12px; border: 1px solid #AAAAAA;">
	<tr>
		<tr>
			<td class="cellTitle">Date</td>
			<td class="cellTitle">ET</td>
			<td class="cellTitle">Water Level (m)</td>
			<td class="cellTitle">Precipitation (mm)</td>
		</tr>
		<s:iterator value="dateList" status="row">
			<tr style="line-height: 25px;">
				<td class="cellDate"><s:property /></td>
				<td class="cellValue1"><s:property value="etList[#row.index]" /></td>
				<td class="cellValue2"><s:property value="waterLevelList[#row.index]" /></td>
				<td class="cellValue3"><s:property value="precipitationList[#row.index]" /></td>
			</tr>
		</s:iterator>
	</tr>
</table>
</div>
<jsp:include page="inc/tail.jsp"></jsp:include></div>
</body>
</html>