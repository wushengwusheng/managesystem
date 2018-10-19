$(function(){
	
	//用户名失去焦点事件
	$("#username").blur(function (){
		var username=$("#username").val();
		if(username.length==0){
			$.Huimodalalert('用户名不能为空',1000)
		}
	})
	
	//密码失去焦点事件
	$("#password").blur(function (){
		var password=$("#password").val();
		if(password.length==0){
			$.Huimodalalert('密码不能为空',1000)
		}
	})
	
	//验证码失去焦点事件
	$("#repassword").blur(function (){
		var repassword=$("#repassword").val();
		var password=$("#password").val();
		if(repassword.length==0){
			$.Huimodalalert('重复密码不能为空',1000)
		}else if(repassword!=password){
			$.Huimodalalert('两次输入密码不一致',1000)
		}
	})
	
	//提交按钮点击事件
	$("#btnSubmit").click(function (){
		var username=$("#username").val();
		var repassword=$("#repassword").val();
		var password=$("#password").val();
		var flag=true;
		
		if(username.length==0){
			$.Huimodalalert('用户名不能为空',1000)
			flag=false;
		}else if(password.length==0){
			$.Huimodalalert('密码不能为空',1000);
			flag=false;
		}else if(repassword.length==0){
			$.Huimodalalert('重复密码不能为空',1000);
			flag=false;
		}else if(repassword!=password){
			$.Huimodalalert('两次输入密码不一致',1000);
			flag=false;
		}else{
			flag=true;
		}
		return flag;
	})
	
})