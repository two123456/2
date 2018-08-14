<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
     <link rel="stylesheet" href="/netctoos/static/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="/netctoos/static/bootstrap/bootstrap-theme.min.css"/>

    <script src="/netctoos/static/js/jQuery-2.2.2-min.js"></script>
    <script src="/netctoos/static/bootstrap/bootstrap.min.js"></script>
    <script src="/netctoos/static/bootstrap/bootstrap-paginator.min.js"></script>
    <!-- <script src="/netctoos/static/bootstrap/WdatePicker.js"></script> -->
    
    <style>
        *{
            font-family: 幼圆;
        }
        #title1{
            text-align: center;
            font-size: 30px;
            margin-top: 20px;
        }
        .col-md-5 div{
            margin-top: 15px;
        }
        body{
            background-color: transparent;
        }
        .btn{
            color: white;
            background-color:rgba(51, 153, 51,0.7);
        }

    </style>
</head>
<body>
<p class="container-fluid">
<form action="#" >
    <div class="row" id="title1">
        修改密码
    </div>
    <div class="col-md-5 col-md-offset-3" style="height: 450px; margin-left: 42% " >
        <div class="row">
            <div class="col-md-3">
                <label for="eventName" class="control-label">姓名：</label>
            </div>
            <div class="col-md-9">
                <span id="eventName">张三</span>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <label for="eventName1" class="control-label">身份证：</label>
            </div>
            <div class="col-md-9">
                <span id="eventName1">51125458525885455454</span>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <label for="eventName2" class="control-label">账务账号：</label>
            </div>
            <div class="col-md-9">
                <span id="eventName2">1515415151</span>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <label for="time" class="control-label">原密码</label>
            </div>
            <div class="col-md-9">
                <input type="password" id="time" name="time" class="form-control" style="width: 150px">
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <label for="time1" class="control-label">新密码</label>
            </div>
            <div class="col-md-9">
                <input type="password" id="time1" name="time" class="form-control" style="width: 150px">
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <label for="time2" class="control-label">确认密码</label>
            </div>
            <div class="col-md-9">
                <input type="password" id="time2" name="time" class="form-control" style="width: 150px">
            </div>
        </div>

        <div class="" >
            <a href="#" class="btn" role="button" style="width: 110px; margin-right: 50px ;">保存</a>

            <a href="#" class="btn" role="button" style="width: 110px">取消</a>
        </div>
    </div>
</form>
</body>
</html>