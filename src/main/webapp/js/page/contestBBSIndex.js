/**
 * Created by cristph on 2015/7/26.
 */

var list=document.getElementsByClassName("bbsTopic");
var i;
for(i=0;i<list.length;i++){
    list[i].addEventListener("click",getTopic,false);
}

var btn=document.getElementById("releaseTopic");
btn.addEventListener("click",releaseTopic,false);

function releaseTopic(){
    alert('post');
    $.post("/post/add",
        {
            "topicTitle":document.getElementById("topicTitle").value,
            "topicContent":document.getElementById("topicContent").value
        },
        function(data){
            if(data=='true'){
                alert('发布成功');
            }else if(data=='false'){
                alert('游客请先登录！');
            }else{
                alert(data);
            }
        }
    );
}




function getTopic(){
    //var div=document.getElementById("bbsModel");
    //while(div.childElementCount>0){
    //    div.removeChild(div.firstElementChild);
    //}
}