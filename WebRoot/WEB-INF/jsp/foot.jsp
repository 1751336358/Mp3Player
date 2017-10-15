<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
    
	<meta charset="utf-8"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/foot.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/MusicModel.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/MusicModel.js"></script>
  </head>
  
  <body>
  
 	<div id="foot_box1">
 		<div id="box1">
 			<ul>
 				<li><a href="">关于酷狗</a></li>
 				<li><a href="">监督举报</a></li>
 				<li><a href="">广告服务</a></li>
 				<li><a href="">版权指引</a></li>
 				<li><a href="">隐私政策</a></li>
 				<li><a href="">用户服务协议</a></li>
 				<li><a href="">推广合作</a></li>
 				<li><a href="">酷狗音乐人</a></li>
 				<li><a href="">酷狗音乐推</a></li>
 				<li><a href="">招聘信息</a></li>
 				<li><a href="">客服中心</a></li>
 				<li class="lastli"><a href="">用户体验升计划</a></li>
 				
 			</ul>
 		</div>
 	</div>
 	<div id="foot_box2">
 		<div id="box2">
 			
 		</div>
 	</div>
  </body>
</html>
