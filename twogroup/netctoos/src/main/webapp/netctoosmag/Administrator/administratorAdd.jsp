<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>管理员管理系统</title>
<link rel="stylesheet"
	href="/netctoos/static/layui/css/theme/default.css" id="theme">
<link rel="stylesheet" href="/netctoos/static/layui/css/kitadmin.css"
	id="kitadmin">
<script src="/netctoos/static/js/polyfill.min.js"></script>
<script src="/netctoos/static/js/layui.js"></script>
<script src="/netctoos/static/js/kitadmin.js"></script>
<script src="/netctoos/static/js/mockjs-config.js"></script>
<script src="/netctoos/static/jQuery-2.2.2-min.js"></script>
<script src="/netctoos/static/layui/layui.js"></script>
<link rel="stylesheet" href="/netctoos/static/layui/css/layui.css"
	id="layui">


</head>
<div class="layui-fluid">
	<div class="layui-row">
		<div class="layui-col-xs12">
			<div class="layui-card">

				<div class="layui-card-body">

					<fieldset class="layui-elem-field layui-field-title"
						style="margin-top: 50px;">
						<legend>添加管理员</legend>
					</fieldset>
					<form class="layui-form layui-form-pane"
						action="/netctoos/admins/saveAdmin" method="post">
						<div class="layui-form-item">
							<label class="layui-form-label">姓名</label>
							<div class="layui-input-block">
								<input type="text" name="adminName" autocomplete="off"
									placeholder="请输入姓名" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">账号</label>
							<div class="layui-input-block">
								<input type="text" name="adminNum" autocomplete="off"
									placeholder="请输入账号" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">密码</label>
							<div class="layui-input-block">
								<input type="password" name="adminPwd" placeholder="请输入密码"
									autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">邮箱</label>
							<div class="layui-input-block">
								<input type="text" name="adminMail" autocomplete="off"
									placeholder="请输入邮箱" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">电话</label>
							<div class="layui-input-block">
								<input type="text" name="adminPhone" autocomplete="off"
									placeholder="请输入电话" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">角色</label>
							<div class="layui-input-block">
								<select name="interest" lay-filter="aihao">
									<option value=""></option>
									<option value="0">超级</option>
									<option value="1" selected="">普通</option>
									<option value="2">用户</option>
									<option value="3">资费</option>
									<option value="4">等等</option>
								</select>
							</div>
						</div>
						<div class="layui-form-item" pane="">
							<label class="layui-form-label">性别</label>
							<div class="layui-input-block">
								<input type="radio" name="sex" value="男" title="男" checked="">
								<input type="radio" name="sex" value="女" title="女">
							</div>
						</div>
						<div class="layui-form-item">
							<button class="layui-btn" lay-submit="" lay-filter="demo2">添加</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</html>
<script>
	layui.use(['form', 'layedit', 'laydate'], function() {
		var form = layui.form,
			layer = layui.layer,
			layedit = layui.layedit,
			laydate = layui.laydate;

		form.render();

		 //自定义验证规则
        form.verify({
            userName: function(value){
                if(value.length < 2){
                    return '姓名必须为大于2个字符';
                }
            }
            ,password: [/(.+){6,12}$/, '密码必须6到12位']
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });
		//监听提交
		form.on('submit(demo1_hash)', function(data) {
			layer.alert(JSON.stringify(data.field), {
				title: '最终的提交信息'
			});
			var index = parent.layer
			.getFrameIndex(window.name); //先得到当前iframe层的索引
	parent.layer.close(index); //再执行关闭
	return true;
		});
	});
</script>

<style scoped>
</style>