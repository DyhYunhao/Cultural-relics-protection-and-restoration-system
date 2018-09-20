<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2018/4/9
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>用户详情</title>
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

<div class="container" style="height: 100%" style="padding-top: 10px;">
    <div class="panel panel-default">
        <div class="panel-heading">
            <p class="lead">个人信息</p>
        </div>
        <div class="panel-body">
            <p class="lead">用户名&nbsp;  ： ${users['username']}</p>
            <p class="lead">常用邮箱 ： ${users['email']}</p>
            <p class="lead">联系方式 ： ${users['phone']}</p>
            <p class="lead">联系地址 ： ${users['address']}</p>
            <p class="lead">身份证号 ： ${users['idcard']}</p>
            <p class="lead">现任职务 ： ${users['post']}</p>
            <p class="lead">现任职称 ： ${users['typeid']}</p>
            <p class="lead">所在单位 ： ${users['unit']}</p
            <p class="lead">上次登陆时间 ： ${ltime}</p>
            <p class="lead">上次登陆IP ： ${ip}</p>
        </div>
        <div class="text-right">
            <a href="${pageContext.request.contextPath}/user/update">修改个人信息</a>
            <c:if test="${users['type'] == 1}">
                <a href="${pageContext.request.contextPath}/user/backup">数据库备份</a>
                <a href="${pageContext.request.contextPath}/user/restore">数据库还原</a>
            </c:if>

        </div>

    </div>


    <%@include file="footer.jsp"%>
</div>

</body>
</html>




















