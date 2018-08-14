<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>账务账号管理</title>
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
							<a  href="javascript:;" class="layui-btn layui-btn-xs layui-btn-primary" id="search_hash">
								<i class="layui-icon findbutton">查询&#xe615;</i>
							</a>
							<button type="button" class="layui-btn" id="upload">
								<i class="layui-icon">&#xe67c;</i>选择文件</button>
						</div>
						</div>
						<div class="layui-card-body">
							<table id="demo_hash" lay-filter="test"></table>
							<script type="text/html" id="barDemo_hash">
								<a class="layui-btn layui-btn-xs" lay-event="edit">恢复</a>
								<a class="layui-btn layui-btn-xs" lay-event="open" >开通业务账号</a>
								<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="stop">暂停</a>
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
			<label class="layui-form-label">账务账号：</label>
			<div class="layui-input-block">
				<input type="text" name="title" placeholder="请输入账务账号" autocomplete="off" class="layui-input">
			</div>
			<label class="layui-form-label">姓名：</label>
			<div class="layui-input-block">
				<input type="text" name="name" placeholder="请输入姓名" autocomplete="off" class="layui-input">
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
					username: '@name',
					accountingNumber: '@accountingNum',
					accountingState: '@accountingState',
					address: '@address',
					operate: '@operate',
				}]
			}
		});

		layui.use('upload', function(){
			var upload = layui.upload;

			//执行上传
			var uploadInst = upload.render({
				elem: '#upload' //绑定元素
				,url: '/ssfwpt/ra/ramanage' //上传接口
				,method: 'POST'
				,accept: 'file'
				,size: 1024
				,before: function(obj){
					layer.load();
				}
				,done: function(res){//上传完毕回调
					layer.closeAll('loading');
					var result = '';

					for(var i=0; i<res.length; i++){
						result = result + res[i].nsrsbh+"="+res[i].container+"\n";
					}
				}
				,error: function(){//请求异常回调
					layer.closeAll('loading');
					layer.msg('网络异常，请稍后重试！');
				}
			});
		});
		//第一个实例
		table.render({
			method: 'post',
			// size: 'sm',
			limit: 20,
			elem: '#demo_hash',
			height: 'full-235',
			url: '/demo/table/user', //数据接口
			page: true, //开启分页
			cols: [
				[ //表头
					{
						field: 'username',
						title: '用户名',
						width: 200
					}, {
						field: 'accountingNumber',
						title: '账务账号',
						width: 200
					}, {
						field: 'accountingState',
						title: '账务状态',
						width: 200
					}, {
						field: 'address',
						title: '地址',
						width: 300
					}, {
						field: 'operate',
						title: '操作',
						width: 350,
					toolbar: '#barDemo_hash'
					}
				]
			]
		});

		$('#addButton').on('click', function() {
			layer.open({
				type: 2,
				area: ['600px', '450px'],
				title: ['新增', 'font-size:18px;'],
				fixed: false, //不固定
				maxmin: true,
				content: 'userRegister.jsp',
				end: function () {
					$(".layui-laypage-btn")[0].click();
				}
			});
		});
		//监听工具条
		table.on('tool(test)', function(obj) {
			var data = obj.data;
			if(obj.event === 'open') {
				layer.open({
					type: 2,
					area: ['600px', '450px'],
					fixed: false, //不固定
					maxmin: true,
					content: 'businessRegister.jsp'
				});
			}else if (obj.event === 'del') {
				layer.confirm('真的删除行么', function(index) {
					var infomation = {"id":data.id,"username":data.username,"accountingNumber":data.accountingNumber,"accountingState":data.accountingState,"address":data.address,"operate":data.operate};
					$.ajax({
						   type: "DELETE",
						   url: "admins/"+data.id,
						   data:infomation,
						   success: function(){
						    obj.del();
						    layer.close(index);
						    $(".layui-laypage-btn")[0].click();
						   }
						}); 
					
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
</script>

<style scoped>
#addButton{
	width: 100px;
	height: 40px;
}
	.addbutton{
     position: absolute;
		margin-top: 10px;
		margin-left: -20px;
	}

#search_hash{
	width: 100px;
	height: 40px;
}
.findbutton{
	position: absolute;
	margin-top: 10px;
	margin-left: -20px;
}
</style>