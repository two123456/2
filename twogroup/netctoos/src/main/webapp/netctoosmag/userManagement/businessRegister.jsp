<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>用户注册</title>
      <link rel="stylesheet" href="../static/layui/css/layui.css" id="layui">
    <link rel="stylesheet" href="../static/layui/css/theme/default.css" id="theme">
    <link rel="stylesheet" href="../static/layui/css/kitadmin.css" id="kitadmin">
    <script src="../static/jQuery-2.2.2-min.js"></script>
     <script src="../static/js/polyfill.min.js"></script>
    <script src="../static/js/layui.js"></script>
    <script src="../static/js/kitadmin.js"></script>
    <script src="../static/js/mockjs-config.js"></script>
</head>
<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-col-xs12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <br/>
                    <br/>
                    <div class="layui-row">
                        <h1>业务账号申请</h1>
                    </div>
                </div>
                <br/>
                <br/>
                <br/>
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <label class="layui-form-label">账务账号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="username" lay-verify="required" placeholder="请输入账务账号" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">业务账号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="businessName" lay-verify="required" placeholder="请输入业务账号" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">确认密码</label>
                        <div class="layui-input-inline">
                            <input type="password" name="password" placeholder="请再次输入密码" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-col-md3">
                        <label class="layui-form-label">服务器IP</label>
                        <div class="layui-input-block">
                            <select name="interest" lay-filter="serverIp">
                                <option value=""></option>
                                <option value="0">01</option>
                                <option value="1" selected="">02</option>
                                <option value="2">03</option>
                                <option value="3">04</option>
                                <option value="4">05</option>
                            </select>
                        </div>
                    </div>
                        </div>
                    <div class="layui-form-item">
                        <div class="layui-col-md3">
                        <label class="layui-form-label">资费模式</label>
                        <div class="layui-input-block">
                            <select name="interest" lay-filter="expensesType">
                                <option value=""></option>
                                <option value="0">300元/月</option>
                                <option value="1" selected="">2元/小时</option>
                                <option value="2">3000元/年</option>
                            </select>
                        </div>
                    </div>
                        </div>
                    <div class="layui-form-item">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">提交</button>
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

        form.render();

        //自定义验证规则
        form.verify({
            pass: [/(.+){6,12}$/, '密码必须6到12位'],
            content: function(value) {
                layedit.sync(editIndex);
            }
        });
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