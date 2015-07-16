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
    <script type="text/javascript" src="/js/page/user.js" charset="utf-8"></script>
</head>
<body>
<jsp:include page="../commonHeader.jsp"/>
<div id="main">
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
                    <li>
                        <a id="publish" class="left_nav_bar active" onclick="changeBar(this,${user.uid})">
                            发布<em class="got-num">7</em>
                        </a>
                    </li>
                    <li>
                        <a id="attend" class="left_nav_bar" href="#" onclick="changeBar(this,${user.uid})">
                            参与<em class="got-num">0</em>
                        </a>
                    </li>
                    <li>
                        <a id="follow" class="left_nav_bar" href="#" onclick="changeBar(this,${user.uid})">
                            关注<em class="got-num">0</em>
                        </a>
                    </li>
                    <li>
                        <a id="fans" class="left_nav_bar" href="#" onclick="changeBar(this,${user.uid})">粉丝
                            <em class="got-num">0</em>
                        </a>
                    </li>
                </ul>
            </div>
        </div>


        <div id="detail_body">
            <div id="published_project" class="content_div show">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active" onclick=""><a href="#">未完成</a></li>
                    <li role="presentation" onclick=""><a href="#">已完成</a></li>
                </ul>
                <div class="main-body">
                    <div class="project-list">
                        <ul class="">
                            <c:forEach var="project" items="${projectList}">
                                <li>
                                    <p>${project.pname}</p>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="attent_project" class="content_div hide">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="#">已参加</a></li>
                    <li role="presentation" class="active"><a href="#">已完成</a></li>
                </ul>
            </div>
            <div id="my_follow_people" class="content_div hide">
                我关注的人
            </div>
            <div id="people_follow_me" class="content_div hide">
                关注我的人
            </div>
        </div>
    </div>
</div>
<jsp:include page="../commonFooter.jsp"/>
</body>
</html>
