<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="itemArea">
	<div class="itemBar">
		<div class="itemName">City</div>
		<div class="itemValue"><s:property value="cityName"/></div>
	</div>
	<div class="itemBar">
		<div class="itemName">Country</div>
		<div class="itemValue"><s:property value="countryName"/></div>
	</div>
	<div class="itemBar">
		<div class="itemName">Status</div>
		<div class="itemValue"><s:property value="status"/></div>
	</div>
	<div class="itemBar">
		<div class="itemName">Population</div>
		<div class="itemValue"><s:property value="popClass"/></div>
	</div>
</div>