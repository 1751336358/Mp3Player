//������Ƶ�Ĳ�������֪ͣͨ��Ļ�Ĳ�������ͣ
function playMvDanmu(obj){
	var music = document.getElementsByClassName("music")[0];
	var musicid = music.id.substr(5);	//mv��id
	var duration = music.duration;	// ���ֵ���ʱ��
	var  total = $("#controller #contShow #right_cont #total");	//�������ܿ�ȶ���
	var curr = $("#controller #contShow #right_cont #total #curr");	//��ǰ����������

	//����Ajax��ѯ��Ļ
	if(music != null){
		if(!music.paused){	//û����ͣ
			music.pause();
			clearInterval(timer);	//��ͣ���������ʱ��
			obj.css("background-image","url(/Mp3Player/image/btn.png)");
			obj.css("background-position","-2px -2px");
			return;
		}else{
			music.play();
			obj.css("background-image","url(/Mp3Player/image/btn.png)");
			obj.css("background-position","-2px -62px");		
		}
		//���ƽ������Ķ�ʱ��
		cont = setInterval(function(){
			var currentTime = music.currentTime;
			var pre = currentTime / duration;
			//���Ľ�����λ��
			curr.css("width",total.width()*pre+"px");
			
		},1000);
		//���ƿ���Ϳ���
		total.click(function(ev){
			var pos = ev.offsetX;	//�������������λ��
			music.currentTime = duration*(pos / total.width());	//�������ֲ��ŵ�ʱ��
			curr.css("width",pos+"px");	//����������λ��
		})
		//���Ƶ�Ļ�Ķ�ʱ��
		timer = setInterval(function(){
			
			var url = "/Mp3Player/SelDanmu/"+musicid+"/"+parseInt(music.currentTime);
			var showDanmu = document.getElementById("showDanmu");
			$.get(url,true,function(data){
				eval("var a="+data);
				for(var i = 0;i<a.length;i++){
					/**********************/
					var p = document.createElement("p");	//ÿһ����Ļ����
					p.innerHTML = a[i].message;
					p.setAttribute("class","danmudetail");
					//����һ������߶Ⱥ�����ڱ߾�
					var height = (Math.random()*400);
					var paddingLeft = (Math.random()*400);
					p.setAttribute("style","top:"+height+"px;padding-left:"+paddingLeft+"px;");
					
					showDanmu.appendChild(p);
					//����һ��leftֵ
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
/*	var music = document.getElementsByClassName("music")[0];	//audio����
	
	var musicid = "";
	if(music != null){
		musicid = music.id.substr(5);
		//������Ƶ�Ĳ�������֪ͣͨ��Ļ�Ĳ�������ͣ
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