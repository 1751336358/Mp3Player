window.onload = function(){
	var btn = document.getElementById('btn');//��ť,���Ʋ��ź���ͣ
	var boxs = document.getElementsByClassName('box');
	var musicIdList = new Array();	//ȫ�����飬��ŵ�ǰҳ������е�musicid(music0,music1)
	for(var i = 0;i<boxs.length;i++){
		musicIdList[i] = boxs[i].firstChild.id;
	}
	
	var globalSrc = null;	//ȫ�ֱ�������ס�¼�Դ����boxs[i]
	var globalSrcMusic = null;	//ȫ�ֱ�������ס��ǰ������
	var globalVolum = 0.5;	//����ȫ������
	var orderPlayListener = null;	//˳�򲥷Ŷ�ʱ��������
	var randomPlayListener = null;
	for(var i = 0;i < boxs.length;i++){
		boxs[i].onclick = function(e){
			var event = e || window.event;	//�¼�����
			var src = event.srcElement || event.currentTarget;	//�¼�Դ����boxs[i]
			globalSrc = src;
			globalSrcMusic = globalSrc.firstChild;
		//	globalSrcMusic.volume = globalVolum;
			for(var j = 0;j<boxs.length;j++){
				if(boxs[j] != src){
					boxs[j].firstChild.pause();	//���һ����������������ͣ
					continue;
				}
				//���ͬһ�����֣����Ʋ��ź���ͣ
				if(src.firstChild.paused){	//��ͣ״̬
					src.firstChild.play();	//ʹ�䲥��
					btn.innerHTML = "stop";
				}else{						//����״̬
					src.firstChild.pause();	//ʹ����ͣ
					btn.innerHTML = "start";
				}
			}
		}
	}
	
	if(btn == null){
		return;
	}
	btn.onclick = function(e){
		var event = e || window.event;	//�¼�����
		var src = event.srcElement || event.currentTarget;	//�¼�Դ����btn
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


	var loopPlay = document.getElementById("loopPlay");	//����ѭ��
	var randomPlay = document.getElementById("randomPlay");	//�������
	var orderPlay = document.getElementById("orderPlay");	//˳�򲥷�
	

	//���Ƶ���ѭ��
	loopPlay.onclick = function(){
		clearInterval(randomPlayListener);	//���������ŵĶ�ʱ������
		clearInterval(orderPlayListener);	//���˳�򲥷ŵĶ�ʱ��������
		for(var i = 0;i<boxs.length;i++){
			boxs[i].firstChild.loop = true;
		}
	}
	//˳�򲥷�
	orderPlay.onclick = function(){
		
		var currentId = 0;
		var index = 0;
		clearInterval(randomPlayListener);	//���������ż�����
		for(var i = 0;i<boxs.length;i++){
			boxs[i].firstChild.loop = false;	//�����е�����ѭ������ȡ��
		}
		if(globalSrc != null){
			currentId = globalSrcMusic.id; //�õ���ǰ�����id��music0,music1...��

		//	index = parseInt(currentId.substr(5));	//�õ���ǰ���ֵ��±�������0,1��...��
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
		//������ʱ��������ǰ�������Ƿ񲥷Ž���
		orderPlayListener = setInterval(function(){
			if(globalSrcMusic.ended == true){	//���Ž���
				//��ʼ������һ��
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
	//�������
	randomPlay.onclick = function(){
		
		
		clearInterval(orderPlayListener);	//���˳�򲥷ż�����
		for(var i = 0;i<boxs.length;i++){
			boxs[i].firstChild.loop = false;	//�����е�����ѭ������ȡ��
		}
		if(globalSrc == null){
			globalSrc = boxs[0];
			globalSrcMusic = globalSrc.firstChild;
		}
		//������ʱ��������ǰ�������Ƿ񲥷Ž���
		randomPlayListener = setInterval(function(){
			if(globalSrcMusic.ended == true){	//���Ž���
				//���������һ��
				//����һ��0<= x < musicIdList.length�������
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


	/*���Ž���������*/
	var totalTimeBox = $("#totalTimeBox")	//���ֲ��Ž������ܳ���
	var currentTimeBox =$("#currentTimeBox");	//��ǰ���ֲ��ŵĳ���
	//������ǰ���ֵĲ���ʱ��
	setInterval(function(){
		if(globalSrcMusic != null){
			var currentTime = globalSrcMusic.currentTime;	//��ǰ���ֵĵ�ǰ�Ĳ��ų���
			var pre = currentTime / globalSrcMusic.duration;	//�����ǰ���Ž���	0.51...
			//���Ľ�����λ��
			currentTimeBox.css("width",totalTimeBox.width()*pre+"px");
		}
		
	},500);
	totalTimeBox.click(function(ev){
		var pos = ev.offsetX;	//�������������λ��
		globalSrcMusic.currentTime = globalSrcMusic.duration*(pos / totalTimeBox.width());	//�������ֲ��ŵ�ʱ��
		currentTimeBox.css("width",pos+"px");	//����������λ��
	})
	
	/*��������*/
	var totalVolumeBox = $("#totalVolumeBox");	//���������
	var currentVolumeBox = $("#currentVolumeBox");	//��ǰ�����߶ȶ���
	if(globalSrcMusic != null){
		currentVolumeBox.css("width",globalSrcMusic.volume*totalVolumeBox.width()+"px");
	}else{
		currentVolumeBox.css("width","100%");
	}
	totalVolumeBox.click(function(ev){
		var pos = ev.offsetX;	//�����������λ��
		if(globalSrcMusic != null){
			for(var i = 0;i<boxs.length;i++){
				boxs[i].firstChild.volume = (pos/totalVolumeBox.width());
			}
			currentVolumeBox.css("width",pos+"px");
		}				
	})
	
	

}