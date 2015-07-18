<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="icon" href="../../favicon.ico">

  <title>${project.pname}</title>

  <!-- Bootstrap core CSS -->
  <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/css/page/reset.css" rel="stylesheet" type="text/css">
  <link href="/css/page/projectInfo.css" rel="stylesheet" type="text/css">
  <link href="/css/page/commonHeader.css" rel="stylesheet" type="text/css">
  <link href="/css/page/commonFooter.css" rel="stylesheet" type="text/css">

  <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
  <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
  <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body>

<jsp:include page="../../commonHeader.jsp"/>

<div class="container">

  <div class="project-header">
    <div class="row">
      <h1 class="project-title">
      ${project.pname}

      </h1>
      <span class="project-description name_popover">
        ${project.starttime} by
          <a href="http:\\Github.com"> ${project.publisher.username}</a>
      </span>
    </div>
  </div>

  <hr class="featurette-divider" style=" margin: 80px 0">

  <div class="row">

    <div class="col-sm-8 project-main">

      <div class="project-post">
        <h2 class="project-post-title">项目描述：</h2>
        <hr>
        <p>${project.pinstruction}</p>
        <br>
        <br>
        <br>
        <h2 class="project-post-title">项目报酬：</h2>
        <hr>
        <p>${project.reward}</p>
        <br>
        <br>
        <br>
        <h2 class="project-post-title">联系方式：</h2>
        <hr>
        <p><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> <a href="http://cristph@foxmail.com"> ${project.email}</a></p>
        <br>
        <p><span class="glyphicon glyphicon-phone" aria-hidden="true"></span> ${project.phonenumber}</p>
      </div><!-- /.project-post -->

      <nav>
        <ul class="pager">
          <li><a href="#">Previous</a></li>
          <li><a href="#">Next</a></li>
        </ul>
      </nav>

    </div><!-- /.project-main -->

    <div class="col-sm-3 col-sm-offset-1 project-sidebar">
      <div class="sidebar-module sidebar-module-inset">
          <ul class="list">
            <li><img src="../../image/ini/thumbs/1.jpg"/></li>
            <li><img src="../../image/ini/thumbs/2.jpg"/></li>
            <li><img src="../../image/ini/thumbs/3.jpg"/></li>
            <li><img src="../../image/ini/thumbs/8.jpg"/></li>
            <li><img src="../../image/ini/thumbs/9.jpg"/></li>
          </ul>
      </div>
      <div class="sidebar-module sidebar-module-inset">
        <h4>项目分类：</h4>
        <span class="label label-success category"><a href="http:\\GitHub.com">Web</a></span>
      </div>
      <div class="sidebar-module sidebar-module-inset">
        <h4>项目标签：</h4>
        <span class="label label-primary lab"><a href="http:\\GitHub.com">Java</a></span>
        <span class="label label-primary lab"><a href="http:\\GitHub.com">Web</a></span>
        <span class="label label-primary lab"><a href="http:\\GitHub.com">Spring</a></span>
        <span class="label label-primary lab"><a href="http:\\GitHub.com">JavaScript</a></span>
      </div>
    </div><!-- /.project-sidebar -->

  </div><!-- /.row -->

</div><!-- /.container -->

<jsp:include page="../../commonFooter.jsp"/>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="/js/page/bootstrap-popover.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

<script src="../../js/page/commonHeader.js"></script>
<script src="//cdn.bootcss.com/masonry/3.3.1/masonry.pkgd.min.js"></script>
<script>
  $(document).ready(function() {
    $('.list').masonry({
      itemSelector:'.list li',
      columnWidth:50
    });
  });
</script>


</body>
</html>