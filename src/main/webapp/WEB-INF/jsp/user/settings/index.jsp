<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ezio
  Date: 7/14/2015
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>设置个人信息</title>
  <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
  <link href="/css/page/cus.css" rel="stylesheet" type="text/css" />
  <link href="/css/page/reset.css" rel="stylesheet" type="text/css" />
  <link href="/css/page/style2.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" type="text/css" href="/css/page/settings.css">
  <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
  <script type="text/javascript" src="/js/page/settings.js"></script>
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/">Match Us</a>
      <a class="navbar-brand" href="/view/page/project.html">找项目</a>
      <a class="navbar-brand" href="/view/page/team.html">找团队</a>
      <a class="navbar-brand" href="/view/page/talent.html">找人才</a>
      <a class="navbar-brand" href="/view/page/user.html">个人中心</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#" id="login" data-toggle="modal" data-target="#userlogin">登陆</a></li>
        <li><a href="#" id="sign_in" data-toggle="modal" data-target="#usersignin" onClick="myReload()">注册</a></li>
        <li><a href="#" id="help">帮助</a></li>
      </ul>
      <form class="navbar-form navbar-right">
        <input type="text" class="form-control" placeholder="大牛，项目...">
      </form>
    </div>
  </div>
</nav>
<section class='container'>
  <!-- left side part -->
  <div class="settings-left col-md-3">
    <ul class="wrapped-boxes">
        <li class="active">
        <a href="#">个人资料</a>
      </li>
      <li>
        <a href="#">头像设置</a>
      </li>
      <li>
        <a href="#">邮箱验证</a>
      </li>
      <li>
        <a href="#">修改密码</a>
      </li>
      <li>
        <a href="#">绑定账号</a>
      </li>
    </ul>
  </div>
  <jsp:include page="basic_settings.jsp"/>
</section>
</body>

</html>
