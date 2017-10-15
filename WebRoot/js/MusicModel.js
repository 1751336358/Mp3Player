window.onload = function(){
	var btn = document.getElementById('btn');//按钮,控制播放和暂停
	var boxs = document.getElementsByClassName('box');
	var musicIdList = new Array();	//全局数组，存放当前页面的所有的musicid(music0,music1)
	for(var i = 0;i<boxs.length;i++){
		musicIdList[i] = boxs[i].firstChild.id;
	}
	
	var globalSrc = null;	//全局变量，记住事件源对象boxs[i]
	var globalSrcMusic = null;	//全局变量，记住当前的音乐
	var globalVolum = 0.5;	//控制全局音乐
	var orderPlayListener = null;	//顺序播放定时器监听器
	var randomPlayListener = null;
	for(var i = 0;i < boxs.length;i++){
		boxs[i].onclick = function(e){
			var event = e || window.event;	//事件对象
			var src = event.srcElement || event.currentTarget;	//事件源对象boxs[i]
			globalSrc = src;
			globalSrcMusic = globalSrc.firstChild;
		//	globalSrcMusic.volume = globalVolum;
			for(var j = 0;j<boxs.length;j++){
				if(boxs[j] != src){
					boxs[j].firstChild.pause();	//点击一个让其他的音乐暂停
					continue;
				}
				//点击同一首音乐，控制播放和暂停
				if(src.firstChild.paused){	//暂停状态
					src.firstChild.play();	//使其播放
					btn.innerHTML = "stop";
				}else{						//播放状态
					src.firstChild.pause();	//使其暂停
					btn.innerHTML = "start";
				}
			}
		}
	}
	
	if(btn == null){
		return;
	}
	btn.onclick = function(e){
		var event = e || window.event;	//事件对象
		var src = event.srcElement || event.currentTarget;	//事件源对象btn
		if(globalSrc != null){						
			if(globalSrc.firstChild.paused){
				globalSrc.firstChild.play();
				src.innerHTML="stop";
			}else{
				globalSrc.firstChild.pause();
				src.innerHTML="start";
			}
		}else{
			globalSrc = boxs[0];
			boxs[0].firstChild.play();
			src.innerHTML="stop";
		}
		globalSrcMusic = globalSrc.firstChild;
	}


	var loopPlay = document.getElementById("loopPlay");	//单曲循环
	var randomPlay = document.getElementById("randomPlay");	//随机播放
	var orderPlay = document.getElementById("orderPlay");	//顺序播放
	

	//控制单曲循环
	loopPlay.onclick = function(){
		clearInterval(randomPlayListener);	//清除随机播放的定时监听器
		clearInterval(orderPlayListener);	//清除顺序播放的定时器监听器
		for(var i = 0;i<boxs.length;i++){
			boxs[i].firstChild.loop = true;
		}
	}
	//顺序播放
	orderPlay.onclick = function(){
		
		var currentId = 0;
		var index = 0;
		clearInterval(randomPlayListener);	//清除随机播放监听器
		for(var i = 0;i<boxs.length;i++){
			boxs[i].firstChild.loop = false;	//将所有的音乐循环播放取消
		}
		if(globalSrc != null){
			currentId = globalSrcMusic.id; //得到当前对象的id（music0,music1...）

		//	index = parseInt(currentId.substr(5));	//得到当前音乐的下标索引（0,1，...）
			for(var i = 0;i<musicIdList.length;i++){
				if(currentId == musicIdList[i]){
					index = i;
					break;
				}
			}
			
		}else{
			globalSrc = boxs[0];
			globalSrcMusic = globalSrc.firstChild;
		}
		//启动定时器监听当前的音乐是否播放结束
		orderPlayListener = setInterval(function(){
			if(globalSrcMusic.ended == true){	//播放结束
				//开始播放下一首
				var tmp = document.getElementById(musicIdList[(index+1)%musicIdList.length]);
				if(tmp != null){

					tmp.play();
				
					globalSrc = document.getElementById("box"+(musicIdList[(index+1)%musicIdList.length].substr(5)));
					globalSrcMusic = globalSrc.firstChild;
					currentId = globalSrcMusic.id;
					index = (index+1)%musicIdList.length;
				}
			}
		},10);
		
	}
	//随机播放
	randomPlay.onclick = function(){
		
		
		clearInterval(orderPlayListener);	//清除顺序播放监听器
		for(var i = 0;i<boxs.length;i++){
			boxs[i].firstChild.loop = false;	//将所有的音乐循环播放取消
		}
		if(globalSrc == null){
			globalSrc = boxs[0];
			globalSrcMusic = globalSrc.firstChild;
		}
		//启动定时器监听当前的音乐是否播放结束
		randomPlayListener = setInterval(function(){
			if(globalSrcMusic.ended == true){	//播放结束
				//随机播放下一首
				//生成一个0<= x < musicIdList.length的随机数
				var random = parseInt(Math.random()*musicIdList.length);
			
				var tmp = document.getElementById(musicIdList[random]);
				if(tmp != null){

					tmp.play();
				
					globalSrc = document.getElementById("box"+(musicIdList[random].substr(5)));
					globalSrcMusic = globalSrc.firstChild;
					currentId = globalSrcMusic.id;						
				}
			}
		},10);
	}


	/*播放进度条部分*/
	var totalTimeBox = $("#totalTimeBox")	//音乐播放进度条总长度
	var currentTimeBox =$("#currentTimeBox");	//当前音乐播放的长度
	//监听当前音乐的播放时间
	setInterval(function(){
		if(globalSrcMusic != null){
			var currentTime = globalSrcMusic.currentTime;	//当前音乐的当前的播放长度
			var pre = currentTime / globalSrcMusic.duration;	//算出当前播放进度	0.51...
			//更改进度条位置
			currentTimeBox.css("width",totalTimeBox.width()*pre+"px");
		}
		
	},500);
	totalTimeBox.click(function(ev){
		var pos = ev.offsetX;	//鼠标点击进度条的位置
		globalSrcMusic.currentTime = globalSrcMusic.duration*(pos / totalTimeBox.width());	//调整音乐播放的时间
		currentTimeBox.css("width",pos+"px");	//调整进度条位置
	})
	
	/*控制音量*/
	var totalVolumeBox = $("#totalVolumeBox");	//音量框对象
	var currentVolumeBox = $("#currentVolumeBox");	//当前音量高度对象
	if(globalSrcMusic != null){
		currentVolumeBox.css("width",globalSrcMusic.volume*totalVolumeBox.width()+"px");
	}else{
		currentVolumeBox.css("width","100%");
	}
	totalVolumeBox.click(function(ev){
		var pos = ev.offsetX;	//鼠标点击音量的位置
		if(globalSrcMusic != null){
			for(var i = 0;i<boxs.length;i++){
				boxs[i].firstChild.volume = (pos/totalVolumeBox.width());
			}
			currentVolumeBox.css("width",pos+"px");
		}				
	})
	
	

}