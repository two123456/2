<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
 <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>前台日志系统</title>
	<link rel="stylesheet" href="/netctoos/static/layui/css/layui.css" id="layui">
    <link rel="stylesheet" href="/netctoos/static/layui/css/theme/default.css" id="theme">
    <link rel="stylesheet" href="/netctoos/static/layui/css/kitadmin.css" id="kitadmin">
    <script src="/netctoos/static/js/polyfill.min.js"></script>
    <script src="/netctoos/static/js/layui.js"></script>
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
							

  <script type="text/html" id="barDemo_hash">

  <a class="layui-btn layui-btn-xs" lay-event="edit">查看</a>

</script>
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
    	date.setTime(d.dailyTime);
    	return date.Format("yyyy-MM-dd"); 
    	}} 
    </script>

<script type="text/html" id="search_tpl_hash">
	<form class="layui-form" action="">
		

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
        <input type="text" class="layui-input" id="test1-1" placeholder="yyyy-MM-dd"name="endTime">
      </div>
    </div>
</br></br>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo_hash"><i class="layui-icon">&#xe615;</i> 搜索</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
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
		limit: 5,
		elem: '#demo_hash',
		height: '300',
		url: '/netctoos/logDaily/write', //数据接口
		page: true, //开启分页
		cols: [
			[ //表头
				
				{
					field: 'dailyName',
					title: '管理员',
					
				}, {
					field: 'logTime',
					title: '操作时间',
					sort:true,
					
					toolbar: '#optTime'
				}, {
					field: 'dailyMod',
					title: '操作模块',
					
				}, {
					field: 'dailyType',
					title: '操作类型',
					toolbar: '#titleTpl',
				
				}, {
					field: 'operate',
					title: '操作',
					
				toolbar: '#barDemo_hash'
				}
			]
		]
	});
	$('table.layui-table thead tr th:eq(0)').addClass('layui-hide'); 
	
	
		table.on('tool(test)', function(obj) {
			var data = obj.data;
			if(obj.event === 'edit') {
				layer.open({
					  type: 2,
					  area: ['400px', '400px'],
					  fixed: false, //不固定
					  maxmin: true,
					  content: '/netctoos/loginfo/write?id='+data.id
					
				});
			}
		 
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





		//监听工具条
 
 
</script>
<script type="text/html" id="titleTpl">
        {{#  if(d.dailyType =='0'){ }}
           新增
        {{#  } else if(d.dailyType =='1') { }}
            修改
         {{#  } else if(d.dailyType =='2') { }}
            删除
		{{#  } else  { }}
             查询
        {{#  } }}
</script>
<style scoped>

</style>