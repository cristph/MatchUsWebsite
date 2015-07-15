<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
        <li><a href="#" data-toggle="modal" data-target="#releasepro">发布项目</a></li>
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
          <div class="form-group has-feedback">
            <label class="control-label">注册邮箱：</label>
            <input type='email' id='inputEmail' name="username" class='form-control'
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
          <div class="form-group has-feedback">
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

<div class="modal fade" id="releasepro" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
  <div class="modal-dialog releasepro_width" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="releasepro_title">发布项目</h4>
      </div>
      <div class="modal-body">
        <form method="post"  action="/project/add">
          <div class="form-group">
            <label class="control-label">项目名称：</label>
            <input type='text' id='rp_name' name="rp_name" class='form-control' required
                   autofocus>
          </div>
          <div class="form-group">
            <label class="control-label">项目描述：</label>
            <textarea class="form-control"  id='rp_detail' name="rp_detail" required></textarea>
          </div>
          <div class="form-group">
            <label class="control-label">项目分类：</label>
            <input type='text' id='rp_category'  name='rp_category' class='form-control' required>
          </div>
          <div class="form-group">
            <label class="control-label">项目报酬：</label>
            <input type="text" id="rp_reward" name="rp_reward" class="form-control"required>
          </div>
          <div class="form-group">
            <label class="control-label">电话：</label>
            <input type="text" id="rp_tel" name="rp_tel" class="form-control" required>
          </div>
          <div class="form-group">
            <label class="control-label">邮箱：</label>
            <input type="text" id="rp_email" name="rp_email" class="form-control"required>
          </div>

          <div class="form-group">
            <div class="container-fluid">
              <label class="control-label">验证码</label>
              <div class="row">
                <div class="col-md-6">
                  <input type="text" id="rp_checkCode" name="rp_userCheckCode"  class="form-control" required>
                </div>
                <div class="col-md-6">
                  <img src="checkCode.jpg" id="rp_img_code" alt="hahha">
                  <a href="#" onClick="myReload()">换一个</a>
                </div>
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="submit" id="submit_pro" class="btn btn-primary">确认发布</button>
          </div>
        </form>
      </div>

    </div>
  </div>
</div>