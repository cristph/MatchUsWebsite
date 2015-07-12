/**
 * Created by �Ų��� on 2015/7/9.
 */
function changeColor(btn) {
    if (btn.classList.contains("btn-default")) {
        btn.classList.remove("btn-default");
        btn.classList.add("btn-primary")
    }
    else if (btn.classList.contains("btn-primary")) {
        btn.classList.remove("btn-primary");
        btn.classList.add("btn-default")
    }
}