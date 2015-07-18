var changeBar = function (bar,uid) {
    hideContents();
    switch (bar.id) {
        case "publish":
            changeBarClass(bar);
            getPublish_unCompleted(uid);
            break;
        case "published_uncompleted":
            getPublish_unCompleted(uid);
            break;
        case "published_completed":
            getPublish_completed(uid);
            break;
        case "attend":
            changeBarClass(bar);
            getAttend_unCompleted(uid);
            break;
        case "attend_uncompleted":
            getAttend_unCompleted(uid);
            break;
        case "attend_completed":
            getAttend_completed(uid);
            break;
        case "follow":
            changeBarClass(bar);
            getFollow(uid);
            break;
        case "fans":
            changeBarClass(bar);
            getFans(uid);
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

function getPublish_unCompleted(uid) {
    var bar = document.getElementById("published_uncompleted");
    var body = document.getElementById("published_project_body");
    body.innerHTML = "";
    changeToActive(bar);
    $.post("/user/releasedProjects", {"uid":uid,"projectState": "will"}, function (projects) {
        var htmlStr = getProjetListHtmlStr(projects);
        body.innerHTML = htmlStr;
    });
    var div = document.getElementById("published_project");
    div.className = "content_div show";
}//得到发布的未完成的项目

function getPublish_completed(uid) {
    var bar = document.getElementById("published_completed");
    var body = document.getElementById("published_project_body");
    body.innerHTML = "";
    changeToActive(bar)
    $.post("/user/releasedProjects", {"uid":uid,"projectState": "Done"}, function (projects) {
        var htmlStr = getProjetListHtmlStr(projects);
        body.innerHTML = htmlStr;
    });
    var div = document.getElementById("published_project");
    div.className = "content_div show";
}//得到发布的完成的项目

function getAttend_unCompleted(uid) {
    var bar = document.getElementById("attend_uncompleted");
    changeToActive(bar);
    var body = document.getElementById("attend_project_body");
    body.innerHTML = "";
    $.post("/user/attendProjects", {"uid":uid,"projectState": "will"}, function (projects) {
        var htmlStr = getProjetListHtmlStr(projects);
        body.innerHTML = htmlStr;
    });
    var div = document.getElementById("attend_project");
    div.className = "content_div show";
}//得到参加的未完成的项目

function getAttend_completed(uid) {
    var bar = document.getElementById("attend_completed");
    changeToActive(bar);
    var body = document.getElementById("attend_project_body");
    body.innerHTML = "";
    $.post("/user/attendProjects", {"uid":uid,"projectState": "Done"}, function (projects) {
        var htmlStr = getProjetListHtmlStr(projects);
        body.innerHTML = htmlStr;
    });
    var div = document.getElementById("attend_project");
    div.className = "content_div show";
}//得到参加的已完成的项目

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