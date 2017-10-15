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
    
    <title>播放MV的页面</title>
    
	<meta charset="utf-8"/>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/HotMV.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/PlayMV.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/HotMV.js"></script>
	
  </head>
  
  <body>
  	<jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
  	
  	<c:if test="${requestScope.musicMv == null}">
  	<div id="uploadMV">
  		<div id="uploadShow">
  			<p>抱歉，该音乐没有mv，可以选择上传</p>
	  		<form action="${pageContext.request.contextPath}/servlet/UploadMV" method="post" enctype="multipart/form-data">
	  			<input type="text" name="mvName" value="${requestScope.filename}" hidden/>
	  			<input type="text" name="musicid" value="${requestScope.musicid}" hidden>
	  			<input type="file" name="file1" id="file">
	    		<input type="submit" value="上传"  id="uploadMV1" />
	  		</form>
	  		<div id="warn">
	  			温馨提示，由于网络原因，上传MV速度会很慢。在此期间请不要刷新页面，防止上传失败.
	  		</div>
  		</div>
  	</div>
  		
  		
  		<script type="text/javascript">		
			
			document.getElementById("uploadMV1").onclick = function(e){
				var event = e || window.event;	//事件对象
				var file = document.getElementById("file");
				var filename = file.value;
				
				if(filename.slice(-4) != '.mp4'){	//如果文件名不是以.mp4结尾，取消浏览器默认行为
					event.returnValue = false;
					event.preventDefault();	//阻止浏览器默认行为，阻止上传文件
					alert("文件格式错误，请上传mp4格式的文件");
				}
			}		
		</script>
  	</c:if>
  	
  	
  	<c:if test="${requestScope.musicMv != null}">
  		
  		<!--<p>musicid:${requestScope.musicid}</p>
	  	<p>musicfilename:${requestScope.filename}</p>
	  	<p>mv.id:${requestScope.musicMv.mvid}</p>
	  	<p>mvpath:${requestScope.musicMv.mvpath}</p>
	  	<p>mvname:${requestScope.musicMv.mvname}</p>
	  	-->
	  	<div id="HotMVbox">
	  		<div id="MVshow">
	  			<div id="play">
	  				<p id="title">正在播放 :${requestScope.filename}</p>
	  				<video class="${requestScope.musicMv.mvid}" id="video" src="/Music${requestScope.musicMv.mvpath}" controls="controls">
	  				<p class="danmudetail"></p>
	  			</div>	  			
	  			<textarea id="danmuInner"></textarea><button id="sendDanmu">发送弹幕</button>
	  		</div>
	  	</div>
  	</c:if>
	
  	<jsp:include page="/WEB-INF/jsp/foot.jsp"></jsp:include>
  </body>
</html>
