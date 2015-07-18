<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- right side part -->
<form data-bind="submit: update">
    <div class="settings-right wrapped-boxes active" data-bind="with: user">
        <div class="row">
            <label for="name" class="col-md-2 text-right">用户名</label>
            <div class="col-md-8">
                <input data-bind="value: username" type="text" name="name" id="name" class="form-control"
                       required="required">
            </div>
        </div>
        <div class="row">
            <label for="university" class="col-md-2 text-right">所在学校</label>

            <div class="col-md-8">
                <input data-bind="value: university" type="text" name="university" id="university"
                       class="form-control"/>
            </div>
        </div>
        <div class="row">
            <label for="major" class="col-md-2 text-right">就读专业</label>

            <div class="col-md-8">
                <input data-bind="value: major" type="text" name="major" id="major" class="form-control"/>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label for="adress" class="col-md-2 text-right">所在地</label>

                <div class="col-md-8">
                    <input data-bind="value: address" type="text" name="address" id="adress" class="form-control">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label for="good_at" class="col-md-2 text-right">擅长领域</label>

                <div class="col-md-8">
                    <input data-bind="value: skills" type="text" name="good_at" id="good_at" class="form-control">
                </div>
            </div>
        </div>
        <div class="row">
            <label for="birth" class="col-md-2 text-right">生日</label>

            <div class="col-md-8">
                <input data-bind="value: birthday" type="text" name="birth" id="birth" class="form-control">
            </div>
        </div>
        <div class="row">
            <label class="col-md-2 text-right">简介</label>

            <div class="col-md-10">
                <textarea data-bind="value: instruction" class="form-control" rows="5"></textarea>
            </div>
        </div>
        <p class="row form-group">
            <div class="col-md-2"></div>
            <input id="submit" class="btn btn-success col-md2" type="submit" value="确认修改">
        </p>
    </div>
</form>

