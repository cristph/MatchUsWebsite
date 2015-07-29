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
    alert('send');
    $.post("/post/add",
        {
            "post_id":1,
            "post_ispay":0,
            "is_stick":0,
            "topicTitle":document.getElementById("topicTitle").value,
            "topicContent":document.getElementById("topicContent").value
        },
        function(data){
            alert("infuncton");
            if(data=='fail'){
                alert('游客请先登录');
            }else if(data=='success'){
                alert('发布成功');
            }else{
                alert('other error');
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