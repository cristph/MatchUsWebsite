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
  </ul>

  <div class="replyArea">
    <textarea class="form-control replyContentS" rows="6" name="topicContent" id="replyContent" placeholder="内容"></textarea>
    <button type="button" class="rebtn" id="replyTopic" style="margin-top: 10px;left:88%;">回复楼主</button>
  </div>
  <script>
    var repn = document.getElementById("replyTopic");
    repn.onclick = function(){
      $.post("/post/reply",
              {
                "postID":document.getElementById("postID").value,
                "replyContent":document.getElementById("replyContent").value
              },
              function(data){
                if(data=='fail'){
                  alert('游客请先登录');
                }else if(data=='success'){
                  $.get('/post/show',{postID:document.getElementById("postID").value},function(contestBBS){
                    $('#bbs').html(contestBBS);
                  });
                }else{
                  alert('other error');
                }
              },
              "text"
      );
    };
  </script>
</div>
