var changeBar = function (bar) {
    hideContents();
    switch (bar.id) {
        case "publish":
            changeBarClass(bar);
            getPublish_unCompleted();
            break;
        case "published_uncompleted":
            getPublish_unCompleted();
            break;
        case "published_completed":
            getPublish_completed();
            break;
        case "attend":
            changeBarClass(bar);
            getAttend_unCompleted();
            break;
        case "attend_uncompleted":
            getAttend_unCompleted();
            break;
        case "attend_completed":
            getAttend_completed();
            break;
        case "follow":
            changeBarClass(bar);
            getFollow();
            break;
        case "fans":
            changeBarClass(bar);
            getFans();
            break;
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

function getPublish_unCompleted() {
    var bar = document.getElementById("published_uncompleted");
    changeToActive(bar);
    $.post("/user/releasedProjects", {"projectState": "will"}, function (projects) {
        var body = document.getElementById("published_project_body");
        var htmlStr = getProjetListHtmlStr(projects);
        body.innerHTML = htmlStr;
    });
    var div = document.getElementById("published_project");
    div.className = "content_div show";
}//得到发布的未完成的项目

function getPublish_completed() {
    var bar = document.getElementById("published_completed");
    changeToActive(bar)
    $.post("/user/releasedProjects", {"projectState": "Done"}, function (projects) {
        var body = document.getElementById("published_project_body");
        var htmlStr = getProjetListHtmlStr(projects);
        body.innerHTML = htmlStr;
    });
    var div = document.getElementById("published_project");
    div.className = "content_div show";
}//得到发布的完成的项目

function getAttend_unCompleted() {
    var bar = document.getElementById("attend_uncompleted");
    changeToActive(bar);
    $.post("/user/attendProjects", {"projectState": "will"}, function (projects) {
        var body = document.getElementById("attend_project_body");
        var htmlStr = getProjetListHtmlStr(projects);
        body.innerHTML = htmlStr;
    });
    var div = document.getElementById("attend_project");
    div.className = "content_div show";
}//得到参加的未完成的项目

function getAttend_completed() {
    var bar = document.getElementById("attend_completed");
    changeToActive(bar);
    $.post("/user/attendProjects", {"projectState": "Done"}, function (projects) {
        var body = document.getElementById("attend_project_body");
        var htmlStr = getProjetListHtmlStr(projects);
        body.innerHTML = htmlStr;
    });
    var div = document.getElementById("attend_project");
    div.className = "content_div show";
}//得到参加的已完成的项目

function getFollow() {
    var divs = document.getElementById("my_follow_people");
    divs.className = "content_div show";

}

function getFans() {
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
        return "<h2>没有项目，</h2>"
    } else {
        var htmlStr = "";
        for (var i = 0; i < projects.length; i++) {
            htmlStr += "<li><p>" + projects[i].pname + "</p></li>"
        }
        return htmlStr
    }
}