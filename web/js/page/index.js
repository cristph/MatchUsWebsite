/**
 * Created by cristph on 2015/7/13.
 */

function myReload(){
    document.getElementById("img_code").src=document.getElementById("img_code").src + "?nocache="+new Date().getTime();
}


/*document.getElementById("submit_sign").onclick=chkPswd();*/
function chkPswd(){
    var fir=document.getElementById("inPassword");
    var sec=document.getElementById("sureinPassword");

    if(fir.value!=sec.value){
        alert("两次输入的密码不同！");
        return false;
    }else{
        return true;
    }

}

$(function(){
    $("#submit_sign").click(
        function(){
            $.post("/validate.do",
                {"userCheckCode":document.getElementById('checkCode').value,
                    "sign_email":document.getElementById('inEmail').value,
                    "sign_pswd":document.getElementById('inPassword').value,
                    "sign_name":document.getElementById('inName').value
                },
                function(data){
                    alert(data);
                    if (data=="true") {
                        window.top.location.href="http://www.baidu.com";
                    } else if(data=="RegisterFalse"){
                        alert("注册失败！");
                    }
                    else {
                        myReload();
                        alert("验证码错误！");
                    }
            });
        }
    );
});



/**
$(function() {
    $("#submit_sign").click(
        function() {
            $.post("/validate.do",{"userCheckCode" : $("#checkCode").value
                ,"sign_pswd":$("#inPassword").value
                ,"sign_email":$("#inEmail").value
                ,"sign_name":$("#inName")}.value,
                function(data) {
                    if (data=="true") {
                        window.top.location.href="http://www.baidu.com";
                    } else if(data=="RegisterFalse"){
                        alert("注册失败！");
                    }
                    else {
                        myReload();
                        alert("验证码错误！");
                    }
            });
        });
});
 */
