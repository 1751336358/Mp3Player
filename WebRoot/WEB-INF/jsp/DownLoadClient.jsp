<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>下载客户端</title>    
	<meta charset="utf-8"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/DownLoadClient.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			var t1 = $("#DownBoxTop #DownTop .show1 .updateTime .t");	//更新时间
			var t2 = $("#DownBoxBottom #DownBottom .show2 .time span");	//更新时间
			var show1 = $("#DownBoxTop #DownTop .show1");
			var show2 = $("#DownBoxBottom #DownBottom .show2");
			show1.mouseover(function(){
				$(this).children(".softname1").css("color","#939BE5");
			});
			show1.mouseout(function(){
				$(this).children(".softname1").css("color","#333");
			});
			show2.mouseover(function(){
				
				$(this).children(".softname2").css("color","#939BE5");
			});
			show2.mouseout(function(){
				
				$(this).children(".softname2").css("color","#333");
			});
			var date = new Date();
			t1.html(date.getFullYear()+"."+parseInt(date.getMonth()+1)+"."+date.getDay());
			t2.html(date.getFullYear()+"."+parseInt(date.getMonth()+1)+"."+date.getDay());
		})
	</script>
  </head>
  
  <body>
    <jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
    
    <div id="DownBoxTop">
    	<div id="DownTop">
    		<div class="show1">
    			<p class="version">V 8.1.51</p>
    			<div class="img"><img src="${pageContext.request.contextPath}/image/window.png"/></div>
    			<p class="softname1">酷狗PC版</p>
    			<p class="updateTime">更新日期:<span class="t"></span></p>
    			<a class="downloadsoft" href="${pageContext.request.contextPath}/servlet/DownloadClient?filename=kugou8151.exe">立即下载</a>
    		</div>
    		<div class="show1">
    			<p class="version">V 8.8.0</p>
    			<div class="img"><img src="${pageContext.request.contextPath}/image/android.png"/></div>
    			<p class="softname1">酷狗Android版</p>
    			<p class="updateTime">更新日期:<span class="t"></span></p>
    			<a class="downloadsoft" href="${pageContext.request.contextPath}/servlet/DownloadClient?filename=KugouPlayer_219_V8.8.0.apk">立即下载</a>
    		</div>
    		<div class="show1">
    			<p class="version">V 8.5.5</p>
    			<div class="img"><img src="${pageContext.request.contextPath}/image/mac.png"/></div>
    			<p class="softname1">酷狗iPhone版</p>
    			<p class="updateTime">更新日期:<span class="t"></span></p>
    			<a class="downloadsoft" href="${pageContext.request.contextPath}/servlet/DownloadClient?filename=kugou.ipa">立即下载</a>
    		</div>
    	</div>
    </div>
    <div id="DownBoxBottom">
    	<div id="DownBottom">
    		<div class="show2">
    			<img src="${pageContext.request.contextPath}/image/01.png"/>
    			<p class="softname2">酷狗音乐Mac版</p>
    			<p class="time">更新日期:<span></span></p>
    			<a href="${pageContext.request.contextPath}/servlet/DownloadClient?filename=Kugou_V2.1.0.dmg">下载</a>
    			<p class="version">V 2.1.0</p>
    		</div>
    		
    		<div class="show2">
    			<img src="${pageContext.request.contextPath}/image/02.png"/>
    			<p class="softname2">酷狗音乐iPad版</p>
    			<p class="time">更新日期:<span></span></p>
    			<a href="">下载</a>
    			<p class="version">V 2.0.0</p>
    		</div>
    		
    		<div class="show2">
    			<img src="${pageContext.request.contextPath}/image/03.png"/>
    			<p class="softname2">酷FM 安卓版</p>
    			<p class="time">更新日期:<span></span></p>
    			<a href="${pageContext.request.contextPath}/servlet/DownloadClient?filename=KugouFM.apk">下载</a>
    			<p class="version">V 4.0.3</p>
    		</div>
    		
    		<div class="show2">
    			<img src="${pageContext.request.contextPath}/image/04.png"/>
    			<p class="softname2">酷狗游戏盒</p>
    			<p class="time">更新日期:<span></span></p>
    			<a href="${pageContext.request.contextPath}/servlet/DownloadClient?filename=KGGWSetup_1003.exe">下载</a>
    			<p class="version">V 5.2.6.0</p>
    		</div>
    		<div class="show2">
    			<img src="${pageContext.request.contextPath}/image/05.png"/>
    			<p class="softname2">酷狗直播 安卓版</p>
    			<p class="time">更新日期:<span></span></p>
    			<a href="${pageContext.request.contextPath}/servlet/DownloadClient?filename=fanxing_6578_3.0.0.4_451.apk">下载</a>
    			<p class="version">V 3.0</p>
    		</div>
    		<div class="show2">
    			<img src="${pageContext.request.contextPath}/image/06.png"/>
    			<p class="softname2">酷FM IOS版</p>
    			<p class="time">更新日期:<span></span></p>
    			<a href="">下载</a>
    			<p class="version">V 4.0.2</p>
    		</div>
    		
    		<div class="show2">
    			<img src="${pageContext.request.contextPath}/image/07.png"/>
    			<p class="softname2">酷狗直播IOS版</p>
    			<p class="time">更新日期:<span></span></p>
    			<a href="${pageContext.request.contextPath}/servlet/DownloadClient?filename=FanXing_V2.6.0_1004_0.ipa">下载</a>
    			<p class="version">V 2.6.0</p>
    		</div>
    		<div class="show2">
    			<img src="${pageContext.request.contextPath}/image/08.png"/>
    			<p class="softname2">酷狗收音机PC版</p>
    			<p class="time">更新日期:<span></span></p>
    			<a href="${pageContext.request.contextPath}/servlet/DownloadClient?filename=KuGou_Radio7250.exe">下载</a>
    			<p class="version">V 7.2.5.0</p>
    		</div>
    		<div class="show2">
    			<img src="${pageContext.request.contextPath}/image/09.png"/>
    			<p class="softname2">酷狗识曲/p>
    			<p class="time">更新日期:<span></span></p>
    			<a href="${pageContext.request.contextPath}/servlet/DownloadClient?filename=KugouShiqu_release_1.0.0_1001_shiqu.apk">下载</a>
    			<p class="version">V 1.0.0.0</p>
    		</div>
    		
    		<div class="show2">
    			<img src="${pageContext.request.contextPath}/image/10.png"/>
    			<p class="softname2">铃声制作工具</p>
    			<p class="time">更新日期:<span></span></p>
    			<a href="${pageContext.request.contextPath}/servlet/DownloadClient?filename=MakeRing_Setup.exe">下载</a>
    			<p class="version">V 1.1</p>
    		</div>
    		<div class="show2">
    			<img src="${pageContext.request.contextPath}/image/11.png"/>
    			<p class="softname2">哄你睡</p>
    			<p class="time">更新日期:<span></span></p>
    			<a href="${pageContext.request.contextPath}/servlet/DownloadClient?filename=com.kk.sleep_311_1644423.apk">下载</a>
    			<p class="version">V 2.2.0</p>
    		</div>
    		<div class="show2">
    			<img src="${pageContext.request.contextPath}/image/12.png"/>
    			<p class="softname2">Ssing</p>
    			<p class="time">更新日期:<span></span></p>
    			<a href="">下载</a>
    			<p class="version">V 6.2.3</p>
    		</div>
    		<div class="show2">
    			<img src="${pageContext.request.contextPath}/image/13.png"/>
    			<p class="softname2">米粒桌面/p>
    			<p class="time">更新日期:<span></span></p>
    			<a href="${pageContext.request.contextPath}/servlet/DownloadClient?filename=com.mili.launcher_16500_1819578.apk">下载</a>
    			<p class="version">V 1.5.1</p>
    		</div>
    	</div>
    </div>
    
    <jsp:include page="/WEB-INF/jsp/foot.jsp"></jsp:include>
  </body>
</html>
