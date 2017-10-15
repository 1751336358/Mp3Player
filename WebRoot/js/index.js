$(function(){
	
	var type = $("#index_box1 #index_show1 #left1 #top1 .type");
	/*获得各个标签，修改数据*/
	var boxs = document.getElementsByClassName("box");
	var musicnames = document.getElementsByClassName("musicname");
	
	var musics = document.getElementsByClassName("music");
	var downs = document.getElementsByClassName("down");
	var xiangqings = document.getElementsByClassName("xiangqing");
	var seeMVs = document.getElementsByClassName("seeMV");
	type.mouseover(function(){
		
		var id = $(this).attr("id");	//得到音乐类型名type.id
		
		//启动Ajax，根据类型查出音乐
		var url = "/Mp3Player/HotMusic/"+id;
		$.get(url,true,function(data){
			eval("var a="+data);
		
			for(var i = 0;i<a.length;i++){
				//修改box的id
				var boxid = "box+"+a[i].id;
				boxs[i].id = boxid;
				//修改audio的src和id
				var musicsrc = "/Music/"+a[i].musicpath;
				var musicid = "music+"+a[i].id;
				musics[i].src = musicsrc;
				musics[i].id = musicid;
				//修改musicname
				var name = a[i].filename;

				musicnames[i].innerHTML = name;

				//修改下载 的href
				// /Mp3Player/servlet/DownLoad?id=${music.id}&filename=${music.filename}&musicpath=${music.musicpath}
				var downHref = "/Mp3Player/servlet/DownLoad?id="+a[i].id+"&filename="+a[i].filename+"&musicpath="+a[i].musicpath;
				downs[i].href=downHref;
				//修改详情的href
				// /Mp3Player/Detail?id=${music.id}&filename=${music.filename}&musicpath=${music.musicpath}
				var xiangqingHref="/Mp3Player/Detail?id="+a[i].id+"&filename="+a[i].filename+"&musicpath="+a[i].musicpath;
				xiangqings[i].href = xiangqingHref;
				//修改seeMV的href
				// /Mp3Player/gotoPlayMV/${music.id}
				var seeMVHref = "/Mp3Player/gotoPlayMV/"+a[i].id;
				seeMVs[i].href=seeMVHref;
			}
		});
	})
	//中部广告区效果
	setInterval(function(){
		var lastChild = $('#ul li:last-child');
		lastChild.animate({'height':'0px'},0);
		$("#ul").prepend(lastChild);
		lastChild.animate({'height':'100px'},1000);
	},2000);
})