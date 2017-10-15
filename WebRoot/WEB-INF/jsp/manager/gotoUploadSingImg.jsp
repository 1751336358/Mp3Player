<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传歌手写真的jsp</title>
    
	<meta charset="utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>


  </head>
  
  <body>
    	<c:forEach items="${singNames}" var="singname">
    		<span>${singname}</span>
    	</c:forEach>
  </body>
</html>
