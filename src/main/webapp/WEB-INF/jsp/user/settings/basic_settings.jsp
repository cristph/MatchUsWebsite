<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- right side part -->
<form data-bind="submit: update">
    <div class="settings-right wrapped-boxes active" data-bind="with: user">
        <div class="row">
            <label for="name" class="col-md-2 text-right">用户名</label>

            <div class="col-md-8">
                <input data-bind="value: username" type="text" id="name" class="form-control"
                       required="required">
            </div>
        </div>
        <div class="row">
            <label class="col-md-2 text-right">性别</label>
            <label class="col-md-2">
                <input data-bind="checked: sex" type="radio" value="male">
                男
            </label>
            <label class="col-md-2">
                <input data-bind="checked: sex" type="radio" value="female">
                女
            </label>
        </div>
        <div class="row">
            <label for="university" class="col-md-2 text-right">所在学校</label>

            <div class="col-md-8">
                <input data-bind="value: university" type="text" id="university" class="form-control"/>
            </div>
        </div>
        <div class="row">
            <label for="major" class="col-md-2 text-right">就读专业</label>

            <div class="col-md-8">
                <input data-bind="value: major" type="text" id="major" class="form-control"/>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label for="address" class="col-md-2 text-right">所在地</label>

                <div class="col-md-8">
                    <input data-bind="value: address" type="text" id="address" class="form-control">
                </div>
            </div>
        </div>
        <div class="row">
            <label for="birth" class="col-md-2 text-right">生日</label>

            <div class="col-md-8">
                <input data-bind="value: birthday" type="text" id="birth" class="form-control">
            </div>
        </div>
        <div class="row">
            <label for="mobilephone" class="col-md-2 text-right">手机</label>

            <div class="col-md-8">
                <input data-bind="value: mobilephone" type="text" id="mobilephone" class="form-control"/>
            </div>
        </div>
        <div class="row">
            <label for="telephone" class="col-md-2 text-right">电话</label>

            <div class="col-md-8">
                <input data-bind="value: telephone" type="text" id="telephone" class="form-control"/>
            </div>
        </div>
        <div class="row">
            <label for="qq" class="col-md-2 text-right">QQ</label>

            <div class="col-md-8">
                <input data-bind="value: qq" type="text" id="qq" class="form-control"/>
            </div>
        </div>
        <div class="row">
            <label for="instruction" class="col-md-2 text-right">简介</label>

            <div class="col-md-10">
                <textarea data-bind="value: instruction" id="instruction" class="form-control" rows="5"></textarea>
            </div>
        </div>
        <p class="row form-group">
            <div class="col-md-2"></div>
            <input id="submit" class="btn btn-success col-md2" type="submit" value="确认修改">
        </p>
    </div>
</form>

