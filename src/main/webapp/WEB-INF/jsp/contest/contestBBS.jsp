<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Seven
  Date: 15/7/25
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<input id="postID" type="hidden" value="${postC.post_id}">
<div class="bbs_block blockShadow">
  <ul>
    <li class="listItem clearfix bbs_header">
      <div class="bbsTitle">${postC.post_title}</div>
    </li>
  <c:forEach var="reply" items="${replyList}">
    <li class="listItem clearfix">
      <div class="user-pic">
        <a href="/otherUser?uid=${reply.reply_user.uid}" target="_blank">
          <img src="/hotUsers/userPhoto?oneHotUserId=${reply.reply_user.uid}">
        </a>
        <p class="user-name">
          <a href="/otherUser?uid=${reply.reply_user.uid}" target="_blank">${reply.reply_user.username}</a>
          <span class="sex">${reply.reply_user.sex}</span>
        </p>
      </div>
      <div class="Info">
        <div class="textInfo">
          ${reply.reply_content}
        </div>
        <div class="date">
          ${reply.reply_createtime}
        </div>
      </div>
    </li>
  </c:forEach>


    <%--<li class="listItem clearfix">--%>
      <%--<div class="user-pic">--%>
        <%--<a href="/otherUser?uid=13" target="_blank"><img src="/hotUsers/userPhoto?oneHotUserId=13"></a>--%>
        <%--<p class="user-name"><a href="/otherUser?uid=13" target="_blank">gjp</a><span class="sex">男</span></p>--%>
      <%--</div>--%>
      <%--<div class="Info">--%>
        <%--<div class="textInfo">--%>
          <%--政府对开发公司的实力要求不严，开发商实力良莠不齐，受传统观念束缚严重，--%>
          <%--不重视客源心理及市场发展特性，主观开发，追求暴利，无品牌意识，对专业销售机构极度排斥。--%>
          <%--产品形式单一（多层为主），缺乏特色，不注重整体规划，且有明显区域性特征（集中在千佛山周边）。--%>
          <%--无整体营销思路，盲目追求高利，定价偏高，且无有效的表现及宣传手法，不注重品牌的培养和树立。--%>
        <%--</div>--%>
        <%--<div class="date">--%>
          <%--2015-7-25 10:05--%>
                                <%--<span class="replyBtn">--%>
                                    <%--<a>--%>
                                      <%--评论--%>
                                    <%--</a>--%>
                                <%--</span>--%>
        <%--</div>--%>

      <%--</div>--%>
    <%--</li>--%>

    <%--<li class="listItem clearfix">--%>
      <%--<div class="user-pic">--%>
        <%--<a href="/otherUser?uid=15" target="_blank"><img src="/hotUsers/userPhoto?oneHotUserId=15"></a>--%>
        <%--<p class="user-name"><a href="/otherUser?uid=15" target="_blank">AH</a><span class="sex">男</span></p>--%>
      <%--</div>--%>
      <%--<div class="Info">--%>
        <%--<div class="textInfo">--%>
          <%--政府对开发公司的实力要求不严，开发商实力良莠不齐，受传统观念束缚严重，--%>
          <%--不重视客源心理及市场发展特性，主观开发，追求暴利，无品牌意识，对专业销售机构极度排斥。--%>
          <%--产品形式单一（多层为主），缺乏特色，不注重整体规划，且有明显区域性特征（集中在千佛山周边）。--%>
          <%--无整体营销思路，盲目追求高利，定价偏高，且无有效的表现及宣传手法，不注重品牌的培养和树立。--%>
        <%--</div>--%>
        <%--<div class="date">--%>
          <%--2015-7-25 10:05--%>
                                <%--<span class="replyBtn">--%>
                                    <%--<a>--%>
                                      <%--评论--%>
                                    <%--</a>--%>
                                <%--</span>--%>
        <%--</div>--%>

      <%--</div>--%>
    <%--</li>--%>

  </ul>

  <div class="replyArea">
    <textarea class="form-control replyContentS" rows="6" name="topicContent" id="replyContent" placeholder="内容"></textarea>
    <button type="button" class="rebtn" id="replyTopic" style="margin-top: 10px;left:88%;">回复楼主</button>
  </div>
  <script>
    var repn = document.getElementById("replyTopic");
    repn.onclick = function(){
      alert("in reply");
      alert(document.getElementById('postID').value);
      alert(document.getElementById('replyContent').value);
      $.post("/post/reply",
              {
                "postID":document.getElementById("postID").value,
                "replyContent":document.getElementById("replyContent").value
              },
              function(data){
                alert("infuncton");
                if(data=='fail'){
                  alert('游客请先登录');
                }else if(data=='success'){
                  alert('回复成功');
                }else{
                  alert('other error');
                }
              },
              "text"
      );
    };
  </script>
</div><!-- /.project-post -->
