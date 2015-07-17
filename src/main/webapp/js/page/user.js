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
    var divs = document.getElementById("published_project");
    divs.className = "content_div show";
    $.post("/user/releasedProjects", {"projectState": "will"}, function (projects) {
        alert(projects);

    });
}

function getPublish_completed() {
    var divs = document.getElementById("published_project");
    divs.className = "content_div show";
}

function getAttend_unCompleted() {
    var divs = document.getElementById("attend_project");
    divs.className = "content_div show";
}

function getAttend_completed() {
    var divs = document.getElementById("attend_project");
    divs.className = "content_div show";

}

function getFollow() {
    var divs = document.getElementById("my_follow_people");
    divs.className = "content_div show";

}

function getFans() {
    var divs = document.getElementById("people_follow_me");
    divs.className = "content_div show";
}
