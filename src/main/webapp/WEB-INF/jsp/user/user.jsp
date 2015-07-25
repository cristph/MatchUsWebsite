<%@ page import="us.match.website.model.User" %>
<%@ page import="us.match.website.model.Project" %>
<%@ page import="java.util.List" %>
<%@ page import="us.match.website.model.Information" %>
<%@ page import="us.match.website.model.Message" %>
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
<%!
    User thisUser;
    List<Message> thisInformation;%>
<%
    thisUser =(User)request.getAttribute("user");
    thisInformation=(List<Message>)request.getAttribute("informationList");
%>
<div id="main" class="container">
    <div class="body_container">
        <div class="sider">
            <div class="user-info">
                <span class="user-pic">
                    <img src="userPhoto.jpg?uid=<%=thisUser.getUid()%>" alt="该用户暂无头像">
                </span>
                <ul class="user-lay">
                    <li id="user_name">
                        昵称：<Strong><%=thisUser.getUsername()%></Strong>
                    </li>
                    <li id="user_sex">
                        性别：<Strong><%=thisUser.getSex()%></Strong>
                    </li>
                    <li id="user_university">
                        学校：<Strong><%=thisUser.getUniversity()%></Strong>
                    </li>
                    <li id="user_address">
                        地址：<Strong><%=thisUser.getAddress()%></Strong>
                    </li>
                </ul>
            </div>
            <div>
                <li style="list-style: none;text-align: center">
                    <a class="#" href="/user/settings">设置</a>
                </li>
                <p><%=thisUser.getInstruction()%></p>
            </div>
            <div>
                <ul class="left_nav">
                    <li id="information" class="left_nav_bar selected" onclick="changeBar(this,<%=thisUser.getUid()%>)">
                        我的消息
                    </li>
                    <li id="attend" class="left_nav_bar" href="#" onclick="changeBar(this,<%=thisUser.getUid()%>)">
                        我的比赛
                    </li>
                    <li id="follow" class="left_nav_bar" href="#" onclick="changeBar(this,<%=thisUser.getUid()%>)">
                        我的关注
                    </li>
                    <li id="fans" class="left_nav_bar" href="#" onclick="changeBar(this,<%=thisUser.getUid()%>)">
                        我的粉丝
                    </li>
                </ul>
            </div>
        </div>
        <div id="detail_body">
            <div id="information_all" class="content_div show">
                <ul class="nav nav-tabs">
                    <li role="presentation" id="information_new" class="sub_bar active" onclick="changeBar(this,<%=thisUser.getUid()%>)">
                        <a href="#">未读消息</a>
                    </li>
                    <li role="presentation" id="information_old" class="sub_bar" onclick="changeBar(this,<%=thisUser.getUid()%>)">
                        <a href="#">已读消息</a>
                    </li>
                </ul>
                <div class="information-list">
                    <ul id="information_body">
                        <%if (thisInformation.get(0).getSenderId()==-1){%>
                        <h2>暂时还没有未读消息哦~~~</h2>
                        <%} else{%>
                        <c:forEach var="information" items="${informationList}">
                            <li>
                                <a href="http://www.baidu.com" class="information-info">
                                <div>
                                    ${information.content}
                                </div>
                                </a>
                            </li>
                        </c:forEach>
                        <%}%>
                    </ul>
                </div>
            </div>
            <div id="attend_project" class="content_div hide">
                <ul class="nav nav-tabs">
                    <li role="presentation" id="attend_now" class="sub_bar active" onclick="changeBar(this,<%=thisUser.getUid()%>)">
                        <a href="#">正在进行比赛</a>
                    </li>
                    <li role="presentation" id="attend_past" class="sub_bar" onclick="changeBar(this,<%=thisUser.getUid()%>)">
                        <a href="#">已完成比赛</a>
                    </li>
                    <li role="presentation" id="attend_will" class="sub_bar" onclick="changeBar(this,<%=thisUser.getUid()%>)">
                        <a href="#">已关注比赛</a>
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

<c:choose>
    <c:when test="${empty sessionScope.user}">
    </c:when>
    <c:otherwise>
        <div id = "drop" class="menu" style="position: absolute;margin-top: 10px;margin-left: 1100px;">
            <ul>
                <li>
                    <ul >
                        <li><a class="first">Signed in as gjp</a></li>
                        <li><a href="/user" class="button 3">个人信息</a></li>
                        <li><a href="/exit" class="button last">退出登录</a></li>

                    </ul>
                </li>
            </ul>
        </div>
    </c:otherwise>
</c:choose>


<jsp:include page="../commonFooter.jsp"/>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="//ajax.aspnetcdn.com/ajax/knockout/knockout-3.1.0.js"></script>
<script type="text/javascript" src="/js/page/commonHeader.js"></script>
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