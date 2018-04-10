<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>二维码</title>
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
    <link rel="stylesheet" href="/assert/kindeditor-4.1.10/themes/default/default.css"/>
    <script charset="utf-8" src="/assert/kindeditor-4.1.10/kindeditor-all.js"></script>
    <script charset="utf-8" src="/assert/kindeditor-4.1.10/lang/zh_CN.js"></script>
</head>
<body  onload="getArticle()">
<div class="navbar navbar-default">
    <%@include file="/WEB-INF/jsp/common/head2.jsp"%>
</div>
<div class="container">
    <img src="/assert/img/2wei.png" alt="" style="margin: 0 auto;">
</div>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
</body>
</html>
