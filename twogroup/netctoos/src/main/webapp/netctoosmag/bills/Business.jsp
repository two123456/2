<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div style="text-align: center  "   >
    <h1>所有业务账号</h1>
</div>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>NETCTOSS 业务</title>
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
            limit: 20,
            elem: '#demo_hash',
            height: 'full-100',
            url: '/demo/table/user', //数据接口
            page: false, //开启分页
            cols: [
                [ //表头
                    {
                        field: 'id', 
                        title: 'ID',
                        width: 80, 
                        sort: true,
                        fixed: 'left'
                    }, {
                    field: 'username',
                    title: 'OS账号',
                    width: 120
                }, {
                    field: 'sex',
                    title: '时长（单位：时分秒）',
                    width: 120,
                    sort: true
                }, {
                    field: 'city',
                    title: '实验室（服务器）',
                    width: 120
                }, {
                    field: 'sign',
                    title: '资费名称',
                    width: 120
                }, {
                    field: 'experience',
                    title: '资费类型',
                    width: 120,
                    sort: true
                }, {
                    field: 'score',
                    title: '费用',
                    width: 120,
                    sort: true
                }, {
                    field: 'classify',
                    title: '资费说明',
                    width: 120
                },{
                    fixed: 'right',
                    width: 180,
                    align: 'center',
                    toolbar: '#barDemo_hash'
                }
                ]
            ]
        });


        //监听工具条
        table.on('tool(test)', function(obj) {
            var data = obj.data;
            if(obj.event === 'detail') {
                layer.open({
                    type: 2,
                    area: ['700px', '400px'],
                    fixed: false, //不固定
                    maxmin: true,
                    content: 'Details.jsp'
                });
            }
        });
    });
</script>