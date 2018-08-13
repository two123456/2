<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>NETCTOSS 资费管理</title>
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
                    <div class="layui-card-header" id="layerDemo">
                        <!-- <span>所有会员列表</span> -->

                        <a  class="layui-btn layui-btn-xs" data-method="save">
                            <i class="layui-icon">&#xe654;</i>
                            <span>新增</span>
                        </a>
                    </div>
                    <div class="layui-card-body">
                        <table id="demo_hash" lay-filter="test"></table>
                        <script type="text/html" id="barDemo_hash">
                            <a class="layui-btn layui-btn-xs" lay-event="detail" id="show">开通</a>
                            <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
                            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</html>



<script>
    layui.use('layer', function(){ //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句

        //触发事件
        var active = {
            save: function () {
                var that = this;
                //多窗口模式，层叠置顶
                layer.open({
                    type: 2 //此处以iframe举例
                    , title: '当你选择该窗体时，即会在最顶端'
                    , area: ['800px', '450px']
                    , shade: 0
                    , maxmin: true

                    , content: 'RatesSave.jsp'
                    , yes: function () {
                        $(that).click();
                    }
                    , btn2: function () {
                        layer.closeAll();
                    }

                    , zIndex: layer.zIndex //重点1
                    , success: function (layero) {
                        layer.setTop(layero); //重点2
                    }
                });
            }

        }

        $('#layerDemo .layui-btn').on('click', function(){
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });

    });
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
            height: 'full-80',
            url: '/demo/table/user', //数据接口
            page: true, //开启分页
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
                    title: '资费名称',
                    width: 120
                }, {
                    field: 'sex',
                    title: '资费类型',
                    width: 120,
                    sort: true
                }, {
                    field: 'city',
                    title: '基本时长',
                    width: 120
                }, {
                    field: 'sign',
                    title: '基本费用',
                    width: 120
                }, {
                    field: 'experience',
                    title: '单位费用',
                    width: 120,
                    sort: true
                }, {
                    field: 'score',
                    title: '资费说明',
                    width: 120,
                    sort: true
                }, {
                    field: 'classify',
                    title: '资费状态',
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
            if(obj.event === 'edit') {
                layer.open({
                    type: 2,
                    area: ['800px', '450px'],
                    fixed: false, //不固定
                    maxmin: true,
                    content: 'RatesUpdate.jsp'
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