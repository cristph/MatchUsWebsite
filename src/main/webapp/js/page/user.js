var changeBar = function () {
    changeBarClass(this);
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