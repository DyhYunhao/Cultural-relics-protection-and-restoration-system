<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2018/5/19
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>媒体资源列表</title>
    <%@include file="resources.jsp"%>
</head>
<body>
<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand"href="${pageContext.request.contextPath}/">文物保护修复管理系统</a>
        </div>
        <div class="collapse navbar-collapse navbar-right">
            <ul class="nav navbar-nav">
                <li>
                    <a class="link" href="${pageContext.request.contextPath}/media/addvedio">添加媒体资源</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="table-responsive">
    <table class="table">
        <thead>
        <tr>
            <th>文物名称</th>
            <th>资源名称</th>
            <th>资源描述</th>
            <th>资源类型</th>
            <th>资源展示</th>
            <th>资源删除</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" items="${medialist}">
            <tr>
                <td>${i['crname']}</td>
                <td>${i['vname']}</td>
                <td>${i['mcomment']}</td>
                <c:if test="${i['mtype'] == 1}">
                    <td>视频</td>
                </c:if>
                <c:if test="${i['mtype'] == 2}">
                    <td>3D模型</td>
                </c:if>
                <c:if test="${i['mtype'] == 3}">
                    <td>图片</td>
                </c:if>
                <td><a href="/media/play/${i['mid']}">展示</a></td>
                <td><a href="/media/del/${i['mid']}">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation">
        <ul class="pagination">

            <%--当前页为第一页就禁用按钮--%>
            <li <c:if test="${curPos <= 1}">class="disabled" </c:if> >　
                <a href="${pageContext.request.contextPath}/media/page/${curPos-1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

            <c:forEach var="cur" begin="${begin}" end="${end}">
                <li <c:if test="${cur == curPos}">class="active" </c:if> >
                    <a href="${pageContext.request.contextPath}/media/page/${cur}">${cur}</a>
                </li>
            </c:forEach>

            <%--当前页为最后一页就禁用按钮--%>
            <li <c:if test="${curPos >= maxPage}">class="disabled" </c:if>>
                <a href="${pageContext.request.contextPath}/media/page/${curPos+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
<%@include file="footer.jsp"%>
</body>
</html>

