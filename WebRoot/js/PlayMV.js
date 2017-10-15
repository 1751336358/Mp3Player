$(function(){
	var timer = null;	//���Ƶ�Ļ�Ķ�ʱ��
	//��������js�ͷ���Ļ��js
	var video = document.getElementsByClassName("video")[0];	//������ֶ���
	/*��������ʼ*/
	$("#start").click(function(){	//��ʼ

		video.play();
		danmuStart();	//��ʼ���ŵ�Ļ��������ʱ��
	});
	$("#stop").click(function(){	//��ͣ
		video.pause();
		danmuStop();	//��ͣ��Ļ����ն�ʱ��
	});
	
	//����������
	var totalTimeBox = $("#totalTimeBox")	//���ֲ��Ž������ܳ���
	var currentTimeBox =$("#currentTimeBox");	//��ǰ���ֲ��ŵĳ���
	//������ǰ���ֵĲ���ʱ��
	setInterval(function(){
		if(video != null){
			var currentTime = video.currentTime;	//��ǰ���ֵĵ�ǰ�Ĳ��ų���
			var pre = currentTime / video.duration;	//�����ǰ���Ž���	0.51...
			//���Ľ�����λ��
			currentTimeBox.css("width",totalTimeBox.width()*pre+"px");
		}
		
	},500);
	totalTimeBox.click(function(ev){
		var pos = ev.offsetX;	//�������������λ��
		video.currentTime = video.duration*(pos / totalTimeBox.width());	//�������ֲ��ŵ�ʱ��
		currentTimeBox.css("width",pos+"px");	//����������λ��
	})
	
	/*��������*/
	var totalVolumeBox = $("#totalVolumeBox");	//���������
	var currentVolumeBox = $("#currentVolumeBox");	//��ǰ�����߶ȶ���
	if(video != null){
		currentVolumeBox.css("width",video.volume*totalVolumeBox.width()+"px");
	}
	totalVolumeBox.click(function(ev){
		var pos = ev.offsetX;	//�����������λ��
		if(video != null){				
			video.volume = (pos/totalVolumeBox.width());				
			currentVolumeBox.css("width",pos+"px");
		}				
	})
	
	//���͵�Ļ����ʼ
	$("#SendDanmu").click(function(){
		
		var currentTime = parseInt(video.currentTime);	//��õ�ǰ���ֵĲ���ʱ��
		var videoid = video.id;	//��ǰvideo��id
		var danmuDetail = $("#danmuDetail").val();	//��Ļ����
		//����Ajax�����ݿ���뵯Ļ��Ϣ
	//	var str = "time="+currentTime+"&musicid="+musicid+"&detail="+danmuDetail;
		var str = currentTime+"/"+videoid+"/"+danmuDetail;
		$.get("/Mp3Player/SendMVDanmu/"+str,true,function(data){
		//	alert("��Ļ���ͳɹ�");
		});
	})
	//���͵�Ļ������
	
	//��Ļ��ʾ��
	function danmuStart(){
		var showDanmu = document.getElementById("showDanmu");	//��Ļ��ʾ������
		var videoWidth = video.offsetWidth;	//�����������Ŀ��
		var videoHeight = video.offsetHeight;	//�����������ĸ߶�
		timer = setInterval(function(){
			var str = "/Mp3Player/SelMVDanmu/"+video.id+"/"+parseInt(video.currentTime);
		
			$.get(str,true,function(data){
			//	document.title = data;			
				eval("var a="+data);
				if(a.length != 0){
				
					for(var i = 0;i<a.length;i++){
						
						//	$("#showDanmu").append("<p>"+a[i].message+"</p>");
						var p = document.createElement("p");	//ÿһ����Ļ����
						p.innerHTML = a[i].message;
						p.setAttribute("class","danmudetail");
						//����һ������߶Ⱥ�����ڱ߾�
						var height = (Math.random()*250);
						var paddingLeft = (Math.random()*400);
						p.setAttribute("style","top:"+height+"px;padding-left:"+paddingLeft+"px;");
						
						showDanmu.appendChild(p);
						//����һ��leftֵ
						var left = -500-paddingLeft;
						var speed = Math.random()*5000;
						$("#showDanmu .danmudetail").animate({left:left+"px"},5000);
					}
				}		
			});
			
		},1000);
	}
	
	//��ͣ��Ļ����ն�ʱ��
	function danmuStop(){
		clearInterval(timer);
	}
	//��Ļ��ʾ������
});