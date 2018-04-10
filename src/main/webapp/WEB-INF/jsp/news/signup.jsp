<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户注册</title>
    <link rel="stylesheet" href="/assert/css/bootstrap.min.css">

    <link rel="stylesheet" href="/assert/css/main.css">
    <script type="text/javascript"
            src="/assert/js/common.js"></script>
    <script type="text/javascript"
            src="/assert/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script src="/assert/js/common.js"></script>
    <script type="text/javascript"
            src="/assert/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="/assert/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css"
          href="/assert/css/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="/assert/css/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript"
            src="/assert/js/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript"
            src="/assert/js/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="/assert/js/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        $(function () {
        $("#submitButtun").click(function() {
            var userName = $("#userName").val();
            var password = $("#password").val();
            var id = $("#userId").val();
            var data = {"id": id, "password": password, "userName": userName}
            console.log(data);
            $.ajax({
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "${pageContext.request.contextPath}/users",//url
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data),
                success: function (result) {
                    console.log(result);//打印服务端返回的数据
                    if (result.resultCode == 200) {
                        $.messager.alert("系统提示", "保存成功");

                        resetValue();
                    }
                    else {
                        $.messager.alert("系统提示", "操作失败");

                        resetValue();
                    }
                    ;
                },
                error: function () {
                    $.messager.alert("系统提示", "操作失败");
                }
            });
        })

        });
    </script>
</head>
<body >

<div class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="/traffic/zhuye" class="navbar-brand"></a>
        </div>
        <label id="toggle-label" class="visible-xs-inline-block" for="toggle-checkbox">MENU</label>
        <input class="hidden" id="toggle-checkbox" type="checkbox">
        <div class="hidden-xs">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">首页</a></li>
                <li><a href="#">国内</a></li>
                <li><a href="#">国际</a></li>
                <li><a href="#">数读</a></li>
                <li><a href="#">社会</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="login.html">登录</a></li>
                <li><a href="signup.html">注册</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container container-small">
    <h1>注册
        <small>没有账号？<a href="/traffic/signup">注册</a></small>
    </h1>
    <form id="zhuceForm" >
        <div class="form-group" style="display: none" >
            <label>id</label>
            <input type="text" id="userId" name="userId" class="form-control" value="0">
        </div>
        <div class="form-group" style="display: none" >
            <label>roleName</label>
            <input type="text" id="roleName" name="roleName" class="form-control" value="普通用户">
        </div>
        <div class="form-group">
            <label>账号</label>
            <input type="text" id="userName" name="userName" class="form-control">
        </div>
        <div class="form-group">
            <label>密码</label>
            <input type="password" id="password" name="password" class="form-control">
        </div>
        <div class="form-group">
            <div id="submitButtun" class="btn btn-default">注册</div>
            <%--<button class="btn btn-primary btn-block" id="zhuceButton" onclick="saveUser()">注册</button>--%>
        </div>
        <div class="form-group">
            注册闪闪头条即代表您同意<a href="#">闪闪头条服务条款</a>
        </div>
    </form>
</div>


<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
</body>
</html>