<%--
  Created by IntelliJ IDEA.
  User: Ezio
  Date: 7/14/2015
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/user/settings/portrait" method="post">
    <div class="settings-right wrapped-boxes">
        <div id="setting-avator" class="setting-wrap setting-avator clearfix">
            <div class="avator-img l">
                <div><img src="http://img.mukewang.com/user/54584ee0000179f302200220-220-220.jpg" width="220" height="220"></div>
                <div><input type="button" hidefocus="true" value="换一换" class="js-avator-try avator-try"></div>
            </div>
            <div class="avator-btn-group">
                <div id="avator-btns" class="avator-btn-inner">

                    <div class="avator-btn-wrap">
                        <form target="uploadtarget" action="postpic" method="post" enctype="multipart/form-data">
                            <a href="javascript:void(0)" hidefocus="true" class="avator-btn-fake">上传头像</a>
                            <input type="file" title="上传头像" name="fileField" id="upload" accept="image/*">
                            <input type="hidden" name="type" value="1">
                        </form>
                        <iframe src="about:blank" id="uploadtarget" name="uploadtarget" frameborder="0" style="display:none;"></iframe>
                    </div>
                </div>
                <div class="avator-upload-wrap" style="display:none;">
                    <span hidefocus="true" id="avator-btn-save" aria-role="button" class="rlf-btn-green btn-block">保存</span>
                </div>
            </div>

        </div>
        <%--<div id="portrait" class="row">--%>
            <%--<div class="col-md-6">--%>
                <%--<img src="//placehold.it/200x200" alt=""/>--%>
            <%--</div>--%>
            <%--<div class="col-md-6">--%>
                <%--<input type="submit" value="更换头像"/>--%>
            <%--</div>--%>
        <%--</div>--%>
    </div>
</form>