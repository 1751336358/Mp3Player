function loginCore(event){	//������¼��������ɵ�¼
	
    var	cover = $("#cover");
    var head_login = $("#head_login");	//��¼��
    event.preventDefault();
	cover.css({"width":"100%","height":"100%","display":"block"});
	head_login.css({"display":"block"});
	var closeWindow = $("#head_login #login_show #closeWindow");
	closeWindow.click(function(){
		head_login.css({"display":"none"});		
		cover.css({"width":"0px","height":"0px","display":"none"});
	})
	//�����¼����
	var submit = $("#head_login #login_show #submit");
	
	submit.click(function(){
		var username = $("#head_login #login_show #username").val();	//��ȡ�û�����ֵ
		var password = $("#head_login #login_show #password").val();	//��ȡ�����ֵ
		if(username==null || username=='' || password==null||password==''){
			return;
		}
		var url="/Mp3Player/Login";
		$.post(url,"username="+username+"&password="+password,function(data){
			eval("var a="+data);
			if(a[0] == "1"){//�����ɹ���ת����ҳ
				head_login.css({"display":"none"});
				cover.css({"width":"0px","height":"0px","display":"none"});
				location.reload();	//ˢ�±�ҳ��
			}else if(a[0] =="0"){//��¼ʧ��Ajax��ʾ
				$("#head_login #login_show #Message").css("display","block");
			}					
		})	
	})
};
//�����ϴ���
function uploadMusic(event){
	 var cover = $("#cover");
	 var headUpload = $("#headUpload");	//�ϴ���
	 event.preventDefault();	//ȡ�������Ĭ����Ϊ
	 cover.css({"width":"100%","height":"100%","display":"block"});
	 headUpload.css("display","block");	//��ʾ�ϴ���
	 //��ѯ�����е�type
	 var select = $("#headUpload #uploadShow select");
	 var url = "/Mp3Player/SelAllType";
	
	 $.post(url,null,function(data){
		 eval("var a="+data);
		 select.empty();
		 for(var i = 0;i<a.length;i++){
		 	select.append("<option value="+a[i].id+">"+a[i].typename+"</option>");
		 }
	 })
	 var closeWindow = $("#headUpload #uploadShow  #closeWindow");
	closeWindow.click(function(){
		headUpload.css({"display":"none"});
		cover.css({"width":"0px","height":"0px","display":"none"});
	})
}
