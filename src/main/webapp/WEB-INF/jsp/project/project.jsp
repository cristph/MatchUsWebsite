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
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
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
            <span class="select_line_text">模式：</span>

            <div class="btn-group project-mode">
                <button type="submit" id="全部模式" name="全部模式" class="btn btn-primary all-btn">全部模式</button>
                <button type="button" name="外包" class="btn btn-default">外包</button>
                <button type="button" name="比赛" class="btn btn-default">比赛</button>
                <button type="button" name="其他模式" class="btn btn-default">其他模式</button>
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
                <button type="button" name="iOS" class="btn btn-default">android</button>
                <button type="button" name="iOS" class="btn btn-default">iOS</button>
                <button type="button" name="其他技术" class="btn btn-default">其他技术</button>
            </div>
        </div>
        <br>

        <div class="select_line_div">
            <span class="select_line_text">报酬：</span>

            <div class="btn-group project-pay">
                <button type="button" id="全部报酬" name="全部报酬" class="btn btn-primary all-btn">全部报酬</button>
                <button type="button" name="0-100" class="btn btn-default">0-100</button>
                <button type="button" name="100-200" class="btn btn-default">100-200</button>
                <button type="button" name="200-500" class="btn btn-default">200-500</button>
                <button type="button" name="500-1000" class="btn btn-default">500-1000</button>
                <button type="button" name="1000-5000" class="btn btn-default">1000-5000</button>
                <button type="button" name="5000-10000" class="btn btn-default">5000-10000</button>
                <button type="button" name="其他报酬" class="btn btn-default">其他报酬</button>
            </div>
        </div>
    </div>
    <hr style="margin-left: 5%">
    <div id="projects">
        <ul class="projects-index">
            <c:forEach var="project" items="${projects}">
                <li>
                    <a href="/project/getOneProject/${project.pid}">
                        <div class="projects-img">
                            <img src="http://img.mukewang.com/54c5e5ab0001dd9906000338-280-160.jpg">
                        </div>
                        <div class="projects-info">
                            <p>${project.skill}</p>
                            <span class="left">发布者:${project.userName}</span>
                            <span class="right">电话:${project.phonenumber}</span>
                        </div>
                        <div class="projects-subinfo">
                            <h2>${project.pname}</h2>
                            <span class="left">&#65509;≈${project.reward}</span>
                            <span class="right">所在地:${project.location}</span>
                        </div>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<jsp:include page="../commonFooter.jsp"/>
<script type="text/javascript" defer="defer">
    var btn = document.getElementsByClassName("btn");
    for (var i = 0; i < btn.length; i++) {
        btn[i].onclick = select;
    }
</script>
</body>
</html>
