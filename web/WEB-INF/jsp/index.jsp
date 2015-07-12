<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head id="head">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">utf-8
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

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

</head>
<!-- NAVBAR
================================================== -->
<body id="body">
<!-- Carousel
================================================== -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Match Us</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" id="login" data-toggle="modal" data-target="#userlogin">登陆</a></li>
                <li><a href="#" id="sign_in" data-toggle="modal" data-target="#usersignin">注册</a></li>
                <li><a href="#" id="help">帮助</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="大牛，项目...">
            </form>
        </div>
    </div>
</nav>

<div class="modal fade" id="userlogin" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel">登陆</h4>
            </div>
            <div class="modal-body">
                <form class='form-signin' method="post" action="/login">
                    <div class="form-group">
                        <label class="control-label">注册邮箱：</label>
                        <input type='email' id='inputEmail'  name="username" class='form-control' placeholder='Email address' required autofocus>
                    </div>
                    <div class="form-group">
                        <label class="control-label">密码：</label>
                        <input type='password' id='inputPassword' name="password" class='form-control' placeholder='Password' required>
                    </div>
                    <div class='checkbox'>
                        <label>
                            <input type='checkbox' value='remember-me'> 记住我
                        </label>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" type="submit">确认</button>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="usersignin" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="signin_title">注册</h4>
            </div>
            <div class="modal-body">
                <form class='form-signin'>
                    <div class="form-group">
                        <label class="control-label">注册邮箱：</label>
                        <input type='email' id='inEmail' class='form-control' placeholder='Email address' required autofocus>
                    </div>
                    <div class="form-group">
                        <label class="control-label">密码：</label>
                        <input type='password' id='inPassword' class='form-control' placeholder='Password' required>
                    </div>
                    <div class="form-group">
                        <label class="control-label">确认密码：</label>
                        <input type='password' id='sureinPassword' class='form-control' placeholder='SurePassword' required>
                    </div>
                    <div class="form-group">
                        <label class="control-label">昵称</label>
                        <input type="text" id="inName" class="form-control" placeholder="Name" required>
                    </div>
                    <div class="form-group">
                        <label class="control-label">验证码</label>
                        <input type="text" id="sureCode" class="form-control" placeholder="SureCode" required>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" type="submit">确认</button>
            </div>
        </div>
    </div>
</div>




<div class="topbanner">
    <div class="topbanner_content">
        <div class="topbanner_img" style="background-image: url(../../image/ini/banner1.jpg)">
        </div>
    </div>
</div>


<div class="container marketing">
    <!-- START THE FEATURETTES -->

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading">First featurette heading. <span class="text-muted">It'll blow your mind.</span></h2>
            <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5">
            <img class="featurette-image img-responsive center-block" src="../../image/ini/kk.jpg" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
            <h2 class="featurette-heading">Oh yeah, it's that good. <span class="text-muted">See for yourself.</span></h2>
            <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
            <img class="featurette-image img-responsive center-block" src="../../image/ini/kk.jpg" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="row featurette">
        <div class="col-md-7">
            <h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
            <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
        </div>
        <div class="col-md-5">
            <img class="featurette-image img-responsive center-block" src="../../image/ini/kk.jpg" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
    </div>

    <hr class="featurette-divider">

    <div class="projects-header page-header">
        <h2>优质项目推荐</h2>
        <p>这些项目好牛逼啊！！！！</p>
    </div>


    <div class="projects">
        <ul class="projects-index clearfix">
            <li>
                <a href="/view/282">
                    <div class="projects-img">
                        <img src="http://img.mukewang.com/54c5e5ab0001dd9906000338-280-160.jpg" alt="">
                    </div>
                    <div class="projects-info clearfix">
                        <p>手把手教你用 Unity3D 开发一款休闲游戏</p>
                        <span class="l">更新至7-1</span>
                        <span class="r">课程时长： 1小时58分</span>
                    </div>
                    <div class="projects-subinfo clearfix">
                        <h2>《小十传奇》 Unity3D 休闲游戏开发</h2>
                        <span class="l">5小时前更新</span>
                        <span class="r">296人学习</span>
                    </div>
                </a>
            </li>

            <li>
                <a href="/view/387">
                    <div class="projects-img">
                        <img src="http://img.mukewang.com/5549b15d0001661f06000338-280-160.jpg" alt="">
                    </div>
                    <div class="projects-info clearfix">
                        <p>Hive是基于HDFS的数据仓库。</p>
                        <span class="l">更新至7-1</span>
                        <span class="r">课程时长： 2小时20分</span>
                    </div>
                    <div class="projects-subinfo clearfix">
                        <h2>Hive旅程之初识印象</h2>
                        <span class="l">1天前更新</span>
                        <span class="r">745人学习</span>
                    </div>
                </a>
            </li>

            <li>
                <a href="/view/438">
                    <div class="projects-img">
                        <img src="http://img.mukewang.com/55909e3d0001af6506000338-280-160.jpg" alt="">
                    </div>
                    <div class="projects-info clearfix">
                        <p>带你率先领略PHP7.0的风采。</p>
                        <span class="l">更新至2-1</span>
                        <span class="r">课程时长：30分</span>
                    </div>
                    <div class="projects-subinfo clearfix">
                        <h2>PHP7.0新特性</h2>
                        <span class="l">1天前更新</span>
                        <span class="r">5760人学习</span>
                    </div>
                </a>
            </li>

            <li>
                <a href="/view/445">
                    <div class="projects-img">
                        <img src="http://img.mukewang.com/559b904a0001a9ed06000338-280-160.jpg" alt="">
                    </div>
                    <div class="projects-info clearfix">
                        <p>使用HTML5与CSS3搭建超酷扁平化风格博客</p>
                        <span class="l">更新至3-8</span>
                        <span class="r">课程时长： 1小时51分</span>
                    </div>
                    <div class="projects-subinfo clearfix">
                        <h2>CSS3扁平化风格博客</h2>
                        <span class="l">2天前更新</span>
                        <span class="r">2829人学习</span>
                    </div>
                </a>
            </li>

            <li>
                <a href="/view/443">
                    <div class="projects-img">
                        <img src="http://img.mukewang.com/559636e3000168b006000338-280-160.jpg" alt="">
                    </div>
                    <div class="projects-info clearfix">
                        <p>使用maven来构建和管理Java项目!</p>
                        <span class="l">更新至5-1</span>
                        <span class="r">课程时长： 2小时 0分</span>
                    </div>
                    <div class="projects-subinfo clearfix">
                        <h2>项目管理利器——maven</h2>
                        <span class="l">2天前更新</span>
                        <span class="r">3179人学习</span>
                    </div>
                </a>
            </li>

            <li>
                <a href="/view/437">
                    <div class="projects-img">
                        <img src="http://img.mukewang.com/558d15990001ea1106000338-280-160.jpg" alt="">
                    </div>
                    <div class="projects-info clearfix">
                        <p>数据库开发中应用广泛的高级查询！</p>
                        <span class="l">更新至5-5</span>
                        <span class="r">课程时长： 3小时24分</span>
                    </div>
                    <div class="projects-subinfo clearfix">
                        <h2>Oracle高级查询</h2>
                        <span class="l">2天前更新</span>
                        <span class="r">2148人学习</span>
                    </div>
                </a>
            </li>

            <li>
                <a href="/view/441">
                    <div class="projects-img">
                        <img src="http://img.mukewang.com/5594a8e50001332006000338-280-160.jpg" alt="">
                    </div>
                    <div class="projects-info clearfix">
                        <p>想让你的界面跳舞吗？本次课程你值得拥有</p>
                        <span class="l">更新至4-1</span>
                        <span class="r">课程时长： 1小时25分</span>
                    </div>
                    <div class="projects-subinfo clearfix">
                        <h2>iOS动画案例之会跳舞的界面(上)</h2>
                        <span class="l">2天前更新</span>
                        <span class="r">2977人学习</span>
                    </div>
                </a>
            </li>

            <li>
                <a href="/view/444">
                    <div class="projects-img">
                        <img src="http://img.mukewang.com/5598b22f0001ed0e06000338-280-160.jpg" alt="">
                    </div>
                    <div class="projects-info clearfix">
                        <p>本课将使用SurfaceView来实现抽奖转盘。</p>
                        <span class="l">更新至5-1</span>
                        <span class="r">课程时长： 1小时30分</span>
                    </div>
                    <div class="projects-subinfo clearfix">
                        <h2>SurfaceView-实现抽奖转盘</h2>
                        <span class="l">2天前更新</span>
                        <span class="r">2194人学习</span>
                    </div>
                </a>
            </li>

        </ul>
    </div>


    <hr class="featurette-divider">

    <div class="projects-header page-header">
        <h2>结交牛人</h2>
        <p>看看底下的牛人->_-></p>
    </div>

    <section class="pe-container">
        <ul id="pe-thumbs" class="pe-thumbs">
            <li><a href="#"><img src="../../image/ini/thumbs/1.jpg" /><div class="pe-description"><h3>time</h3><p>Since time, and his predestinated end</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/2.jpg" /><div class="pe-description"><h3>hopeful</h3><p>Abridged the circuit of his hopeful days</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/3.jpg" /><div class="pe-description"><h3>virtue</h3><p>Whiles both his youth and virtue did intend</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/4.jpg" /><div class="pe-description"><h3>endeavors</h3><p>The good endeavors of deserving praise</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/5.jpg" /><div class="pe-description"><h3>monument</h3><p>What memorable monument can last</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/6.jpg" /><div class="pe-description"><h3>name</h3><p>Whereon to build his never-blemished name</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/7.jpg" /><div class="pe-description"><h3>life was graced</h3><p>But his own worth, wherein his life was graced</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/8.jpg" /><div class="pe-description"><h3>the same</h3><p>Sith as that ever he maintained the same?</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/9.jpg" /><div class="pe-description"><h3>oblivion</h3><p>Oblivion in the darkest day to come</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/10.jpg" /><div class="pe-description"><h3>sin shall tread</h3><p>When sin shall tread on merit in the dust</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/11.jpg" /><div class="pe-description"><h3>lamentable tomb</h3><p>Cannot rase out the lamentable tomb</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/12.jpg" /><div class="pe-description"><h3>short-lived deserts</h3><p>Of his short-lived deserts; but still they must</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/13.jpg" /><div class="pe-description"><h3>hearts and memories</h3><p>Even in the hearts and memories of men</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/14.jpg" /><div class="pe-description"><h3>respect</h3><p>Claim fit respect, that they, in every limb</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/15.jpg" /><div class="pe-description"><h3>comfort</h3><p>Remembering what he was, with comfort then</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/16.jpg" /><div class="pe-description"><h3>pattern</h3><p>May pattern out one truly good, by him</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/17.jpg" /><div class="pe-description"><h3>truly good</h3><p>For he was truly good, if honest care</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/18.jpg" /><div class="pe-description"><h3>harmless conversation</h3><p>Of harmless conversation may commend</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/19.jpg" /><div class="pe-description"><h3>recompensed</h3><p>Ill recompensed only in his end</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/20.jpg" /><div class="pe-description"><h3>tongue</h3><p>Nor can the tongue of him who loved him least</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/21.jpg" /><div class="pe-description"><h3>superlative</h3><p>To one superlative above the rest</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/22.jpg" /><div class="pe-description"><h3>steady faith</h3><p>Of many men in steady faith reprove</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/23.jpg" /><div class="pe-description"><h3>constant temper</h3><p>His constant temper, in the equal weight</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/24.jpg" /><div class="pe-description"><h3>thankfulness</h3><p>Of thankfulness and kindness: Truth doth leave</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/25.jpg" /><div class="pe-description"><h3>proof</h3><p>Sufficient proof, he was in every right</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/26.jpg" /><div class="pe-description"><h3>thankful</h3><p>As kind to give, as thankful to receive.</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/27.jpg" /><div class="pe-description"><h3>curious eye</h3><p>The curious eye of a quick-brained survey</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/28.jpg" /><div class="pe-description"><h3>scantly find</h3><p>Could scantly find a mote amidst the sun</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/29.jpg" /><div class="pe-description"><h3>too-shortened days</h3><p>Of his too-shortened days, or make a prey</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/30.jpg" /><div class="pe-description"><h3>faulty errors</h3><p>Of any faulty errors he had done</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/31.jpg" /><div class="pe-description"><h3>spleenful sense</h3><p>Not that he was above the spleenful sense</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/32.jpg" /><div class="pe-description"><h3>spite of malice</h3><p>And spite of malice, but for that he had</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/33.jpg" /><div class="pe-description"><h3>innocence</h3><p>Warrant enough in his own innocence</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/34.jpg" /><div class="pe-description"><h3>nature</h3><p>Against the sting of some in nature bad</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/35.jpg" /><div class="pe-description"><h3>absolutely blest</h3><p>Yet who is he so absolutely blest</p></div></a></li>
            <li><a href="#"><img src="../../image/ini/thumbs/36.jpg" /><div class="pe-description"><h3>mortal frame</h3><p>That lives encompassed in a mortal frame</p></div></a></li>
        </ul>
    </section>

    <hr class="featurette-divider">

    <div class="jumbotron">
        <h1>Marketing stuff!</h1>
        <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet.</p>
        <p><a class="btn btn-lg btn-success" href="#" role="button">加入我们吧</a></p>
    </div>
    <!-- /END THE FEATURETTES -->

    <hr class="featurette-divider">

    <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2014 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
    </footer>

</div><!-- /.container -->






<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/page/jquery.proximity.js"></script>

<script type="text/javascript">
    $(function() {

        var Photo	= (function() {

            // list of thumbs
            var $list		= $('#pe-thumbs'),
            // list's width and offset left.
            // this will be used to know the position of the description container
                    listW		= $list.width(),
                    listL		= $list.offset().left,
            // the images
                    $elems		= $list.find('img'),
            // the description containers
                    $descrp		= $list.find('div.pe-description'),
            // maxScale : maximum scale value the image will have
            // minOpacity / maxOpacity : minimum (set in the CSS) and maximum values for the image's opacity
                    settings	= {
                        maxScale	: 1.3,
                        maxOpacity	: 0.9,
                        minOpacity	: Number( $elems.css('opacity') )
                    },
                    init		= function() {

                        // minScale will be set in the CSS
                        settings.minScale = _getScaleVal() || 1;
                        // preload the images (thumbs)
                        _loadImages( function() {

                            _calcDescrp();
                            _initEvents();

                        });

                    },
            // Get Value of CSS Scale through JavaScript:
            // http://css-tricks.com/get-value-of-css-rotation-through-javascript/
                    _getScaleVal= function() {

                        var st = window.getComputedStyle($elems.get(0), null),
                                tr = st.getPropertyValue("-webkit-transform") ||
                                        st.getPropertyValue("-moz-transform") ||
                                        st.getPropertyValue("-ms-transform") ||
                                        st.getPropertyValue("-o-transform") ||
                                        st.getPropertyValue("transform") ||
                                        "fail...";

                        if( tr !== 'none' ) {

                            var values = tr.split('(')[1].split(')')[0].split(','),
                                    a = values[0],
                                    b = values[1],
                                    c = values[2],
                                    d = values[3];

                            return Math.sqrt( a * a + b * b );

                        }

                    },
            // calculates the style values for the description containers,
            // based on the settings variable
                    _calcDescrp	= function() {

                        $descrp.each( function(i) {

                            var $el		= $(this),
                                    $img	= $el.prev(),
                                    img_w	= $img.width(),
                                    img_h	= $img.height(),
                                    img_n_w	= settings.maxScale * img_w,
                                    img_n_h	= settings.maxScale * img_h,
                                    space_t = ( img_n_h - img_h ) / 2,
                                    space_l = ( img_n_w - img_w ) / 2;

                            $el.data( 'space_l', space_l ).css({
                                height	: settings.maxScale * $el.height(),
                                top		: -space_t,
                                left	: img_n_w - space_l
                            });

                        });

                    },
                    _initEvents	= function() {

                        $elems.on('proximity.Photo', { max: 80, throttle: 10, fireOutOfBounds : true }, function(event, proximity, distance) {

                            var $el			= $(this),
                                    $li			= $el.closest('li'),
                                    $desc		= $el.next(),
                                    scaleVal	= proximity * ( settings.maxScale - settings.minScale ) + settings.minScale,
                                    scaleExp	= 'scale(' + scaleVal + ')';

                            // change the z-index of the element once it reaches the maximum scale value
                            // also, show the description container
                            if( scaleVal === settings.maxScale ) {

                                $li.css( 'z-index', 1000 );

                                if( $desc.offset().left + $desc.width() > listL + listW ) {

                                    $desc.css( 'left', -$desc.width() - $desc.data( 'space_l' ) );

                                }

                                $desc.fadeIn( 800 );

                            }
                            else {

                                $li.css( 'z-index', 1 );

                                $desc.stop(true,true).hide();

                            }

                            $el.css({
                                '-webkit-transform'	: scaleExp,
                                '-moz-transform'	: scaleExp,
                                '-o-transform'		: scaleExp,
                                '-ms-transform'		: scaleExp,
                                'transform'			: scaleExp,
                                'opacity'			: ( proximity * ( settings.maxOpacity - settings.minOpacity ) + settings.minOpacity )
                            });

                        });

                    },
                    _loadImages	= function( callback ) {

                        var loaded 	= 0,
                                total	= $elems.length;

                        $elems.each( function(i) {

                            var $el = $(this);

                            $('<img/>').load( function() {

                                ++loaded;
                                if( loaded === total )
                                    callback.call();

                            }).attr( 'src', $el.attr('src') );

                        });

                    };

            return {
                init	: init
            };

        })();

        Photo.init();

    });
</script>

</body>
</html>
