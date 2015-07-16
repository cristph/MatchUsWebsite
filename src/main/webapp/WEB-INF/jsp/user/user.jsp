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
                    <li id="name">
                        ${user.username}
                        ${user.address}
                        ${user.uid}
                        ${user.email}
                    </li>
                    <li>
                        <a href="/user/settings" class="user-setting">
                            <span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>设置
                        </a>
                    </li>
                </ul>
            </div>
            <ul class="left_nav">
                <li>
                    <a class="active" href="#">发布<em class="got-num">7</em></a>
                </li>
                <li>
                    <a class="#" href="#">参与<em class="got-num">0</em></a>
                </li>
                <li>
                    <a class="#" href="#">关注<em class="got-num">0</em></a>
                </li>
                <li>
                    <a class="#" href="#">粉丝<em class="got-num">0</em></a>
                </li>
            </ul>
        </div>


        <div class="l space-main">
            <div class="family">
                <h1 class="family-hd">我的项目</h1>
            </div>

            <div class="course-tool-bar clearfix">
                <div class="tool-left l">
                    <a href="#" class="#">已关注
                    </a>
                    <a href="#" class="active">已接受</a>
                    <a href="#" class=" ">已完成</a>
                </div>
            </div>


            <div class="main-bd clearfix">
                <div class="my-space-course study-tl">
                    <div class="clearfix tl-item  tl-item-first">
                        <div class="project-list project-list-m">
                            <ul class="clearfix">
                                <li class="course-one">
                                    <a href="#">
                                        <h2>电商网站</h2>

                                        <div class="tips">
                                            <p class="text-ellipsis">
                                                本课程从最基本的概念开始讲起，步步深入，带领
                                            </p>
                                        </div>
                                    </a>
                                </li>
                                <li class="course-one">
                                    <a href="#">
                                        <h2>电商网站</h2>

                                        <div class="tips">
                                            <p class="text-ellipsis">
                                                本课程从最基本的概念开始讲起，步步深入，带领
                                            </p>
                                        </div>
                                    </a>
                                </li>
                                <li class="course-one">
                                    <a href="#">
                                        <h2>电商网站</h2>

                                        <div class="tips">
                                            <p class="text-ellipsis">
                                                本课程从最基本的概念开始讲起，步步深入，带领
                                            </p>
                                        </div>
                                    </a>
                                </li>
                                <li class="course-one">
                                    <a href="#">
                                        <h2>电商网站</h2>

                                        <div class="tips">
                                            <p class="text-ellipsis">
                                                本课程从最基本的概念开始讲起，步步深入，带领
                                            </p>
                                        </div>
                                    </a>
                                </li>
                                <li class="course-one">
                                    <a href="#">
                                        <h2>电商网站</h2>

                                        <div class="tips">
                                            <p class="text-ellipsis">
                                                本课程从最基本的概念开始讲起，步步深入，带领
                                            </p>
                                        </div>
                                    </a>
                                </li>
                                <li class="course-one">
                                    <a href="#">
                                        <h2>电商网站</h2>

                                        <div class="tips">
                                            <p class="text-ellipsis">
                                                本课程从最基本的概念开始讲起，步步深入，带领
                                            </p>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../commonFooter.jsp"/>
</body>
</html>
