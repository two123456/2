<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
 "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">

 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>前台日志系统</title>
	<link rel="stylesheet" href="/netctoos/static/layui/css/layui.css" id="layui">
    <link rel="stylesheet" href="/netctoos/static/layui/css/theme/default.css" id="theme">
    <link rel="stylesheet" href="/netctoos/static/layui/css/kitadmin.css" id="kitadmin">
    <script src="/netctoos/static/js/polyfill.min.js"></script>
    <script src="/netctoos/static/js/layui.js" charset="utf-8"></script>
    <script src="/netctoos/static/js/kitadmin.js"></script>
    <script src="/netctoos/static/js/mockjs-config.js"></script>
    <script src="/netctoos/static/jQuery-2.2.2-min.js"></script>
	</head>
	<div class="layui-fluid">
		<div class="layui-row">
			<div class="layui-col-xs12">
				<div class="layui-card">

					<div class="layui-card-body">
						<div class="layui-card-header">
					
							<a href="javascript:;" class="layui-btn layui-btn-xs layui-btn-primary" id="search_hash">
								<i class="layui-icon">&#xe615;</i>
							</a>
						</div>
						<div class="layui-card-body">
							<table id="demo_hash" lay-filter="test"></table>

</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</html>
<script type="text/javascript">
	Date.prototype.Format = function(fmt)   
		{ //author: meizz   
		var o = {   
		 "M+" : this.getMonth()+1,                 //月份   
		 "d+" : this.getDate(),                    //日   
		 "h+" : this.getHours(),                   //小时   
		 "m+" : this.getMinutes(),                 //分   
		 "s+" : this.getSeconds(),                 //秒   
		 "q+" : Math.floor((this.getMonth()+3)/3),   
		 "S"  : this.getMilliseconds()             //毫秒   
		};   
		if(/(y+)/.test(fmt))   
		 fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
		for(var k in o)   
		 if(new RegExp("("+ k +")").test(fmt))   
		fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
		return fmt;   
		} 
		 
	</script>

	<script id="optTime" type="text/html">
    	{{#   
    	var date = new Date();
    	date.setTime(d.logTime);
    	return date.Format("yyyy-MM-dd"); 
    	}} 
    </script>
<script type="text/html" id="search_tpl_hash">
	<form class="layui-form" action="">
	
<div class="layui-form">
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">起始日期</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="test1" placeholder="yyyy-MM-dd" name="startTime">
      </div>
    </div>

</br></br>
	<div class="layui-inline">
      <label class="layui-form-label">结束日期</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="test1-1" placeholder="yyyy-MM-dd" name="endTime">
      </div>
    </div>
</br></br>
</div>
</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo_hash"><i class="layui-icon">&#xe615;</i> 搜索</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</script>
<script>
layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  
	  //常规用法
	  laydate.render({
	    elem: '#test1'
	  });
	  laydate.render({
		    elem: '#test1-1'
		  });
});
</script>
<script>

layui.config({
	base: '/src/js/'
}).use(['jquery', 'mockjs', 'table', 'sidebar', 'form', 'layer'], function() {
	var $ = layui.jquery,
		layer = layui.layer,
		table = layui.table,
		sidebar = layui.sidebar,
		form = layui.form;


	//第一个实例
	table.render({
		method: 'post',
		// size: 'sm',
		limit: 20,
		elem: '#demo_hash',
		height: 'full-235',
		url: '/netctoos/logIn/write', //数据接口
		page: true, //开启分页
		cols: [
			[ //表头
				{
					field: 'logName',
					title: '管理员',
					width: 200
				}, {
					field: 'logTime',
					title: '操作时间',
					sort:true,
					width: 200,
					toolbar: '#optTime'
				}, {
					field: 'serverIp',
					title: 'IP',
					width: 200
				}, {
					field: 'enter',
					title: '操作内容',
					
					width: 300
				}, {
					field: 'operate',
					title: '操作',
					width: 350,
					toolbar: '#titleTpl'
				}
			]
		]
	});

	$('#search_hash').on('click', function() {
		var that = this;
		// console.log($('#search_tpl_hash').html());
		sidebar.render({
			elem: that,
			content: $('#search_tpl_hash').html(),
			title: '搜索',
			shade: true,
			// shadeClose:false,
			// direction: 'left'
			// dynamicRender: false,
			// url: 'views/member/all/search.html',
			width: '500px', //可以设置百分比和px
			done: function() {
				console.log('ccc');
				form.render();

				//监听提交
				form.on('submit(formDemo_hash)', function(data) {
					// layer.msg(JSON.stringify(data.field));
					table.reload('demo_hash', {
						where: data.field
					});
					return false;
				});
			}
		});
	});
});




</script>
<script type="text/html" id="titleTpl">
        {{#  if(d.enter =='0'){ }}
            登陆
        {{#  } else if(d.enter =='1') { }}
            退出
        {{#  } else  { }}
             未知
        {{#  } }}
</script>
<style scoped>

</style>