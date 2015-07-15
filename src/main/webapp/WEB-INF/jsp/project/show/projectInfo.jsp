<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="icon" href="../../favicon.ico">

  <title>Blog Template for Bootstrap</title>

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

<nav class="navbar navbar-inverse navbar-fixed-top" id="nav_top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a href="#" id="img_a">
        <img src="/image/base/logov1.png" id="img_wh">
      </a>
    </div>

    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-left" id="nav_left">
        <li><a href="../../view/page/project.html">找项目</a></li>
        <li><a href="../../view/page/team.html">找团队</a></li>
        <li><a href="../../view/page/talent.html">找人才</a></li>
      </ul>

      <ul class="nav navbar-nav navbar-right">
        <li><a href="#" data-toggle="modal" data-target="#userlogin">登陆</a></li>
        <li><a href="#" data-toggle="modal" data-target="#usersignin" onClick="myReload()">注册</a></li>
        <li><a href="../../view/page/user.html">个人中心</a></li>
      </ul>
      <form class="navbar-form navbar-right">
        <input type="text" class="form-control" placeholder="项目，大牛...">
      </form>
    </div>
  </div>
</nav>

<div class="modal fade" id="userlogin" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog modal_width"role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">登陆</h4>
      </div>
      <div class="modal-body">
        <form class='form-signin' method="post" action="/login">
          <div class="form-group">
            <label class="control-label">注册邮箱：</label>
            <input type='text' id='inputEmail' name="username" class='form-control'
                   placeholder='Email address' required autofocus>
          </div>
          <div class="form-group">
            <label class="control-label">密码：</label>
            <input type='password' id='inputPassword' name="password" class='form-control'
                   placeholder='Password' required>
          </div>
          <div class='checkbox'>
            <label>
              <input type='checkbox' value='remember-me'> 记住我
            </label>
          </div>
          <div class="modal-footer">
            <button type="submit" class="btn btn-primary">确认</button>
          </div>
        </form>
      </div>

    </div>
  </div>
</div>

<div class="modal fade" id="usersignin" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog modal_width" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="signin_title">注册</h4>
      </div>
      <div class="modal-body">
        <form method="post">
          <div class="form-group">
            <label class="control-label">注册邮箱：</label>
            <input type='email' id='inEmail' name="sign_email" class='form-control' placeholder='Email address' required
                   autofocus>
          </div>
          <div class="form-group">
            <label class="control-label">密码：</label>
            <input type='password' id='inPassword' name="sign_pswd" class='form-control' placeholder='Password' required>
          </div>
          <div class="form-group">
            <label class="control-label">确认密码：</label>
            <input type='password' id='sureinPassword' class='form-control' placeholder='SurePassword'
                   required>
          </div>
          <div class="form-group">
            <label class="control-label">昵称</label>
            <input type="text" id="inName" name="sign_name" class="form-control" placeholder="Name" required>
          </div>
          <div class="form-group">
            <label class="control-label">验证码</label>
            <div class="container-fluid">

              <div class="row">
                <div class="col-md-6">
                  <input type="text" id="checkCode" name="userCheckCode"  class="form-control" placeholder="SureCode" required>
                </div>
                <div class="col-md-6">
                  <img src="checkCode.jpg" id="img_code" alt="hahha">
                  <a href="#" onClick="myReload()">换一个</a>
                </div>
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" id="submit_sign" class="btn btn-primary">确认</button>
          </div>
        </form>
      </div>

    </div>
  </div>
</div>


<div class="container">

  <div class="project-header">
    <div class="row">
      <h1 class="project-title">Java项目
                <span class="project-description name_popover">January 1, 2014 posted by
                    <a href="http:\\Github.com">Mark</a>
                </span>
      </h1>
    </div>
  </div>

  <hr class="featurette-divider" style=" margin: 80px 0">

  <div class="row">

    <div class="col-sm-8 project-main">

      <div class="project-post">
        <h2 class="project-post-title">项目描述：</h2>
        <hr>
        <p>在这一部分中，你要对项目的收益群体做一个更加详细的描述。
          有必要时，你还可以把收益群体分为直接受益和间接收益群体。
          比如NPO信息咨询中心的能力建设项目的直接收益群体是国内 NGO和NGO的从业人员，
          但间接收益群体却是NGO的服务对象。因为通过能力建设，提高了NGO的服务能力与效率，
          从而使之能为其服务对象提供更好、更多、更完善的服务。又比如一个残疾人服务机构，
          其直接收益群体是残疾人群，间接收益群体则是他们的家庭，甚至是整个社会。
          许多资助方都希望受益群体能从始至终地参与到项目之中。尤其是在项目的设计阶段，
          受益群体的参与更加重要。你可以在附件中列出受益群体参与项目的活动，包括组织受益群体参加的讨论会、
          会议主题、时间、参加人员等；同时，也让资助方了解到你的项目不但是针对受益群体而设计的，而且，得到了他们的广泛支持与认可。
        </p>
        <br>
        <br>
        <br>
        <h2 class="project-post-title">项目报酬：</h2>
        <hr>
        <p>面议，提供午餐，好处多多</p>
        <br>
        <br>
        <br>
        <h2 class="project-post-title">联系方式：</h2>
        <hr>
        <p><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> <a href="http://cristph@foxmail.com">cristph@foxmail.com</a></p>
        <br>
        <p><span class="glyphicon glyphicon-phone" aria-hidden="true"></span> 13306237695</p>
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

<footer class="co-footer">
  <p>@ company <a href="http://getbootstrap.com">Math Us</a></p>
  <p><a href="#">Back to top</a></p>
</footer>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="/js/page/bootstrap-popover.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>


<script type="javascript">
  $(function () {
    $('[data-toggle="tooltip"]').tooltip()
  })
  $(function () {
    $('[data-toggle="popover"]').popover()
  })
</script>

</body>
</html>