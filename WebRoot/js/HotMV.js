//������Ƶ�Ĳ�������֪ͣͨ��Ļ�Ĳ�������ͣ
function playMvDanmu(){
	var mvid = video.className;	//mv��id
	
	//����Ajax��ѯ��Ļ
	if(video != null){
		if(!video.paused){	//û����ͣ
			video.pause();
			clearInterval(timer);	//��ͣ���������ʱ��
			return;
		}
		timer = setInterval(function(){
			
			var url = "/Mp3Player/SelMVDanmu/"+mvid+"/"+parseInt(video.currentTime);
			
			$.get(url,true,function(data){
				eval("var a="+data);
				for(var i = 0;i<a.length;i++){
					/**********************/
					var p = document.createElement("p");	//ÿһ����Ļ����
					p.innerHTML = a[i].message;
					p.setAttribute("class","danmudetail");
					//����һ������߶Ⱥ�����ڱ߾�
					var height = (Math.random()*play.offsetHeight);
					var paddingLeft = (Math.random()*400);
					p.setAttribute("style","top:"+height+"px;padding-left:"+paddingLeft+"px;");
					
					play.appendChild(p);
					//����һ��leftֵ
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
			var video = document.getElementById("video");	//��Ƶ����
			var play = document.getElementById("play");	//��Ƶ����	
			var mvid = "";
			if(video != null){
				mvid = video.className;
				//������Ƶ�Ĳ�������֪ͣͨ��Ļ�Ĳ�������ͣ
				video.onclick = function(){
						playMvDanmu();			
				}
			}
			/*
			 alert(video.offsetHeight);
			alert(play.offsetHeight);
			*/
			
			
			//���͵�Ļ����
			
			var sendDanmu = $("#HotMVbox #MVshow #sendDanmu");	//���͵�Ļ��ť
			sendDanmu.click(function(){
				var danmuInnter = $("#HotMVbox #MVshow #danmuInner").val();	//���͵ĵ�Ļ������
				if(danmuInnter == null || danmuInnter.trim()==""){
					alert("null");
				}else{
					//����Ajax����Ļ�������ݿ�
					var param = "/Mp3Player/SendMVDanmu/"+parseInt(video.currentTime)+"/"+mvid+"/"+danmuInnter;
					$.get(param,true,function(data){
					//	alert(danmuInnter);
						document.title = danmuInnter;
					});
				}
			})
		});