var select = function () {
    changeColor(this);
    applySelect();
}
function applySelect() {
    var primary_btn_list = document.getElementsByClassName("btn-primary");
    var dataContent = new Array();
    for (var i = 0; i < primary_btn_list.length; i++) {
        dataContent[i] = primary_btn_list[i].name;
    }
    $.post("../../Category", {"dataContent": dataContent}, function (data) {
        var projectsJ = JSON.stringify(data);
        //var projects=eval(projectsJ);
        alert(projectsJ);

    });

}

function refreshView() {

}
function changeColor(btn) {
    var parent_element = btn.parentElement;//父元素
    var btn_group = parent_element.children;//所有兄弟元素
    if (btn.classList.contains("all-btn")) {
        if (btn.classList.contains("btn-default")) {
            for (var i = 0; i < btn_group.length; i++) {
                changeToDefault(btn_group[i]);
            }
            var all_btn = parent_element.getElementsByClassName("all-btn");
            changeToPrimary(all_btn[0]);
        }//全部按钮被点亮
    }//点击全部按钮
    else {
        reverseColor(btn);//将此元素颜色改变
        var isSelect = 0//是否有筛选像被选中
        for (var i = 0; i < btn_group.length; i++) {
            if (btn_group[i].classList.contains("btn-primary")) {
                isSelect = 1;
                break;
            }
        }
        var all_btn = parent_element.getElementsByClassName("all-btn");
        if (isSelect == 1) {
            changeToDefault(all_btn[0]);//取消选中全部按钮
        }
        else if (isSelect == 0) {
            changeToPrimary(all_btn[0]);//如果没有筛选像被选中则选中全部按钮
        }
    }//点击其他按钮
}

function reverseColor(btn) {
    if (btn.classList.contains("btn-primary")) {
        btn.classList.remove("btn-primary");
        btn.classList.add("btn-default");
    }
    else if (btn.classList.contains("btn-default")) {
        btn.classList.remove("btn-default");
        btn.classList.add("btn-primary");
    }
}//改变按钮颜色

function changeToDefault(btn) {
    if (btn.classList.contains("btn-primary")) {
        btn.classList.remove("btn-primary");
    }
    btn.classList.add("btn-default");
}//将按钮变为未选中

function changeToPrimary(btn) {
    if (btn.classList.contains("btn-default")) {
        btn.classList.remove("btn-default");
    }
    btn.classList.add("btn-primary");
}//将按钮变为选中