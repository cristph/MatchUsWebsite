<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head id="head">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Match Us</title>
    <!-- Bootstrap core CSS -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
    <link href="/css/page/cus.css" rel="stylesheet" type="text/css"/>
    <link href="/css/page/reset.css" rel="stylesheet" type="text/css"/>
    <link href="/css/page/style2.css" rel="stylesheet" type="text/css"/>
    <link href="/css/page/commonHeader.css" rel="stylesheet" type="text/css">
    <link href="/css/page/commonFooter.css" rel="stylesheet" type="text/css">

</head>
<!-- NAVBAR
================================================== -->
<body id="body">
<!-- Carousel
================================================== -->
<jsp:include page="commonHeader.jsp"/>

<div class="topbanner"></div>


<div class="container marketing">
    <!-- START THE FEATURETTES -->

    <div class="container">

        <div class="row">
            <div class="col-md-4" style="text-align: center">
                <img src="/image/ini/searchicon.jpg" width="190" height="190" />
                <br>
                <p>获取最热项目</p>
            </div>
            <div class="col-md-4" style="text-align: center">
                <img src="/image/ini/targeticon.jpg" width="235" height="190" />
                <br>
                <p>聚焦实战开发</p>
            </div>
            <div class="col-md-4" style="text-align: center">
                <img src="/image/ini/freeicon.jpg" width="190" height="190" />
                <br>
                <p>免费寻找牛人</p>
            </div>
        </div>
    </div>

    <div class="projects-header page-header">
        <p style="color:#d20104;font-size:160%">比赛推荐</p>
    </div>

    <div class="projects">
        <ul class="projects-index clearfix">
            <c:forEach var="project" items="${projects}">
                <li>
                    <a href="/project/getOneProject?pid=${project.pid}" target="_blank">
                        <div class="projects-img">
                            <c:choose>
                                <c:when test="${project.pid==1}" >
                                    <img src="http://ww4.sinaimg.cn/mw690/005ZoaEmjw1eujnqid1z6j306y04gt9u.jpg">
                                </c:when>
                                <c:when test="${project.pid==2}" >
                                    <img src="http://ww1.sinaimg.cn/mw690/005ZoaEmjw1eujnyuzepwj306y04gq30.jpg">
                                </c:when>
                                <c:otherwise>
                                    <img src="http://img.mukewang.com/54c5e5ab0001dd9906000338-280-160.jpg">
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="projects-info">
                            <p style="text-align: center">${project.skill}</p>
                            <span class="l">发布者:${project.publisher.username}</span>
                            <span class="r">电话:${project.phonenumber}</span>
                        </div>
                        <div class="projects-subinfo">
                            <h2>${project.pname}</h2>
                            <span class="l">&#65509;≈${project.reward}</span>
                            <span class="r">所在地:${project.location}</span>
                        </div>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>

    <div class="textStyle"><a href="">更多比赛......</a></div>

    <hr class="featurette-divider textDivider">

    <div class="projects-header page-header">
        <p style="color:#d20104;font-size:160%">热门话题</p>
    </div>

    <div class="project_info blockShadow">

        <div>
            <ul>

                <li class="listItem clearfix">
                    <div class="projectTitle">
                        <a href="/project/getOneProject?pid=1" target="_blank">软件学院EL比赛</a>
                    </div>
                    <div class="projectPublish">
                        <p>
                            2015-7-21  posted by <span><a href="/">njusoftware</a></span>
                        </p>
                    </div>
                    <div class="projectPicture">
                        <img src="http://ww4.sinaimg.cn/mw690/005ZoaEmjw1eujnqid1z6j306y04gt9u.jpg">
                    </div>
                    <div class="projectIntro">
                        嗨嗨嗨~大家期待已久的EL比赛开始报名啦！没组好队的要抓紧时间啦！没抱到大腿的不要悲伤~【求人不如求己！嘿嘿】下面是一些有关报名的详细信息：<br>
                        组队报名方面：<br>
                        1）原则上四人一队。如果因为特殊原因，可以接受个别人数不足四人的队伍。（关于这一点，我们将会在后文中提供一个队伍人数协调机制）<br>

                        2）全队队员必须皆为大一的学生。只要队伍中有一人不是大一的学生，将不会通过审核。<br>

                        ......
                    </div>


                </li>



                <li class="listItem clearfix">
                    <div class="moreInfo">更多话题......</div>
                </li>
            </ul>
        </div><!-- /.project-post -->

    </div><!-- /.project-main -->

    <hr class="featurette-divider">

    <div class="projects-header page-header">
        <p style="color:#d20104;font-size:160%">结交牛人</p>
    </div>

    <section class="pe-container">
        <ul id="pe-thumbs" class="pe-thumbs">
            <c:forEach items="${hotUsers}" var="user">
                <li>
                    <a href="/otherUser?uid=${user.uid}" target="_blank">
                        <img class="lazy" data-original="/hotUsers/userPhoto?oneHotUserId=${user.uid}">
                        <%--<img src="hotUsers/userPhoto?oneHotUserId=${user.uid}" alt="无头像"/>--%>
                        <div class="pe-description">
                            <h3>${user.username}</h3>
                            <p>${user.email}</p>
                        </div>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </section>

    <hr class="featurette-divider">

    <div class="jumbotron jumbotronHead">
        <h1>别再犹豫!</h1>
        <p class="lead">方便快捷的项目发布平台，轻松招兵买马！</p>
        <p class="lead">大量牛人，实践项目等你发现，交友&提升个人能力，一举两得！</p>

        <p class="jumbotronBt"><a type="button" class="btn btn-danger" href="#" role="button" data-toggle="modal" data-target="#usersignin" onClick="myReload()">加入我们</a></p>
    </div>
    <!-- /END THE FEATURETTES -->
</div>

<c:choose>
    <c:when test="${empty sessionScope.user}">
    </c:when>
    <c:otherwise>
        <div class="menu" style="position: absolute;margin-top: 10px;margin-left: 1100px;">
            <ul>
                <li>
                    <ul id = "drop">
                        <li><a class="first">Signed in as ${sessionScope.user.username}</a></li>
                        <li><a href="/user" class="button 3">个人信息</a></li>
                        <li><a href="/exit" class="button last">退出登录</a></li>

                    </ul>
                </li>
            </ul>
        </div>
    </c:otherwise>
</c:choose>

<!-- /.container -->
<jsp:include page="commonFooter.jsp"/>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="//cdn.bootcss.com/knockout/3.3.0/knockout-min.js"></script>
<script type="text/javascript" src="/js/page/jquery.proximity.js"></script>
<script type="text/javascript" src="/js/page/commonHeader.js"></script>
<script type="text/javascript" src="/js/page/jquery.lazyload.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("#banner").mouseover(function(){
            $("#drop").css("opacity","1");
            $(".button").css("cursor" ,"pointer");
        });
        $("#banner").mouseout(function(){
            setTimeout(function () {
                $('#drop').css("opacity","0");
                $(".button").css("cursor" ,"default");
            }, 3000);

        });
        $.get("/usermessage",function (result){
            if(result==0){
                $("#circle").css("opacity","0");
            }
            else{
                $("#circle").css("opacity","1");
                document.getElementById("messages").innerHTML = result;
            }

        });
    });
</script>



<script type="text/javascript">

    $("img.lazy").lazyload({
        event: "sporty"
    });

    $(window).bind("load", function() {
        var timeout = setTimeout(function() {$("img").trigger("sporty")}, 100);
    });

    $(function () {

        var Photo = (function () {

            // list of thumbs
            var $list = $('#pe-thumbs'),
            // list's width and offset left.
            // this will be used to know the position of the description container
                    listW = $list.width(),
                    listL = $list.offset().left,
            // the images
                    $elems = $list.find('img'),
            // the description containers
                    $descrp = $list.find('div.pe-description'),
            // maxScale : maximum scale value the image will have
            // minOpacity / maxOpacity : minimum (set in the CSS) and maximum values for the image's opacity
                    settings = {
                        maxScale: 1.3,
                        maxOpacity: 0.9,
                        minOpacity: Number($elems.css('opacity'))
                    },
                    init = function () {

                        // minScale will be set in the CSS
                        settings.minScale = _getScaleVal() || 1;
                        // preload the images (thumbs)
                        _loadImages(function () {

                            _calcDescrp();
                            _initEvents();

                        });

                    },
            // Get Value of CSS Scale through JavaScript:
            // http://css-tricks.com/get-value-of-css-rotation-through-javascript/
                    _getScaleVal = function () {

                        var st = window.getComputedStyle($elems.get(0), null),
                                tr = st.getPropertyValue("-webkit-transform") ||
                                        st.getPropertyValue("-moz-transform") ||
                                        st.getPropertyValue("-ms-transform") ||
                                        st.getPropertyValue("-o-transform") ||
                                        st.getPropertyValue("transform") ||
                                        "fail...";

                        if (tr !== 'none') {

                            var values = tr.split('(')[1].split(')')[0].split(','),
                                    a = values[0],
                                    b = values[1],
                                    c = values[2],
                                    d = values[3];

                            return Math.sqrt(a * a + b * b);

                        }

                    },
            // calculates the style values for the description containers,
            // based on the settings variable
                    _calcDescrp = function () {

                        $descrp.each(function (i) {

                            var $el = $(this),
                                    $img = $el.prev(),
                                    img_w = $img.width(),
                                    img_h = $img.height(),
                                    img_n_w = settings.maxScale * img_w,
                                    img_n_h = settings.maxScale * img_h,
                                    space_t = ( img_n_h - img_h ) / 2,
                                    space_l = ( img_n_w - img_w ) / 2;

                            $el.data('space_l', space_l).css({
                                height: settings.maxScale * $el.height(),
                                top: -space_t,
                                left: img_n_w - space_l
                            });

                        });

                    },
                    _initEvents = function () {

                        $elems.on('proximity.Photo', {
                            max: 80,
                            throttle: 10,
                            fireOutOfBounds: true
                        }, function (event, proximity, distance) {

                            var $el = $(this),
                                    $li = $el.closest('li'),
                                    $desc = $el.next(),
                                    scaleVal = proximity * ( settings.maxScale - settings.minScale ) + settings.minScale,
                                    scaleExp = 'scale(' + scaleVal + ')';

                            // change the z-index of the element once it reaches the maximum scale value
                            // also, show the description container
                            if (scaleVal === settings.maxScale) {

                                $li.css('z-index', 1000);

                                if ($desc.offset().left + $desc.width() > listL + listW) {

                                    $desc.css('left', -$desc.width() - $desc.data('space_l'));

                                }

                                $desc.fadeIn(800);

                            }
                            else {

                                $li.css('z-index', 1);

                                $desc.stop(true, true).hide();

                            }

                            $el.css({
                                '-webkit-transform': scaleExp,
                                '-moz-transform': scaleExp,
                                '-o-transform': scaleExp,
                                '-ms-transform': scaleExp,
                                'transform': scaleExp,
                                'opacity': ( proximity * ( settings.maxOpacity - settings.minOpacity ) + settings.minOpacity )
                            });

                        });

                    },
                    _loadImages = function (callback) {

                        var loaded = 0,
                                total = $elems.length;

                        $elems.each(function (i) {

                            var $el = $(this);

                            $('<img/>').load(function () {

                                ++loaded;
                                if (loaded === total)
                                    callback.call();

                            }).attr('src', $el.attr('src'));

                        });

                    };

            return {
                init: init
            };

        })();

        Photo.init();

    });
</script>



</body>
</html>
