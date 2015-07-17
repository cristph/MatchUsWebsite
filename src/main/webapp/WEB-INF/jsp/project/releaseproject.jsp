<%--
  Created by IntelliJ IDEA.
  User: Seven
  Date: 15/7/17
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>发布项目</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
  <link href="//cdn.bootcss.com/jquery.tipsy/1.0.2/jquery.tipsy.css" rel="stylesheet">
  <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="/js/page/releasepro.js"></script>
  <script type="text/javascript">
    $(function () {
      $('[data-toggle="popover"]').popover()
    })
  </script>
</head>
<body>
<jsp:include page="../commonHeader.jsp"/>
<div class="container">
  <h2>发布项目</h2><br>
  <form role="form">
    <div class="row">
      <div class="form-group col-md-6">
        <label >项目名称</label>
        <input type="text" class="form-control input-sm" id="projectname"
               placeholder="请输入名称">
      </div>
    </div>
    <div class="row">
      <div class="form-group col-md-6">
        <label >项目标签</label>
        <input type="text" class="form-control input-sm" id="projecttag"
               placeholder="请输入标签">
      </div>
    </div>
    <div class="row">
      <div class="form-group col-md-8">
        <label >项目描述</label>
          <textarea class="form-control input-sm" id="projectdetail" data-toggle="popover" title="项目描述参考模板" data-html="true" data-content="
          <strong>一.详细需求：<br></strong>
          1.可将手机中的数据备份到本地sd卡中。<br>
          2.通过无线网络将手机中的资料备份到备份云端。<br>
          3.提供给在线编辑、浏览、搜索等功能，方便用户对手机资料的管理。<br>
          4.要注重用户体验和用户操作习惯<br>
          5.……<br>
          <strong>二. 验收标准<br></strong>
          1.完成以上的基本功能需求（是/否）<br>
          2.提交相关的源代码（是/否）<br>
          3.提交相关的开发文档（是/否）<br>
          4.确保在XXXXX的工作时间内完成并提交工作成果。<br>
          <strong>三. 团队要求<br></strong>
          1.希望找一个有丰富经验的XXXX（个人/团队/公司）承接这个项目。<br>
          2.希望这个团队最好能够在XXXXX地区。<br>
          3.希望能够最少XXX个人参与此项目。<br>
          4.需要提供UI设计和界面制作（是/否）<br>
          <strong>四.其它要求<br></strong>
          eg: 最好能够跨平台，能够帮助进行多机型的测试提供测试报告……" data-placement="bottom" rows="4"></textarea>
      </div></div>
    <div class="form-group">
      <label for="inputfile">上传附件</label>
      <input type="file" id="inputfile">
      <p class="help-block">上传项目描述图片或项目介绍文档</p>
    </div>
    <div class="row">
      <div class="form-group col-md-8">
        <label >涉及技术</label>
        <input type="text" class="form-control input-sm" id="protech"
               placeholder="请输入标签">
      </div></div>
    <div class="row">
      <div class="form-group col-md-8">
        <label >项目预算</label>
        <select class="form-control input-sm" id="proreward">
          <option>小于¥1,000</option>
          <option>¥1,000-¥3,000</option>
          <option>¥3,000-¥5,000</option>
          <option>¥5,000-¥10,000</option>
          <option>¥10,000－¥20,000</option>
          <option>¥20,000－¥50,000</option>
          <option>¥50,000以上</option>
        </select>
      </div></div>


    <div class="form-group">
      <label >联系方式</label>
      <div>
        <label class="checkbox-inline">
          <input type="checkbox" id="inlineCheckbox1" value="option1"> 手机
        </label>
        <label class="checkbox-inline">
          <input type="checkbox" class="hideemail" id="inlineCheckbox2" value="option2"> 邮箱
        </label>
        <label class="checkbox-inline">
          <input type="checkbox" class="hideqq" id="inlineCheckbox3" value="option3"> QQ
        </label>
        <label class="checkbox-inline">
          <input type="checkbox" class="hidephone" id="inlineCheckbox4" value="option3"> 固定电话
        </label>
        <label class="checkbox-inline">
          <input type="checkbox" class="hidefax" id="inlineCheckbox5" value="option3"> 传真
        </label>
      </div>
    </div>
    <form class="form-horizontal">
      <div class="row">
        <div class="form-group form-group-sm">
          <label class="col-sm-1 control-label" for="mobilephone">手机</label>
          <div class="col-sm-3">
            <input class="form-control" type="text" id="mobilephone" placeholder="">
          </div>
        </div></div>

      <div class="row hideemaili">
        <div class="form-group form-group-sm">
          <label class="col-sm-1 control-label" for="email">邮箱</label>
          <div class="col-sm-3">
            <input class="form-control" type="text" id="email" placeholder="">
          </div>
        </div></div>

      <div class="row hideqqi">
        <div class="form-group form-group-sm">
          <label class="col-sm-1 control-label" for="qq">QQ</label>
          <div class="col-sm-3">
            <input class="form-control" type="text" id="qq" placeholder="">
          </div>
        </div></div>

      <div class="row hidephonei">
        <div class="form-group form-group-sm">
          <label class="col-sm-1 control-label" for="phone">固定电话</label>
          <div class="col-sm-3">
            <input class="form-control" type="text" id="phone" placeholder="">
          </div>
        </div></div>

      <div class="row hidefaxi">
        <div class="form-group form-group-sm">
          <label class="col-sm-1 control-label" for="fax">传真</label>
          <div class="col-sm-3">
            <input class="form-control" type="text" id="fax" placeholder="">
          </div>
        </div></div>
    </form>
    <button type="submit" class="btn btn-default" id="submit_btn">提交</button>
  </form>

</div>
<script>
  flag= false;
  function addphone(){


    if(flag==false){
      phone.innerHTML="<input type='text' class='form-control'  placeholder='请输入手机号码'>";
      flag=true;
    }
    else{
      phone.innerHTML="";
      flag=false;
    }
  }
  $(document).ready(function(){
    $(".hideemaili").hide();
    $(".hideqqi").hide();
    $(".hidephonei").hide();
    $(".hidefaxi").hide();
  });
  $(document).ready(function(){
    $(".hideemail").click(function(){
      $(".hideemaili").toggle("100");
    });
  });
  $(document).ready(function(){
    $(".hideqq").click(function(){
      $(".hideqqi").toggle("100");
    });
  });
  $(document).ready(function(){
    $(".hidephone").click(function(){
      $(".hidephonei").toggle("100");
    });
  });
  $(document).ready(function(){
    $(".hidefax").click(function(){
      $(".hidefaxi").toggle("100");
    });
  });


  $(function(){
    $('#submit_btn').click(
            function(){
              alert("!");
              $.post("/project/add",
                      { "projectname":document.getElementById('projectname').value,
                        "projectdetail":document.getElementById('projectdetail').value,
                        "projecttag":document.getElementById('projecttag').value,
                        "protech":document.getElementById('protech').value,
                        "proreward":document.getElementById('proreward').value,
                        "mobilephone":document.getElementById('mobilephone').value,
                        "qq":document.getElementById('qq').value,
                        "email":document.getElementById('email').value,
                        "phone":document.getElementById('phone').value,
                        "fax":document.getElementById('fax').value
                      },
                      function(data){
                        //alert(data);
                        if (data=="true") {
                          window.top.location.href='/';
                        }
                        else {
                          alert("no");
                        }
                      });

            }
    );
  });

</script>
</body>
</html>