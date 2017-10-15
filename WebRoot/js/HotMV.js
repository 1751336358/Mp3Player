//随着视频的播放与暂停通知弹幕的播放与暂停
function playMvDanmu(){
	var mvid = video.className;	//mv的id
	
	//启动Ajax查询弹幕
	if(video != null){
		if(!video.paused){	//没有暂停
			video.pause();
			clearInterval(timer);	//暂停，并清除定时器
			return;
		}
		timer = setInterval(function(){
			
			var url = "/Mp3Player/SelMVDanmu/"+mvid+"/"+parseInt(video.currentTime);
			
			$.get(url,true,function(data){
				eval("var a="+data);
				for(var i = 0;i<a.length;i++){
					/**********************/
					var p = document.createElement("p");	//每一条弹幕对象
					p.innerHTML = a[i].message;
					p.setAttribute("class","danmudetail");
					//产生一个随机高度和随机内边距
					var height = (Math.random()*play.offsetHeight);
					var paddingLeft = (Math.random()*400);
					p.setAttribute("style","top:"+height+"px;padding-left:"+paddingLeft+"px;");
					
					play.appendChild(p);
					//产生一个left值
					var left = -500-paddingLeft;
					var speed = Math.random()*5000;
					$("#play .danmudetail").animate({left:left+"px"},5000);
					/**************************/
				}
			});
		},1000);
	}
}
$(function(){
			var video = document.getElementById("video");	//视频对象
			var play = document.getElementById("play");	//视频对象	
			var mvid = "";
			if(video != null){
				mvid = video.className;
				//随着视频的播放与暂停通知弹幕的播放与暂停
				video.onclick = function(){
						playMvDanmu();			
				}
			}
			/*
			 alert(video.offsetHeight);
			alert(play.offsetHeight);
			*/
			
			
			//发送弹幕部分
			
			var sendDanmu = $("#HotMVbox #MVshow #sendDanmu");	//发送弹幕按钮
			sendDanmu.click(function(){
				var danmuInnter = $("#HotMVbox #MVshow #danmuInner").val();	//发送的弹幕的内容
				if(danmuInnter == null || danmuInnter.trim()==""){
					alert("null");
				}else{
					//启动Ajax将弹幕存入数据库
					var param = "/Mp3Player/SendMVDanmu/"+parseInt(video.currentTime)+"/"+mvid+"/"+danmuInnter;
					$.get(param,true,function(data){
					//	alert(danmuInnter);
						document.title = danmuInnter;
					});
				}
			})
		});