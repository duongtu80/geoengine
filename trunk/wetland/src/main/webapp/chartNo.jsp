<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chart</title>
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
</head>
<body class="tundra" style="font-size: 12px;">
	<div class="bodywrap">
		<jsp:include page="inc/top.jsp"></jsp:include>
		<div id="mainPanel">
			Not found wetland at location <s:property value="pt"/>
		</div>
		<jsp:include page="inc/tail.jsp"></jsp:include>
	</div>
</body>
</html>