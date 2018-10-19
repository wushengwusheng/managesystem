<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="comment.*,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="../lib/html5shiv.js"></script>
<script type="text/javascript" src="../lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="../lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->
<title>添加用户</title>
</head>
<body>

<%
	String result=(String)request.getAttribute("err");
	if(result==null){
		result="";
	}
%>

<article class="page-container">
	<form action="updatesinglecomment" method="post" class="form form-horizontal" id="form-member-add">
		<%
		Object obj = request.getAttribute("commentList");
		List<Comments> commentList = null;
		if(obj instanceof List){
			commentList = (List<Comments>)obj;
		}
		if(commentList!=null){
			for(Comments comment:commentList){
				%>
				<div class="row cl">
					<div class="formControls col-xs-8 col-sm-9">
						<input type="hidden" class="input-text" value="<%=comment.getId() %>" id="commentid" name="commentid">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value="<%=comment.getCommentsname() %>" placeholder="用户名" id="username" name="username" readonly="readonly">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" placeholder="@" name="email" id="email" value="<%=comment.getCommentsemail() %>">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3">评论内容：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<textarea name=comment cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)"><%=comment.getCommentscontent() %></textarea>
						<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
					<div class="formControls col-xs-8 col-sm-9 skin-minimal">
						<div class="radio-box">
							<input name="isdelete" type="radio" id="sex-1" <%=comment.getCommentsstatus()==0?"checked":"" %> value="0">
							<label for="sex-1">未审核</label>
						</div>
						<div class="radio-box">
							<input type="radio" id="sex-2" name="isdelete" <%=comment.getCommentsstatus()==1?"checked":"" %> value="1">
							<label for="sex-2">审核通过</label>
						</div>
						<div class="radio-box">
							<input type="radio" id="sex-3" name="isdelete" <%=comment.getCommentsstatus()==2?"checked":"" %> value="2">
							<label for="sex-3">审核不通过</label>
						</div>
					</div>
				</div>
				<div class="row cl">
					<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
						<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;保存&nbsp;&nbsp;">
					</div>
				</div>
				<%
			}
		}
		%>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
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
	
	/* $("#form-member-add").validate({
		rules:{
			username:{
				required:true,
				minlength:2,
				maxlength:16
			},
			sex:{
				required:true,
			},
			mobile:{
				required:true,
				isMobile:true,
			},
			email:{
				required:true,
				email:true,
			},
			uploadfile:{
				required:true,
			},
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			//$(form).ajaxSubmit();
			var index = parent.layer.getFrameIndex(window.name);
			//parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	}); */
});
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>