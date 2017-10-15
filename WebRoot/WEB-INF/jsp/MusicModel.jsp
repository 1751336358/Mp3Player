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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/MusicModel.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/MusicModel.js"></script>
  </head>
  
  <body>
  
  <div id="controller">
  	<div id="cbox">
  		 <div id="totalTimeBox">
			<div id="currentTimeBox"></div>
		</div>
		
		<div id="totalVolumeBox">
			<div id="currentVolumeBox"></div>
		</div>
		<button class="controller_btn" id="btn">start</button>

		<button class="controller_btn" id="loopPlay">单曲</button>
		<button class="controller_btn" id="orderPlay">顺序</button>
		<button class="controller_btn" id="randomPlay">随机</button>
		
	
		
  	</div>
  </div>

  </body>
</html>
