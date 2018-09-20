<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2018/5/18
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>修复日志</title>
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

<div class="table-responsive">
    <table class="table">
        <thead>
        <tr>
            <th>修复人员</th>
            <th>修复日期</th>
            <th>修复地点</th>
            <th>修复材料和工具</th>
            <th>工作内荣简述</th>
            <th>技术变更原因和方案</th>
            <th>变更提出人</th>
            <th>技术变更时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" items="${repairloglist}">
            <tr>
                <td>${i['rlpep']}</td>
                <td>${i['rltime']}</td>
                <td>${i['rlpls']}</td>
                <td>${i['rltool']}</td>
                <td>${i['rldecon']}</td>
                <td>${i['rlchange']}</td>
                <td>${i['rlcname']}</td>
                <td>${i['rlctime']}</td>
                <td><a href="/repairlog/del/${i['rlid']}">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
