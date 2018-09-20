<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2018/4/21
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>待修申请信息</title>
    <%@include file="resources.jsp"%>
</head>
<body>
<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand"href="${pageContext.request.contextPath}/cultural/">文物基本信息</a>
        </div>
        <div class="collapse navbar-collapse navbar-right">
            <ul class="nav navbar-nav">
                <li>
                    <a class="link" href="${pageContext.request.contextPath}/applyc/applyadd">添加申请</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="table-responsive">
    <table class="table">
        <thead>
        <tr>
            <th>待修文物名</th>
            <th>提取经办人</th>
            <th>提取时间</th>
            <th>返还经办人</th>
            <th>返还时间</th>
            <th>修复方案名称编号</th>
            <th>批准单位</th>
            <th>批准时间</th>
            <th>批准文号</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" items="${applylist}">
            <tr>
                <td>${i['crname']}</td>
                <td>${i['exname']}</td>
                <td>${i['extime']}</td>
                <td>${i['rtname']}</td>
                <td>${i['rttime']}</td>
                <td>${i['rsname']}</td>
                <td>${i['apunit']}</td>
                <td>${i['aptime']}</td>
                <td>${i['apnum']}</td>
                <td><a href="/applyc/del/${i['aid']}">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation">
        <ul class="pagination">

            <%--当前页为第一页就禁用按钮--%>
            <li <c:if test="${curPos <= 1}">class="disabled" </c:if> >　
                <a href="${pageContext.request.contextPath}/applyc/page/${curPos-1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

            <c:forEach var="cur" begin="${begin}" end="${end}">
                <li <c:if test="${cur == curPos}">class="active" </c:if> >
                    <a href="${pageContext.request.contextPath}/applyc/page/${cur}">${cur}</a>
                </li>
            </c:forEach>

            <%--当前页为最后一页就禁用按钮--%>
            <li <c:if test="${curPos >= maxPage}">class="disabled" </c:if>>
                <a href="${pageContext.request.contextPath}/applyc/page/${curPos+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
