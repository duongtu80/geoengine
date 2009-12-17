<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript">
    	var ttt= {'test1': 23, 'test2': 35};
    	var _t;
    	for(_t in ttt){
        	alert(_t);
    	}
    </script>
  </head>

  <body>
    <div id="chart_div" style="width: 600px; height: 300px;"></div>
</body>
</html>