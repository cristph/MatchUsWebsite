var changeBar = function (uid) {
    changeBarClass(this);
    hideAllContents();
    switch (this.id) {
        case "publish":
            getPublish_unCompleted(uid);
            break;
        case "attend":
            getAttend_unCompleted(uid);
            break;
        case "follow":
            getFollow(uid);
            break;
        case "fans":
            getFans(uid);
            break;
    }
}

function changeBarClass(bar) {
    var bars = document.getElementsByClassName("left_nav_bar");
    for (var i = 0; i < bars.length; i++) {
        if (bars[i].classList.contains("active")) {
            bars[i].classList.remove("active");
            break;
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
    //$.post("url", uid, function (data) {
    //
    //});
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