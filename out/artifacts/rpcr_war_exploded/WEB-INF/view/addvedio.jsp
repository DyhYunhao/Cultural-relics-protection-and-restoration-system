<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2018/5/19
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加待修申请</title>
    <%@include file="resources.jsp"%>
</head>
<body>
<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand"href="${pageContext.request.contextPath}/media/">媒体资源列表</a>
        </div>
    </div>
</nav>
<div class="modal-title">
    <h1 class="text-center">添加媒体资源</h1>
</div>
<div class="container" style="height: 100%" style="padding-top: 10px;">
    <form class="form-group" enctype="multipart/form-data" action="${pageContext.request.contextPath}/media/addvedio" method="post">
        <div class="form-group">
            <label for="crname">文物名称</label>
            <input id="crname" name="crname" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="vname">资源名称</label>
            <input id="vname" name="vname" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="mtype">资源类型</label>
            <select id="mtype" name="mtype" class="form-control">
                <option value="1">视频</option>
                <option value="2">3D模型</option>
                <option value="3">图片</option>
            </select>
            <%--<input id="mtype" name="mtype" class="form-control" type="text">--%>
        </div>
        <div class="form-group">
            <label for="video">资源文件</label>
            <input id="video" name="mfile" class="form-control" type="file">
        </div>
        <div class="form-group">
            <label for="mcomment">资源描述</label>
            <input id="mcomment" name="mcomment" class="form-control" type="text" placeholder="">
        </div>
        <div class="text-right">
            <button class="btn btn-primary" type="submit">提交</button>
            <button class="btn btn-danger" data-dismiss="modal">取消</button>
        </div>
    </form>
</div>
</body>
</html>

