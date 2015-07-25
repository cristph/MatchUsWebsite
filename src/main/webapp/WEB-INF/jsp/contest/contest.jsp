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
  <link href="./bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="./user.css" type="text/css"/>
</head>
<body class="grayBg">
<div class="container">
  <div class="row">
    <div class="col-md-6">
      <img src="./poster.png" class="titleimg">
    </div>
    <div class="col-md-3">
      <
    </div>
    <div class="col-md-3">
    </div>
  </div>


  <div class="row">

    <div class="col-md-9">
      <div class="leftBlock whiteBg">
        <div class="leftSub">

          <h3>比赛介绍</h3><hr/>

          <p style="line-height:180%;color:#5a5a5a;font-size:15px;">
            嗨嗨嗨~大家期待已久的EL比赛开始报名啦！没组好队的要抓紧时间啦！没抱到大腿的不要悲伤~【求人不如求己！嘿嘿】下面是一些有关报名的详细信息：<br>
            组队报名方面：<br>
            1）原则上四人一队。如果因为特殊原因，可以接受个别人数不足四人的队伍。（关于这一点，我们将会在后文中提供一个队伍人数协调机制）<br>

            2）全队队员必须皆为大一的学生。只要队伍中有一人不是大一的学生，将不会通过审核。<br>

            3）对于学院的要求，我们将接受全部学院的同学报名，但必须注意，全队队员必须皆为大一的学生。另外队员必须是南京大学本科学生。且一人限报一队。<br>

            4）报名时，需要提供一下信息：队伍名称，队长姓名学号学院及联系方式，队员的姓名学号与学院。（关于队伍名称，请不要使用粗俗词语的谐音，否则将不会通过审核）另外，如果可以设计队伍logo更好。<br>

            5）报名时，请将第四点的所要求的信息发送到指定邮箱（njuel2014@163.com ），为防止邮箱被拦截或未发送成功等问题，请密切关注回信，若我们的工作人员回复邮件说“报名成功”，则显示报名没有问题。<br>

            队伍人数协调机制：<br>

            由于各种原因所造成的影响，一定会存在很多人，组不到队伍，或者很多队伍有着缺人之类的问题。为了提供那些因为组不到队伍而放弃比赛的同学比赛的机会。我们制定了以下人数协调机制。<br>

            1）如果有同学仍然找不到队伍，请将自己的信息（学号学院及联系方式）发送到指定邮箱 njuel2014@163.com 我们将为这些同学做一些协调工作。
            <br>
            2）如果有队伍需要多于四人，可以写申请，只要通过审核，队伍中就可以多于四人（但注意：不得多于五人）。<br>
          </p>
        </div>



      </div>
    </div>
    <div class="col-md-3 settings-left">
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

  </div>
</div>

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//ajax.aspnetcdn.com/ajax/knockout/knockout-3.1.0.js"></script>
</body>
</html>
