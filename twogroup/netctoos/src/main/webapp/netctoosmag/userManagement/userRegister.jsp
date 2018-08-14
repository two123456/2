<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>用户注册</title>
<link rel="stylesheet" href="/netctoos/static/layui/css/layui.css"
	id="layui">
<link rel="stylesheet"
	href="/netctoos/static/layui/css/theme/default.css" id="theme">
<link rel="stylesheet" href="/netctoos/static/layui/css/kitadmin.css"
	id="kitadmin">
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
					<br /> <br />
					<div class="layui-row">
						<h1>用户新增</h1>
					</div>
				</div>
				<br /> <br /> <br />
				<form class="layui-form layui-form-pane" action="admins/saveAdmin" method="post">
					<div class="layui-form-item">
						<label class="layui-form-label">用户名</label>
						<div class="layui-input-inline">
							<input type="text" name="username" lay-verify="required"
								placeholder="请输入用户名" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">密码</label>
						<div class="layui-input-inline">
							<input type="password" name="password" placeholder="请输入密码"
								autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">确认密码</label>
						<div class="layui-input-inline">
							<input type="password" name="password" placeholder="请再次输入密码"
								autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item" pane="">
						<label class="layui-form-label">性别</label>
						<div class="layui-input-block ">
							<input type="radio" name="sex" value="男" title="男" checked="">
							<input type="radio" name="sex" value="女" title="女">
							<!-- <input type="radio" name="sex" value="禁" title="禁用" disabled=""> -->
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">身份证号码</label>
						<div class="layui-input-inline">
							<input type="text" name="userCardNum" lay-verify="required"
								placeholder="请输入身份证号码" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">真实姓名</label>
						<div class="layui-input-inline">
							<input type="text" name="tureUserName" lay-verify="required"
								placeholder="请输入真实姓名" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">联系电话</label>
						<div class="layui-input-inline">
							<input type="text" name="phone" lay-verify="required"
								placeholder="请输入联系电话" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">通讯地址</label>
						<div class="layui-input-inline">
							<input type="text" name="address" lay-verify="required"
								placeholder="请输入通讯地址" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">邮编</label>
						<div class="layui-input-inline">
							<input type="text" name="postcode" lay-verify="required"
								placeholder="请输入邮编" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">QQ</label>
						<div class="layui-input-inline">
							<input type="text" name="QQ" lay-verify="required"
								placeholder="请输入QQ号码" autocomplete="off" class="layui-input">
						</div>
					</div>

					<div class="layui-form-item">
						<button class="layui-btn" lay-submit lay-filter="formDemo">确认</button>
						<button id="backBtn" class="layui-btn layui-btn-primary">返回</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</div>

</html>
<script>
	layui
			.use(
					[ 'form', 'layedit', 'laydate' ],
					function() {
						var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;

						form.render();

						//自定义验证规则
						form.verify({
							pass : [ /(.+){6,12}$/, '密码必须6到12位' ],
							content : function(value) {
								layedit.sync(editIndex);
							}
						});
						//监听提交
						form.on('submit(formDemo)',
								function(data) {
									layer.alert(JSON.stringify(data.field), {
										title : '最终的提交信息'
									});
									var index = parent.layer
											.getFrameIndex(window.name); //先得到当前iframe层的索引
									parent.layer.close(index); //再执行关闭
									return true;
								});
					});
	$("#backBtn").click(function() {
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭
	});
</script>
<style scoped>
</style>