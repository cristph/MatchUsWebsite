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


$(function(){
    $('#submit_btn').click(
        function(){
                $.post("/validate.do",
                    {"projectname":document.getElementById('projectname').value,
                        "projectdetail":document.getElementById('projectdetail').value,
                        "projecttag":document.getElementById('projecttag').value,
                        "protech":document.getElementById('protech').value,
                        "proreward":document.getElementById('proreward').value,
                        "protech":document.getElementById('protech').value,
                        "mobilephone":document.getElementById('mobilephone').value,
                        "qq":document.getElementById('qq').value,
                        "email":document.getElementById('email').value,
                        "phone":document.getElementById('phone').value,
                        "fax":document.getElementById('fax').value
                    },
                    function(data){
                        //alert(data);
                        if (data=="true") {
                            window.top.location.href='/';
                        } else if(data=="RegisterFalse"){
                            alert('用户名已存在，注册失败！');
                        }
                        else {
                            myReload();
                            alert('验证码错误！');
                        }
                    });

        }
    );
});