<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- right side part -->\
<form action="/user/settings/basic" method="post">
    <div class="settings-right col-md-9 wrapped-boxes">
        <div class="row">
            <label for="name" class="col-md-2 text-right">昵称</label>

            <div class="col-md-8">
                <input type="text" name="name" id="name" class="form-control" required="required">
            </div>
        </div>
        <div class="row">
            <label for="university" class="col-md-2 text-right">所在学校</label>

            <div class="col-md-8">
                <input type="text" name="university" id="university" class="form-control" required="required"/>
            </div>
        </div>
        <div class="row">
            <label for="major" class="col-md-2 text-right">就读专业</label>

            <div class="col-md-8">
                <input type="text" name="major" id="major" class="form-control" required="required"/>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label for="adress" class="col-md-2 text-right">所在地</label>

                <div class="col-md-10">
                    <input type="text" name="address" id="adress" class="form-control" required="required">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
            	<label for="good_at" class="col-md-2 text-right">擅长领域</label>
            	<div class="col-md-10">
            		<input type="text" name="good_at" id="good_at" class="form-control" required="required" >
            	</div>
            </div>
        </div>
        <div class="row">
            <label for="birth" class="col-md-2 text-right">生日</label>

            <div class="col-md-8">
                <input type="text" name="birth" id="birth" class="form-control" required="required">
            </div>
        </div>
        <div class="row">
            <label for="introduction" class="col-md-2 text-right">简介</label>

            <div class="col-md-10">
                <textarea name="introduction" id="introduction" class="form-control" rows="3"
                          required="required"></textarea>
                <!-- <input type="text" name="name" id="name" class="form-control" required="required"> -->
            </div>
        </div>

        <input class="btn btn-success" type="submit" value="确认修改">
    </div>
</form>

