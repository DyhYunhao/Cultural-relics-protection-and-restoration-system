<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2018/5/16
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>历史记录详情</title>
    <%@include file="resources.jsp"%>
</head>
<body>
<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand"href="${pageContext.request.contextPath}/rprecords/">&lt;&lt;返回</a>
        </div>
    </div>
</nav>

<div class="container" style="height: 100%" style="padding-top: 10px;">
    <div class="panel panel-default">
        <div class="panel-heading">
            <p class="lead">历史记录详情</p>
        </div>
        <div class="panel-body">
            <p class="lead">修复文物名 ： ${news['crname']}</p>
            <p class="lead">修复前文物尺寸： ${news['bssize']}</p>
            <p class="lead">修复前文物重量(kg) ： ${news['bsweight']}</p>
            <p class="lead">修复前文物外观 ：<img src="${news['bspicture']}"  class="img-thumbnail" alt="Cinque Terre" width="304" height="236"></p>
            <p class="lead">修复前埋藏及保存环境 ： ${news['bssave']}</p>
            <p class="lead">病害描述 ： ${news['disde']}</p>
            <p class="lead">病害图片 ： <img src="${news['dispic']}"  class="img-thumbnail" alt="Cinque Terre" width="304" height="236"></p>
            <p class="lead">修复后文物尺寸 ： ${news['assize']}</p>
            <p class="lead">修复后文物重量(kg) ： ${news['asweight']}</p>
            <p class="lead">修复后文物外观 ：<img src="${news['aspicture']}"  class="img-thumbnail" alt="Cinque Terre" width="304" height="236"></p>
            <p class="lead">保存条件和建议 ： ${news['assave']}</p>
            <p class="lead">修复完成日期 ：<fmt:formatDate pattern="yyyy-MM-dd" value="${news['astime']}"/> </p>
            <p class="lead"> <a href="${pageContext.request.contextPath}/repairlog/detail/${news['rpid']}">修复日志详情</a></p>
            <p class="lead"> <a href="${pageContext.request.contextPath}/repairlog/addlog/${news['rpid']}">添加修复日志</a></p>
        </div>
        <footer>
            <form action="/rprecords/detail/del" method="post">
                <input class="hidden" type="text" name="id" value=${news['rpid']}>
                <input class="button" value="删除" type="submit">
            </form>
        </footer>

    </div>


    <%@include file="footer.jsp"%>
</div>

</body>
</html>

