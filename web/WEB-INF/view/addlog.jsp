<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2018/5/18
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加修复日志</title>
    <%@include file="resources.jsp"%>
</head>
<body>
<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand"href="${pageContext.request.contextPath}/rprecords/">历史修复记录</a>
        </div>
    </div>
</nav>
<div class="modal-title">
    <h1 class="text-center">添加修复日志</h1>
</div>
<div class="container" style="height: 100%" style="padding-top: 10px;">
    <form class="form-group" action="${pageContext.request.contextPath}/repairlog/addlog/" method="post">
        <div class="form-group">
            <label for="rlpep">修复人员</label>
            <input id="rlpep" name="rlpep" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="rltime">修复日期</label>
            <input id="rltime" name="rltime" class="form-control" type="date" placeholder="" fmt:dateformat="yyyy-MM-dd">
        </div>
        <div class="form-group">
            <label for="rlpls">修复地点</label>
            <input id="rlpls" name="rlpls" class="form-control" type="text" placeholder="">
        </div>
        <div class="form-group">
            <label for="rltool">修复材料和工具</label>
            <input id="rltool" name="rltool" class="form-control" type="text" placeholder="">
        </div>
        <div class="form-group">
            <label for="rldecon">工作内容简述</label>
            <input id="rldecon" name="rldecon" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="rlchange">技术变更原因和变更方案</label>
            <input id="rlchange" name="rlchange" class="form-control" type="text" placeholder="">
        </div>
        <div class="form-group">
            <label for="rlctime">技术变更时间</label>
            <input id="rlctime" name="rlctime" class="form-control" type="date" placeholder="" fmt:dateformat="yyyy-MM-dd">
        </div>
        <div class="form-group">
            <label for="rlcname">变更提出人</label>
            <input id="rlcname" name="rlcname" class="form-control" type="text" placeholder="">
        </div>
        <div class="text-right">
            <button class="btn btn-primary" type="submit">提交</button>
            <button class="btn btn-danger" data-dismiss="modal">取消</button>
        </div>
    </form>
</div>
</body>
</html>

