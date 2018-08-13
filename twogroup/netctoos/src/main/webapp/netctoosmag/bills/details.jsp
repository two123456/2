<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div style="text-align: center  "   >
    <h1>业务账号具体详情</h1>
</div>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>NETCTOSS 业务账号详情</title>
       <link rel="stylesheet" href="../static/layui/css/layui.css" id="layui">
    <link rel="stylesheet" href="../static/layui/css/theme/default.css" id="theme">
    <link rel="stylesheet" href="../static/layui/css/kitadmin.css" id="kitadmin">
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
                    <div class="layui-card-body">
                        <table id="demo_hash" lay-filter="test"></table>
                        <script type="text/html" id="barDemo_hash">
                            <a class="layui-btn layui-btn-xs" lay-event="detail" id="show">查看</a>
                        </script>
                </div>
            </div>
            </div>
        </div>
    </div>
</div>
</html>
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
                    username: '@name',
                    sex: '@boolean',
                    city: '@city',
                    sign: '@csentence',
                    experience: '@integer',
                    score: '@integer',
                    classify: '@word',
                    wealth: '@integer',
                    auth: '@boolean'
                }]
            }
        });
        //第一个实例
        table.render({
            method: 'post',
            // size: 'sm',
            limit: 10,
            elem: '#demo_hash',
            height: 'full-235',
            url: '/demo/table/user', //数据接口
            page: true, //开启分页
            cols: [
                [ //表头
                    {
                        field: 'id',
                        title: 'ID',
                        width: 100,
                        sort: true,
                        fixed: 'left'
                    }, {
                    field: 'username',
                    title: '资费名称',
                    width: 250
                }, {
                    field: 'sex',
                    title: '时长（单位：秒）',
                    width: 250,
                    sort: true
                }, {
                    field: 'city',
                    title: '实验室（服务器）',
                    width: 250
                }, {
                    field: 'sign',
                    title: '资费类型',
                    width: 250
                }, {
                    field: 'experience',
                    title: '资费说明',
                    width: 250,
                    sort: true
                },{
                    field: 'experience',
                    title: '登入时间',
                    width: 250,
                    sort: true
                },{
                    field: 'experience',
                    title: '登出时间',
                    width: 250,
                    sort: true
                },
                ]
            ]
        });



    });
</script>

<style scoped>

</style>