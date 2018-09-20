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
  <meta charset="utf-8"/>
  <title>文物保护修复管理系统</title>
  <%@include file="resources.jsp"%>
</head>

<body>

<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">文物保护修复管理系统</a>
    </div>
    <div class="collapse navbar-collapse navbar-right">
      <ul class="nav navbar-nav">
        <li>
          <a href="${pageContext.request.contextPath}/cultural/">文物基本信息</a>
        </li>
        <%--<li>--%>
          <%--<a href="${pageContext.request.contextPath}/#/">检测分析记录</a>--%>
        <%--</li>--%>

        <c:if test="${sessionScope['user'] != null}">
          <li>
            <a href="${pageContext.request.contextPath}/rprecords/">保护修复记录</a>
          </li>
          <li>
            <a href="${pageContext.request.contextPath}/media/">媒体资源</a>
          </li>
        </c:if>

        <%--<li>--%>
          <%--<a href="${pageContext.request.contextPath}/rprecords/">保护修复记录</a>--%>
        <%--</li>--%>
        <%--<li>--%>
          <%--<a href="${pageContext.request.contextPath}/media/">媒体资源</a>--%>
        <%--</li>--%>
        <c:if test="${sessionScope['user'] != null}">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              个人中心
              <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
              <li>
                <a href="${pageContext.request.contextPath}/user/center">个人资料</a>
              </li>
              <li class="divider"></li>
              <li>
                <a href="${pageContext.request.contextPath}/user/logout">退出登录</a>
              </li>
            </ul>
          </li>
        </c:if>
        <c:if test="${sessionScope['user'] == null}">
          <li>
            <a id="register" data-toggle="modal" data-target="#reg" href=""><span class="glyphicon glyphicon-user"></span> 注册</a>
          </li>
          <li>
            <a id="login" data-toggle="modal" data-target="#log" href=""><span class="glyphicon glyphicon-log-in"></span> 登录</a>
          </li>
        </c:if>

      </ul>
    </div>
  </div>
</nav>

<div id="reg" class="modal fade" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body">
        <button class="close" data-dismiss="modal">
          <span>&times;</span>
        </button>
      </div>
      <div class="modal-title">
        <h1 class="text-center">注册</h1>
      </div>
      <div class="modal-body">
        <form class="form-group" action="${pageContext.request.contextPath}/user/register" method="post">
          <div class="form-group">
            <label for="username">用户名</label>
            <input id="username" name="username" class="form-control" type="text" placeholder="6-15位字母或数字">
          </div>
          <div class="form-group">
            <label for="password">密码</label>
            <input id="password" name="password" class="form-control" type="password" placeholder="至少6位字母或数字">
          </div>
          <div class="form-group">
            <label for="confirmPassword">再次输入密码</label>
            <input id="confirmPassword" name="confirmPassword" class="form-control" type="password" placeholder="至少6位字母或数字">
          </div>
          <div class="form-group">
            <label for="email">邮箱</label>
            <input id="email" name="email" class="form-control" type="email" placeholder="例如:260000000@qq.com">
          </div>
          <div class="form-group">
            <label for="phone">联系方式</label>
            <input id="phone" name="phone" class="form-control" type="tel" placeholder="13000000000">
          </div>
          <div class="form-group">
            <label for="address">联系地址</label>
            <input id="address" name="address" class="form-control" type="text">
          </div>
          <div class="form-group">
            <label for="idcard">身份证号</label>
            <input id="idcard" name="idcard" class="form-control" type="text">
          </div>
          <div class="form-group">
            <label for="post">用户职务</label>
            <input id="post" name="post" class="form-control" type="text">
          </div>
          <div class="form-group">
            <label for="typeid">用户职称</label>
            <input id="typeid" name="typeid" class="form-control" type="text">
          </div>
          <div class="form-group">
            <label for="unit">用户所在单位</label>
            <input id="unit" name="unit" class="form-control" type="text">
          </div>
          <div class="form-group">
            <label for="verifyCode">验证码</label>
            <input id="verifyCode" name="verifyCode" class="form-control" type="text"　placeholder="不区分大小写">
            <div>
              <img id="reg_code" src="${pageContext.request.contextPath}/getVerifyCode" />
              <span style="vertical-align: bottom">点击图片刷新</span>
            </div>
          </div>
          <div class="text-right">
            <button class="btn btn-primary" type="submit">提交</button>
            <button class="btn btn-danger" data-dismiss="modal">取消</button>
          </div>
          <a href="" id="login_href" data-toggle="modal" data-dismiss="modal" data-target="#log">已有账号？点我登录</a>
        </form>
      </div>
    </div>
  </div>
</div>

<!-- 登录窗口 -->
<div id="log" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body">
        <button class="close" data-dismiss="modal">
          <span>&times;</span>
        </button>
      </div>
      <div class="modal-title">
        <h1 class="text-center">登录</h1>
      </div>
      <div class="modal-body">
        <form class="form-group" action="${pageContext.request.contextPath}/user/login" method="post">
          <div class="form-group">
            <label for="user">用户名</label>
            <input id="user" name="username" class="form-control" type="text" placeholder="">
          </div>
          <div class="form-group">
            <label for="pwd">密码</label>
            <input id="pwd" name="password" class="form-control" type="password" placeholder="">
          </div>
          <div class="form-group">
            <label for="code">验证码</label>
            <input id="code" name="verifyCode" class="form-control" type="text" placeholder="不区分大小写">
            <div>
              <img id="login_code" src="${pageContext.request.contextPath}/getVerifyCode" />
              <span style="vertical-align: bottom">点击图片刷新</span>
            </div>
          </div>
          <div class="text-right">
            <button class="btn btn-primary" type="submit">登录</button>
            <button class="btn btn-danger" data-dismiss="modal">取消</button>
          </div>
          <a href="" id="reg_href" data-toggle="modal" data-dismiss="modal" data-target="#reg">还没有账号？点我注册</a>
        </form>
      </div>
    </div>
  </div>
</div>

<div class="container-fluid">
  <div class="row">
    <div class="col-md-12">
      <div id="myCarousel" class="carousel slide" data-ride="carousel" >
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
          <div class="item active">
            <img class="img-rounded" src="${pageContext.request.contextPath}/static/img/1.jpg" alt="First slide"
                 style="height: 550px;width: 100%;"/>
          </div>
          <div class="item">
            <img class="img-rounded" src="${pageContext.request.contextPath}/static/img/2.jpg" alt="Second slide"
                 style="height: 550px;width: 100%;"/>
          </div>
          <div class="item">
            <img class="img-rounded" src="${pageContext.request.contextPath}/static/img/3.jpg" alt="Thired slide"
                 style="height: 550px;width: 100%;"/>
          </div>
        </div>
        <a class="carousel-control left" href="#myCarousel"
           data-slide="prev">&lsaquo;
        </a>
        <a class="carousel-control right" href="#myCarousel"
           data-slide="next">&rsaquo;
        </a>
      </div>
    </div>
  </div>

  <footer>
    <div class="row" style="margin-top: 30px;">
      <div class="col-md-offset-5">
        <ul class="nav navbar-nav">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              联系我们
              <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
              <li><a href="#">电话：DYH</a></li>
              <li><a href="#">地址：DYH</a></li>
              <li><a href="#">QQ：&nbsp; DYH</a></li>
            </ul>
          </li>
          <li><a href="#">加入我们</a></li>
        </ul>
      </div>
    </div>
  </footer>

</div>

<script>
    $(document).ready(function () {
        var reg_code = jQuery("#reg_code");
        var login_code = jQuery("#login_code");

        $("#register").on('click',function(){
            reg_code.attr("src",reg_code.attr("src") + "?a");
        });

        $("#login").on("click",function(){
            login_code.attr("src",login_code.attr("src") + "?b");
        });
        $("#reg_href").on("click",function () {
            reg_code.attr("src",reg_code.attr("src") + "?a");
        });

        $("#login_href").on("click",function () {
            login_code.attr("src",login_code.attr("src") + "?b");
        });

        $("#reg_code").on("click",function(){
            reg_code.attr("src",reg_code.attr("src") + "?a");
        });
        $("#login_code").on("click",function(){
            login_code.attr("src",login_code.attr("src") + "?b");
        });
    });
</script>

</body>
</html>

