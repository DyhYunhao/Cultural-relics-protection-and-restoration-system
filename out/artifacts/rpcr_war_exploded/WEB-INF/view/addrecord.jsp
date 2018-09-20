<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2018/5/16
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加修复记录</title>
    <%@include file="resources.jsp"%>
</head>
<body>
<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand"href="${pageContext.request.contextPath}/rprecords/">历史记录</a>
        </div>
    </div>
</nav>
<div class="modal-title">
    <h1 class="text-center">添加历史修复记录</h1>
</div>
<div class="container" style="height: 100%" style="padding-top: 10px;">
    <form class="form-group" action="${pageContext.request.contextPath}/rprecords/addrecord" enctype="multipart/form-data" method="post">
        <div class="form-group">
            <label for="crname">文物名称</label>
            <input id="crname" name="crname" class="form-control" type="text" placeholder="例如：鎏金铜蚕">
        </div>
        <div class="form-group">
            <label for="bssize">修复前文物尺寸</label>
            <input id="bssize" name="bssize" class="form-control" type="text" placeholder="">
        </div>
        <div class="form-group">
            <label for="bsweight">修复前文物重量(kg)</label>
            <input id="bsweight" name="bsweight" class="form-control" type="number" step="0.01" placeholder="0.00">
        </div>
        <div class="form-group">
            <label for="bspicture">修复前文物外观</label>
            <input id="bspicture" name="file1" class="form-control" type="file">
        </div>
        <div class="form-group">
            <label for="bssave">修复前埋藏及保存环境</label>
            <input id="bssave" name="bssave" class="form-control" type="text" placeholder="">
        </div>
        <div class="form-group">
            <label for="disde">病害描述</label>
            <input id="disde" name="disde" class="form-control" type="text" placeholder="">
        </div>
        <div class="form-group">
            <label for="dispic">病害图片</label>
            <input id="dispic" name="file2" class="form-control" type="file">
        </div>
        <div class="form-group">
            <label for="assize">修复后文物尺寸</label>
            <input id="assize" name="assize" class="form-control" type="text" placeholder="">
        </div>
        <div class="form-group">
            <label for="asweight">修复后文物重量(kg)</label>
            <input id="asweight" name="asweight" class="form-control" type="number" step="0.01" placeholder="0.00">
        </div>
        <div class="form-group">
            <label for="aspicture">修复后文物外观</label>
            <input id="aspicture" name="file3" class="form-control" type="file">
        </div>
        <div class="form-group">
            <label for="assave">保存条件和建议</label>
            <input id="assave" name="assave" class="form-control" type="text" placeholder="">
        </div>
        <div class="form-group">
            <label for="astime">修复完成日期</label>
            <input id="astime" name="astime" class="form-control" type="date" placeholder="" fmt:dateformat="yyyy-MM-dd">
        </div>
        <div class="text-right">
            <button class="btn btn-primary" type="submit">提交</button>
            <button class="btn btn-danger" data-dismiss="modal">取消</button>
        </div>
    </form>
</div>
</body>
</html>
