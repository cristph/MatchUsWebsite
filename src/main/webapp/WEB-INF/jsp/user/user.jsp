<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: 张波波
  Date: 2015/7/15
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>个人主页</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../../css/page/user.css" type="text/css">
    <link rel="stylesheet" href="../../../css/page/commonHeader.css" type="text/css">
    <link rel="stylesheet" href="../../../css/page/commonFooter.css" type="text/css">
    <script type="text/javascript" src="/js/page/user.js"></script>
</head>
<body>
<jsp:include page="../commonHeader.jsp"/>
<div id="main" class="container">
    <div class="body_container">
        <div class="sider">
            <div class="user-info">
                <span class="user-pic">
                    <img src="userPhoto.jpg?uid=${user.uid}" alt="该用户暂无头像">
                </span>
                <ul class="user-lay">
                    <li id="user_name">
                        昵称：<Strong>${user.username}</Strong>
                    </li>
                    <li id="user_sex">
                        性别：<Strong>${user.sex}</Strong>
                    </li>
                    <li id="user_university">
                        学校：<Strong>${user.university}</Strong>
                    </li>
                    <li id="user_email">
                        地址：<Strong>${user.address}</Strong>
                    </li>
                </ul>
            </div>
            <div>
                <li style="list-style: none;text-align: center">
                    <a class="#" href="/user/settings">设置</a>
                </li>
                <p>${user.instruction}</p>
            </div>
            <div>
                <ul class="left_nav">
                    <li id="publish" class="left_nav_bar selected" onclick="changeBar(this,${user.uid})">
                        发布
                    </li>
                    <li id="attend" class="left_nav_bar" href="#" onclick="changeBar(this,${user.uid})">
                        参与
                    </li>
                    <li id="follow" class="left_nav_bar" href="#" onclick="changeBar(this,${user.uid})">
                        关注
                    </li>
                    <li id="fans" class="left_nav_bar" href="#" onclick="changeBar(this,${user.uid})">
                        粉丝
                    </li>
                </ul>
            </div>
        </div>


        <div id="detail_body">
            <div id="published_project" class="content_div show">
                <ul class="nav nav-tabs">
                    <li role="presentation" id="published_uncompleted" class="sub_bar active" onclick="changeBar(this,${user.uid})">
                        <a href="#">未完成项目</a>
                    </li>
                    <li role="presentation" id="published_completed" class="sub_bar" onclick="changeBar(this,${user.uid})">
                        <a href="#">已完成项目</a>
                    </li>
                </ul>
                <div class="project-list">
                    <ul id="published_project_body">
                        <c:forEach var="project" items="${projectList}">
                            <li>
                                <a href="/project/getOneProject?pid=${project.pid}" target="_blank">
                                    <h3>${project.pname}</h3>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div id="attend_project" class="content_div hide">
                <ul class="nav nav-tabs">

                    <li role="presentation" id="attend_uncompleted" class="sub_bar active" onclick="changeBar(this,${user.uid})">
                        <a href="#">已参加项目</a>
                    </li>
                    <li role="presentation" id="attend_completed" class="sub_bar" onclick="changeBar(this,${user.uid})">
                        <a href="#">已完成项目</a>
                    </li>
                </ul>
                <div class="project-list">
                    <ul id="attend_project_body">
                    </ul>
                </div>
            </div>
            <div id="my_follow_people" class="content_div hide">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="#">我关注的人</a>
                    </li>
                </ul>
                <div class="people-list">
                    <ul id="follow_people_body">

                    </ul>
                </div>
            </div>
            <div id="people_follow_me" class="content_div hide">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active">
                        <a href="#">关注我的人</a>
                    </li>
                </ul>
                <div class="people-list">
                    <ul id="follow_me_body">

                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>
<jsp:include page="../commonFooter.jsp"/>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="//ajax.aspnetcdn.com/ajax/knockout/knockout-3.1.0.js"></script>
<script type="text/javascript" src="/js/page/commonHeader.js"></script>
</body>
</html>
