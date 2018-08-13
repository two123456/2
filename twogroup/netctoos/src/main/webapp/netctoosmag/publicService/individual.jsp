<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
    <link rel="stylesheet" href="../static/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="../static/bootstrap/bootstrap-theme.min.css"/>

    <script src="../static/js/jQuery-2.2.2-min.js"></script>
    <script src="../static/bootstrap/bootstrap.min.js"></script>
    <script src="../static/bootstrap/bootstrap-paginator.min.js"></script>
    <script src="../static/bootstrap/WdatePicker.js"></script>
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
        个人信息
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
                <label for="eventName3" class="control-label">性别：</label>
            </div>
            <div class="col-md-9">
                <span id="eventName3">男</span>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <label for="eventName4" class="control-label">联系电话：</label>
            </div>
            <div class="col-md-9">
                <span id="eventName4">11515214415415</span>
            </div>
        </div>
        <div class="col-md-2">
            <div class="row" >
                <a href="#" class="btn" role="button" style="width: 110px">返回</a>
            </div>
        </div>
    </div>
</form>
</body>
</html>