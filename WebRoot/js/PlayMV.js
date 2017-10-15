$(function(){
	var timer = null;	//控制弹幕的定时器
	//控制栏的js和发表弹幕的js
	var video = document.getElementsByClassName("video")[0];	//获得音乐对象
	/*控制栏开始*/
	$("#start").click(function(){	//开始

		video.play();
		danmuStart();	//开始播放弹幕，开启定时器
	});
	$("#stop").click(function(){	//暂停
		video.pause();
		danmuStop();	//暂停弹幕，清空定时器
	});
	
	//进度条部分
	var totalTimeBox = $("#totalTimeBox")	//音乐播放进度条总长度
	var currentTimeBox =$("#currentTimeBox");	//当前音乐播放的长度
	//监听当前音乐的播放时间
	setInterval(function(){
		if(video != null){
			var currentTime = video.currentTime;	//当前音乐的当前的播放长度
			var pre = currentTime / video.duration;	//算出当前播放进度	0.51...
			//更改进度条位置
			currentTimeBox.css("width",totalTimeBox.width()*pre+"px");
		}
		
	},500);
	totalTimeBox.click(function(ev){
		var pos = ev.offsetX;	//鼠标点击进度条的位置
		video.currentTime = video.duration*(pos / totalTimeBox.width());	//调整音乐播放的时间
		currentTimeBox.css("width",pos+"px");	//调整进度条位置
	})
	
	/*控制音量*/
	var totalVolumeBox = $("#totalVolumeBox");	//音量框对象
	var currentVolumeBox = $("#currentVolumeBox");	//当前音量高度对象
	if(video != null){
		currentVolumeBox.css("width",video.volume*totalVolumeBox.width()+"px");
	}
	totalVolumeBox.click(function(ev){
		var pos = ev.offsetX;	//鼠标点击音量的位置
		if(video != null){				
			video.volume = (pos/totalVolumeBox.width());				
			currentVolumeBox.css("width",pos+"px");
		}				
	})
	
	//发送弹幕区开始
	$("#SendDanmu").click(function(){
		
		var currentTime = parseInt(video.currentTime);	//获得当前音乐的播放时间
		var videoid = video.id;	//当前video的id
		var danmuDetail = $("#danmuDetail").val();	//弹幕内容
		//启动Ajax向数据库插入弹幕信息
	//	var str = "time="+currentTime+"&musicid="+musicid+"&detail="+danmuDetail;
		var str = currentTime+"/"+videoid+"/"+danmuDetail;
		$.get("/Mp3Player/SendMVDanmu/"+str,true,function(data){
		//	alert("弹幕发送成功");
		});
	})
	//发送弹幕区结束
	
	//弹幕显示区
	function danmuStart(){
		var showDanmu = document.getElementById("showDanmu");	//弹幕显示区对象
		var videoWidth = video.offsetWidth;	//视屏播放区的宽度
		var videoHeight = video.offsetHeight;	//视屏播放区的高度
		timer = setInterval(function(){
			var str = "/Mp3Player/SelMVDanmu/"+video.id+"/"+parseInt(video.currentTime);
		
			$.get(str,true,function(data){
			//	document.title = data;			
				eval("var a="+data);
				if(a.length != 0){
				
					for(var i = 0;i<a.length;i++){
						
						//	$("#showDanmu").append("<p>"+a[i].message+"</p>");
						var p = document.createElement("p");	//每一条弹幕对象
						p.innerHTML = a[i].message;
						p.setAttribute("class","danmudetail");
						//产生一个随机高度和随机内边距
						var height = (Math.random()*250);
						var paddingLeft = (Math.random()*400);
						p.setAttribute("style","top:"+height+"px;padding-left:"+paddingLeft+"px;");
						
						showDanmu.appendChild(p);
						//产生一个left值
						var left = -500-paddingLeft;
						var speed = Math.random()*5000;
						$("#showDanmu .danmudetail").animate({left:left+"px"},5000);
					}
				}		
			});
			
		},1000);
	}
	
	//暂停弹幕，清空定时器
	function danmuStop(){
		clearInterval(timer);
	}
	//弹幕显示区结束
});