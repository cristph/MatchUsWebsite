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
        obj.setAttribute("data-target","#imgModal");
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
    //alert("ow"+tempWidth+" oh"+tempHeight);

    if(tempWidth>screenWidth||tempHeight>screenHeight){
        if(tempWidth>screenWidth){
            var c1=tempWidth/1200;
            if(tempHeight<=screenHeight){
                img.style.width='1200px';
                dialog.style.width='1200px';
                dialog.style.left=(screenWidth-1200)/2+'px';

                var testHeight=tempHeight/c1;
                img.style.height=testHeight+'px';
                dialog.style.height=testHeight+'px';
                dialog.style.top=(screenHeight-testHeight)/2+'px';
            }else{
                var testHeight=tempHeight/c1;
                if(testHeight>=screenHeight){
                    var c2=tempHeight/620;
                    var testWidth=tempWidth/c2;

                    img.style.width=testWidth+'px';
                    dialog.style.width=testWidth+'px';
                    dialog.style.left=(screenWidth-testWidth)/2+'px';

                    img.style.height='620px';
                    dialog.style.height='620px';
                    dialog.style.top=(screenHeight-620)/2+'px';
                }else{
                    img.style.width='1200px';
                    dialog.style.width='1200px';
                    dialog.style.left=(screenWidth-1200)/2+'px';

                    var testHeight=tempHeight/c1;
                    img.style.height=testHeight+'px';
                    dialog.style.height=testHeight+'px';
                    dialog.style.top=(screenHeight-testHeight)/2+'px';
                }
            }
        }else{
            var c2=tempHeight/620;
            var testWidth=tempWidth/c2;

            img.style.width=testWidth+'px';
            dialog.style.width=testWidth+'px';
            dialog.style.left=(screenWidth-testWidth)/2+'px';
            img.style.height=620+'px';
            dialog.style.height=620+'px';
            dialog.style.top=(screenHeight-620)/2+'px';
        }
    }else{
        img.style.width=tempWidth+'px';
        dialog.style.width=tempWidth+'px';
        dialog.style.left=(screenWidth-tempWidth)/2+'px';
        img.style.height=tempHeight+'px';
        dialog.style.height=tempHeight+'px';
        dialog.style.top=(screenHeight-tempHeight)/2+'px';
    }

    //if(tempWidth>=screenWidth){
    //    img.style.width='1200px';
    //    dialog.style.width='1200px';
    //    dialog.style.left=(screenWidth-1200)/2+'px';
    //}else{
    //    img.style.width=tempWidth+'px';
    //    dialog.style.width=tempWidth+'px';
    //    dialog.style.left=(screenWidth-tempWidth)/2+'px';
    //
    //}
    //
    //if(tempHeight>=screenHeight){
    //    img.style.height='620px';
    //    dialog.style.height='620px';
    //    dialog.style.top=(screenHeight-620)/2+'px';
    //}else{
    //    img.style.height=tempHeight+'px';
    //    dialog.style.height=tempHeight+'px';
    //    dialog.style.top=(screenHeight-tempHeight)/2+'px';
    //}

    path="url('"+path+"')";
    //alert(path);
    img.style.backgroundImage=path;
    

    //alert("sh:"+screenHeight+" sw:"+screenWidth);

    //var imgHeight=img.style.backgroundImage.height;
    //var imgWidth=img.style.backgroundImage.width;
    //alert("h:"+imgHeight+" w:"+imgWidth);


    //dialog.style.left=(screenWidth-imgWidth)/2;
    //dialog.style.right=(screenHeight-imgHeight)/2;
}