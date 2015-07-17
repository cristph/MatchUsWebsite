var changeBar = function (bar) {
    changeBarClass(bar);
    hideAllContents();
    switch (bar.id) {
        case "publish":
            getPublish_unCompleted();
            break;
        case "published_uncompleted":
            getPublish_unCompleted();
            break;
        case "published_completed":
            getPublish_completed();
            break;
        case "attend":
            getAttend_unCompleted();
            break;
        case "attend_uncompleted":
            getAttend_unCompleted();
            break;
        case "attend_completed":
            getAttend_completed();
        case "follow":
            getFollow();
            break;
        case "fans":
            getFans();
            break;
    }
}

function changeBarClass(bar) {
    var bars = document.getElementsByClassName("left_nav_bar");
    for (var i = 0; i < bars.length; i++) {
        if (bars[i].classList.contains("active")) {
            bars[i].classList.remove("active");
        }
    }
    bar.classList.add("active");
}

function hideAllContents() {
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
    //$.post("/user/releasedProjects", {"projectState": "will"}, function (projects) {
    //    alert(projects);
    //
    //});
    var div = document.getElementById("published_project");
    div.className = "content_div show";
}//得到发布的未完成的项目

function getPublish_completed() {
    var bar = document.getElementById("published_completed");
    changeToActive(bar)
    var div = document.getElementById("published_project");
    div.className = "content_div show";
}//得到发布的完成的项目

function getAttend_unCompleted() {
    var bar = document.getElementById("attend_completed");
    changeToActive(bar);


    var div = document.getElementById("attend_project");
    div.className = "content_div show";
}//得到参加的未完成的项目

function getAttend_completed() {
    var bar = document.getElementById("attend_uncompleted");
    changeToActive(bar);


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
