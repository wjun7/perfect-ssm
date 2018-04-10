<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>主页</title>
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
    <script>getCookie("userName");console.log(getCookie("userName"))</script>
</head>

<body>
<div class="navbar navbar-default">
    <%@include file="/WEB-INF/jsp/common/head2.jsp" %>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-2">
            <div class="hidden-xs list-group side-bar">
                <a href="/traffic/zhonghe/" class="list-group-item active">首页</a>
                <a href="/traffic/zhuye/" class="list-group-item">交通知识</a>
                <a href="/traffic/con/" class="list-group-item">标识库</a>
                <a href="#" class="list-group-item">视频案例</a>
                <a href="/traffic/liuyanban/" class="list-group-item">留言板</a>
                <a href="/traffic/erweima/" class="list-group-item">二维码</a>
                <a href="#" class="list-group-item">关于我们</a>
            </div>
        </div>
        <div class="col-sm-7">
            <div class="news-list">
                <c:forEach var="a" items="${articleList}">
                    <div class="news-list-item clearfix">
                        <div class="col-xs-5">
                            <img src="/assert/img/002.jpg">
                        </div>
                        <div class="col-xs-7">
                            <a href="http://localhost:8080/article.jsp?id=${a.id}" class="title">${a.articleTitle}</a>
                            <div class="info">
                                <span><span class="avatar"><img
                                        src="/assert/img/logo.jpg"></span>${a.articleTitle}</span> ⋅
                                <span>25k评论</span>
                                <span>10分钟前</span>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="search-bar">
                <input type="search" class="form-control" placeholder="搜一下">
            </div>
            <div class="side-bar-card flag clearfix">
                <div class="col-xs-5">
                    <img src="/assert/img/1-1.png">
                </div>
                <div class="col-xs-7">
                    <div class="text-lg">有害信息举报专区</div>
                    <div>举报电话：12377</div>
                </div>
            </div>
            <div class="side-bar-card">
                <div class="card-title">24小时热闻</div>
                <div class="card-body">
                    <div class="list">
                        <div class="item">
                            <div class="title">Lorem ipsum dolor sit amet, consectetur adipisicing</div>
                            <div class="desc">15k阅读 1k评论</div>
                        </div>
                        <div class="item">
                            <div class="title">Lorem ipsum dolor sit amet, consectetur adipisicing</div>
                            <div class="desc">15k阅读 1k评论</div>
                        </div>
                        <div class="item">
                            <div class="title">Lorem ipsum dolor sit amet, consectetur adipisicing</div>
                            <div class="desc">15k阅读 1k评论</div>
                        </div>
                        <div class="item">
                            <div class="title">Lorem ipsum dolor sit amet, consectetur adipisicing</div>
                            <div class="desc">15k阅读 1k评论</div>
                        </div>
                        <div class="item">
                            <div class="title">Lorem ipsum dolor sit amet, consectetur adipisicing</div>
                            <div class="desc">15k阅读 1k评论</div>
                        </div>
                        <div class="item">
                            <div class="title">Lorem ipsum dolor sit amet, consectetur adipisicing</div>
                            <div class="desc">15k阅读 1k评论</div>
                        </div>
                        <div class="item">
                            <div class="title">Lorem ipsum dolor sit amet, consectetur adipisicing</div>
                            <div class="desc">15k阅读 1k评论</div>
                        </div>
                        <div class="item">
                            <div class="title">Lorem ipsum dolor sit amet, consectetur adipisicing</div>
                            <div class="desc">15k阅读 1k评论</div>
                        </div>
                        <div class="item">
                            <div class="title">Lorem ipsum dolor sit amet, consectetur adipisicing</div>
                            <div class="desc">15k阅读 1k评论</div>
                        </div>
                        <div class="item">
                            <div class="title">Lorem ipsum dolor sit amet, consectetur adipisicing</div>
                            <div class="desc">15k阅读 1k评论</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
</body>
</html>

