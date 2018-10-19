<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List,comment.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>评论管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 评论管理 <span class="c-gray en">&gt;</span> 评论列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<form action="getcommentlist" method="post">
		<div class="text-c"> <!-- 日期范围： -->
			<!-- <input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" style="width:120px;">
			-
			<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:120px;"> -->
			<input type="text" class="input-text radius" style="width:250px" placeholder="输入用户名称" id="username" name="username">
			<input type="text" class="input-text radius" style="width:250px" placeholder="输入关键词" id="comment" name="comment">
			<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" style="width:120px;" name="comments_time" placeholder="输入起始时间">
			-
			<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:120px;" name="comments_time" placeholder="输入截止时间">
			<button type="submit" class="btn btn-success radius" id="btnSubmit" name="btnSubmit"><i class="Hui-iconfont">&#xe665;</i> 搜留言 </button>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20"> 
			<span class="l">
				<a href="javascript:;" onclick="member_start()" class="btn btn-success radius">
					<i class="Hui-iconfont">&#xe6a1;</i> 批量审核
				</a>
				<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius">
					<i class="Hui-iconfont">&#xe6e2;</i> 批量删除
				</a> 
			</span> 
			<span class="r">共有数据：<strong>88</strong> 条</span> 
		</div>	
		<div class="mt-20">
			<table class="table table-border table-bordered table-hover table-bg table-sort">
					<thead>
						<tr class="text-c">
							<th width="25"><input type="checkbox" name="" value=""></th>
							<th width="80">ID</th>
							<th width="100">用户名</th>
							<th width="150">留言内容</th>
							<th width="100">用户邮箱</th>
							<th width="130">创建时间</th>
							<th width="70">状态</th>
							<th width="100">操作</th>
						</tr>
					</thead>
	<%
	Object obj = request.getAttribute("commentlist");
	List<Comments> commentlist = null;
	int userid=0;
	if(obj instanceof List){
		commentlist = (List<Comments>)obj;
	}
	if(commentlist!=null){
		for(Comments comment:commentlist){
			String status="",delete="";
			if(comment.getCommentsstatus()==0){
				status="danger";
				delete="未审核";
			}else if(comment.getCommentsstatus()==1){
				status="success";
				delete="已审核";
			}else{
				status="fails";
				delete="未通过审核";
			}
			%>
					<tbody>
						<tr class="text-c">
							<td><input type="checkbox" value="<%=comment.getId()%>" name="checkid" id="checkid"></td>
							<td><%=comment.getId() %></td>
							<td><u style="cursor:pointer" class="text-primary" onclick="member_show('张三','','10001','360','400')"><%=comment.getCommentsname() %></u></td>
							<td><%=comment.getCommentscontent() %></td>
							<td><%=comment.getCommentsemail() %></td>
							<td><%=comment.getCommentstime() %></td>
							<td class="td-status"><span class="label label-<%=status %> radius"><%=delete %></span></td>
							<td class="td-manage">
								<a title="编辑" href="javascript:;" onclick="member_edit('编辑','getsinglecomment?commentid=<%=comment.getId() %>','4','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i>
								</a> 
							</td>
						</tr>
					</tbody>
			<%
		}
	}
	%>
				</table>
		</div>
	</form>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,5]}// 制定列不参与排序
		]
	});
	
});
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}

/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}

/*用戶-批量刪除*/
function datadel(){
	var check = $("input[name='checkid']:checked");
	var length = check.length;
	var boxValue = "";
	
	if(length==0){
		$.Huimodalalert('请选中需要删除的留言:)',1000)
	}else{
		for(var i = 0 ; i < length ; i ++){
			if(check[i].checked){
				boxValue += "'"+check[i].value+"',";
			}
		}
		
		if(boxValue.length>1){
			boxValue = boxValue.substring(0,boxValue.length-1);
		}
		//alert(boxValue);
		
		layer.confirm('确认要删除所选留言吗？',function(index){
			//var page = window.location.pathname;
			$.ajax({
				type : "post",
				dataType: "text",
				url : "batchdeletecomments?userid="+boxValue,
				success : function(data) {
					layer.msg('已删除!',{icon:1,time:1000});
					layer.close(index);
					window.location.reload();
				},
				error: function(data){
					layer.msg('删除留言失败!',{icon:1,time:1000});
				}
			});
			
		});
	}
}


/*用戶-批量停用*/
function member_stop_test(){
	//alert(window.location.pathname);
	var page=window.location.pathname;
	var check = $("input[name='checkid']:checked");
	var length = check.length;
	var boxValue = "";
	
	if(length==0){
		$.Huimodalalert('请选中需要停用的用户:)',1000)
	}else{
		for(var i = 0 ; i < length ; i ++){
			if(check[i].checked){
				boxValue += "'"+check[i].value+"',";
			}
		}
		
		if(boxValue.length>1){
			boxValue = boxValue.substring(0,boxValue.length-1);
		}
		//alert(boxValue);
		
		layer.confirm('确认要停用所选用户吗？',function(index){
			//alert(window.location.pathname);
			$.ajax({
				type : "post",
				dataType: "text",
				url : "stopsingleuser?userid="+boxValue,
				success : function(data) {
					layer.msg('已停用!',{icon:1,time:1000});
					layer.close(index);
					window.location.reload();
				},
				error: function(data){
					layer.msg('停用用户失败!',{icon:1,time:1000});
				}
			});
			
		});
	}
}

/*用戶-批量启用*/
function member_start(){
	var check = $("input[name='checkid']:checked");
	var length = check.length;
	var boxValue = "";
	
	if(length==0){
		$.Huimodalalert('请选中需要审核的留言:)',1000)
	}else{
		for(var i = 0 ; i < length ; i ++){
			if(check[i].checked){
				boxValue += "'"+check[i].value+"',";
			}
		}
		
		if(boxValue.length>1){
			boxValue = boxValue.substring(0,boxValue.length-1);
		}
		//alert(boxValue);
		
		layer.confirm('确认要审核所选留言吗？',function(index){
			//alert(window.location.pathname);
			var page=window.location.pathname;
			$.ajax({
				type : "post",
				dataType: "text",
				url : "batchpasscomments?userid="+boxValue,
				success : function(data) {
					layer.msg('已审核!',{icon:1,time:1000});
					layer.close(index);
					window.location.reload();
				},
				error: function(data){
					layer.msg('审核留言失败!',{icon:1,time:1000});
				}
			});
			
		});
	}
}
</script> 
</body>
</html>