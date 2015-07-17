<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ezio
  Date: 7/14/2015
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>设置个人信息</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/page/cus.css" rel="stylesheet" type="text/css"/>
    <link href="/css/page/reset.css" rel="stylesheet" type="text/css"/>
    <link href="/css/page/style2.css" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet" href="/css/page/settings.css">
    <link rel="stylesheet" href="/css/page/commonHeader.css"/>
</head>

<body>
<jsp:include page="../../commonHeader.jsp"/>
<section class='container'>
    <!-- left side part -->
    <div class="settings-left col-md-3">
        <ul class="wrapped-boxes">
            <li data-bind="css: {active: active_part() === 1}">
                <div data-bind="click: function(){active_part(1)}">个人资料</div>
            </li>
            <li data-bind="css: {active: active_part() === 2}">
                <div data-bind="click: function(){active_part(2)}">头像设置</div>
            </li>
            <li data-bind="css: {active: active_part() === 3}">
                <div data-bind="click: function(){active_part(3)}">邮箱验证</div>
            </li>
            <li data-bind="css: {active: active_part() === 4}">
                <div data-bind="click: function(){active_part(4)}">修改密码</div>
            </li>
            <li data-bind="css: {active: active_part() === 5}">
                <div data-bind="click: function(){active_part(5)}">绑定账号</div>
            </li>
        </ul>
    </div>
    <div class="col-md-9">
        <div data-bind="visible: active_part() === 1">
            <%@include file="basic_settings.jsp"%>
        </div>
        <div data-bind="visible: active_part() === 2">
            <%@include file="portrait_settings.jsp"%>
        </div>
        <div data-bind="visible: active_part()=== 3">
            <%@include file="mail_settings.jsp"%>
        </div>
    </div>
</section>


<%--<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>--%>
<%--<script src="//ajax.aspnetcdn.com/ajax/knockout/knockout-3.1.0.js"></script>--%>
<%--<script type="text/javascript" src="/js/page/settings.js"></script>--%>
</body>

</html>
