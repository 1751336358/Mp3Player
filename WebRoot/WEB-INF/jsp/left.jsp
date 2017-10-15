<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <!--在Music.jsp,TypeMusic.jsp,Singname.jsp页面中入left.jsp-->
  <div id="Music_Left">
	<p id="Left_Title">热门榜单</p>
	<ul>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/001.png)"></span><a class="link" href="">酷狗飙升榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/002.png)"></span><a class="link" href="">酷狗TOP500</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/003.png)"></span><a class="link" href="">网络红歌榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/004.png)"></span><a class="link" href="">DJ热歌榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/005.png)"></span><a class="link" href="">华语新歌榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/006.png)"></span><a class="link" href="">欧美新歌榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/007.png)"></span><a class="link" href="">韩国新歌榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/008.png)"></span><a class="link" href="">日本新歌榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/009.png)"></span><a class="link" href="">金曲捞榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/010.png)"></span><a class="link" href="">原创音乐榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/011.png)"></span><a class="link" href="">粤语新歌榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/012.png)"></span><a class="link" href="">酷狗分享榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/013.png)"></span><a class="link" href="">5sing音乐榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/014.png)"></span><a class="link" href="">繁星音乐榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/015.png)"></span><a class="link" href="">校园音乐榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/016.png)"></span><a class="link" href="">中文DJ</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/017.png)"></span><a class="link" href="">洗脑神曲</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/018.png)"></span><a class="link" href="">百大DJ</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/019.png)"></span><a class="link" href="">伤感网络情歌</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/020.png)"></span><a class="link" href="">车载音乐</a></li>					
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/021.png)"></span><a class="link" href="">KTV</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/022.png)"></span><a class="link" href="">影视金曲</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/023.png)"></span><a class="link" href="">纯音乐</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/024.png)"></span><a class="link" href="">美国BillBorder榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/025.png)"></span><a class="link" href="">英国单曲榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/026.png)"></span><a class="link" href="">日本工信榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/027.png)"></span><a class="link" href="">韩国M-net音乐榜</a></li>
		<li><span class="img" style="background-image:url(${pageContext.request.contextPath}/image/028.png)"></span><a class="link" href="">中国TOP排行榜</a></li>
	</ul>
	
</div>
</html>
