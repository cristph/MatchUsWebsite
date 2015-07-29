<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>找项目</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/page/project.css">
    <link rel="stylesheet" href="/css/page/commonHeader.css">
    <link rel="stylesheet" href="/css/page/commonFooter.css">
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="/js/page/project.js" charset="UTF-8"></script>

</head>
<body id="body">
<jsp:include page="../commonHeader.jsp"/>
<div class="container">
    <hr>
    <hr>
    <div id="select_option">
        <br>
        <div class="select_line_div">
            <span class="select_line_text">类目：</span>

            <div class="btn-group project-kind">
                <button type="button" id="全部类目" name="全部类目" class="btn btn-primary all-btn">全部类目</button>
                <button type="button" name="移动应用" class="btn btn-default">移动应用</button>
                <button type="button" name="网站建设" class="btn btn-default">网站建设</button>
                <button type="button" name="企业软件" class="btn btn-default">企业软件</button>
                <button type="button" name="嵌入式开发" class="btn btn-default">嵌入式开发</button>
                <button type="button" name="视觉设计" class="btn btn-default">视觉设计</button>
                <button type="button" name="文案设计" class="btn btn-default">文案设计</button>
                <button type="button" name="其他类目" class="btn btn-default">其他类目</button>
            </div>
        </div>
        <br>

        <div class="select_line_div">
            <span class="select_line_text">技术：</span>

            <div class="btn-group project-skills">
                <button type="button" id="全部技术" name="全部技术" class="btn btn-primary all-btn">全部技术</button>
                <button type="button" name="Java" class="btn btn-default">Java</button>
                <button type="button" name="C/C++" class="btn btn-default">C/C++</button>
                <button type="button" name="Html/Css/Js" class="btn btn-default">Html/Css/Js</button>
                <button type="button" name="python" class="btn btn-default">python</button>
                <button type="button" name="PHP" class="btn btn-default">PHP</button>
                <button type="button" name="Ruby" class="btn btn-default">Ruby</button>
                <button type="button" name="Linux" class="btn btn-default">Linux</button>
                <button type="button" name="MySql" class="btn btn-default">MySql</button>
                <button type="button" name="C#" class="btn btn-default">C#</button>
                <button type="button" name="android" class="btn btn-default">android</button>
                <button type="button" name="iOS" class="btn btn-default">iOS</button>
                <button type="button" name="其他技术" class="btn btn-default">其他技术</button>
            </div>
        </div>
        <br>
    </div>
    <hr style="margin-left: 5%">
    <div id="projects">
        <ul class="projects-index">
            <c:forEach var="project" items="${projects}">
                <li>
                    <a href="/project/getOneProject?pid=${project.pid}" target="_blank">
                        <div class="projects-img">
                        <c:choose>
                            <c:when test="${project.pid==1}" >
                                <img src="http://ww4.sinaimg.cn/mw690/005ZoaEmjw1eujnqid1z6j306y04gt9u.jpg">
                            </c:when>
                            <c:when test="${project.pid==2}" >
                                <img src="http://ww1.sinaimg.cn/mw690/005ZoaEmjw1eujnyuzepwj306y04gq30.jpg">
                            </c:when>
                            <c:otherwise>
                                <img src="http://img.mukewang.com/54c5e5ab0001dd9906000338-280-160.jpg">
                            </c:otherwise>
                        </c:choose>

                        </div>
                        <div class="projects-info">
                            <p>${project.skill}</p>
                            <span class="left">邮箱:${project.email}</span>
                            <span class="right">电话:${project.phonenumber}</span>
                        </div>
                        <div class="projects-subinfo">
                            <h2>${project.pname}</h2>
                            <span class="left">主办方:${project.publisher.username}</span>
                            <span class="right">所在地:${project.location}</span>
                        </div>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<c:choose>
    <c:when test="${empty sessionScope.user}">
    </c:when>
    <c:otherwise>
        <div class="menu" style="position: absolute;margin-top: 10px;margin-left: 1100px;">
            <ul>
                <li>
                    <ul id = "drop">
                        <li><a class="first">Signed in as ${sessionScope.user.username}</a></li>
                        <li><a href="/user" class="button 3">个人信息</a></li>
                        <li><a href="/exit" class="button last">退出登录</a></li>

                    </ul>
                </li>
            </ul>
        </div>
    </c:otherwise>
</c:choose>

<jsp:include page="../commonFooter.jsp"/>
<script type="text/javascript" defer="defer">
    var btn = document.getElementsByClassName("btn");
    for (var i = 0; i < btn.length; i++) {
        btn[i].onclick = select;
    }
</script>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="//cdn.bootcss.com/knockout/3.3.0/knockout-min.js"></script>
<script src="/js/page/commonHeader.js" type="text/javascript"></script>
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
        $.get("/usermessage",function (result){
            if(result==0){
                $("#circle").css("opacity","0");
            }
            else{
                $("#circle").css("opacity","1");
                document.getElementById("messages").innerHTML = result;
            }

        });
    });
</script>

</body>
</html>
