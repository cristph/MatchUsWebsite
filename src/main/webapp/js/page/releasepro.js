/**
 * Created by Seven on 15/7/17.
 */

flag= false;
function addphone(){


    if(flag==false){
        phone.innerHTML="<input type='text' class='form-control'  placeholder='请输入手机号码'>";
        flag=true;
    }
    else{
        phone.innerHTML="";
        flag=false;
    }
}
$(document).ready(function(){
    $(".hideemaili").hide();
    $(".hideqqi").hide();
    $(".hidephonei").hide();
    $(".hidefaxi").hide();
});
$(document).ready(function(){
    $(".hideemail").click(function(){
        $(".hideemaili").toggle("100");
    });
});
$(document).ready(function(){
    $(".hideqq").click(function(){
        $(".hideqqi").toggle("100");
    });
});
$(document).ready(function(){
    $(".hidephone").click(function(){
        $(".hidephonei").toggle("100");
    });
});
$(document).ready(function(){
    $(".hidefax").click(function(){
        $(".hidefaxi").toggle("100");
    });
});
