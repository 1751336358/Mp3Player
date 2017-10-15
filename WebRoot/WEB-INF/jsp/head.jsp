<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">     
	<meta charset="utf-8"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/head.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/head.js"></script>
	
	<script type="text/javascript">
		$(function(){
			var login = $("#head_box #head_show #head_login");	//首页登录按钮
			var upload = $("#head_box #head_show #head_upload");	//上传按钮对象
			var mymusic = $("#head_box #head_show #head_mymusic");	//查看我的音乐按钮对象
			upload.click(function(event){
			
				if(${sessionScope.user == null}){	//如果没有登录
					loginCore(event);	//调用弹出登录框函数，完成登录
				}else{
					//弹出上传框
					uploadMusic(event);
				}
			});
			mymusic.click(function(event){
			
				if(${sessionScope.user == null}){	//如果没有登录
					loginCore(event);	//调用弹出登录框函数，完成登录
				}
			});
			
			login.click(function(event){	//点击首页登录按钮
				loginCore(event);	//调用弹出登录框函数，完成登录
			})
		})
		
		
		
	</script>
  </head>
  <body>
  <div id="cover"></div>
  <!-- 登录框 -->
  <div id="head_login">
  	<div id="login_show">
		<p id="login_title">登录酷狗音乐</p>
		<img id="closeWindow" src="${pageContext.request.contextPath}/image/closeWindow.png"/>
  		<p id="Message">用户名或密码不正确</p>
  			<input id="username" type="text" name="username" placeholder="用户名" required="required"></input>
		   	<input id="password" type="text" name="password" placeholder="密码" required="required"></input>
		   	<button id="submit">登录</button>
  		
  		<a id="register" href="${pageContext.request.contextPath}/gotoRegisterPage">立即注册</a>
  		<img id="login_logo" src="${pageContext.request.contextPath}/image/login_logo.png"/>
  		<a id="a1" href="">用户协议</a>
  		<a id="a2" href="">隐私政策</a>
  	</div>
  </div>
  
  <!-- 上传框 -->
   <div id="headUpload">
  		<div id="uploadShow">
			<p id="uploadTitle">上传音乐</p>
			<img id="closeWindow" src="${pageContext.request.contextPath}/image/closeWindow.png"/>
	  		
	  		<form action="${pageContext.request.contextPath}/servlet/UploadMusic" method="post" enctype="multipart/form-data">
		    	<!-- id在后台生成 -->
		    	<input type="text" name="username" value="${sessionScope.user.username}" hidden>
		    	<input type="text" name="userid" value="${sessionScope.user.id}" hidden>
		    	<select  name="typeid">
		    		<!--<option value="1">影视</option>
		    		<option value="2">悲伤</option>
		    		<option value="3">愉快</option>
		    		<option value="4">轻松</option>
		    		<option value="5">欧美</option>
		    		<option value="6">DJ劲曲</option>
		    		<option value="7">日韩</option>
		    		<option value="8">古风</option>
		    		<option value="9">爱情</option>
		    		<option value="10">励志</option>
		    		<option value="11">华语</option>
		    		<option value="12">粤语</option>
		    		<option value="13">网络歌手</option>   		
	    			-->
	    		</select>
		    	
		    	<input  id="singname" type="text" name="singname" placeholder="输入歌手名" required="required"/><br/>
		    	<!-- 必须要有name属性 -->
		    	<input id="file1" type="file" name="file1"><br/>
		    	<input id="submitfile" type="submit" value="上传">
		    	<div id="warn">
		    		温馨提示，由于网络原因，上传Music速度会很慢。在此期间请不要刷新页面，防止上传失败
		    	</div>
		    	<script type="text/javascript">
		    		//自动完成歌手名字的录入	
					document.getElementById("file1").onchange = function(){
					//C:\fakepath\TG4 - 阳光男孩阳光女孩.mp3
						var filename = document.getElementById("file1").value;
						var singname = filename.slice(12,filename.indexOf("-")).trim();	//歌手名:TG4
						var sing = filename.slice(filename.indexOf("-")+1).trim();	//歌名：xxx.mp3						
						document.getElementById("singname").value = singname;
					}
					document.getElementById("submitfile").onclick = function(e){
						var event = e || window.event;	//事件对象
						var file1 = document.getElementById("file1");
						var filename = file1.value;
						
						if(filename.slice(-4) != '.mp3'){	//如果文件名不是以.mp3结尾，取消浏览器默认行为
							event.returnValue = false;
							event.preventDefault();	//阻止浏览器默认行为，阻止上传文件
							alert("文件格式错误，请上传mp3格式的文件");
						}
						
					}	
				</script>
		    </form>
  		</div>
  	</div>
  
  
  
  
  
  
    <div id="head_box">
    	<div id="head_show">
    		<img id="head_logo" src="${pageContext.request.contextPath}/image/logo.png"/>
  			<input id="head_search" type="text" name="key" form="form" /> 				
  			<input id="head_submit" type="submit" value="sousuo" form="form">
  			<a id="head_mymusic" href="${pageContext.request.contextPath}/SelMusicByUserId?userid=${sessionScope.user.id}" target="_blank">查看我的音乐</a>
    		<a id="head_upload" href="">上传歌曲</a>		
    		<c:if test="${sessionScope.user != null}">
    			<a id="head_logout" href="${pageContext.request.contextPath}/unLogin">注销</a>
    		</c:if>
    		<c:if test="${sessionScope.user == null}">
    			<a id="head_login" href="">登录</a>
    			<a id="head_register" href="${pageContext.request.contextPath}/gotoRegisterPage">注册</a>
    		</c:if>
    	</div>
    </div>
    <div id="head_list">
    	<div id="head_show1">
    		<div id="one" class="list_left"><a id="head_index" href="${pageContext.request.contextPath}/gotoIndex">首页</a></div>
    		<div id="two" class="list_left"><a href="http://www.kugou.com/yy/html/rank.html">榜单</a></div>
    		<div id="three" class="list_left"><a href="${pageContext.request.contextPath}/gotoDownloadClient">下载客户端</a></div>
    		<div id="four" class="list_left"><a href="http://www.kugou.com/">原站</a></div>
    		<div id="six" class="list_right"><a href="http://www.kugou.com/shop/">商城</a></div>
    		<div id="seven" class="list_right"><a href="http://games.kugou.com/?f=7">游戏</a></div>
    		<div id="eight" class="list_right"><a href="http://www.kugou.com/imusic/">音乐人</a></div>
    		<div id="nine" class="list_right"><a href="http://live.kugou.com/">酷狗LIVE</a></div>
    		<div id="ten" class="list_right"><a href="http://fanxing.kugou.com/?action=spreadIndex&id=3">音乐直播</a></div>
    	</div>
    </div>
    <form id="form" action="${pageContext.request.contextPath}/SelByKey" method="post"></form>
  </body>
</html>
