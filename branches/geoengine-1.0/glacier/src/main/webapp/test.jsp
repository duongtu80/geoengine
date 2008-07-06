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
<STYLE type="text/css">
	.resultPanel {
		border: 1px solid #EEEEEE;
	}
</STYLE>
<script type="text/javascript" src="/public/dojo/dojo/dojo.js" djConfig="parseOnLoad:true"></script>
<script type="text/javascript" src="scripts/models.js"></script>
<script type="text/javascript">
	dojo.require("dojo.parser");
	dojo.require("dijit.form.TextBox");
	dojo.require("dijit.form.DateTextBox");
	dojo.require("dijit.form.NumberTextBox");
	dojo.require("dijit.form.Button");
	dojo.require("dijit.form.ComboBox");
	dojo.require("dojo.data.ItemFileWriteStore");
	dojo.require("dojo.data.ItemFileReadStore");
	dojo.require("dijit.layout.ContentPane");
	dojo.require("dijit.layout.TabContainer");
	dojo.require("dijit.layout.AccordionContainer");

	function invokeTemperatureModel1(){
		var _data = {
				'identifier': 'name',
				'label': 'name',
				'items': [
						{'name': 'test1', 'title': 'test1'},
						{'name': 'test2', 'title': 'test2'},
						{'name': 'test3', 'title': 'test3'}
					]
			};
			
		var _store = new dojo.data.ItemFileReadStore({data: _data});
		dijit.byId('listCatchment').store = _store;
	}

	function invokeTemperatureModel2(){
		alert(dijit.byId('listCatchment').item);
		
		var _val = dijit.byId('listCatchment').getValue();
		alert(_val);
		
		alert(dijit.byId('listCatchment').store._getItemByIdentity(_val));
		
	}

	function invokeTemperatureModel3(){
     	var _newDiv = document.createElement("div");
     	var _closeImg = document.createElement('img');
     	_closeImg.src = 'images/close.png';
     	_closeImg.onclick = function (e){
     			alert(e.target.parentNode.nodeType);
     			e.target.parentNode.parentNode.parentNode.removeChild(e.target.parentNode.parentNode);
//     			dojo.byId('resultPanel').removeChild(e.target.parentNode);
     		}
     	
       	var _closeDiv = document.createElement("div");
       	_closeDiv.appendChild(_closeImg);
       	_closeDiv.style["textAlign"] = 'right';
       	
     	var _newImg = document.createElement("img");
     	_newImg.src = "model/chartStream.do?code=119fc90d16e";
     	
     	_newDiv.appendChild(_closeDiv);
     	_newDiv.appendChild(_newImg);
     	_newDiv.className = 'resultPanel';
     	
     	dojo.byId('resultPanel').appendChild(_newDiv);
	}
</script>
</head>
<body class="tundra" style="font-size: 12px;">
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
								<div class="viewItem"><div class="viewTitle">搜索半径:</div><div id="temperatureMaxDistance" dojoType="dijit.form.NumberTextBox" style="width: 60px;"></div></div>
								<div class="viewItem"><button dojoType="dijit.form.Button" onclick="invokeTemperatureModel1();"> 计算 </button></div>
								<div class="viewItem"><button dojoType="dijit.form.Button" onclick="invokeTemperatureModel2();"> 计算 </button></div>
								<div class="viewItem"><button dojoType="dijit.form.Button" onclick="invokeTemperatureModel3();"> 计算 </button></div>
								<div class="viewItem"><div class="viewTitle">流域</div><div style="float: left;"><input id="listCatchment" dojoType="dijit.form.ComboBox" style="width: 150px;" onchange="glacier_selectBasin();"></input></div><div><img src="images/setting.png" onclick="glacier.selectWfsDataSource('listCatchment');"/></div></div>
							</div>
						</div>
						<div id="precipitationModel" dojoType="dijit.layout.ContentPane" title="Precipitation">
							Once upon a time there was a dear little girl who was loved by
							every one who looked at her, but most of all by her grandmother,
							and there was nothing that she would not have given to the child.
						</div>
					<div dojoType="dijit.layout.AccordionContainer" duration="200"
						minSize="20" style="width: 300px;" id="leftAccordion" region="leading" splitter="true">
					
					      <div dojoType="dijit.layout.AccordionPane" selected="true" title="Pane 1">
					        <p >Content 1</p >
					        <div>eeeeeeeeeeeee</div>
					      </div>
					
					      <div dojoType="dijit.layout.AccordionPane" closable="true" selected="false" title="Pane 2">
					        <p >Content 233</p >
					        <div>eeeeeeeeeeeee</div>
					      </div>
					
					      <div dojoType="dijit.layout.AccordionPane" closable="true" selected="false" title="Pane 3">
					        <p > Content 3</p >
					      </div>
						
					</div>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="resultPanel"></div>
					<div>
						<div style="float: left;">tstewerwer</div>
						<div style="text-align: right;">
							<img src="images/close.png"/>
						</div>
						<div>
							<img src="model/chartStream.do?code=11a003b5d31"/>
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