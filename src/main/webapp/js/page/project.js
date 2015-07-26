var select = function () {
    changeColor(this);
    applySelect();
}

function applySelect() {
    var primary_btn_list = document.getElementsByClassName("btn-primary");
    var all_btn = document.getElementsByClassName("all-btn");
    var isall = 1;//是否全部为全部
    for (var i = 0; i < all_btn.length; i++) {
        if (all_btn[i].classList.contains("btn-default")) {
            isall = 0;
            break;
        }
    }
    if (isall == 1) {
        primary_btn_list = document.getElementsByClassName("btn btn-default");
    }//判断是否四个全部
    var dataContent = new Array();
    for (var i = 0; i < primary_btn_list.length; i++) {
        dataContent[i] = primary_btn_list[i].name;
    }
    addcloud();
    $.post("/Category", {"dataContent": dataContent}, function (projects) {
        refreshView(projects);
    });
    setTimeout(removecloud,300);
}

function refreshView(projects) {
    var project_div = document.getElementById("projects");
    if (projects[0].pid == -1) {
        project_div.innerHTML = "<div style='height: 500px'><h1 style='height: 500px;text-align: center'>此类目下暂无项目，敬请期待~~~</h1></div>";
    } else {
        var content = "<ul class=\"projects-index\">";
        for (var i = 0; i < projects.length; i++) {
            content += getOneProjectView(projects[i]);
        }
        content += "</ul>";
        project_div.innerHTML = content;
    }
}

function getOneProjectView(project) {
    var projectHTML = "<li>" +
        "<a href='/project/getOneProject?pid=" + project.pid + "' target=\"_blank\">" +
        "<div class=\"projects-img\">" +
        "<img src=\"http://img.mukewang.com/54c5e5ab0001dd9906000338-280-160.jpg\"> " +
        "</div>" +
        "<div class=\"projects-info\">" +
        "<p>" + project.skill + "</p> " +
        "<span class=\"left\">" + "发布者:" + project.userName + "</span> " +
        "<span class=\"right\">"+ "电话:" + project.phonenumber + "</span> " +
        "</div>" +
        "<div class=\"projects-subinfo\">" +
        "<h2 align='center'>" + project.pname + "</h2>" +
        "<span class =\"left\">" + "&#65509;≈" + project.reward + "</span>" +
        "<span class =\"right\">"+ "所在地:" + project.location + "</span>" +
        "</div> " +
        "</a> " +
        "</li>";
    return projectHTML;
}
function changeColor(btn) {
    var parent_element = btn.parentElement;//父元素
    var btn_group = parent_element.children;//所有兄弟元素
    if (btn.classList.contains("all-btn")) {
        if (btn.classList.contains("btn-default")) {
            for (var i = 0; i < btn_group.length; i++) {
                changeToDefault(btn_group[i]);
            }
            var all_btn = parent_element.getElementsByClassName("all-btn");
            changeToPrimary(all_btn[0]);
        }//全部按钮被点亮
    }//点击全部按钮
    else {
        reverseColor(btn);//将此元素颜色改变
        var isSelect = 0//是否有筛选像被选中
        for (var i = 0; i < btn_group.length; i++) {
            if (btn_group[i].classList.contains("btn-primary")) {
                isSelect = 1;
                break;
            }
        }
        var all_btn = parent_element.getElementsByClassName("all-btn");
        if (isSelect == 1) {
            changeToDefault(all_btn[0]);//取消选中全部按钮
        }
        else if (isSelect == 0) {
            changeToPrimary(all_btn[0]);//如果没有筛选像被选中则选中全部按钮
        }
    }//点击其他按钮
}

function reverseColor(btn) {
    if (btn.classList.contains("btn-primary")) {
        btn.classList.remove("btn-primary");
        btn.classList.add("btn-default");
    }
    else if (btn.classList.contains("btn-default")) {
        btn.classList.remove("btn-default");
        btn.classList.add("btn-primary");
    }
}//改变按钮颜色

function changeToDefault(btn) {
    if (btn.classList.contains("btn-primary")) {
        btn.classList.remove("btn-primary");
    }
    btn.classList.add("btn-default");
}//将按钮变为未选中

function changeToPrimary(btn) {
    if (btn.classList.contains("btn-default")) {
        btn.classList.remove("btn-default");
    }
    btn.classList.add("btn-primary");
}//将按钮变为选中

function addcloud() {
    var bodyWidth = document.documentElement.clientWidth;
    var bodyHeight = Math.max(document.documentElement.clientHeight, document.body.scrollHeight);
    var bgObj = document.createElement("div" );
    bgObj.setAttribute( 'id', 'bgDiv' );
    bgObj.style.position = "absolute";
    bgObj.style.top = "0";
    bgObj.style.background = "#000000";
    bgObj.style.filter = "progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75" ;
    bgObj.style.opacity = "0.5";
    bgObj.style.left = "0";
    bgObj.style.width = bodyWidth + "px";
    bgObj.style.height = bodyHeight + "px";
    bgObj.style.zIndex = "10000"; //设置它的zindex属性，让这个div在z轴最大，用户点击页面任何东西都不会有反应|
    document.body.appendChild(bgObj); //添加遮罩
    var loadingObj = document.createElement("div");
    loadingObj.setAttribute( 'id', 'loadingDiv' );
    loadingObj.style.position = "absolute";
    loadingObj.style.top =  "200px";
    loadingObj.style.left = bodyWidth / 11*5 + "px";
    loadingObj.style.background = "url(/image/base/loading.gif)" ;
    loadingObj.style.width = "100px";
    loadingObj.style.height = "100px";
    loadingObj.style.zIndex = "10000";
    document.body.appendChild(loadingObj); //添加loading动画-
}
function removecloud() {
    $( "#loadingDiv").remove();
    $( "#bgDiv").remove();
}
