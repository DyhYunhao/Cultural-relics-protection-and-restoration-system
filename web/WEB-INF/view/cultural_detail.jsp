<%--
  Created by IntelliJ IDEA.
  User: dyh
  Date: 2018/4/21
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>文物详情</title>
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

<div class="container" style="height: 100%" style="padding-top: 10px;">
<div class="panel panel-default">
<div class="panel-heading">
<p class="lead">文物信息</p>
</div>
<div class="panel-body">
<p class="lead">文物名称 ： ${news['crname']}</p>
<p class="lead">文物登录号 ： ${news['crnum']}</p>
<p class="lead">文物材质 ： ${news['crmeq']}</p>
<p class="lead">文物时代 ： ${news['crtimes']}</p>
<p class="lead">文物级别 ： ${news['crlevel']}</p>
<p class="lead">文物收藏单位 ： ${news['crhouse']}</p>
<p class="lead">文物来源 ： ${news['crcome']}</p>
<p class="lead">文物完残情况 ： ${news['crcom']}</p>
</div>
    <footer>
        <form action="/cultural/detail/del" method="post">
            <input class="hidden" type="text" name="id" value=${news['crid']}>
            <input class="button" value="删除" type="submit">
        </form>
    </footer>

</div>


<%@include file="footer.jsp"%>
</div>

</body>
</html>
