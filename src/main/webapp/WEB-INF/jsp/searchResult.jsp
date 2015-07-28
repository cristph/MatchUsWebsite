<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>搜索结果</title>
  <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
  <link href="/css/page/reset.css" rel="stylesheet" type="text/css"/>
  <link href="/css/page/commonHeader.css" rel="stylesheet" type="text/css">
  <link href="/css/page/commonFooter.css" rel="stylesheet" type="text/css">
  <link href="/css/page/searchResult.css" rel="stylesheet" type="text/css">
</head>
<body>

<jsp:include page="commonHeader.jsp"/>

<div class="container">

  <div class="row">

    <div class="col-sm-8 person_info blockShadow">

      <div>
        <ul>
          <li class="listItem clearfix">
            <div class="searchType">符合条件的大牛：</div>
          </li>

          <li class="listItem clearfix">
            <div class="user-pic">
              <a href="/otherUser?uid=13" target="_blank"><img src="/hotUsers/userPhoto?oneHotUserId=13"></a>
              <p class="user-name"><a href="/otherUser?uid=13" target="_blank">gjp</a><span class="sex">男</span></p>
            </div>
            <div class="Info">
              <div class="schoolInfo"><span class="tip">学校：</span>南京大学</div>
              <div class="selfIntro"><span class="tip">个人说明：</span>嗯哈哈哈哈哈哈哈哈哈。</div>
              <div class="skillInfo"><span class="tip">擅长领域：</span>Java,C++,Ruby</div>
              <div class="projectInfo">
                <span class="tip">项目经历：</span>
                <ul>
                  <li><a href="/">JavaWeb Project</a></li>
                  <li><a href="/">Android Project</a></li>
                </ul>
              </div>
            </div>
          </li>

          <li class="listItem clearfix">
            <div class="user-pic">
              <a href="/otherUser?uid=15" target="_blank"><img src="/hotUsers/userPhoto?oneHotUserId=15"></a>
              <p class="user-name"><a href="/otherUser?uid=13" target="_blank">AH</a><span class="sex">男</span></p>
            </div>
            <div class="Info">
              <div class="schoolInfo"><span class="tip">学校：</span>南京大学</div>
              <div class="selfIntro"><span class="tip">个人说明：</span>嗯哈哈哈哈哈哈哈哈哈。</div>
              <div class="skillInfo"><span class="tip">擅长领域：</span>Java,C++,Ruby</div>
              <div class="projectInfo">
                <span class="tip">项目经历：</span>
                <ul>
                  <li><a href="/">JavaWeb Project</a></li>
                  <li><a href="/">Android Project</a></li>
                </ul>
              </div>
            </div>
          </li>

          <li class="listItem clearfix">
            <div class="moreInfo">更多大牛......</div>
          </li>
        </ul>
      </div><!-- /.project-post -->

    </div><!-- /.project-main -->

    <div class="col-sm-3 col-sm-offset-1 blockShadow slider">
      <div>
        <ul>
          <li class="navItem clearfix">
            所有结果
          </li>
          <li class="navItem clearfix">
            大牛
          </li>
          <li class="navItem clearfix">
            比赛
          </li>
          <li class="navItem clearfix">
            帖子
          </li>
        </ul>
      </div>
    </div><!-- /.project-sidebar -->

    <div class="col-sm-8 project_info blockShadow">

      <div>
        <ul>
          <li class="listItem clearfix">
            <div class="searchType">符合条件的比赛：</div>
          </li>

          <li class="listItem clearfix">
            <div class="projectTitle">
              <a href="/project/getOneProject?pid=1" target="_blank">软件学院创新杯比赛</a>
            </div>
            <div class="projectPublish">
              <p>
                2015-7-21  posted by <span><a href="/">Somebody</a></span>
              </p>
            </div>
            <div class="projectPicture">
              <img src="http://img.mukewang.com/54c5e5ab0001dd9906000338-280-160.jpg" alt="Img">
            </div>
            <div class="projectIntro">
              政府对开发公司的实力要求不严，开发商实力良莠不齐，受传统观念束缚严重，
              不重视客源心理及市场发展特性，主观开发，追求暴利，无品牌意识，对专业销售机构极度排斥。
              产品形式单一（多层为主），缺乏特色，不注重整体规划，且有明显区域性特征（集中在千佛山周边）。
              无整体营销思路，盲目追求高利，定价偏高，且无有效的表现及宣传手法，不注重品牌的培养和树立。
            </div>


          </li>

          <li class="listItem clearfix">
            <div class="projectTitle">
              <a href="/project/getOneProject?pid=2" target="_blank">“全志杯”东南大学第八届嵌入式系统设计邀请赛</a>
            </div>
            <div class="projectPublish">
              <p>
                2015-7-21  posted by <span><a href="/">Somebody</a></span>
              </p>
            </div>
            <div class="projectPicture">
              <img src="http://img.mukewang.com/54c5e5ab0001dd9906000338-280-160.jpg" alt="Img">
            </div>
            <div class="projectIntro">
              政府对开发公司的实力要求不严，开发商实力良莠不齐，受传统观念束缚严重，
              不重视客源心理及市场发展特性，主观开发，追求暴利，无品牌意识，对专业销售机构极度排斥。
              产品形式单一（多层为主），缺乏特色，不注重整体规划，且有明显区域性特征（集中在千佛山周边）。
              无整体营销思路，盲目追求高利，定价偏高，且无有效的表现及宣传手法，不注重品牌的培养和树立。
            </div>


          </li>

          <li class="listItem clearfix">
            <div class="moreInfo">更多项目......</div>
          </li>
        </ul>
      </div><!-- /.project-post -->

    </div><!-- /.project-main -->

    <div class="col-sm-8 bbs_block blockShadow">
      <ul>
        <li class="listItem clearfix bbs_header">
          <div class="searchType">符合条件的帖子:</div>
        </li>

        <li class="listItem clearfix">
          <div class="user-pic">
            <a href="/otherUser?uid=15" target="_blank"><img src="/hotUsers/userPhoto?oneHotUserId=15"></a>
            <p class="user-name"><a href="/otherUser?uid=15" target="_blank">AH</a><span class="sex">男</span></p>
          </div>
          <div class="Info">
            <div class="infoTitle">
              <a href="#" data-bind="click: function(){active_part(5)}" class="setTop bbsTopic">
                [置顶]政府对开发公司的实力要求不严，开发商实力良莠不齐，受传统观念束缚严重。</a>
            </div>
            <div class="infoIntro">
              不重视客源心理及市场发展特性，主观开发，追求暴利，无品牌意识，对专业销售机构极度排斥。
              产品形式单一（多层为主），缺乏特色，不注重整体规划，且有明显区域性特征（集中在千佛山周边）。
              无整体营销思路，盲目追求高利，定价偏高，且无有效的表现及宣传手法，不注重品牌的培养和树立。
            </div>
            <div class="date">
              2015-7-25 10:05
            </div>
          </div>
        </li>

        <li class="listItem clearfix">
          <div class="user-pic">
            <a href="/otherUser?uid=15" target="_blank"><img src="/hotUsers/userPhoto?oneHotUserId=15"></a>
            <p class="user-name"><a href="/otherUser?uid=15" target="_blank">AH</a><span class="sex">男</span></p>
          </div>
          <div class="Info">
            <div class="infoTitle">
              <a href="#" data-bind="click: function(){active_part(5)}" class="setTop bbsTopic">
                [置顶]政府对开发公司的实力要求不严，开发商实力良莠不齐，受传统观念束缚严重。</a>
            </div>
            <div class="infoIntro">
              不重视客源心理及市场发展特性，主观开发，追求暴利，无品牌意识，对专业销售机构极度排斥。
              产品形式单一（多层为主），缺乏特色，不注重整体规划，且有明显区域性特征（集中在千佛山周边）。
              无整体营销思路，盲目追求高利，定价偏高，且无有效的表现及宣传手法，不注重品牌的培养和树立。
            </div>
            <div class="date">
              2015-7-25 10:05
            </div>
          </div>
        </li>

        <li class="listItem clearfix">
          <div class="user-pic">
            <a href="/otherUser?uid=15" target="_blank"><img src="/hotUsers/userPhoto?oneHotUserId=15"></a>
            <p class="user-name"><a href="/otherUser?uid=15" target="_blank">AH</a><span class="sex">男</span></p>
          </div>
          <div class="Info">
            <div class="infoTitle">
              <a href="#" data-bind="click: function(){active_part(5)}" class="bbsTopic">
                政府对开发公司的实力要求不严，开发商实力良莠不齐，受传统观念束缚严重。</a>
            </div>
            <div class="infoIntro">
              不重视客源心理及市场发展特性，主观开发，追求暴利，无品牌意识，对专业销售机构极度排斥。
              产品形式单一（多层为主），缺乏特色，不注重整体规划，且有明显区域性特征（集中在千佛山周边）。
              无整体营销思路，盲目追求高利，定价偏高，且无有效的表现及宣传手法，不注重品牌的培养和树立。
            </div>
            <div class="date">
              2015-7-25 10:05
            </div>
          </div>
        </li>
      </ul>
    </div><!-- /.project-post -->

  </div><!-- /.row -->

</div><!-- /.container -->

<c:choose>
  <c:when test="${empty sessionScope.user}">
  </c:when>
  <c:otherwise>
    <div id = "drop" class="menu" style="position: absolute;margin-top: 10px;margin-left: 1100px;">
      <ul>
        <li>
          <ul >
            <li><a class="first">Signed in as ${sessionScope.user.username}</a></li>
            <li><a href="/user" class="button 3">个人信息</a></li>
            <li><a href="/exit" class="button last">退出登录</a></li>

          </ul>
        </li>
      </ul>
    </div>
  </c:otherwise>
</c:choose>

<jsp:include page="commonFooter.jsp"/>

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="/js/page/commonHeader.js"></script>
<script src="/js/page/searchResult.js"></script>
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
    $.get("/usermessage",function (result){
      document.getElementById("messages").innerHTML = result;
    });
  });
</script>

</body>
</html>
