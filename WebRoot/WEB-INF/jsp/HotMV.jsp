<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta charset="utf-8"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/HotMV.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/HotMV.js"></script>
	
	
		
  </head>
  
  <body>
  <jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
  <!--
  	name:${requestScope.musicMV.mvname}<br/>
  	playnum:${requestScope.musicMV.playnum}<br/>
  	musicfilename:${requestScope.musicMV.musicfilename}<br/>
  	singname:${requestScope.musicMV.singname}<br/>
  	mvid:${requestScope.musicMV.mvid}<br/>
 	-->
 	<div id="HotMVbox">
 		<div id="MVshow">
 			<p id="title">正在播放 :${requestScope.musicMV.singname}--${requestScope.musicMV.musicfilename}</p>
 			<div id="play">
 				<video id="video" class="${requestScope.musicMV.mvid}" src="/Music/${requestScope.musicMV.mvpath}" controls="controls"></video>
 				<p class="danmudetail"></p>
 			</div>
 			<textarea id="danmuInner"></textarea><button id="sendDanmu">发送弹幕</button>
 		</div>		
 	</div>
 	
	<jsp:include page="/WEB-INF/jsp/foot.jsp"></jsp:include>
  </body>
</html>
