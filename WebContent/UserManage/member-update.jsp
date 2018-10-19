<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="user.User,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>添加资讯</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="" action=updateexistuser>
	<%
		Object obj = request.getAttribute("userList");
		List<User> userList = null;
		if(obj instanceof List){
			userList = (List<User>)obj;
		}
		if(userList!=null){
			for(User user:userList){
				%>
				<div class="row cl">
					<div class="formControls col-xs-8 col-sm-9">
						<input type="hidden" class="input-text" value="<%=user.getId() %>" id="userid" name="userid">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value="<%=user.getUsername() %>" placeholder="用户名" id="username" name="username">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
					<div class="formControls col-xs-8 col-sm-9 skin-minimal">
						<div class="radio-box">
							<input name="sex" type="radio" id="sex-1" <%=user.getSex()==0?"checked":"" %> value="0">
							<label for="sex-1">男</label>
						</div>
						<div class="radio-box">
							<input type="radio" id="sex-2" name="sex" <%=user.getSex()==1?"checked":"" %> value="1"> 
							<label for="sex-2">女</label>
						</div>
						<div class="radio-box">
							<input type="radio" id="sex-3" name="sex" <%=user.getSex()==2?"checked":"" %> value="2">
							<label for="sex-3">保密</label>
						</div>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value="<%=user.getPhone() %>" placeholder="手机号" id="phone" name="phone">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" placeholder="@" name="email" id="email" value="<%=user.getEmail()%>">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3">所在城市：</label>
					<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
						<select class="select" size="1" name="address">
							<option value="未填" <%=user.getAddress().equals("未填")?"selected":"" %>>请选择城市</option>
							<option value="北京" <%=user.getAddress().equals("北京")?"selected":"" %>>北京</option>
							<option value="上海" <%=user.getAddress().equals("上海")?"selected":"" %>>上海</option>
							<option value="广州" <%=user.getAddress().equals("广州")?"selected":"" %>>广州</option>
						</select>
						</span> </div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3">备注：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<textarea name=comment cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)"><%=user.getComment() %></textarea>
						<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
					<div class="formControls col-xs-8 col-sm-9 skin-minimal">
						<div class="radio-box">
							<input name="isdelete" type="radio" id="sex-1" <%=user.getIsdelete()==0?"checked":"" %> value="0">
							<label for="sex-1">启用</label>
						</div>
						<div class="radio-box">
							<input type="radio" id="sex-2" name="isdelete" <%=user.getIsdelete()==1?"checked":"" %> value="1">
							<label for="sex-2">禁用</label>
						</div>
						<div class="radio-box">
							<input type="radio" id="sex-3" name="isdelete" <%=user.getIsdelete()==2?"checked":"" %> value="2">
							<label for="sex-3">删除</label>
						</div>
					</div>
				</div>
				<div class="row cl">
					<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
						<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
					</div>
				</div>
		<%}
			} %>
	
	
	</form>
</article>

<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	/* $("#file-2").change(function(){
		var $file = $(this);
        var objUrl = $file[0].files[0];
        //获得一个http格式的url路径:mozilla(firefox)||webkit or chrome  
        var windowURL = window.URL || window.webkitURL;
        //createObjectURL创建一个指向该参数对象(图片)的URL  
        var dataURL = windowURL.createObjectURL(objUrl);
        $("#img").attr("src", dataURL);
	}); */
	
});

</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>