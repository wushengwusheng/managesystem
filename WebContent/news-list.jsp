<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="news.News,java.util.List"%>
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
<title>资讯列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 新闻动态管理 <span class="c-gray en">&gt;</span> 新闻动态列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<form action="getnewslist" method="post">
		<div class="text-c">
			<button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button>
		 <span class="select-box inline">
			<select name="type" class="select">
				<option value="all">全部分类</option>
				<option value="edutalk">教育技术杂谈</option>
				<option value="eduresearch">教育技术研究</option>
				<option value="educonsult">教育技术咨询</option>
			</select>
			</span>
			<input type="text" name="title" id="" placeholder="动态标题" style="width:250px" class="input-text">
			<input type="text" name="brief_intro" id="" placeholder="动态简介" style="width:250px" class="input-text">
			<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜动态</button>
		</div>
	</form>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
		<span class="l">
			<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 
			<a href="javascript:;" onclick="news_start()" class="btn btn-success radius"><i class="Hui-iconfont">&#xe615;</i> 批量审批</a>
			<a href="javascript:;" onclick="news_stop()" class="btn btn-warning radius"><i class="Hui-iconfont">&#xe706;</i> 批量下架</a>
			<a class="btn btn-primary radius" data-title="添加资讯" data-href="" onclick="article_add('添加资讯','skipnews','5100','5100')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加资讯</a>
		</span> 
		<span class="r">共有数据：<strong>54</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="80">ID</th>
					<th width="100">标题</th>
					<th width="130">简要介绍</th>
					<th width="40">分类</th>
					<th width="120">封面图</th>
					<th width="75">模块</th>
					<th width="60">作者</th>
					<th width="20">点赞数</th>
					<th width="20">评论数</th>
					<th width="20">浏览量</th>
					<th width="70">发布时间</th>
					<th width="70">状态</th>
					<th width="80">操作</th>
				</tr>
			</thead>
			<%
			Object obj = request.getAttribute("newsList");
			List<News> newsList = null;
			if(obj instanceof List){
				newsList = (List<News>)obj;
			}
			if(newsList!=null){
				for(News news:newsList){
						String status="",delete="";
						if(news.getStatus()==0){
							status="danger";
							delete="未审批";
						}else if(news.getStatus()==1){
							status="success";
							delete="已发布";
						}else if(news.getStatus()==2){
							status="fails";
							delete="已下架";
						}else{
							status="default";
							delete="已删除";
						}
			%>
			<tbody>
				<tr class="text-c">
					<td><input type="checkbox" value="<%=news.getId() %>" name="checkid"></td>
					<td><%=news.getId() %></td>
					<td class="text-l"><u style="cursor:pointer" class="text-primary" onClick="article_edit('查看','index.jsp','10001')" title="查看"><%=news.getTitle() %></u></td>
					<td><%=news.getBrief_intro() %></td>
					<td><i class="Hui-iconfont">&#xe64b;</i><span class="Hui-tags-token"><%=news.getType() %></span></td>
					<td><img src="<%=news.getPic() %>" width="120" height="60"></td>
					<td><span class="label label-primary radius"><%=news.getPart() %></span></td>
					<td><span class="label label-secondary radius"><%=news.getWriter() %></span></td>
					<td><%=news.getGoods_count() %></td>
					<td><%=news.getComment() %></td>
					<td><%=news.getView() %></td>
					<td><%=news.getTime() %></td>
					<td class="td-status"><span class="label label-<%=status %> radius"><%=delete %></span></td>
					<td class="f-14 td-manage">
						<a style="text-decoration:none" class="ml-5" onClick="article_edit('资讯编辑','getsinglenews?userid=<%=news.getId() %>','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> 
				</tr>
			</tbody>
			<%}} %>
		</table>
	</div>
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
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"pading":false,
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[5,10]}// 不参与排序的列
	]
});

/*资讯-添加*/
function article_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*资讯-编辑*/
function article_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*资讯-批量刪除*/
function datadel(){
	var check = $("input[name='checkid']:checked");
	var length = check.length;
	var boxValue = "";
	
	if(length==0){
		$.Huimodalalert('请选中需要删除的资讯:)',1000)
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
		
		layer.confirm('确认要删除所选资讯吗？',function(index){
			//var page = window.location.pathname;
			$.ajax({
				type : "post",
				dataType: "text",
				url : "batchdeletenews?userid="+boxValue,
				success : function(data) {
					layer.msg('已删除!',{icon:1,time:1000});
					layer.close(index);
					window.location.reload();
				},
				error: function(data){
					layer.msg('删除资讯失败!',{icon:1,time:1000});
				}
			});
			
		});
	}
}


/*资讯-批量停用*/
function news_stop(){
	//alert(window.location.pathname);
	var page=window.location.pathname;
	var check = $("input[name='checkid']:checked");
	var length = check.length;
	var boxValue = "";
	
	if(length==0){
		$.Huimodalalert('请选中需要下架的资讯:)',1000)
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
		
		layer.confirm('确认要下架所选资讯吗？',function(index){
			//alert(window.location.pathname);
			$.ajax({
				type : "post",
				dataType: "text",
				url : "stopsinglenews?userid="+boxValue,
				success : function(data) {
					layer.msg('已下架!',{icon:1,time:1000});
					layer.close(index);
					window.location.reload();
				},
				error: function(data){
					layer.msg('下架资讯失败!',{icon:1,time:1000});
				}
			});
			
		});
	}
}

/*资讯-批量启用*/
function news_start(){
	var check = $("input[name='checkid']:checked");
	var length = check.length;
	var boxValue = "";
	
	if(length==0){
		$.Huimodalalert('请选中需要发布的资讯:)',1000)
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
		
		layer.confirm('确认要发布所选资讯吗？',function(index){
			//alert(window.location.pathname);
			//var page=window.location.pathname;
			$.ajax({
				type : "post",
				dataType: "text",
				url : "startsinglenews?userid="+boxValue,
				success : function(data) {
					layer.msg('已发布!',{icon:1,time:1000});
					layer.close(index);
					window.location.reload();
				},
				error: function(data){
					layer.msg('发布资讯失败!',{icon:1,time:1000});
				}
			});
			
		});
	}
}

</script> 
</body>
</html>