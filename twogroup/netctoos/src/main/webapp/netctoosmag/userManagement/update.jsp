<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>修改业务账号详情</title>
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
						<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
							<legend>修改管理员资料</legend>
						</fieldset>
						<form class="layui-form layui-form-pane" action="admins/updateAdmin">				
							<div class="layui-form-item">
								<label class="layui-form-label">业务账号</label>
								
								<div class="layui-form-mid layui-word-aux" name="businessNum">&nbsp;1433223</div>
							</div>															
							<div class="layui-form-item">
								<label class="layui-form-label">资费方式</label>
								<div class="layui-input-block">
									<select name="interest" lay-filter="charge">
										<option value=""></option>
										<option value="0">包月</option>
										<option value="1" selected="">计时</option>
										<option value="2">包年</option>
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
		//监听提交
        form.on('submit(formDemo)', function(data) {
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            });
            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
            return true;
        });
    });
    $("#backBtn").click(function () {
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
    });
</script>

<style scoped>

</style>