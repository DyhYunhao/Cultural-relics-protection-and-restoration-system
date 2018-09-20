<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2018/5/9
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人资料</title>
    <%@include file="resources.jsp"%>
</head>
<body>
    <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand"href="${pageContext.request.contextPath}/">文物保护修复管理系统</a>
            </div>
            <div class="navbar-right">
                <a class="navbar-brand">By DYH</a>
            </div>
        </div>
    </nav>
    <div class="modal-title">
        <h1 class="text-center">修改个人资料</h1>
    </div>
    <div class="container" style="height: 100%" style="padding-top: 10px;">
    <form class="form-group" action="${pageContext.request.contextPath}/user/affupdate" method="post">
        <div class="form-group">
            <label for="email">邮箱</label>
            <input id="email" name="email" class="form-control" type="tel" value=${usersp['email']}>
        </div>
        <div class="form-group">
            <label for="phone">联系方式</label>
            <input id="phone" name="phone" class="form-control" type="tel" value=${usersp['phone']}>
        </div>
        <div class="form-group">
            <label for="address">联系地址</label>
            <input id="address" name="address" class="form-control" type="text" value=${usersp['address']}>
        </div>
        <div class="form-group">
            <label for="idcard">身份证号</label>
            <input id="idcard" name="idcard" class="form-control" type="number" value=${usersp['idcard']}>
        </div>
        <div class="form-group">
            <label for="post">用户职务</label>
            <input id="post" name="post" class="form-control" type="text" value=${usersp['post']}>
        </div>
        <div class="form-group">
            <label for="typeid">用户职称</label>
            <input id="typeid" name="typeid" class="form-control" type="text" value=${usersp['typeid']}>
        </div>
        <div class="form-group">
            <label for="unit">用户所在单位</label>
            <input id="unit" name="unit" class="form-control" type="text" value=${usersp['unit']}>
        </div>
        <div class="text-right">
            <button class="btn btn-primary" type="submit">保存</button>
            <button class="btn btn-danger" data-dismiss="modal">取消</button>
        </div>
    </form>
</div>
</body>
</html>
