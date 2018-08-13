<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>NETCTOSS 资费修改</title>
     <link rel="stylesheet" href="/netctoos/static/layui/css/layui.css" id="layui">
    <link rel="stylesheet" href="/netctoos/static/layui/css/theme/default.css" id="theme">
    <link rel="stylesheet" href="/netctoos/static/layui/css/kitadmin.css" id="kitadmin">
    <script src="/netctoos/static/js/polyfill.min.js"></script>
    <script src="/netctoos/static/js/layui.js"></script>
    <script src="/netctoos/static/js/kitadmin.js"></script>
    <script src="/netctoos/static/js/mockjs-config.js"></script>
</head>
<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-col-xs12">
            <div class="layui-card">

                <div class="layui-card-body">
                    <fieldset class="layui-elem-field layui-field-title" >
                        <legend>资费修改</legend>
                    </fieldset>
                    <form class="layui-form layui-form-pane" action="">
                        <div class="layui-form-item" >
                            <label class="layui-form-label">资费名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" lay-verify="required" placeholder="请输入资费名称" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">选择资费</label>
                            <div class="layui-input-inline">
                                <select name="quiz1">
                                    <option value="">请选择资费</option>
                                    <option value="套餐" selected="">套餐</option>
                                    <option value="按时">按时</option>
                                    <option value="包月">包月</option>
                                </select>
                            </div>
                            <div class="layui-input-inline">
                                <select name="quiz2">
                                    <option value="">请选择资费</option>
                                    <option value="小时">20/小时</option>
                                    <option value="月" >200元/月</option>
                                    <option value="套餐">100元/6小时</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-form-item" >
                            <label class="layui-form-label">基本费用</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" lay-verify="required" placeholder="请输入基本费用（单位RMB）" autocomplete="off" class="layui-input">
                            </div>
                            <label class="layui-form-label">单位费用</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" lay-verify="required" placeholder="请输入单位费用" autocomplete="off" class="layui-input">
                            </div>
                            
                        </div>
                        <div class="layui-form-item" >
                        <label class="layui-form-label">基本时长</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" lay-verify="required" placeholder="请输入基本时长" autocomplete="off" class="layui-input">
                            </div>
                             </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">套餐详情</label>
                            <div class="layui-input-block">
                                <textarea placeholder="请输入套餐详情" class="layui-textarea"></textarea>
                            </div>
                        </div>
                        <div class="layui-form-item" >
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