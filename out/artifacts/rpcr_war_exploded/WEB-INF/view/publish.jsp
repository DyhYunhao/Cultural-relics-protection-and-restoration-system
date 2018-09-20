<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2018/4/21
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="footer.jsp"%>
</div>

</body>
</html>

<html>
<head>
    <title>添加文物信息</title>
    <%@include file="resources.jsp"%>
</head>
<body>
<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand"href="${pageContext.request.contextPath}/cultural/">&lt;&lt;返回</a>
        </div>
    </div>
</nav>
<div class="modal-title">
    <h1 class="text-center">添加文物信息</h1>
</div>
<div class="container" style="height: 100%" style="padding-top: 10px;">
    <form class="form-group" action="${pageContext.request.contextPath}/cultural/publish" method="post">
        <div class="form-group">
            <label for="crname">文物名称</label>
            <input id="crname" name="crname" class="form-control" type="text" placeholder="例如：鎏金铜蚕">
        </div>
        <div class="form-group">
            <label for="crnum">文物登录号</label>
            <input id="crnum" name="crnum" class="form-control" type="text" placeholder="">
        </div>
        <div class="form-group">
            <label for="crmeq">文物材质</label>
            <input id="crmeq" name="crmeq" class="form-control" type="text" placeholder="">
        </div>
        <div class="form-group">
            <label for="crtimes">文物时代</label>
            <input id="crtimes" name="crtimes" class="form-control" type="text" placeholder="">
        </div>
        <div class="form-group">
            <label for="crlevel">文物级别</label>
            <input id="crlevel" name="crlevel" class="form-control" type="number" placeholder="1，2，3">
        </div>
        <div class="form-group">
            <label for="crhouse">文物收藏单位</label>
            <input id="crhouse" name="crhouse" class="form-control" type="text" placeholder="">
        </div>
        <div class="form-group">
            <label for="crcome">文物来源</label>
            <input id="crcome" name="crcome" class="form-control" type="text" placeholder="">
        </div>
        <div class="form-group">
            <label for="crcom">文物完残情况</label>
            <input id="crcom" name="crcom" class="form-control" type="text" placeholder="完整或残缺">
        </div>
        <div class="text-right">
            <button class="btn btn-primary" type="submit">提交</button>
            <button class="btn btn-danger" data-dismiss="modal">取消</button>
        </div>
    </form>
</div>
</body>
</html>

