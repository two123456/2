<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>管理员管理系统</title>
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
							<!-- <span>所有会员列表</span> -->
							<button  class="layui-btn layui-btn-xs" id="addButton">
								<i class="layui-icon">&#xe654;</i>
								<span>新增</span>
							</button>
							<a href="javascript:;" class="layui-btn layui-btn-xs layui-btn-primary" id="search_hash">
								<i class="layui-icon">&#xe615;</i>
							</a>
						</div>
						</div>
						<div class="layui-card-body">
							<table id="demo_hash" lay-filter="test"></table>
							<script type="text/html" id="barDemo_hash">
								<a class="layui-btn layui-btn-xs" lay-event="detail" id="show">查看</a>
								<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
								<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
							</script>
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
				<input type="text" name="title" placeholder="请输入用户名.." autocomplete="off" class="layui-input">
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
					gender: '@boolean',
					accoName: '@city',
					role: '@csentence',
				
					tell: '@integer',
					email: '@word',
				
				}]
			}
		});
		//第一个实例
		table.render({
			method: 'post',
			// size: 'sm',
			limit: 5,
			elem: '#demo_hash',
			
			height: 'full-235',
			url: '/demo/table/user', //数据接口
			page: true, //开启分页
			cols: [
				[ //表头
					{
						field: 'id',
						title: 'ID',
						width: 80,
						style:'display:none;',
						
						
					}, {
						field: 'userName',
						title: '管理员',
						width: 211
					},{
						field: 'accoName',
						title: '账户名称',
						width: 211
					}, {
						field: 'tell',
						title: '联系电话',
						width: 211
					}, {
						field: 'email',
						title: '邮箱',
						width: 211,
						
					}, {
						field: 'role',
						title: '角色',
						width: 211,
						
					}, {
						fixed: 'right',
						width: 211,
						align: 'center',
						toolbar: '#barDemo_hash'
					}
				]
			]
		});
		$('table.layui-table thead tr th:eq(0)').addClass('layui-hide');
		//监听工具条
		table.on('tool(test)', function(obj) {
			var data = obj.data;
			if(obj.event === 'detail') {
				layer.open({
					  type: 2,
					  area: ['700px', '550px'],
					  fixed: false, //不固定
					  maxmin: true,
					  content: 'get.html'
					
				});
			}else if(obj.event === 'edit') {
				layer.open({
					  type: 2,
					  area: ['700px', '550px'],
					  fixed: false, //不固定
					  maxmin: true,
					  content: 'update.html'
					
				});
			}else if(obj.event === 'del'){
			      layer.confirm('真的删除行么', function(index){
			          obj.del();
			          layer.close(index);
			        });
			      } 
			
			
		});
	
		$('#addButton').on('click', function() {
			layer.open({
				  type: 2,
				  area: ['700px', '560px'],
				  fixed: false, //不固定
				  maxmin: true,
				  content: 'form1.html'
				});
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

<style scoped>

</style>