<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- right side part -->
  <div class="settings-right col-md-9 wrapped-boxes">
    <div class="row">
      <label for="name" class="col-md-2 text-right">昵称</label>
      <div class="col-md-8">
        <input type="text" name="name" id="name" class="form-control" required="required">
      </div>
    </div>
    <div class="row">
      <label for="introduction" class="col-md-2 text-right">简介</label>
      <div class="col-md-8">
      <textarea name="introduction" id="introduction" class="form-control" rows="3" required="required"></textarea>
        <!-- <input type="text" name="name" id="name" class="form-control" required="required"> -->
      </div>
    </div>
    <div class="row">
      <label for="birth" class="col-md-2 text-right">生日</label>
      <div class="col-md-8">
        <input type="text" name="birth" id="birth" class="form-control" required="required">
      </div>
    </div>
  </div>
