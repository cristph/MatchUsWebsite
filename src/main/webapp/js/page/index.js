/**
 * Created by cristph on 2015/7/13.
 */

function myReload(){
    document.getElementById("img_code").src=document.getElementById("img_code").src + "?nocache="+new Date().getTime();
}

function chkEmail() {
    var email = document.getElementById("inEmail");
    var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
    flag = pattern.test(email.value);
    if(flag) {
        email.parentNode.classList.remove('has-error');
        email.parentNode.classList.add('has-success');
        return true;
    }
    else {
        email.parentNode.classList.add('has-error');
        return false;
    }
}

/*document.getElementById("submit_sign").onclick=chkPswd();*/
function chkPswd(){
    var fir=document.getElementById("inPassword");
    var sec=document.getElementById("sureinPassword");
    if(fir.value!=sec.value){
        fir.parentNode.classList.add('has-error');
        sec.parentNode.classList.add('has-error');
        return false;
    }else{
        fir.parentNode.classList.remove('has-error');
        sec.parentNode.classList.remove('has-error');
        fir.parentNode.classList.add('has-success');
        sec.parentNode.classList.add('has-success');
        return true;
    }

}

$(function(){
    $('#inEmail').keyup(chkEmail);
    $('#sureinPassword').keyup(chkPswd);
    $('#inPassword').keyup(chkPswd);
    $("#submit_sign").click(
        function(){
            if(chkEmail()&chkPswd()){
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
                            alert('注册失败！');
                        }
                        else {
                            myReload();
                            alert('验证码错误！');
                        }
                    });
            }else if(!chkEmail()){
                alert('请输入正确的邮箱地址！');
            }else if(!chkPswd()){
                alert('请输入正确的密码！');
            }
        }
    );
});
