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
        email.setAttribute("aria-describedby",'inputSuccess2Status');
        var em=email.parentNode;
        var test=document.getElementById("email_span");
        if(test==null){
            var sp=document.createElement('span');
            sp.id="email_span";
            sp.classList.add('glyphicon');
            sp.classList.add('glyphicon-ok');
            sp.classList.add('form-control-feedback');
            sp.setAttribute("aria-hidden",'true');
            sp.setAttribute("style",'top: 33px');
            em.appendChild(sp);
        }
        em.classList.remove('has-error');
        em.classList.add('has-success');
        return true;
    }
    else {
        //email.parentNode.classList.add('has-feedback');
        var emailNode=document.getElementById("email_span");
        if(emailNode!=null){
            emailNode.parentNode.removeChild(emailNode);
        }
        email.setAttribute("aria-describedby",'inputWarning2Status');
        email.parentNode.classList.add('has-error');
        return false;
    }
}

/*document.getElementById("submit_sign").onclick=chkPswd();*/
function chkPswd(){
    var fir=document.getElementById("inPassword");
    var sec=document.getElementById("sureinPassword");
    if(fir.value!=sec.value){
        var pswd_span1=document.getElementById('pswd_span1');
        var pswd_span2=document.getElementById('pswd_span2');
        if(pswd_span1!=null){
            pswd_span1.parentNode.removeChild(pswd_span1);
        }
        if(pswd_span2!=null){
            pswd_span2.parentNode.removeChild(pswd_span2);
        }
        fir.parentNode.classList.add('has-error');
        sec.parentNode.classList.add('has-error');
        return false;
    }else{
        sp1=document.createElement('span');
        sp1.id='pswd_span1';
        sp1.classList.add('glyphicon');
        sp1.classList.add('glyphicon-ok');
        sp1.classList.add('form-control-feedback');
        sp1.setAttribute("aria-hidden",'true');
        sp1.setAttribute("style",'top: 33px');

        sp2=document.createElement('span');
        sp2.id='pswd_span2';
        sp2.classList.add('glyphicon');
        sp2.classList.add('glyphicon-ok');
        sp2.classList.add('form-control-feedback');
        sp2.setAttribute("aria-hidden",'true');
        sp2.setAttribute("style",'top: 33px');

        var pswd1=fir.parentNode;
        var pswd2=sec.parentNode;

        pswd1.classList.remove('has-error');
        pswd2.classList.remove('has-error');
        pswd1.classList.add('has-success');
        pswd2.classList.add('has-success');

        pswd1.appendChild(sp1);
        pswd2.appendChild(sp2);
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
