<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.net.URLEncoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>酷狗音乐 - 音乐总有新玩法</title>
	<meta charset="utf-8"/>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/archefoucs.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/MusicModel.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js.js"></script>	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/archefoucs.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/MusicModel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
		
		
  </head>
  
  <body>
    <jsp:include page="/WEB-INF/jsp/head.jsp"></jsp:include>
    <!-- 大区轮播 -->
	 <div class="header">
        <div class="gg" id="gg">
            
            <div class="ggs">
                <div class="ggBox" id="ggBox">
                    <a href="#" title="5月22日测试开启领报名资格" style="z-index: 3; opacity: 4;">
                        <img src="image/lunbo1.jpg" alt="" /></a>
                    <a href="#" title="首测世界的雕琢篇章开启">
                        <img src="image/lunbo2.jpg" alt="" /></a>
                    <a href="#" title="上古世纪游戏资料手册">
                        <img src="image/lunbo3.jpg" alt="" /></a>
                    <a href="#" title="游戏四大特色揭晓">
                        <img src="image/lunbo4.jpg" alt="" /></a>
                </div>
            </div>
            <div class="ggb">
                <div class="ggBtns" id="ggBtns">
                    <a title="5月22日测试开启领报名资格" href='javascript:void(0)' class="ggOn"><em>5月22日测试开启领报名资格</em></a>
                    <a title="首测世界的雕琢篇章开启" href='javascript:void(0)'><em>首测世界的雕琢篇章开启</em></a>
                    <a title="上古世纪游戏资料手册" href='javascript:void(0)'><em>上古世纪游戏资料手册</em></a>
                    <a title="游戏四大特色揭晓" href='javascript:void(0)'><em>游戏四大特色揭晓</em></a>
                </div>
            </div>
        </div>
    </div>
    <!-- 大区轮播结束 -->
    <!-- 热门下载 -->
    <div id="index_box1">
    	<div id="index_show1">   		
    		<div id="left1">
    			<div id="top1">
    				<h3><span>热门</span>下载</h3>
    				<p class="type" id="11">华语</p>
    				<p class="type" id="5">欧美</p>
    				<p class="type" id="7">日韩</p>
    				<p class="type" id="9">爱情</p>
    			</div>
    			<div id="bottom1">
	    			<c:forEach items="${hotMusic}" var="music">
	    				<div class="index_outer">
	    					<div id="box+${music.id}" class="box"><audio src="/Music/${music.musicpath}" id="music+${music.id}" class="music"></audio>
								&nbsp&nbsp&nbsp&nbsp<span class="musicname">${music.filename}</span>
							</div>
							<div class="index_operator">
								<a href="${pageContext.request.contextPath}/servlet/DownLoad?id=${music.id}&filename=${music.filename}&musicpath=${music.musicpath}" class="down">下载</a>
								<a href="${pageContext.request.contextPath}/Detail?id=${music.id}&filename=${music.filename}&musicpath=${music.musicpath}" class="xiangqing">详情</a>
								<a href="${pageContext.request.contextPath}/gotoPlayMV/${music.id}" class="seeMV">观看MV</a>
							</div>
	    				</div>
					</c:forEach>
    			</div>
    		</div>
    		<div id="right1">
    			<h3><span>&nbsp&nbsp&nbsp热播</span>MV</h3>
    			<c:forEach items="${hotMv}" var="mv">
    				<div class="listmv">
    					<a class="info" href="${pageContext.request.contextPath}/gotoHotMV/${mv.mvid}">${mv.filename}</a>
    					<span class="singname">${mv.singname}</span>
    				</div>
    			</c:forEach>
    		</div>
    	</div>
    </div>
    <!-- 热门下载结束 -->
    <!-- 中部广告区 -->
    <div id="guanggao">
    	<div id="gbox">
    		<ul id="ul">
				<li><a href=""><img src="image/guanggao1.jpg"/></a></li>
				<li><a href=""><img src="image/guanggao2.jpg"/></a></li>
				<li><a href=""><img src="image/guanggao3.jpg"/></a></li>	
			</ul>
    	</div>
    </div>
    <!-- 中部广告区结束 -->
    <!-- 热门分类 -->
    <div id="hotType">
    	<div id="typeShow">
    		<h3><span>&nbsp&nbsp&nbsp热门</span>分类</h3>
    		<c:forEach items="${types}" var="type">
    			<div class="typeInfo">
    				<div class="typeimg"><a href="${pageContext.request.contextPath}/TypeMusic/${type.id}"><img src="image/type${type.id}.jpg"/></a></div>
					<a class="typeLink" href="${pageContext.request.contextPath}/TypeMusic/${type.id}">${type.typename}</a>
    			</div>
    			
			</c:forEach>
    	</div>
    </div>
    <!-- 热门分类结束 -->
    <!-- 热门歌手 -->
    <div id="hotSinger">
    	<div id="singShow">
    		<h3><span>热门</span>歌手</h3>
    		<c:forEach items="${hotSingname}" var="singname">
    			<div class="singInfo">
    				<a href="${pageContext.request.contextPath}/SingnameMusic/${singname.singname}">${singname.singname}</a>
    				<span>:${singname.count}</span>
    			</div>		
				
			</c:forEach>
    	</div>
    </div>
    <!-- 热门歌手结束 -->
	
    <jsp:include page="/WEB-INF/jsp/MusicModel.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/foot.jsp"></jsp:include>
  </body>
</html>
