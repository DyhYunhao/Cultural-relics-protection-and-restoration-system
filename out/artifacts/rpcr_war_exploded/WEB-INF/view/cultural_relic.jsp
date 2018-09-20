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
    <title>文物基本信息</title>
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
<a class="link" href="${pageContext.request.contextPath}/cultural/publish">文物添加</a>
</li>
<li>
<a class="link" href="${pageContext.request.contextPath}/applyc/">待修申请</a>
</li>
<li>
<form class="form-search">
<input type="text" class="input-medium search-query">
<button type="submit" class="btn">搜索</button>
</form>
</li>
</ul>
</div>

</div>
</nav>
<div class="container">

    <div class="row">

        <div class="">

        </div>

        <c:forEach var="i" items="${list}">
            <div class="panel panel-default">
                <div class="panel-body">
                    <a class="link" href="${pageContext.request.contextPath}/cultural/detail/${i['crid']}">${i['crname']}</a>
                    <p style="float: right; margin: 0;">登录号：${i['crnum']}</p>
                </div>
            </div>
        </c:forEach>

        <nav aria-label="Page navigation">
            <ul class="pagination">

                <%--当前页为第一页就禁用按钮--%>
                <li <c:if test="${curPos <= 1}">class="disabled" </c:if> >　
                    <a href="${pageContext.request.contextPath}/cultural/page/${curPos-1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>

                <c:forEach var="cur" begin="${begin}" end="${end}">
                    <li <c:if test="${cur == curPos}">class="active" </c:if> >
                        <a href="${pageContext.request.contextPath}/cultural/page/${cur}">${cur}</a>
                    </li>
                </c:forEach>

                <%--当前页为最后一页就禁用按钮--%>
                <li <c:if test="${curPos >= maxPage}">class="disabled" </c:if>>
                    <a href="${pageContext.request.contextPath}/cultural/page/${curPos+1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>


    <%@include file="footer.jsp"%>
</div>

</body>
</html>
