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
						<form class="layui-form layui-form-pane" action="/netctoos/admins/updateAdmin" method="post">
						<div>
							 <input type="hidden" name="id" id="id" >					
						</div>
						<div class="layui-form-item">
								<label class="layui-form-label">姓名</label>
								<div class="layui-input-block">
									<input type="text" id="adminName" name="adminName" placeholder="请输入姓名" autocomplete="off" class="layui-input">
								</div>								
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">账务账号</label>
								<div class="layui-input-block">
									<input type="text" id="adminNum" name="adminNum"  autocomplete="off" class="layui-input" readonly="readonly">
								</div>								
							</div>							
							<div class="layui-form-item">
								<label class="layui-form-label">邮箱</label>
								<div class="layui-input-block">
									<input type="text" id="adminMail" name="adminMail" autocomplete="off" placeholder="请输入邮箱" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">电话</label>
								<div class="layui-input-block">
									<input type="text" id="adminPhone" name="adminPhone" autocomplete="off" placeholder="请输入电话" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">角色</label>
								<div class="layui-input-block" id="role">
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
								<button class="layui-btn" lay-submit="" lay-filter="formDemo">修改</button>
								<button id="backBtn" class="layui-btn layui-btn-primary">取消</button>
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
		form.on('submit(formDemo)', function(data) {
			layer.alert(JSON.stringify(data.field), {
				title: '最终的提交信息'
			});
			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			window.parent.location.reload();
	        parent.layer.close(index); //再执行关闭
	        return true;
		});	
	 $("#backBtn").click(function () {
	        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引	        
	        parent.layer.close(index); //再执行关闭
	    });
	});
</script>

<style scoped>

</style>