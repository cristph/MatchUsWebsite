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
    <link rel="stylesheet" href="../../../css/page/user.css" type="text/css"/>
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
                        <a class="left_nav_bar active" href="#">发布<em class="got-num">7</em></a>
                    </li>
                    <li>
                        <a class="left_nav_bar" href="#">参与<em class="got-num">0</em></a>
                    </li>
                    <li>
                        <a class="left_nav_bar" href="#">关注<em class="got-num">0</em></a>
                    </li>
                    <li>
                        <a class="left_nav_bar" href="#">粉丝<em class="got-num">0</em></a>
                    </li>
                </ul>
            </div>
        </div>


        <div id="detail_body">
            <div id="published_project content_div" class="show">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="#">未完成</a></li>
                    <li role="presentation" class="active"><a href="#">已完成</a></li>
                </ul>

            </div>
            <div id="attent_project content_div" class="hide">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="#">已参加</a></li>
                    <li role="presentation" class="active"><a href="#">已完成</a></li>
                </ul>
            </div>
            <div id="my_follow_people content_div" class="hide">
                我关注的人
            </div>
            <div id="people_follow_me content_div" class="hide">
                关注我的人
            </div>
        </div>
    </div>
</div>
<jsp:include page="../commonFooter.jsp"/>

<script type="text/javascript" defer="defer">
    var va = document.getElementsByClassName("left_nav_bar");
    for (var i = 0; i < va.length; i++) {
        va[i].onclick = changeBar;
    }
</script>
</body>
</html>
