$(function(){
	
	var register_submit = $("#register_box #register_show #form #register_submit");
	register_submit.click(function(){
		
		var uname = $("#register_box #register_show #form #register_uname").val();	//��ȡ�û���
		var pwd = $("#register_box #register_show #form #register_pwd").val();	//��ȡ����
		if(uname==null||uname=='' || pwd==null || pwd==''){
			
			return;
		}
		//����Ajax��֤
		var url = "/Mp3Player/Register";
		var param = "username="+uname+"&password="+pwd;
		$.post(url,param,function(data){
			
			eval("var a="+data);
			if(a[0] == "1"){	//ע��ɹ�
				location.replace("/Mp3Player");
			}else{
				
				$("#register_box #register_show #form #Message").css("display","block");
			}
		})
	})
})