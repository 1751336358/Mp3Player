<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册界面</title>
    
	<meta charset="utf-8"/>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/head.css">	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Register.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/head.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/Register.js"></script>
	<script type="text/javascript">
	
		$(function(){
			var login_a = $("#register_top1 #top1 #login_a");	//登录连接
			login_a.click(function(event){	//点击登录连接
				loginCore(event);	//调用弹出登录框函数，完成登录
			})
		})
	</script>
	

  </head>
  
  <body>
	  <div id="cover"></div>
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
	  
	  
  		<div id="register_top1">
  			<div id="top1">
  				<a id="login_a" href="${pageContext.request.contextPath}/gotoLoginPage">登录</a>
  				<a id="register_a" href="${pageContext.request.contextPath}/gotoRegisterPage">注册</a>
  			</div>
  			
  		</div>
  		<div id="register_top2">
  			
  			<div id="top2">
  				<a id="top2_logo" href=""><img src="${pageContext.request.contextPath}/image/register_logo2.jpg"/></a>
  				<a id="a1" class="list" href="http://www.kugou.com/shop/">酷狗商城</a>
  				<a id="a2" class="list" href="${pageContext.request.contextPath}/gotoDownloadClient">下载客户端</a>
  				<a id="a3" class="list" href="http://fanxing.kugou.com/?action=spreadIndex&id=3">音乐直播</a>
  				<a id="a4" class="list" href="http://www.kugou.com/imusic/">酷狗音乐人</a>
  				<a id="a5" class="list" href="http://download.kugou.com/">产品中心</a>
  				<a id="a6" class="list" href="http://vip.kugou.com/">VIP中心</a>
  				<a id="a7" class="list" href="http://www.kugou.com/shop/help/serviceCenter">客服中心</a>
  			</div>
  		</div>
  		
  		<div id="register_box">
  			<div id="register_show">
  				<div id="form">
  					<p id="register_title">注册酷狗音乐</p>
  					<p id="Message">用户已存在</p>
  					<input id="register_uname" type="text"  placeholder="用户名"></inout>
		   			<input id="register_pwd" type="text"  placeholder="密码"></inout>
		   			<button id="register_submit">注册</button>
  				</div>
  			</div>
  		</div>
	   <form action="${pageContext.request.contextPath}/Register" method="post"> 
		   	
	   </form>
	   <jsp:include page="/WEB-INF/jsp/foot.jsp"></jsp:include>
  </body>
</html>
