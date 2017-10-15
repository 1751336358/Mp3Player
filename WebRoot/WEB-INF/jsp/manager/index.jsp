<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员首页</title>
    
	<meta charset="utf-8"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
 
  
  	<frameset cols="200px,*">
		<frame src="${pageContext.request.contextPath}/gotoLeft" name="left"></frame>
		<frame src="${pageContext.request.contextPath}/gotoRight" name="right"></frame>
	</frameset>
</html>
