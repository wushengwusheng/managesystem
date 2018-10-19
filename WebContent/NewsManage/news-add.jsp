<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	<form class="form form-horizontal" id="form-admin-add">
	<div class="row cl">
					<div class="formControls col-xs-8 col-sm-9">
						<input type="hidden" class="input-text" value="" id="newsid" name="newsid">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>标题：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text radius" value="" placeholder="资讯标题" id="title" name="title">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3">简要介绍：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<textarea name="brief_intro" cols="" rows="" class="textarea"  placeholder="请简要介绍添加的资讯..100个字符以内" dragonfly="true" onKeyUp="$.Huitextarealength(this,100)">
						</textarea>
						<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
					</div>
				</div>
				<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3">类型：</label>
						<div class="formControls col-xs-8 col-sm-9"> 
							<span class="select-box">
								<select class="select" size="1" name="type">
									<option value="研究">研究</option>
									<option value="资讯">资讯</option>
									<option value="杂谈">杂谈</option>
								</select>
							</span> 
						</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3">封面图片：</label>
					<div class="formControls col-xs-8 col-sm-9"> <span class="btn-upload form-group">
						<input class="input-text upload-url radius" type="text" name="uploadfile1" id="uploadfile1" readonly style="width:200px" value="">
						<a href="javascript:void();" class="btn btn-primary upload-btn"><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
						<input type="file" multiple name="file-2" class="input-file" id="file-2">
						</span> </div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>图片预览：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<img src="eduR/res1.png" width="120" height="60" id="img">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3">资讯内容：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<textarea name="content" cols="" rows="" class="textarea"  placeholder="正文内容..." dragonfly="true" onKeyUp="$.Huitextarealength(this,100)">
						</textarea>
						<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>作者：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text radius" value="" placeholder="作者" id="writer" name="writer">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-3">模块：</label>
					<div class="formControls col-xs-8 col-sm-9"> <span class="select-box" style="width:150px;">
						<select class="select" name="part" size="1">
							<option value="eduResearch">教育技术研究</option>
							<option value="eduTalk">教育技术杂谈</option>
							<option value="eduConsult">教育技术资讯</option>
						</select>
						</span> </div>
				</div>
				<div class="row cl">
						<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>状态：</label>
						<div class="formControls col-xs-8 col-sm-9 skin-minimal">
							<div class="radio-box">
								<input name="status" type="radio" id="sex-1" value="1" checked>
								<label for="sex-1">发布</label>
							</div>
							<div class="radio-box">
								<input type="radio" id="sex-2" name="status" value="2">
								<label for="sex-2">下架</label>
							</div>
							<div class="radio-box">
								<input type="radio" id="sex-3" name="isdelete" value="3">
								<label for="sex-3">删除</label>
							</div>
						</div>
				</div>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
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
	
	$("#form-admin-add").validate({
		rules:{
			adminName:{
				required:true,
				minlength:4,
				maxlength:16
			},
			password:{
				required:true,
			},
			password2:{
				required:true,
				equalTo: "#password"
			},
			sex:{
				required:true,
			},
			phone:{
				required:true,
				isPhone:true,
			},
			email:{
				required:true,
				email:true,
			},
			adminRole:{
				required:true,
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: 'post',
				url: "xxxxxxx" ,
				success: function(data){
					layer.msg('添加成功!',{icon:1,time:1000});
				},
                error: function(XmlHttpRequest, textStatus, errorThrown){
					layer.msg('error!',{icon:1,time:1000});
				}
			});
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
	
	$("#file-2").change(function(){
		var $file = $(this);
        var objUrl = $file[0].files[0];
        //获得一个http格式的url路径:mozilla(firefox)||webkit or chrome  
        var windowURL = window.URL || window.webkitURL;
        //createObjectURL创建一个指向该参数对象(图片)的URL  
        var dataURL = windowURL.createObjectURL(objUrl);
        $("#img").attr("src", dataURL);
	});
});
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>