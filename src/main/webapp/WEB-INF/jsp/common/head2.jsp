<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/assert/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/css/main.css">
    <script src="/assert/js/common.js"></script>
    <script>
        $(function () {
            if(getCookie("userName") != null || getCookie("roleName") != null){
            $("#login").html(getCookie("userName"));
            $("#zhuce").html("欢迎您");}
        })
    </script>

</head>

    <div class="container">
        <div class="navbar-header">
            <a href="/traffic/zhuye" class="navbar-brand"></a>
        </div>
        <label id="toggle-label" class="visible-xs-inline-block" for="toggle-checkbox">MENU</label>
        <input class="hidden" id="toggle-checkbox" type="checkbox">
        <div class="hidden-xs">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/traffic/zhonghe">首页</a></li>
                <li><a href="#" id="guonei">国内</a></li>
                <li><a href="#">国际</a></li>
                <li><a href="#">法治</a></li>
                <li><a href="#">社会</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a id="login" href="/traffic/login">登录</a></li>
                <li><a id="zhuce" href="/traffic/signup">注册</a></li>

            </ul>
        </div>
    </div>
