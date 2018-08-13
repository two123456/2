<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div style="text-align: center  "   >
    <h1>按月份查询账务</h1>
</div>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>NETCTOSS 按月查询</title>
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
                    cost: '@cost',
                    os_account: '@os account',
                    account: '@account',
                    server_ip: '@server_ip',
                    valid_time: '@valid_time',
                    use_time: '@use_time',
                    tariff_combo: '@tariff_combo'
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
                    field: 'cost',
                    title: '费用',
                    width: 165
                }, {
                    field: 'os_account',
                    title: '业务账号',
                    width: 200,
                    sort: true
                }, {
                    field: 'server_ip',
                    title: '服务器IP',
                    width: 250
                }, {
                    field: 'account',
                    title: '账务账号',
                    width: 250
                }, {
                    field: 'use_time',
                    title: '账单日期(月)',
                    width: 250,
                    sort: true
                }, {

                    field: 'valid_time',
                    title: '有效时间',
                    width: 250,
                    sort: true
                }, {
                    field: 'tariff_combo',
                    title: '资费套餐',
                    width: 250,
                    sort: true
                }, {
                    fixed: 'right',
                    width: 130,
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
                    area: ['1500px', '700px'],
                    fixed: false, //不固定
                    maxmin: true,
                    content: 'finddate.jsp'
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

<style scoped>

</style>