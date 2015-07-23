/**
 * Created by cristph on 2015/7/22.
 */

$(function(){
    var list=document.getElementsByClassName("navItem");
    var infoList=document.getElementsByClassName("moreInfo");

    var i;
    for(i=0;i<list.length;i++){
        list[i].addEventListener("click",changeState,false);
    }
    for(i=0;i<infoList.length;i++){
        infoList[i].addEventListener("click",moreInfo,false);
    }

});

function changeState(){
    var list=document.getElementsByClassName("navItem");
    var i;
    for(i=0;i<list.length;i++){
        list[i].style.borderRightWidth=0;
        list[i].style.color="#5e5e5e";
    }
    this.style.borderRight="2px solid #be3a48";
    this.style.color="#be3a48";
}

function moreInfo(){
    var li=document.createElement("li");
    li.classList.add("listItem");
    li.classList.add("clearfix");

    if(this.innerText.search("项目")>0){
        li.innerHTML='<div class="projectTitle">' +
            '<a href="/project/getOneProject?pid=1" target="_blank">软件学院创新杯比赛</a>' +
            '</div>' +
            '<div class="projectPublish">' +
            '<p>2015-7-21  posted by <span><a href="/">Somebody</a></span>' +
            '</p>' +
            '</div>' +
            '<div class="projectPicture">' +
            '<img src="http://img.mukewang.com/54c5e5ab0001dd9906000338-280-160.jpg" alt="Img">' +
            '</div>' +
            '<div class="projectIntro">政府对开发公司的实力要求不严，开发商实力良莠不齐，' +
            '受传统观念束缚严重不重视客源心理及市场发展特性，主观开发，追求暴利，无品牌意识，对专业销售机构极度排斥' +
            '产品形式单一（多层为主），缺乏特色，不注重整体规划，且有明显区域性特征（集中在千佛山周边）。' +
            '无整体营销思路，盲目追求高利，定价偏高，且无有效的表现及宣传手法，不注重品牌的培养和树立。 ' +
            '</div>'
    }else{
        li.innerHTML='<div class="user-pic">' +
            '<a href="/otherUser?uid=15" target="_blank"><img src="/hotUsers/userPhoto?oneHotUserId=15"></a>' +
            '<p class="user-name"><a href="/otherUser?uid=13" target="_blank">AH</a><span class="sex">男</span></p>' +
            '</div>' +
            '<div class="Info">' +
            '<div class="schoolInfo"><span class="tip">学校：</span>南京大学</div>' +
            '<div class="selfIntro"><span class="tip">个人说明：</span>嗯哈哈哈哈哈哈哈哈哈。</div>' +
            '<div class="skillInfo"><span class="tip">擅长领域：</span>Java,C++,Ruby</div>' +
            '<div class="projectInfo">' +
            '<span class="tip">项目经历：</span>' +
            '<ul>' +
            '<li><a href="/">JavaWeb Project</a></li>' +
            '<li><a href="/">Android Project</a></li>' +
            '</ul>' +
            '</div>' +
            '</div>';
    }

    this.parentNode.parentNode.appendChild(li);
    this.parentNode.parentNode.removeChild(this.parentNode);
}