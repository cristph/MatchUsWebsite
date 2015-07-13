/**
 * Created by �Ų��� on 2015/7/9.
 */
var changeColor = function () {
    if (this.classList.contains("btn-default")) {
        this.classList.remove("btn-default");
        this.classList.add("btn-primary")
    }
    else if (this.classList.contains("btn-primary")) {
        this.classList.remove("btn-primary");
        this.classList.add("btn-default")
    }
}