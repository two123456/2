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
	
	<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
	</head>
	<div class="layui-fluid">
		<div class="layui-row">
			<div class="layui-col-xs12">
				<div class="layui-card">
					
					<div class="layui-card-body">

						<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
							<legend>修改管理员资料</legend>
						</fieldset>
						<form class="layui-form layui-form-pane" action="">
						<div class="layui-form-item">
								<label class="layui-form-label">姓名</label>
								<div class="layui-input-block">
									<input type="text" name="userName" placeholder="请输入姓名" autocomplete="off" class="layui-input">
								</div>
								
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">账户名称</label>
								
								<div class="layui-form-mid layui-word-aux" name="accoName">&nbsp;zhangsan</div>
							</div>
								<div class="layui-form-item">
								<label class="layui-form-label">性别</label>
								
								<div class="layui-form-mid layui-word-aux" name="gender">&nbsp;男</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">邮箱</label>
								<div class="layui-input-block">
									<input type="text" name="Email" autocomplete="off" placeholder="请输入邮箱" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">电话</label>
								<div class="layui-input-block">
									<input type="text" name="tell" autocomplete="off" placeholder="请输入电话" class="layui-input">
								</div>
							</div>
						

							

							

							<div class="layui-form-item">
								<label class="layui-form-label">角色</label>
								<div class="layui-input-block">
									<select name="interest" lay-filter="aihao">
										<option value=""></option>
										<option value="0">超级</option>
										<option value="1" selected="">普通</option>
										<option value="2">资费</option>
										<option value="3">用户</option>
										<option value="4">等等</option>
									</select>
								</div>
							</div>

							
						
							<div class="layui-form-item">
								<button class="layui-btn" lay-submit="" lay-filter="demo2">修改</button>
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

		//日期
		laydate.render({
			elem: '#date_hash'
		});
		laydate.render({
			elem: '#date1_hash'
		});

		//创建一个编辑器
		var editIndex = layedit.build('LAY_demo_editor_hash');

		//自定义验证规则
		form.verify({
			title: function(value) {
				if(value.length < 5) {
					return '标题至少得5个字符啊';
				}
			},
			pass: [/(.+){6,12}$/, '密码必须6到12位'],
			content: function(value) {
				layedit.sync(editIndex);
			}
		});

		//监听指定开关
		form.on('switch(switchTest_hash)', function(data) {
			layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
				offset: '6px'
			});
			layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
		});

		//监听提交
		form.on('submit(demo1_hash)', function(data) {
			layer.alert(JSON.stringify(data.field), {
				title: '最终的提交信息'
			})
			return false;
		});
	});
</script>

<style scoped>

</style>