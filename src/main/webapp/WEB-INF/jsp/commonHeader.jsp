<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-inverse navbar-fixed-top" id="nav_top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/" id="img_a">
                <img src="/image/base/logov1.png" id="img_wh">
            </a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-left" id="nav_left">
                <li id="navli1"><a href="/project">找比赛</a></li>

            </ul>

            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${empty sessionScope.user}">
                        <li id="navli4"><a href="#" data-toggle="modal" data-target="#userlogin">登陆</a></li>
                        <li id="navli5"><a href="#" data-toggle="modal" data-target="#usersignin" onClick="myReload()">注册</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li style="height: 50px;"><a id="banner" class="banner photo" href="/user">
                            <img class="banner-face" src="/userPhoto.jpg?uid=${sessionScope.user.uid}" width="30" height="30">
                            <div id="notify">
                                <div id="circle">
                                    <p id="messages"></p>
                                </div>
                            </div>
                        </a></li>
                    </c:otherwise>
                </c:choose>
            </ul>

            <form class="navbar-form navbar-right">
                <div class="input-group">
                    <input type="text" class="form-control searchArea" id="searchArea" placeholder="搜索项目，大牛">
                    <span class="input-group-btn">
                        <button class="btn searchButton" id="searchButton" type="button"><a href="#" target="_blank" id="linkLocation">GO</a></button>
                    </span>
                    <dl class="searchResult" id="searchResult">
                    </dl>
                </div>
                <!-- /input-group -->
            </form>

        </div>
    </div>
</nav>

<c:if test="${empty sessionScope.user}">
    <div class="modal fade" id="userlogin" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
        <div class="modal-dialog modal_width" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="exampleModalLabel">登陆</h4>
                </div>
                <div class="modal-body">
                        <%--<form class='form-signin' method="post" action="/login">--%>
                    <form class='form-signin' data-bind="submit: login">
                        <div class="form-group">
                            <label class="control-label">用户名或注册邮箱：</label>
                            <input type='text' data-bind="value: username" id='username' name="username"
                                   class='form-control'
                                   placeholder='Use Name or Email...' required autofocus>
                        </div>
                        <div class="form-group">
                            <label class="control-label">登陆密码：</label>
                            <input type='password' data-bind="value: password" id="password" name="password"
                                   class='form-control'
                                   placeholder='Password' required>
                        </div>
                        <div class="form-group">
                            <p data-bind="visible: fail" id="suggestion-on-fail">抱歉，用户名或密码错误。</p>
                        </div>
                        <div class="modal-footer">
                            <div class='checkbox'>
                                <label>
                                    <input type='checkbox' data-bind="checked: remember" name="remember"> 记住我
                                </label>
                            </div>
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
                            <input type='email' id='inEmail' name="sign_email" class='form-control' placeholder='邮箱地址'
                                   required autofocus>
                        </div>
                        <div class="form-group has-feedback">
                            <label class="control-label">密码：</label>
                            <input type='password' id='inPassword' name="sign_pswd" class='form-control'
                                   placeholder='密码' required>
                        </div>
                        <div class="form-group has-feedback">
                            <label class="control-label">请确认密码：</label>
                            <input type='password' id='sureinPassword' class='form-control' placeholder='确认密码' required>
                            <!--<input type='password' id='sureinPassword' class='form-control' placeholder='SurePassword' required>-->
                        </div>
                        <div class="form-group">
                            <label class="control-label">昵称：</label>
                            <input type="text" id="inName" name="sign_name" class="form-control" placeholder="昵称"
                                   required>
                        </div>
                        <div class="form-group">
                            <label class="control-label">验证码：</label>

                            <div class="container-fluid">

                                <div class="row">
                                    <div class="col-md-6 codeRowCss">
                                        <input type="text" id="checkCode" name="userCheckCode" class="form-control"
                                               placeholder="验证码" required>
                                    </div>
                                    <div class="col-md-6 imgRowCss">
                                        <img src="/checkCode.jpg" id="img_code" alt="验证码">
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
</c:if>