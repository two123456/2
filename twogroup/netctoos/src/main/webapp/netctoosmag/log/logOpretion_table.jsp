<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>前台日志系统</title>
		<link rel="stylesheet" href="/netctoos/static/layui/css/theme/default.css" id="theme">
		<link rel="stylesheet" href="/netctoos/static/layui/css/kitadmin.css" id="kitadmin">
		<script src="/netctoos/static/js/polyfill.min.js"></script>
		<script src="/netctoos/static/js/layui.js"></script>
		<script src="/netctoos/static/js/kitadmin.js"></script>
		<script src="/netctoos/static/js/mockjs-config.js"></script>
		
		<script src="/netctoos/static/jQuery-2.2.2-min.js"></script>
		<script src="/netctoos/static/layui/layui.js"></script>
		
		<link rel="stylesheet" href="/netctoos/static/layui/css/layui.css" id="layui">
	
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
								<a class="layui-btn layui-btn-xs" lay-event="detail" id="show">查看</a>
								
							</script>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</html>

<script type="text/html" id="search_tpl_hash">
	<form class="layui-form" action="">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block">
				<input type="text" name="userName" placeholder="请输入用户名.." autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-inline">
      <label class="layui-form-label">起始日期</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="test1" placeholder="yyyy-MM-dd">
      </div>
    </div>
</br></br>
	<div class="layui-inline">
      <label class="layui-form-label">结束日期</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="test1-1" placeholder="yyyy-MM-dd">
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
	layui.config({
		base: '/src/js/'
	}).use(['jquery', 'mockjs', 'table', 'sidebar', 'form', 'layer'], function() {
		var $ = layui.jquery,
			layer = layui.layer,
			table = layui.table,
			sidebar = layui.sidebar,
			form = layui.form;
		// 注入mock
		layui.mockjs.inject({
			'POST /demo/table/user': {
				code: 0,
				msg: "xxx",
				count: 1000,
				'data|20': [{
					'id|+1': 1,
					userName: '@name',
					
					optDate: '@csentence',
					ip: '@integer',
					optInfo: '@integer'
				
				}]
			}
		});
		//第一个实例
		table.render({
			method: 'post',
			// size: 'sm',
			limit: 10,
			elem: '#demo_hash',
			height: 'full-235',
			url: '/demo/table/user', //数据接口
			page: true, //开启分页
			cols: [
				[ //表头
					{
						field: 'id',
						title: 'ID',
						
						style:'display:none;'
						
					}, {
						field: 'userName',
						title: '管理员',
						width: 317
					}, {
						field: 'optDate',
						title: '操作时间',
						width: 317,
						sort: true
					}, {
						field: 'ip',
						title: 'IP',
						width:317
					}, {
						field: 'optInfo',
						title: '操作内容',
						width: 317
					}
				]
			]
		});
		$('table.layui-table thead tr th:eq(0)').addClass('layui-hide');

		//监听工具条
	

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

<style scoped>

</style>