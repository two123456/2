<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>登陆界面2</title>
    <link href="/netctoos/static/layui/css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="/netctoos/static/js/jQuery1.7.js"></script>
    <script type="text/javascript" src="/netctoos/static/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="/netctoos/static/js/jquery1.42.min.js"></script>
    <script type="text/javascript" src="/netctoos/static/js/jquery.SuperSlide.js"></script>
    <script type="text/javascript" src="/netctoos/static/js/Validform_v5.3.2_min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            var $tab_li = $('#tab ul li');
            $tab_li.hover(function(){
                $(this).addClass('selected').siblings().removeClass('selected');
                var index = $tab_li.index(this);
                $('div.tab_box > div').eq(index).show().siblings().hide();
            });
        });
    </script>
    <script type="text/javascript">
        $(function(){
            /*账号登录信息验证*/
            $("#stu_username_hide").focus(function(){
                var username = $(this).val();
                if(username=='输入账号'){
                    $(this).val('');
                }
            });
            $("#stu_password_hide").focus(function(){
                var username = $(this).val();
                if(username=='输入密码'){
                    $(this).val('');
                }
            });
            $("#stu_password_hide").focusout(function(){
                var username = $(this).val();
                if(username==''){
                    $(this).val('输入密码');
                }
            });
            $("#stu_code_hide").focus(function(){
                var username = $(this).val();
                if(username=='输入验证码'){
                    $(this).val('');
                }
            });
            $("#stu_code_hide").focusout(function(){
                var username = $(this).val();
                if(username==''){
                    $(this).val('输入验证码');
                }
            });
            $(".stu_login_error").Validform({
                tiptype:function(msg,o,cssctl){
                    var objtip=$(".stu_error_box");
                    cssctl(objtip,o.type);
                    objtip.text(msg);
                },
                ajaxPost:true
            });
            /*手机登录信息验证*/
            $("#tea_username_hide").focus(function(){
                var phone = $(this).val();
                if(phone=='输入手机号'){
                    $(this).val('');
                }
            });
            $("#tea_code_hide").focusout(function(){
                var phonecode = $(this).val();
                if(phonecode==''){
                    $(this).val('输入验证码');
                }
            });
            $(".tea_login_error").Validform({
                tiptype:function(msg,o,cssctl){
                    var objtip=$(".tea_error_box");
                    cssctl(objtip,o.type);
                    objtip.text(msg);
                },
                ajaxPost:true
            });
        });
    </script>
    <script type="text/javascript">
        $(function(){
            $(".screenbg ul li").each(function(){
                $(this).css("opacity","0");
            });
            $(".screenbg ul li:first").css("opacity","1");
            var index = 0;
            var t;
            var li = $(".screenbg ul li");
            var number = li.size();
            function change(index){
                li.css("visibility","visible");
                li.eq(index).siblings().animate({opacity:0},3000);
                li.eq(index).animate({opacity:1},3000);
            }
            function show(){
                index = index + 1;
                if(index<=number-1){
                    change(index);
                }else{
                    index = 0;
                    change(index);
                }
            }
            t = setInterval(show,8000);
            //根据窗口宽度生成图片宽度
            var width = $(window).width();
            $(".screenbg ul img").css("width",width+"px");
        });
    </script>
</head>

<body>
<div id="tab">
    <ul class="tab_menu">
        <li class="selected">账户密码登录</li>
        <li>手机号登录</li>
    </ul>
    <div class="tab_box">
        <!-- 账户密码登录开始 -->
        <div>
            <div class="stu_error_box"></div>
            <form action="" method="post" class="stu_login_error">
                <div id="username">
                    <label>账&nbsp;&nbsp;&nbsp;号：</label>
                    <input type="text" id="stu_username_hide" name="username" value="账号" nullmsg="帐号不能为空！" datatype="s6-18" errormsg="帐号范围在6~18个字符之间！" sucmsg="账号号验证通过！"/>
                    <!--ajaxurl="demo/valid.jsp"-->
                </div>
                <div id="password">
                    <label>密&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="password" id="stu_password_hide" name="password" value="输入密码" nullmsg="密码不能为空！" datatype="*6-16" errormsg="密码范围在6~16位之间！" sucmsg="密码验证通过！"/>
                </div>
                <div id="code">
                    <label>验证码：</label>
                    <input type="text" id="stu_code_hide" name="code"  value="输入验证码" nullmsg="验证码不能为空！" datatype="*4-4" errormsg="验证码有4位数！" sucmsg="验证码验证通过！"/>
                    <img src="/netctoos/static/img/captcha.jpg" title="点击更换" alt="验证码占位图"/> </div>
                <div id="remember">
                    <input type="checkbox" name="remember">
                    <label>记住密码</label>
                </div>
                <div id="login">
                    <button type="submit">登录</button>
                </div>
            </form>
        </div>
        <!-- 账户密码登录结束-->
        <!-- 手机号登录开始-->
        <div class="hide">
            <div class="tea_error_box"></div>
            <form action="" method="post" class="tea_login_error">
                <div id="phone">
                    <label>手机号：</label>
                    <input type="text" id="tea_username_hide" name="username" value="输入手机号" nullmsg="手机号不能为空！" datatype="s11-11" errormsg="手机号为11位！" sucmsg="教工号验证通过！"/>
                    <!--ajaxurl="demo/valid.jsp"-->
                </div>
                <div id="phonecode">
                    <label>验证码：</label>
                    <input type="password" id="tea_password_hide" name="password" value="输入密码" nullmsg="密码不能为空！" datatype="*6-6" errormsg="验证码范围为6位！" sucmsg="密码验证通过！"style="width: 62px"/>
                    <button style="width: 135px;font-size: 1px">获取验证码</button>
                </div>
                <div id="phonelogin">
                    <button type="submit">登录</button>
                </div>
            </form>
        </div>
        <!-- 手机号登录结束-->
    </div>
</div>
<div class="bottom">©2018 NETCTOSS <a href="javascript:;" target="_blank">关于</a> <span>川ICP证088888号</span>  More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">lovo</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">登陆系统</a><img width="13" height="16" src="../static/img/copy_rignt_24.png" /></div>
<div class="screenbg">
    <ul>
        <li><a href="javascript:;"><img src="../static/img/0.jpg"></a></li>
        <li><a href="javascript:;"><img src="../static/img/1.jpg"></a></li>
        <li><a href="javascript:;"><img src="../static/img/2.jpg"></a></li>
    </ul>
</div>
</body>
</html>