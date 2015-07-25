<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<jsp:include page="commonHeader.jsp"/>

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
          <li><a href="#">我要参与</a></li>
          <li><a href="#">关注</a></li>
        </ul>
      </nav>

    </div><!-- /.project-main -->

    <div class="col-sm-3 col-sm-offset-1 project-sidebar">
      <div class="sidebar-module sidebar-module-inset">
        <h4>
          项目图片:
        </h4>
        <div class="container-fluid imgWall">
          <div class="box"><img src="/image/ini/banner.jpg" class="imgthumbs"/></div>
          <div class="box"><img src="/image/ini/thumbs/2.jpg" class="imgthumbs"/></div>
          <div class="box"><img src="/image/ini/thumbs/3.jpg" class="imgthumbs"/></div>
          <div class="box"><img src="/image/ini/banner1.jpg" class="imgthumbs"/></div>
          <div class="box"><img src="/image/ini/thumbs/9.jpg" class="imgthumbs"/></div>
        </div>
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

<c:choose>
  <c:when test="${empty sessionScope.user}">
  </c:when>
  <c:otherwise>
    <div id = "drop" class="menu" style="position: absolute;margin-top: 10px;margin-left: 1100px;">
      <ul>
        <li>
          <ul >
            <li><a class="first">Signed in as ${sessionScope.user.username}</a></li>
            <li><a href="/user" class="button 3">个人信息</a></li>
            <li><a href="/exit" class="button last">退出登录</a></li>

          </ul>
        </li>
      </ul>
    </div>
  </c:otherwise>
</c:choose>


<jsp:include page="commonFooter.jsp"/>
<script type="text/javascript">
  $(document).ready(function(){
    $("#banner").mouseover(function(){
      $("#drop").css("opacity","1");
      $(".button").css("cursor" ,"pointer");
    });
    $("#banner").mouseout(function(){
      setTimeout(function () {
        $('#drop').css("opacity","0");
        $(".button").css("cursor" ,"default");
      }, 3000);

    });
  });
</script>

</body>
</html>
