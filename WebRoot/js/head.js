function loginCore(event){	//弹出登录框函数，完成登录
	
    var	cover = $("#cover");
    var head_login = $("#head_login");	//登录框
    event.preventDefault();
	cover.css({"width":"100%","height":"100%","display":"block"});
	head_login.css({"display":"block"});
	var closeWindow = $("#head_login #login_show #closeWindow");
	closeWindow.click(function(){
		head_login.css({"display":"none"});		
		cover.css({"width":"0px","height":"0px","display":"none"});
	})
	//处理登录请求
	var submit = $("#head_login #login_show #submit");
	
	submit.click(function(){
		var username = $("#head_login #login_show #username").val();	//获取用户名的值
		var password = $("#head_login #login_show #password").val();	//获取密码的值
		if(username==null || username=='' || password==null||password==''){
			return;
		}
		var url="/Mp3Player/Login";
		$.post(url,"username="+username+"&password="+password,function(data){
			eval("var a="+data);
			if(a[0] == "1"){//如果你成功跳转到首页
				head_login.css({"display":"none"});
				cover.css({"width":"0px","height":"0px","display":"none"});
				location.reload();	//刷新本页面
			}else if(a[0] =="0"){//登录失败Ajax提示
				$("#head_login #login_show #Message").css("display","block");
			}					
		})	
	})
};
//弹出上传框
function uploadMusic(event){
	 var cover = $("#cover");
	 var headUpload = $("#headUpload");	//上传框
	 event.preventDefault();	//取消浏览器默认行为
	 cover.css({"width":"100%","height":"100%","display":"block"});
	 headUpload.css("display","block");	//显示上传框
	 //查询出所有的type
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
