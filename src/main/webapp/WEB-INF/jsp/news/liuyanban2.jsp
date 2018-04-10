<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>留言板</title>
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
    <script>
        var url = "${pageContext.request.contextPath}/messages";

        $(function () {

            //详情编辑器
            KindEditor.ready(function (K) {
//                $("#addName").val(getCookie("userName"));
                this.editor
                    = K.create('textarea[id="editor"]', {
                    items: ['source', '|', 'undo', 'redo', '|', 'preview', 'print', 'template', 'code', 'cut', 'copy', 'paste',
                        'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                        'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                        'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
                        'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                        'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'multiimage',
                        'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
                        'anchor', 'link', 'unlink'],
                    uploadJson: '/images',
                    filePostName: 'file',
                    fileManagerJson: '/images',
                    allowFileManager: true
                });
            });

            $("#submitButtun").click(function(){
                console.log('test')
                var addName = $("#addName").val();
                var content = editor.html();
                var id = $("#messageIdfm").val();
                var data = {"id": id,"messageContent": content, "addName": addName}
                $.ajax({
                    type: 'POST',
                    dataType: "json",
                    url: "${pageContext.request.contextPath}/messages",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(data)
                });
            });

        });



    </script>
</head>
<body>
<div class="navbar navbar-default">
    <%@include file="/WEB-INF/jsp/common/head2.jsp"%>
</div>

<div class="container">
<div class="row">
<c:forEach var="a" items="${messageList}">
    <div class="panel panel-default">
        <div class="panel-heading">
               评论人：${a.addName}
        </div>
        <div class="panel-body">
                ${a.messageContent}
        </div>
    </div>
</c:forEach>

    <form id="form1" class="form-horizontal" role="form" >

        <div class="form-group">
            <label for="addName" class="col-sm-2 control-label">用户</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="addName">
            </div>
        </div>
        <div class="form-group">
            <label for="editor" class="col-sm-2 control-label">留言</label>
            <div class="col-sm-10">
                <textarea id="editor" name="message" rows="8" cols="100" style="width: 700px;height: 200px;visibility: hidden;"></textarea>
            </div>
        </div>
        <input  class="form-control"  type="hidden" name="id" id="messageIdfm" value="0" >
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <%--<button type="submit" id="submitButtun" class="btn btn-default">提交</button>--%>
                <div id="submitButtun" class="btn btn-default">提交</div>
            </div>
        </div>
    </form>


</div>
</div>
<%@include file="/WEB-INF/jsp/common/foot.jsp"%>
</body>
</html>
