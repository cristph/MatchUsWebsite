var changeBar = function (bar) {
    changeBarClass(bar);
    hideAllContents();
    switch (this.id) {
        case "publish":
            getPublish_unCompleted();
            break;
        case "attend":
            getAttend_unCompleted();
            break;
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

function getPublish_unCompleted(uid) {
    var attent_projects = document.getElementById("attent_project");
    alert(uid);
    $.post("/user", "will", function (projects) {
        addWillProjects(projects);
    });
}

function getAttend_unCompleted(uid) {
    alert(uid);
}

function getFollow(uid) {
    alert(uid);
}

function getFans(uid) {
    alert(uid);
}

function addWillProjects(projects) {
    for (var i = 0; i < projects.length; i++) {

    }
}