//随着视频的播放与暂停通知弹幕的播放与暂停
function playMvDanmu(obj){
	var music = document.getElementsByClassName("music")[0];
	var musicid = music.id.substr(5);	//mv的id
	var duration = music.duration;	// 音乐的总时长
	var  total = $("#controller #contShow #right_cont #total");	//进度条总宽度对象
	var curr = $("#controller #contShow #right_cont #total #curr");	//当前进度条对象

	//启动Ajax查询弹幕
	if(music != null){
		if(!music.paused){	//没有暂停
			music.pause();
			clearInterval(timer);	//暂停，并清除定时器
			obj.css("background-image","url(/Mp3Player/image/btn.png)");
			obj.css("background-position","-2px -2px");
			return;
		}else{
			music.play();
			obj.css("background-image","url(/Mp3Player/image/btn.png)");
			obj.css("background-position","-2px -62px");		
		}
		//控制进度条的定时器
		cont = setInterval(function(){
			var currentTime = music.currentTime;
			var pre = currentTime / duration;
			//更改进度条位置
			curr.css("width",total.width()*pre+"px");
			
		},1000);
		//控制快进和快退
		total.click(function(ev){
			var pos = ev.offsetX;	//鼠标点击进度条的位置
			music.currentTime = duration*(pos / total.width());	//调整音乐播放的时间
			curr.css("width",pos+"px");	//调整进度条位置
		})
		//控制弹幕的定时器
		timer = setInterval(function(){
			
			var url = "/Mp3Player/SelDanmu/"+musicid+"/"+parseInt(music.currentTime);
			var showDanmu = document.getElementById("showDanmu");
			$.get(url,true,function(data){
				eval("var a="+data);
				for(var i = 0;i<a.length;i++){
					/**********************/
					var p = document.createElement("p");	//每一条弹幕对象
					p.innerHTML = a[i].message;
					p.setAttribute("class","danmudetail");
					//产生一个随机高度和随机内边距
					var height = (Math.random()*400);
					var paddingLeft = (Math.random()*400);
					p.setAttribute("style","top:"+height+"px;padding-left:"+paddingLeft+"px;");
					
					showDanmu.appendChild(p);
					//产生一个left值
					var left = -500-paddingLeft;
					var speed = Math.random()*5000;
					$(".danmudetail").animate({left:left+"px"},5000);
					/**************************/
				}
			});
		},1000);
	}
}
$(function(){
/*	var music = document.getElementsByClassName("music")[0];	//audio对象
	
	var musicid = "";
	if(music != null){
		musicid = music.id.substr(5);
		//随着视频的播放与暂停通知弹幕的播放与暂停
		music.onclick = function(){
				playMvDanmu();			
		}
	}*/
	var musicbtn = $("#controller #contShow #left_cont");
	
	musicbtn.click(function(){
		//musicid = music.id.substr(5);
		playMvDanmu($(this));	
	});
	
});