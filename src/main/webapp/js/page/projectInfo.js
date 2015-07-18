/**
 * Created by cristph on 2015/7/14.
 */

$(function(){
    var list=document.getElementsByClassName("imgthumbs");
    var i;
    for(i=0;i<list.length;i++){
        var obj=list[i];
        obj.addEventListener("click",showImage,false);
        obj.setAttribute("data-toggle","modal");
        obj.setAttribute("data-target","#exampleModal");
    }
});

function showImage(){
    var img=document.getElementById("showImg");
    var dialog=document.getElementById("imgDialog");
    dialog.style.margin=0;
    dialog.style.position='relative';

    var path=this.getAttribute("src");

    var screenHeight=document.documentElement.clientHeight;
    var screenWidth=document.documentElement.clientWidth;

    var tempImg=new Image();
    tempImg.src=path;
    var tempWidth=tempImg.width;
    var tempHeight=tempImg.height;
    alert("ow"+tempWidth+" oh"+tempHeight);

    if(tempWidth>=screenWidth){
        img.style.width='1200px';
        dialog.style.width='1200px';
        dialog.style.left=(screenWidth-1200)/2+'px';
    }else{
        img.style.width=tempWidth+'px';
        dialog.style.width=tempWidth+'px';
        dialog.style.left=(screenWidth-tempWidth)/2+'px';

    }

    if(tempHeight>screenHeight){
        img.style.height='620px';
        dialog.style.height='620px';
        dialog.style.top=(screenHeight-620)/2+'px';
    }else{
        img.style.height=tempHeight+'px';
        dialog.style.height=tempHeight+'px';
        dialog.style.top=(screenHeight-tempHeight)/2+'px';
    }

    path="url('"+path+"')";
    alert(path);
    img.style.backgroundImage=path;
    

    alert("sh:"+screenHeight+" sw:"+screenWidth);

    //var imgHeight=img.style.backgroundImage.height;
    //var imgWidth=img.style.backgroundImage.width;
    alert("h:"+imgHeight+" w:"+imgWidth);


    //dialog.style.left=(screenWidth-imgWidth)/2;
    //dialog.style.right=(screenHeight-imgHeight)/2;
}