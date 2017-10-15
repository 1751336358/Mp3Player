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
    
    <title>My JSP 'Detail.jsp' starting page</title>
    
	<meta charset="utf-8"/>
	
	
	
	<!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/MusicModel.css">-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Detail.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/Detail.js"></script>
	<!--<script type="text/javascript" src="${pageContext.request.contextPath}/js/MusicModel.js"></script>-->
	<script type="text/javascript">
		//控制ajax发表评论的js
		$(function(){					
			var SendSay = $("#SendSay");
			if(SendSay == null){
				alert("null");
			}
			//启动Ajax将用户评论插入数据库
			SendSay.click(function(){				
				var musicid = $("#musicid").val();
				var userid = $("#userid").val();
				var username = $("#username1").val();				
				var detail = $("#detail").val();							
				var str = "musicid="+musicid+"&userid="+userid+"&detail="+detail+"&username="+username;			
				$.post("/Mp3Player/addSay",str,function(data){
					eval("var a="+data);										
					var node = "<div id='"+a.id+"'><span>"+${sessionScope.user.username}+"在"+a.time+"评论了:</span><br/><span>"+a.detail+"</span></div>";					
					$("#sayBox").prepend(node);	
				});
			});
			
			//发送弹幕区开始
			var music = document.getElementsByClassName("music")[0];	
		//	alert("bbb");
			$("#SendDanmu").click(function(){
			//	alert("aaa");				
				var currentTime = parseInt(music.currentTime);	//获得当前音乐的播放时间
				var musicid = music.id.substr(5);	//当前音乐的音乐id
				var danmuDetail = $("#danmuDetail").val();	//弹幕内容
				//启动Ajax向数据库插入弹幕信息
				if(danmuDetail.length>10){
					alert("字数太多");
					return;
				}
				var str = "/Mp3Player/SendDanmu/"+currentTime+"/"+musicid+"/"+danmuDetail;
				$.get(str,true,function(data){
			//		alert("弹幕发送成功");
				});
			})			
			//发送弹幕部分结束
	
		});
	</script>
  </head>
  
  <body>
  <jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
  <div id="detailBox">
  	<div id="detailShow">
  		<div id="showDanmu"></div>
  		
  		
  			<textarea id="danmuDetail" cols="20" rows="2"></textarea><button id="SendDanmu">发送弹幕</button>
  		
  				<script>
  					if(${sessionScope.user == null}){
					var detail = document.getElementById("danmuDetail");
					var submit = document.getElementById("SendDanmu");
						detail.value="发送弹幕请登录";
						detail.disabled = true;
						submit.disabled = true;
					
					}else{
						var detail = document.getElementById("danmuDetail");
						var submit = document.getElementById("SendDanmu");
						detail.disabled = false;
						submit.disabled = false;
					}		
  				</script>	
  		<a id="download" href="${pageContext.request.contextPath}/servlet/DownLoad?id=${requestScope.music.id}&filename=${requestScope.music.filename}&musicpath=${requestScope.music.musicpath}">下载</a>	
  		<div id="sayBox">
  			<c:forEach items="${listSay}" var="say">
				<div id="${say.id}">
					<span>${say.username}在${say.time}评论了:</span>
					
					<br/>
					<span>${say.detail}</span>	
				</div>			
			</c:forEach>
  		</div>
  		<div id="saySend">
  			<c:if test="${sessionScope.user != null}">		
				<input id="musicid" type="text" value="${music.id}" hidden/>
				<input id="userid" type="text" value="${sessionScope.user.id}" name="userid" hidden/><!-- 评论者id -->
				<input id="username1" type="text" value="${sessionScope.user.username}" name="username" hidden/><!-- 评论者username -->
				<textarea id="detail" name="detail"></textarea>
				<button id="SendSay">发表评论</button>
			
			</c:if>
  		</div>
  	</div>
  </div>
   
    <!--
    id:${requestScope.music.id }<br/>
    filename:${requestScope.music.filename }<br/>
    musicpath:${requestScope.music.musicpath}
    -->
    <div id="controller">
    	<div id="contShow">
    		<div id="left_cont"></div>
    		<div id="right_cont">
    			${music.filename}
    			<div id="total">
    				<div id="curr"></div>    				
    			</div>    			
    		</div>
    		<div id="oper">
    			<a id="download1" href="${pageContext.request.contextPath}/servlet/DownLoad?id=${requestScope.music.id}&filename=${requestScope.music.filename}&musicpath=${requestScope.music.musicpath}">下载</a>
				<a id="watchmv" href="${pageContext.request.contextPath}/gotoPlayMV/${requestScope.music.id}">MV</a>
    		</div>
    	</div>
    </div>
    <div id="box+${music.id}" class="box"><audio src="/Music/${music.musicpath}" id="music${music.id}" class="music"></audio>
	</div>
	
	<hr/>
	
	
	
	
	
		
	
	
  </body>
</html>
