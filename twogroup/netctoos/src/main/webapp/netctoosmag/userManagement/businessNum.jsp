<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>业务账号管理</title>
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
                    <div class="layui-card-header">
                        <!-- <span>所有会员列表</span> -->
                        <a href="javascript:;" class="layui-btn layui-btn-xs layui-btn-primary" id="search_hash">
                            <i class="layui-icon">查询&#xe615;</i>
                        </a>
                    </div>
                    <div class="layui-card-body">
                        <table id="demo_hash" lay-filter="test"></table>
                        <script type="text/html" id="barDemo_hash">
                            <a class="layui-btn layui-btn-xs" lay-event="update">修改</a>
                            <a class="layui-btn layui-btn-xs" lay-event="edit">恢复</a>
                            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="stop">暂停</a>
                            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                        </script>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</html>
<script type="text/html" id="search_tpl_hash">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">账务账号：</label>
            <div class="layui-input-block">
                <input type="text" name="title" placeholder="请输入账务账号" autocomplete="off" class="layui-input">
            </div>
            <label class="layui-form-label">姓名：</label>
            <div class="layui-input-block">
                <input type="text" name="name" placeholder="请输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo_hash"><i class="layui-icon">&#xe615;</i> 搜索</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</script>

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
                    username: '@name',
                    accountingNumber: '@accountingNum',
                    businessNumber:'@businessNum',
                    businessState: '@businessState',
                    server: '@server',
                    expensesType:'@expenses',
                    operate: '@operate',
                }]
            }
        });
        //第一个实例
        table.render({
            method: 'post',
            // size: 'sm',
            limit: 20,
            elem: '#demo_hash',
            height: 'full-235',
            url: '/demo/table/user', //数据接口
            page: true, //开启分页
            cols: [
                [ //表头
                    {
                    field: 'username',
                    title: '用户名',
                    width: 150
                    }, {
                    field: 'accountingNumber',
                    title: '账务账号',
                    width: 150
                }, {
                    field: 'businessNumber',
                    title: '业务账号',
                    width: 150
                }, {
                    field: 'businessState',
                    title: '业务状态',
                    width: 200
                }, {
                    field: 'server',
                    title: '服务器',
                    width: 200
                }, {
                    field: 'expensesType',
                    title: '资费方式',
                    width: 237
                },{
                    field: 'operate',
                    title: '操作',
                    width: 350,
                    toolbar: '#barDemo_hash'
                }
                ]
            ]
        });

      //监听工具条
		table.on('tool(test)', function(obj) {
			var data = obj.data;
			if(obj.event === 'update') {
				layer.open({
					type: 2,
					area: ['600px', '550px'],
					fixed: false, //不固定
					maxmin: true,
					content: 'update.jsp'
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