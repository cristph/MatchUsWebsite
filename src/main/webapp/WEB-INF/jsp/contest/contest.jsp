<%--
  Created by IntelliJ IDEA.
  User: Seven
  Date: 15/7/23
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>MATCH US｜比赛详情</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
  <meta name="keywords" content=""/>
  <meta name="description" content=""/>
  <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="/css/page/contest.css" type="text/css"/>
  <link href="/css/page/cus.css" rel="stylesheet" type="text/css"/>
  <link href="/css/page/reset.css" rel="stylesheet" type="text/css"/>
  <link href="/css/page/style2.css" rel="stylesheet" type="text/css"/>
  <link href="/css/page/commonHeader.css" rel="stylesheet" type="text/css">
  <link href="/css/page/commonFooter.css" rel="stylesheet" type="text/css">

  <link href="/css/page/bbs.css" rel="stylesheet" type="text/css">
  <link href="/css/page/bbsIndex.css" rel="stylesheet" type="text/css">
</head>
<body class="grayBg">
<jsp:include page="/WEB-INF/jsp/commonHeader.jsp"/>
<div class="container">
  <div class="row" style="background-color:#364247;margin-left: 0px;margin-right: 0px;">
    <div class="col-md-6  titleNoPadding">
      <img src="/image/contestImg/poster.png" class="titleimg" style="margin: 0px;">
    </div>
    <div class="col-md-3  titleNoPadding">
      <div class="titleBtn">
        <ul style="background-color:#364247;color:#fff;">
          <li style="padding-top:34px;padding-bottom: 4px;padding-left: 30px;"><span style="background-color:#364247;">参加人数: 196</span>
          </li>
          <hr style="border:0;background-color:#40484b;height:1px; margin-left: 30px;margin-right: 30px;">
          <li style="padding-top:4px;padding-bottom: 4px;padding-left: 30px;"><span style="background-color:#364247">开始时间: 2015年4月1日</span>
          </li>
          <hr style="border:0;background-color:#40484b;height:1px;margin-left: 30px;margin-right: 30px;">
          <li style="padding-bottom:24px;padding-top: 4px;padding-left: 30px;"><span style="background-color:#364247">比赛时长: 96天</span>
          </li>
        </ul>
      </div></div>
    <div class="col-md-3 titleNoPadding">
      <div >
        <ul>
          <li style="padding:32px;background-color:#4d5a61">
            <span style="background-color:#4d5a61;color:#fff">关注比赛</span>
          </li >
          <li style="padding:32px;background-color:#c73b4d;height:150px;"><span style="background-color:#c73b4d;color:#fff">我要报名</span>
          </li>
        </ul>
      </div>
    </div>
  </div>


  <div id="content" class="row">

    <div class="col-md-9">
      <div data-bind="visible: active_part() === 1">
        <%@include file="contestDetail.jsp"%>
      </div>
      <div data-bind="visible: active_part() === 2">
        <%@include file="contestExp.jsp"%>
      </div>
      <div data-bind="visible: active_part()=== 3">
        <%@include file="contestProduct.jsp"%>
      </div>
      <div data-bind="visible: active_part()=== 4" id="bbsModel">
        <%@include file="contestBBSIndex.jsp"%>
      </div>
      <div data-bind="visible: active_part()=== 5">
        <%@include file="contestBBS.jsp"%>>
      </div>
    </div>


    <div class="col-md-3 settings-left" style="margin-top: 20px;">
      <ul class="wrapped-boxes">
        <li data-bind="css: {active: active_part() === 1}">
          <div data-bind="click: function(){active_part(1)}">比赛详情</div>
        </li>
        <li data-bind="css: {active: active_part() === 2}">
          <div data-bind="click: function(){active_part(2)}">经验分享</div>
        </li>
        <li data-bind="css: {active: active_part() === 3}">
          <div data-bind="click: function(){active_part(3)}">优秀作品</div>
        </li>
        <li data-bind="css: {active: active_part() === 4}">
          <div data-bind="click: function(){active_part(4)}">BBS</div>
        </li>
      </ul>
    </div>

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

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//ajax.aspnetcdn.com/ajax/knockout/knockout-3.1.0.js"></script>
<script src="/js/page/commonHeader.js"></script>
<script src="/js/page/contestBBSIndex.js"></script>

<script>
  var viewModel = function() {
    var self=this;
    self.active_part=ko.observable(1);
  }
  ko.applyBindings(new viewModel(), document.getElementById('content'));
</script>

<script type="text/javascript">
  $(document).ready(function(){
    $("#banner").mouseover(function(){
      $('#drop').css("opacity","1");
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
