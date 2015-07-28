<%--
  Created by IntelliJ IDEA.
  User: Ezio
  Date: 7/14/2015
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="settings-right wrapped-boxes">
    <div id="setting-avator">
        <div class="avator-img l">
            <div><img src="/userPhoto.jpg?uid=${sessionScope.user.uid}" width="220" height="220"></div>
        </div>
        <div class="avator-btn-group">
            <div id="avator-btns" class="avator-btn-inner">

                <div class="avator-btn-wrap">
                    <iframe src="about:blank" id="uploadtarget" name="uploadtarget" style="display:none;"></iframe>
                    <form target="uploadtarget" action="/user/settings/uploadAvator" method="post" enctype="multipart/form-data">
                        <a href="javascript:void(0)" hidefocus="true" class="avator-btn-fake">上传头像</a>
                        <input type="file" name="avator">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>