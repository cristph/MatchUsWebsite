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
  <script type="text/javascript" src="/js/page/commonHeader.js"></script>
  <link href="/css/page/commonHeader.css" rel="stylesheet" type="text/css">
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
  <form role="form" enctype="multipart/form-data" method="post">
    <div class="row">
      <div class="form-group col-md-6">
        <label >项目名称</label>
        <input type="text" class="form-control input-sm" id="projectname" data-toggle="popover" title="项目标题参考模板" data-html="true" data-content="
          基于XXX平台，用于XXX功能，类似于XXX的应用<br>
(eg: 基于Android手机平台，用来实现手机数据的备份管理功能)
          " data-placement="bottom"
               placeholder="请输入名称">
      </div>
    </div>
    <div class="row">
      <div class="form-group col-md-6">
        <label >项目标签</label>
        <input type="text" class="form-control input-sm" id="projecttag" data-toggle="modal" data-target="#myModal" readOnly="true"
               placeholder="请点击添加标签">
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
      <label for="imagefile">上传图片</label>
      <input type="file" id="imagefile">
      <p class="help-block">上传项目描述图片,图片将在项目缩略图中展现</p>
    </div>
    <div class="form-group">
      <label for="extrafile">上传附件</label>
      <input type="file" id="extrafile">
      <p class="help-block">上传有关项目描述的附件</p>
    </div>
    <div class="row">
      <div class="form-group col-md-8">
        <label >涉及技术</label>
        <input type="text" class="form-control input-sm" id="protech" data-toggle="modal" data-target="#myModal2" readOnly="true"
               placeholder="请点击选择标签">
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


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">项目标签</h4>
      </div>
      <div class="modal-body">
        <button type="button" class="btn btn-default" data-dismiss="modal"
                onclick="document.getElementById('projecttag').value='移动应用';">移动应用</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"
                onclick="document.getElementById('projecttag').value='网站建设';">网站建设</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"
                onclick="document.getElementById('projecttag').value='企业软件';">企业软件</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"
                onclick="document.getElementById('projecttag').value='嵌入式开发';">嵌入式开发</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"
                onclick="document.getElementById('projecttag').value='视觉设计';">视觉设计</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"
                onclick="document.getElementById('projecttag').value='文案设计';">文案设计</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"
                onclick="document.getElementById('projecttag').value='其他类目';">其他类目</button>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel2">涉及技术</h4>
      </div>
      <div class="modal-body">
        <button type="button" class="btn btn-default"
                onclick="var ori= document.getElementById('protech').value;
                        if(ori.indexOf('Java')>0){return false;}
                        document.getElementById('protech').value=ori+'Java; ';">Java</button>
        <button type="button" class="btn btn-default"
                onclick="var ori= document.getElementById('protech').value;
                        if(ori.indexOf('C/C++')>0){return false;}
                        document.getElementById('protech').value=ori+'C/C++; ';">C/C++</button>
        <button type="button" class="btn btn-default"
                onclick="var ori= document.getElementById('protech').value;
                        if(ori.indexOf('HTML/CSS/JS')>0){return false;}
                        document.getElementById('protech').value=ori+'HTML/CSS/JS; ';">HTML/CSS/JS</button>
        <button type="button" class="btn btn-default"
                onclick="var ori= document.getElementById('protech').value;
                        if(ori.indexOf('PYTHON')>0){return false;}
                        document.getElementById('protech').value=ori+'PYTHON; ';">PYTHON</button>
        <button type="button" class="btn btn-default"
                onclick="var ori= document.getElementById('protech').value;
                        if(ori.indexOf('PHP')>0){return false;}
                        document.getElementById('protech').value=ori+'PHP; ';">PHP</button>
        <button type="button" class="btn btn-default"
                onclick="var ori= document.getElementById('protech').value;
                        if(ori.indexOf('RUBY')>0){return false;}
                        document.getElementById('protech').value=ori+'RUBY; ';">RUBY</button>
        <button type="button" class="btn btn-default"
                onclick="var ori= document.getElementById('protech').value;
                        if(ori.indexOf('LINUX')>0){return false;}
                        document.getElementById('protech').value=ori+'LINUX; ';">LINUX</button>
        <button type="button" class="btn btn-default"
                onclick="var ori= document.getElementById('protech').value;
                        if(ori.indexOf('MYSQL')>0){return false;}
                        document.getElementById('protech').value=ori+'MYSQL; ';">MYSQL</button>
        <button type="button" class="btn btn-default"
                onclick="var ori= document.getElementById('protech').value;
                        if(ori.indexOf('C#')>0){return false;}
                        document.getElementById('protech').value=ori+'C#; ';">C#</button>
        <button type="button" class="btn btn-default"
                onclick="var ori= document.getElementById('protech').value;
                        if(ori.indexOf('ANDROID')>0){return false;}
                        document.getElementById('protech').value=ori+'ANDROID; ';">ANDROID</button>
        <button type="button" class="btn btn-default"
                onclick="var ori= document.getElementById('protech').value;
                        if(ori.indexOf('IOS')>0){return false;}
                        document.getElementById('protech').value=ori+'IOS; ';">IOS</button>
        <button type="button" class="btn btn-default"
                onclick="var ori= document.getElementById('protech').value;
                        if(ori.indexOf('其他技术')>0){return false;}
                        document.getElementById('protech').value=ori+'其他技术; ';">其他技术</button>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">确认</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>