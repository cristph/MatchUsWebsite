var changeBar = function (bar,uid) {
    hideContents();
    switch (bar.id) {
        case "publish":
            changeBarClass(bar);
            getPublish(uid,"now");
            break;//初始化发布的项目
        case "attend":
            changeBarClass(bar);
            getAttend(uid,"now");
            break;//初始化参加的项目
        case "follow":
            changeBarClass(bar);
            getFollow(uid);
            break;//初始化关注的人
        case "fans":
            changeBarClass(bar);
            getFans(uid);
            break;//初始化关注我的人
        case "publish_now":
            getPublish(uid,"now");
            break;//正在进行的我发布的项目
        case "publish_past":
            getPublish(uid,"past");
            break;//已完成的的我发布的项目
        case "publish_will":
            getPublish(uid,"will");
            break;//未开始的我发布的项目
        case "attend_now":
            getAttend(uid,"now");
            break;//正在进行的我参加的项目
        case "attend_past":
            getAttend(uid,"past");
            break;//已完成的我参加的项目
        case "attend_will":
            getAttend(uid,"will");
            break;//我关注的项目
    }
}

function changeBarClass(bar) {
    var bars = document.getElementsByClassName("left_nav_bar");
    for (var i = 0; i < bars.length; i++) {
        if (bars[i].classList.contains("selected")) {
            bars[i].classList.remove("selected");
        }
    }
    bar.className = "left_nav_bar selected";
}

function hideContents() {
    var divs = document.getElementsByClassName("content_div");
    for (var i = 0; i < divs.length; i++) {
        if (divs[i].classList.contains("show")) {
            divs[i].classList.remove("show");
            divs[i].classList.add("hide");
        }
    }
}

function getPublish(uid,state) {
    var id="publish_"+state;
    var bar = document.getElementById(id);
    changeToActive(bar);
    var body = document.getElementById("publish_project_body");
    body.innerHTML = "";
    $.post("/user/releasedProjects", {"uid":uid,"projectState": state}, function (projects) {
        var htmlStr = getProjetListHtmlStr(projects);
        body.innerHTML = htmlStr;
    });
    var div = document.getElementById("publish_project");
    div.className = "content_div show";
}//得到发布的项目

function getAttend(uid,state) {
    var id="attend_"+state;
    var bar = document.getElementById(id);
    changeToActive(bar);//修改指示框
    var body = document.getElementById("attend_project_body");
    body.innerHTML = "";
    $.post("/user/attendProjects", {"uid":uid,"projectState": state}, function (projects) {
        var htmlStr = getProjetListHtmlStr(projects);
        body.innerHTML = htmlStr;
    });
    var div = document.getElementById("attend_project");
    div.className = "content_div show";//修改展示的内容
}//得到参加项目

function getFollow(uid) {
    var body = document.getElementById("follow_people_body");
    body.innerHTML = "";
    $.post("/user/focused", {"uid":uid,}, function (people) {
        if (people[0].uid == -1) {
            body.innerHTML = "<h2>还没有关注其他人哦~~~</h2>";
        } else {
            var htmlStr = getPeopleListHtmlStr(people);
            body.innerHTML = htmlStr;
        }
    });
    var divs = document.getElementById("my_follow_people");
    divs.className = "content_div show";
}

function getFans(uid) {
    var body = document.getElementById("follow_me_body");
    body.innerHTML = "";
    $.post("/user/focus", {"uid":uid,}, function (people) {
        if (people[0].uid == -1) {
            body.innerHTML = "<h2>还没有人关注哦~~~</h2>";
        } else {
            var htmlStr = getPeopleListHtmlStr(people);
            body.innerHTML = htmlStr;
        }
    });
    var divs = document.getElementById("people_follow_me");
    divs.className = "content_div show";
}

function changeToActive(bar) {
    var sub_bar = document.getElementsByClassName("sub_bar");
    for (var i = 0; i < sub_bar.length; i++) {
        if (sub_bar[i].classList.contains("active")) {
            sub_bar[i].classList.remove("active");
        }
    }
    bar.classList.add("active");
}//将特定的分页项转化为选中

function getProjetListHtmlStr(projects) {
    if (projects[0].pid == -1) {
        return "<h2>暂时还没有项目哦~~~</h2>"
    } else {
        var htmlStr = "";
        for (var i = 0; i < projects.length; i++) {
            htmlStr += "<li>" +
                "<a href='/project/getOneProject?pid=1' target='_blank'>"+
                "<h3>" +
                projects[i].pname +
                "</h3>" +
                "</a>"+
                "</li>"
        }
        return htmlStr
    }
}

function getPeopleListHtmlStr(people) {
    var html = "";
    for (var i = 0; i < people.length; i++) {
        html += "<li>" +
            "<a href='/otherUser?uid="+people[i].uid+"' class='people-info' target=\"_blank\">" +
            "<span class='people-pic'>" +
            "<img src=\"userPhoto.jpg?uid=" + people[i].uid + "\" alt=\"该用户暂无头像\">" +
            "</span>" +
            "<ul class='people-lay'>" +
            "<p>" +
            people[i].username +
            "</p>" +
            "<p>" +
            people[i].email +
            "</p>" +
            "</ul>" +
            "</a>" +
            "</li>"
    }
    return html;
}

function swapFollow(btn,uid){
    if(btn.className=="btn btn-primary"){
        btn.className="btn btn-default";
        btn.innerText="已关注";
        $.post("/user/addFollow",{"uid":uid,});
    }else if(btn.className="btn btn-default"){
        btn.className="btn btn-primary"
        btn.innerText="关注Ta";
        $.post("/user/deleteFollow",{"uid":uid,});
    }

}