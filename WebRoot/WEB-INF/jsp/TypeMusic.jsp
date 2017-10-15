<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJMusic.jsp' starting page</title>
    
	<meta charset="utf-8"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/MusicListModel.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/MusicModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			//动态调整Music_Box高度
			var Music_Left = $("#Music_List #Music_Box  #Music_Left");
			var Music_Right = $("#Music_List #Music_Box  #Music_Right");
			var max = Music_Left.height()>=Music_Right.height()?Music_Left.height():Music_Right.height();		
			$("#Music_List #Music_Box").css("height",max+50+"px");
		})
	</script>
  </head>
  
  <body>
  	
  <jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
 	<div id="Music_List">
 		<div id="Music_Box"> 			
 			<jsp:include page="/WEB-INF/jsp/left.jsp"></jsp:include>
 			<div id="Music_Right">
 				<div id="title">
 					酷狗<span style="color:red;">飙升</span>榜
 				</div>
 				<div id="list">
 					<c:forEach items="${musicList}" var="music" varStatus="status">
 						<div class="outer">
 							<c:choose>
 								<c:when test="${status.count <= 3}">
 									<p style="color:red;">${status.count}</p>
 								</c:when>
 								<c:otherwise>
 									<p style="color:black;">${status.count}</p>
 								</c:otherwise>	
 							</c:choose>
 							
 							<div id="box+${music.id}" class="box"><audio src="/Music/${music.musicpath}" id="music+${music.id}" class="music"></audio>${music.filename}</div>
 							<div class="operater">
	 							<a href="${pageContext.request.contextPath}/servlet/DownLoad?id=${music.id}&filename=${music.filename}&musicpath=${music.musicpath}">下载</a>
						   		<a href="${pageContext.request.contextPath}/Detail?id=${music.id}&filename=${music.filename}&musicpath=${music.musicpath}">详情</a>
						   		<a href="${pageContext.request.contextPath}/gotoPlayMV/${music.id}">观看MV</a>
 							</div>
 						</div>
				    </c:forEach>
 				</div>
 			</div> 			 			
 		</div> 		
 	</div>
 	<jsp:include page="/WEB-INF/jsp/MusicModel.jsp"></jsp:include>
   <jsp:include page="/WEB-INF/jsp/foot.jsp"></jsp:include>
 </body>
</html>
