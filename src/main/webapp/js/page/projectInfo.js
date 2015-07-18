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
    var path=this.getAttribute("src");
    path="url('"+path+"')";
    alert(path);
    img.style.backgroundImage=path;

    var screenHeight=document.documentElement.clientHeight;
    var screenWidth=document.documentElement.clientWidth;
    alert("sh:"+screenHeight+" sw:"+screenWidth);

    img.setAttribute("max-width",screenWidth);
    img.setAttribute("max-height",screenHeight);

    var imgHeight=img.style.backgroundImage.height;
    var imgWidth=img.style.width.backgroundImage.width;
    alert("h:"+imgHeight+" w:"+imgWidth);

    var dia=document.getElementById("imgDialog");
    dia.style.margin=0;


    dia.style.Height=imgHeight;
    dia.style.Width=imgWidth;

    dia.style.position='relative';
    dia.style.left=(screenWidth-imgWidth)/2;
    dia.style.right=(screenHeight-imgHeight)/2;
}