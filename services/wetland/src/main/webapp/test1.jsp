<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Dojo example</title>

<!-- Load dojo from Google cache site -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/dojo/1.3.0/dojo/dojo.xd.js" djConfig="parseOnLoad:true"></script>
<style type="text/css">
    @import "http://ajax.googleapis.com/ajax/libs/dojo/1.3.0/dijit/themes/tundra/tundra.css";
</style>

<script>
   dojo.require("dijit.Tooltip");
</script>
<body class="nihilo">
<div dojoType="dijit.Tooltip" connectId="wordOfTheDay">
    a <i>disposition</i> to bear injuries patiently : <b>forbearance</b>
 </div>
 <span id="wordOfTheDay">Longanimity</span>
</body>
</html>