<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>管理员管理系统</title>
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
							<a id="addButton" class="layui-btn layui-btn-xs" lay-event="detail">
								<i class="layui-icon addbutton">新增&#xe654;</i>
							</a>
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
				<input id="demoReload" type="text" name="title" placeholder="请输入用户名.." autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button id="page" class="layui-btn" lay-submit lay-filter="formDemo_hash"><i class="layui-icon">&#xe615;</i> 搜索</button>
				<button  type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</script>
<script>
    var adminName="";
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
					adminName: '@adminName',
					adminNum: '@adminNum',
					adminPhone: '@adminPhone',
					adminMail: '@adminMail',				
					role: '@role',
					operate: '@operate',				
				}]
			}
		});
		//第一个实例
		table.render({
			method: 'get',
			// size: 'sm',
			limit: 5,
			elem: '#demo_hash',			
			height: 'full-235',
			url: '/netctoos/admins/showPage?adminName='+adminName, //数据接口
			page: true, //开启分页
			cols: [
				[ //表头
					{
						field: 'id',
						title: 'id',
						width: 60
					},{
						field: 'adminName',
						title: '管理员',
						width: 180
					},{
						field: 'adminNum',
						title: '账户名称',
						width: 180
					}, {
						field: 'adminPhone',
						title: '联系电话',
						width: 211
					}, {
						field: 'adminMail',
						title: '邮箱',
						width: 211,
						
					}, {
						field: 'role',
						title: '角色',
						width: 211,
						
					}, {
						field: 'operate',
						title: '操作',
						width: 211,
						toolbar: '#barDemo_hash'
					}
				]
			]
		});
		//监听工具条
		table.on('tool(test)', function(obj) {
			var data = obj.data;
			if(obj.event === 'edit') {
				layer.open({
					  title : "编辑",
					  type: 2,
					  area: ['700px', '550px'],
					  fixed: false, //不固定
					  maxmin: true,
					  content: 'administratorUpdate.jsp',
					  end: function () {
						  location.reload();
					 },  
					  success: function (layero, index) {
			                var body = layer.getChildFrame('body', index);  //巧妙的地方在这里哦
			                body.contents().find("#id").val(data.id);
			                body.contents().find("#adminName").val(data.adminName);
			                body.contents().find("#adminNum").val(data.adminNum);
			                body.contents().find("#adminPhone").val(data.adminPhone);
			                body.contents().find("#adminMail").val(data.adminMail);
			                body.contents().find("#role").val(data.role);
			            }
				});
			}else if(obj.event === 'del'){
			      layer.confirm('确定删除？', function(index){
			    	  var infomation = {"id":data.id};
			    	  $.ajax({
						   type: "post",
						   url: "/netctoos/admins/deleteAdmin",
						   data:infomation,
						   success: function(){
						    obj.del();
						    layer.close(index);
						    $(".layui-laypage-btn")[0].click();
						   }
						}); 					
				});	
			}else if(obj.event ==='detail'){
				layer.open({
					title : "查看",
					  type: 2,
					  area: ['700px', '550px'],
					  fixed: false, //不固定
					  maxmin: true,
					  content: 'administratorShow.jsp',
					  end: function () {
						     $(".layui-laypage-btn")[0].click();
						 },  
						  success: function (layero, index) {
				                var body = layer.getChildFrame('body', index);  //巧妙的地方在这里哦
				                body.contents().find("#id").val(data.id);
				                body.contents().find("#adminName").val(data.adminName);
				                body.contents().find("#adminNum").val(data.adminNum);
				                body.contents().find("#adminPhone").val(data.adminPhone);
				                body.contents().find("#adminMail").val(data.adminMail);
				                body.contents().find("#role").val(data.role);
				            }
				})
			}
		});	
		$('#addButton').on('click', function() {
			layer.open({
				  type: 2,
				  area: ['700px', '560px'],
				  fixed: false, //不固定
				  maxmin: true,
				  content: 'administratorAdd.jsp',
				  end: function () {
					  	$(".layui-laypage-btn")[0].click();
				      }
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
				width: '500px', //可以设置百分比和px
				done: function() {
					
					form.render();
					//监听提交
					form.on('submit(formDemo_hash)', function(data) {
						 var demoReload = $('#demoReload');
						 //执行重载
					      table.reload('demo_hash', {
					     	url: '/netctoos/admins/findPage'
					        ,where: {
					             adminName: demoReload.val()
					        }
					      ,page: {
					    	    curr: 1 //重新从第 1 页开始
					    	  }
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