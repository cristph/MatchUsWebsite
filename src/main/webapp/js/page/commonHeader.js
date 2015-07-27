/**
 * Created by cristph on 2015/7/16.
 */

//$("body").click( function(event) {
//    alert("最初触发事件的是:" + event.target.tagName + "#" + event.target.id);
//} );

document.getElementById("searchArea").addEventListener("focus",searchAreaIn,false);
document.getElementById("searchArea").addEventListener("blur",searchAreaOut,false);

document.getElementById("searchArea").addEventListener("focus",search,false);
//document.getElementById("searchArea").addEventListener("blur",test,false);

document.getElementById("searchButton").addEventListener("focus",searchBtnIn,false);
document.getElementById("searchButton").addEventListener("blur",searchBtnOut,false);
document.getElementById("searchButton").addEventListener("click",showResult,false);

function showResult(){
    var link=document.getElementById("linkLocation");
    var pattern=document.getElementById("searchArea").value;
    link.setAttribute("href",'/search/searchResult?pattern='+pattern);
}

$(function () {
    var i;
    for (i = 1; i <= 7; i++) {
        $("#navli" + i).bind("mouseover", { id: i }, navIn);
        $("#navli" + i).bind("mouseout", { id: i }, navOut);
    }
});

function searchAreaIn(){
    var area=document.getElementById("searchArea");
    area.style.backgroundColor="#fff";
    var btn=document.getElementById("searchButton");
    btn.style.backgroundColor="#fff";
    btn.style.color="#f01400";
}

function searchAreaOut(){
    var area=document.getElementById("searchArea");
    if(area.value.length!=0){
        return false;
    }
    area.style.backgroundColor="#363d40";
    var btn=document.getElementById("searchButton");
    btn.style.backgroundColor="#363d40";
    btn.style.color="#999999";
}

function searchBtnIn(){
    var area=document.getElementById("searchArea");
    var btn=document.getElementById("searchButton");
    btn.style.outlineColor="#fff";
    btn.style.outlineWidth=0;
    btn.style.outline="none";
    if(area.value.length==0){
        return false;
    }
    area.style.backgroundColor="#fff";
    btn.style.backgroundColor="#fff";
    btn.style.color="#f01400";
}

function searchBtnOut(){
    var area=document.getElementById("searchArea");
    if(area.value.length!=0){
        return false;
    }
    area.style.backgroundColor="#363d40";
    var btn=document.getElementById("searchButton");
    btn.style.backgroundColor="#363d40";
    btn.style.color="#999999";
}

function navIn() {
    this.style.backgroundColor="#363c41";
    this.childNodes[0].color="#fff";
}

function navOut(){
    this.style.backgroundColor="#222";
    this.childNodes[0].color="#9d9d9d";
}

function myReload(){
    document.getElementById("img_code").src=document.getElementById("img_code").src + "?nocache="+new Date().getTime();
}

function chkEmail() {
    var email = document.getElementById("inEmail");
    var par=/([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})/;
    var flag = par.test(email.value);
    if(flag) {
        //email.setAttribute("aria-describedby",'inputSuccess2Status');
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
    } else {
        var emailNode=document.getElementById("email_span");
        if(emailNode!=null){
            emailNode.parentNode.removeChild(emailNode);
        }
        email.parentNode.classList.add('has-error');
        return false;
    }
}

function chkPswd(){
    var fir=document.getElementById("inPassword");
    var sec=document.getElementById("sureinPassword");

    var help_span=document.getElementById('pswdHelpBlock');
    if(fir.value.length<6) {
        if(help_span!=null){
            help_span.innerText="密码长度不能少于6";
        }else{
            help_span=document.createElement('span');
            help_span.id='pswdHelpBlock';
            help_span.classList.add("help-block");
            help_span.innerText="密码长度不能少于6";
            fir.parentNode.appendChild(help_span);
        }

        fir.parentNode.classList.add('has-error');
        var pswd_span1=document.getElementById('pswd_span1');
        if(pswd_span1!=null){
            pswd_span1.parentNode.removeChild(pswd_span1);
        }
        return false;
    }else if(fir.value.length>18){
        if(help_span!=null){
            help_span.innerText="密码长度不能超过18";
        }else{
            help_span=document.createElement('span');
            help_span.id='pswdHelpBlock';
            help_span.classList.add("help-block");
            help_span.innerText="密码长度不能超过18";
            fir.parentNode.appendChild(help_span);
        }

        fir.parentNode.classList.add('has-error');
        var pswd_span1=document.getElementById('pswd_span1');
        if(pswd_span1!=null){
            pswd_span1.parentNode.removeChild(pswd_span1);
        }
        return false;
    }else{
        if(help_span!=null){
            help_span.parentNode.removeChild(help_span);
        }
        sp1=document.createElement('span');
        sp1.id='pswd_span1';
        sp1.classList.add('glyphicon');
        sp1.classList.add('glyphicon-ok');
        sp1.classList.add('form-control-feedback');
        sp1.setAttribute("aria-hidden",'true');
        sp1.setAttribute("style",'top: 33px');

        var pswd1=fir.parentNode;
        pswd1.classList.remove('has-error');
        pswd1.classList.add('has-success');
        pswd1.appendChild(sp1);
    }

    var help_span2=document.getElementById('surepswdHelpBlock');
    if(fir.value!=sec.value){
        var pswd_span2=document.getElementById('pswd_span2');
        if(pswd_span2!=null){
            pswd_span2.parentNode.removeChild(pswd_span2);
        }
        sec.parentNode.classList.add('has-error');

        if(help_span2!=null){
            if(sec.value.length==0){
                help_span2.innerText="请输入确认密码";
            }else{
                help_span2.innerText="密码不一致";
            }
        }else{
            help_span2=document.createElement('span');
            help_span2.id='surepswdHelpBlock';
            help_span2.classList.add("help-block");
            if(sec.value.length==0){
                help_span2.innerText="请输入确认密码";
            }else{
                help_span2.innerText="密码不一致";
            }
            sec.parentNode.appendChild(help_span2);
        }
        return false;
    }else{
        sp2=document.createElement('span');
        sp2.id='pswd_span2';
        sp2.classList.add('glyphicon');
        sp2.classList.add('glyphicon-ok');
        sp2.classList.add('form-control-feedback');
        sp2.setAttribute("aria-hidden",'true');
        sp2.setAttribute("style",'top: 33px');

        var pswd2=sec.parentNode;
        pswd2.classList.remove('has-error');
        pswd2.classList.add('has-success');
        pswd2.appendChild(sp2);
        if(help_span2!=null){
            help_span2.parentNode.removeChild(help_span2);
        }
        return true;
    }

}

function chkName(){
    var input=document.getElementById('inName');
    var name=input.value;
    var helpBlock=document.getElementById("nameHelpBlock");
    if(name.length==0){
        input.parentNode.classList.remove('has-success');
        input.parentNode.classList.add('has-error');
        if(helpBlock==null){
            helpBlock=document.createElement('span');
            helpBlock.id='nameHelpBlock';
            helpBlock.classList.add("help-block");
            helpBlock.innerText="昵称不能为空";
            input.parentNode.appendChild(helpBlock);
        }
        return false;
    }else{
        input.parentNode.classList.remove('has-error');
        input.parentNode.classList.add('has-success');
        if(helpBlock!=null){
            helpBlock.parentNode.removeChild(helpBlock);
        }
        return true;
    }


    //$post("/",{"userName":name},function(data){
    //    if(data=="true"){
    //        input.parentNode.classList.remove('has_error');
    //        input.parentNode.classList.add('has_success');
    //        if(helpBlock!=null){
    //            helpBlock.parentNode.removeChild(helpBlock);
    //        }
    //        return true;
    //    }else{
    //        input.parentNode.classList.remove('has_success');
    //        input.parentNode.classList.add('has-error');
    //        if(helpBlock==null){
    //            helpBlock=document.createElement('span');
    //            helpBlock.id='nameHelpBlock';
    //            helpBlock.classList.add("help-block");
    //            helpBlock.innerText="昵称已存在";
    //            input.parentNode.appendChild(helpBlock);
    //        }
    //        return false;
    //    }
    //});
}

function chkCode(){
    var code=document.getElementById('checkCode').value;
    if(code.length==0){
        return false;
    }else{
        return true;
    }
}

$(function(){
    $('#inEmail').keyup(chkEmail);
    $('#sureinPassword').keyup(chkPswd);
    $('#inPassword').keyup(chkPswd);
    $('#inName').keyup(chkName);
    $('#submit_sign').click(
        function(){
            if(chkEmail()&chkPswd()&chkName()&chkCode()){
                $.post("/validate",
                    {"userCheckCode":document.getElementById('checkCode').value,
                        "sign_email":document.getElementById('inEmail').value,
                        "sign_pswd":document.getElementById('inPassword').value,
                        "sign_name":document.getElementById('inName').value
                    },
                    function(data){
                        //alert(data);
                        if (data=="true") {
                            location.href='/project';
                        } else if(data=="RegisterFalse"){
                            alert('用户名已存在，注册失败！');
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
            }else if(!chkName()){
                alert('昵称不能为空！');
            }else if(!chkCode()){
                alert('验证码不能为空！');
            }
        }
    );
});

(function () {
    var loginViewModel = function() {
        "use strict";
        var self = this;
        self.username=ko.observable();
        self.password = ko.observable();
        self.remember = ko.observable(true);
        self.fail = ko.observable(false);
        self.warn = function() {
            $('#userlogin .form-group').addClass('has-error')
            self.fail(true);
        }
        this.login = function() {
            $.post('/login', {
                username: self.username(),
                password: self.password(),
                remember: self.remember()
            }, function(data) {
                if(data==="success") {
                    location.href = '/project'
                }
                else {
                    self.warn();
                }
            });
        }
    }
    var userlogin = document.getElementById('userlogin');
    if(userlogin) {
        ko.applyBindings(new loginViewModel(),userlogin);
    }
})();



function search(){
    //$post("/",
    //    {"searchKey":document.getElementById("searchArea").value},
    //    function(data){
    //        var i;
    //        var res=document.getElementById("searchResult");
    //
    //        for(i=0;i<data.length;i++){
    //            var dd=document.createElement("dd");
    //            var a=document.createElement("a");
    //            var span=document.createElement("span");
    //            span.innerText="kkkkkk";
    //            a.setAttribute("href","/");
    //            a.appendChild(span);
    //            dd.appendChild(a);
    //            res.appendChild(dd);
    //        }
    //    }
    //);
    searchOut();
    var input=document.getElementById("searchArea").value;
    if(input.length==0){
        searchOut();
    }else{
        var j;
        var res=document.getElementById("searchResult");
        res.focus();

        var dd=document.createElement("dd");
        var a=document.createElement("a");
        var span=document.createElement("span");
        span.innerText="符合条件的项目";
        a.setAttribute("href","/");
        a.appendChild(span);
        dd.appendChild(a);
        res.appendChild(dd);
        for(j=0;j<3;j++){
            var dd=document.createElement("dd");
            var a=document.createElement("a");
            var span=document.createElement("span");
            span.innerText="Project"+j;
            a.setAttribute("href","http://www.baidu.com");
            a.appendChild(span);
            dd.appendChild(a);
            res.appendChild(dd);
        }

        var dd=document.createElement("dd");
        var a=document.createElement("a");
        var span=document.createElement("span");
        span.innerText="符合条件的牛人";
        a.setAttribute("href","/");
        a.appendChild(span);
        dd.appendChild(a);
        res.appendChild(dd);
        for(j=0;j<3;j++){
            var dd=document.createElement("dd");
            var a=document.createElement("a");
            var span=document.createElement("span");
            span.innerText="NiuBi_"+j;
            a.setAttribute("href","/");
            a.appendChild(span);
            dd.appendChild(a);
            res.appendChild(dd);
        }

        var dd=document.createElement("dd");
        var a=document.createElement("a");
        var span=document.createElement("span");
        span.innerText="符合条件的团队";
        a.setAttribute("href","/");
        a.appendChild(span);
        dd.appendChild(a);
        res.appendChild(dd);
        for(j=0;j<3;j++){
            var dd=document.createElement("dd");
            var a=document.createElement("a");
            var span=document.createElement("span");
            span.innerText="Team_"+j;
            a.setAttribute("href","/");
            a.appendChild(span);
            dd.appendChild(a);
            res.appendChild(dd);
        }
    }
}

function searchOut(){
    var res=document.getElementById("searchResult");
    while(res.childElementCount>0){
        res.removeChild(res.firstElementChild);
    }
}



//$("body").click( function(event) {
//    var str=event.target.parentNode.parentNode.parentNode.id;
//    alert(str);
//    if(str!="searchResult"){
//        searchAreaOut();
//    }
//} );

$(function(){
    $("#searchArea").keyup(search);
});