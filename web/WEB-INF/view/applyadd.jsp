<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2018/5/15
  Time: 16:38
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
            <a class="navbar-brand"href="${pageContext.request.contextPath}/applyc/">待修申请信息</a>
        </div>
    </div>
</nav>
<div class="modal-title">
    <h1 class="text-center">添加待修申请信息</h1>
</div>
<div class="container" style="height: 100%" style="padding-top: 10px;">
    <form class="form-group" action="${pageContext.request.contextPath}/applyc/applyadd" method="post">
        <div class="form-group">
            <label for="crname">文物名称</label>
            <input id="crname" name="crname" class="form-control" type="text" placeholder="例如：鎏金铜蚕">
        </div>
        <div class="form-group">
            <label for="exname">提取经办人</label>
            <input id="exname" name="exname" class="form-control" type="text" placeholder="">
        </div>
        <div class="form-group">
            <label for="extime">提取时间</label>
            <input id="extime" name="extime" class="form-control" type="date" placeholder="" fmt:dateformat="yyyy-MM-dd">
        </div>
        <div class="form-group">
            <label for="rtname">返还经办人</label>
            <input id="rtname" name="rtname" class="form-control" type="text" placeholder="">
        </div>
        <div class="form-group">
            <label for="rttime">返还时间</label>
            <input id="rttime" name="rttime" class="form-control" type="date" placeholder="" fmt:dateformat="yyyy-MM-dd">
        </div>
        <div class="form-group">
            <label for="rsname">修复方案名称和编号</label>
            <input id="rsname" name="rsname" class="form-control" type="text" placeholder="test 01">
        </div>
        <div class="form-group">
            <label for="apunit">批准单位</label>
            <input id="apunit" name="apunit" class="form-control" type="text" placeholder="">
        </div>
        <div class="form-group">
            <label for="aptime">批准时间</label>
            <input id="aptime" name="aptime" class="form-control" type="date" placeholder="" fmt:dateformat="yyyy-MM-dd">
        </div>
        <div class="form-group">
            <label for="apnum">批准文号</label>
            <input id="apnum" name="apnum" class="form-control" type="text" placeholder="">
        </div>
        <div class="text-right">
            <button class="btn btn-primary" type="submit">提交</button>
            <button class="btn btn-danger" data-dismiss="modal">取消</button>
        </div>
    </form>
</div>
</body>
</html>
