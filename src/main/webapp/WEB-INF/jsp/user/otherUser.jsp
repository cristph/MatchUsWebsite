<%@ page import="us.match.website.model.User" %>
<%@ page import="us.match.website.model.Project" %>
<%@ page import="java.util.List" %>
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
  List<Project> thisProject;
    String relationship="unfollow";
%>
<%
  thisUser =(User)request.getAttribute("oneOtherUser");
  thisProject=(List<Project>)request.getAttribute("publishingProjects");
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
              <p><%=thisUser.getInstruction()%></p>
          </li>
          <li style="list-style: none">
              <% if(relationship.equals("follow")){ %>
                <button type="button" class="btn btn-default-sm" onclick="follow(<%=thisUser.getUid()%>)">已关注</button>
              <% }else if (relationship.equals("unfollow")){ %>
                <button type="button" class="btn btn-primary-sm" onclick="unfollow(<%=thisUser.getUid()%>)">关注</button>
              <% }else if (relationship.equals("self")){%>
                <a class="#" href="/user/settings">设置</a>
              <%}%>
          </li>
      </div>
      <div>
        <ul class="left_nav">
          <li id="publish" class="left_nav_bar selected" onclick="changeBar(this,<%=thisUser.getUid()%>)">
            发布
          </li>
          <li id="attend" class="left_nav_bar" href="#" onclick="changeBar(this,<%=thisUser.getUid()%>)">
            参与
          </li>
          <li id="follow" class="left_nav_bar" href="#" onclick="changeBar(this,<%=thisUser.getUid()%>)">
            关注
          </li>
          <li id="fans" class="left_nav_bar" href="#" onclick="changeBar(this,<%=thisUser.getUid()%>)">
            粉丝
          </li>
        </ul>
      </div>
    </div>
    <div id="detail_body">
      <div id="publish_project" class="content_div show">
        <ul class="nav nav-tabs">
          <li role="presentation" id="publish_now" class="sub_bar active" onclick="changeBar(this,<%=thisUser.getUid()%>)">
            <a href="#">正在进行项目</a>
          </li>
          <li role="presentation" id="publish_past" class="sub_bar" onclick="changeBar(this,<%=thisUser.getUid()%>)">
            <a href="#">已完成项目</a>
          </li>
          <li role="presentation" id="publish_will" class="sub_bar" onclick="changeBar(this,<%=thisUser.getUid()%>)">
            <a href="#">未开始项目</a>
          </li>
        </ul>
        <div class="project-list">
          <ul id="publish_project_body">
            <%if (thisProject.get(0).getPid()==-1){%>
            <h2>暂时还没有项目哦~~~</h2>
            <%} else{%>
            <c:forEach var="project" items="${projectList}">
              <li>
                <a href="/project/getOneProject?pid=${project.pid}" target="_blank">
                  <h3>${project.pname}</h3>
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
            <a href="#">正在进行项目</a>
          </li>
          <li role="presentation" id="attend_past" class="sub_bar" onclick="changeBar(this,<%=thisUser.getUid()%>)">
            <a href="#">已完成项目</a>
          </li>
          <li role="presentation" id="attend_will" class="sub_bar" onclick="changeBar(this,<%=thisUser.getUid()%>)">
            <a href="#">已关注项目</a>
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