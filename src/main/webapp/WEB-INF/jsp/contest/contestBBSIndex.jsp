<%--
  Created by IntelliJ IDEA.
  User: cristph
  Date: 2015/7/26
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="bbs_block blockShadow">
  <ul>
    <li class="listItem clearfix bbs_header">
      <div class="bbsTitle">EL大赛讨论版块</div>
    </li>

    <c:forEach var="post" items="${postList}">
      <li class="listItem clearfix">
        <div class="user-pic">
          <a href="/otherUser?uid=${post.poster.uid}" target="_blank"><img src="/userPhoto.jpg?uid=${post.poster.uid}"></a>
          <p class="user-name"><a href="/otherUser?uid=${post.poster.uid}" target="_blank">${post.poster.username}</a><span class="sex">${post.poster.sex}</span></p>
        </div>
        <div class="Info">
          <div class="infoTitle">
            <a href="#" data-bind="click: function(){active_part(5),load(${post.post_id})}" class="bbsTopic">
              ${post.post_title}</a>
          </div>
          <div class="infoIntro">
            ${post.post_content}
          </div>
          <div class="date">
            ${post.post_createtime}
          </div>
        </div>
      </li>
    </c:forEach>

  </ul>

  <div class="replyArea">
    <input type="text" class="form-control formTitle" name="topicTitle" id="topicTitle" placeholder="标题">
    <textarea class="form-control replyContent" rows="6" name="topicContent" id="topicContent" placeholder="内容"></textarea>
    <button type="button" class="rebtn" id="releaseTopic">发表新帖</button>
  </div>
</div><!-- /.project-post -->
