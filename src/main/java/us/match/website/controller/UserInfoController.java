package us.match.website.controller;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import us.match.website.model.Message;
import us.match.website.model.Project;
import us.match.website.model.User;
import us.match.website.service.UserService;
import us.match.website.util.CheckCodeImage;
import us.match.website.util.MD5;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by WH on 2015/7/10.
 */
@Controller
public class UserInfoController extends MultiActionController{
    /*处理访问个人信息的请求*/
    @Resource
    UserService userService;

    @RequestMapping(value="/user")
    public String getBasicInfo(HttpSession session,Model model){
        User u=(User)session.getAttribute("user");
        List<Message> list=userService.getNotReadMsg(u.getUid());
        if(list.size()==0){
            Message m=new Message();
            m.setSenderId(-1);
            list.add(m);
        }
        model.addAttribute("informationList",list);
        model.addAttribute("user", u);
        return "user/user";
    }//初始化个人页面，返回所有的未读消息，如果没有则返回一个id为-1的

    @ResponseBody
    @RequestMapping(value="/user/information",method = RequestMethod.POST)
    public List<Message> getReleased(HttpSession session,Model model,
                              @RequestParam("informationState") String messageState,
                                @RequestParam("uid") int uid){
        System.out.println("function entered");
        if(messageState.equals("old")){
            User u=(User)session.getAttribute("user");
            System.out.println("function exed");
            List<Message> list=userService.getReadMsg(uid);
            if(list.size()==0){
                Message m=new Message();
                m.setSenderId(-1);
                list.add(m);
            }
            return list;
        }else{
            List<Message> list=userService.getNotReadMsg(uid);
            if(list.size()==0){
                Message m=new Message();
                m.setSenderId(-1);
                list.add(m);
            }
           return list;
        }
    }

    @ResponseBody
    @RequestMapping(value="/user/attendProjects",method = RequestMethod.POST)
    public List<Project> getAttend(HttpSession session,
                                     @RequestParam("projectState") String projectState,
                                        @RequestParam("uid") int uid){
        System.out.println("function entered");
        if(projectState.equals("now")){
            System.out.println("function exed");
            List<Project> list=userService.getWorkingProjects(uid);
            List<Project> newList=new LinkedList<Project>();
            for(int i=0;i<list.size();i++){
                if(list.get(i).isState().equals("now"))
                    newList.add(list.get(i));
            }
//            model.addAttribute("projectList",newList);
            if(newList.size()==0){
                Project p=new Project();
                p.setPid(-1);
                newList.add(p);
            }
            return newList;
        }else if(projectState.equals("past")){
            List<Project> list=userService.getWorkingProjects(uid);
            List<Project> newList=new LinkedList<Project>();
            for(int i=0;i<list.size();i++){
                if(list.get(i).isState().equals("past"))
                    newList.add(list.get(i));
            }
//            model.addAttribute("projectList",newList);
            if(newList.size()==0){
                Project p=new Project();
                p.setPid(-1);
                newList.add(p);
            }
            return newList;
        }else {
            List<Project> list=userService.getWorkingProjects(uid);
            List<Project> newList=new LinkedList<Project>();
            for(int i=0;i<list.size();i++){
                if(list.get(i).isState().equals("will"))
                    newList.add(list.get(i));
            }
//            model.addAttribute("projectList",newList);
            if(newList.size()==0){
                Project p=new Project();
                p.setPid(-1);
                newList.add(p);
            }
            return newList;
        }

    }

    @ResponseBody
    @RequestMapping(value="/user/focus",method = RequestMethod.POST)
//    @RequestMapping(value="/user/focus")
    public List<User> getFocus(HttpSession session,
                               @RequestParam int uid){
        List<User> list=userService.getFocus(uid);
//        List<User> list=null;
        if(list==null || list.size()==0) {
            list = new ArrayList<User>();
            User temp=new User();
            temp.setUid(-1);
            list.add(temp);
        }
        System.out.println(list.size());
        return  list;
    }

    @ResponseBody
    @RequestMapping(value="/user/focused",method = RequestMethod.POST)
    public List<User> getFocused(HttpSession session,
                                 @RequestParam int uid){
            List<User> list=userService.getFocused(uid);
            if(list==null || list.size()==0) {
                list = new ArrayList<User>();
                User temp=new User();
                temp.setUid(-1);
                list.add(temp);
            }
            return  list;
    }

    @ResponseBody
    @RequestMapping(value="/user/addFollow",method = RequestMethod.POST)
    public String addFollow(HttpSession session,
                                 @RequestParam int uid){
        //TODO
        System.out.println("登陆者姓名："+((User)session.getAttribute("user")).getUsername());
        System.out.println("添加关注的人的id为："+uid);
        int id1=((User)session.getAttribute("user")).getUid();
        if(userService.addFollow(id1,uid))
            return "succeed";
        else
            return "failed";
    }

    @ResponseBody
    @RequestMapping(value="/user/deleteFollow",method = RequestMethod.POST)
    public String deleteFollow(HttpSession session,
                                @RequestParam int uid){
        //TODO
        System.out.println("登陆者姓名："+((User)session.getAttribute("user")).getUsername());
        System.out.println("取消关注的人的id为："+uid);
        int id1=((User)session.getAttribute("user")).getUid();
        if(userService.deleteFollow(id1, uid))
            return "succeed";
        else
            return "failed";
    }




    @RequestMapping(value="/userPhoto.jpg")
    public  void getUserPhoto(@RequestParam("uid") int userId,
                              HttpServletRequest request,
                              HttpServletResponse response){

        //获取指定的user
        User u=userService.getBasicInfo(userId);
        byte[] bytes=u.getFace();
        InputStream is=new ByteArrayInputStream(bytes);
        BufferedImage img=null;
        try {
            img= ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取二进制数组转换成BufferedImage失败！");
        }
        //指定生成的相应图片
        response.setContentType("image/jpeg") ;
        try {
            if(img!=null)
                ImageIO.write(img, "JPEG", response.getOutputStream()) ;
            else
                throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("输出用户头像失败！");
        }
    }

    @RequestMapping(value="/otherUser")
    public String getOtherUser(HttpSession session,Model model,@RequestParam int uid){

        List<Project> list=userService.getWorkingProjects(uid);
        List<Project> newList=new LinkedList<Project>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).isState().equals("now"))
                newList.add(list.get(i));
        }
        if(newList.size()==0){
            Project p=new Project();
            p.setPid(-1);
            newList.add(p);
        }
        model.addAttribute("attendProjects", newList);
        User u = userService.getBasicInfo(uid);
        u.setPassword(null);
        u.setFocused(null);
        u.setPublishingprojects(null);
        u.setFocuser(null);
        model.addAttribute("oneOtherUser", u);
        User self=(User)session.getAttribute("user");
        String relationShip=new String();
        if(self.getUid()==uid){
            relationShip="self";

        } else if (isFollow(self.getFocused(),uid)){
            relationShip="follow";
        } else{
            relationShip="unfollow";
        }
        model.addAttribute("relationship", relationShip);
        return "/user/otherUser";
    }

    private boolean isFollow(List<User> follows,int targetUid){
        boolean isFollow=false;
        if(follows==null){
            return false;
        }else {
            for(int i=0;i<follows.size();i++){
                if(follows.get(i).getUid()==targetUid){
                    isFollow=true;
                    break;
                }
            }
        }
        return isFollow;
    }//判断一个人是否为登陆者的关注的人

    @ResponseBody
    @RequestMapping(value="/usermessage")
    public  String getmessagenum(HttpSession session){
            User user=(User)session.getAttribute("user");
            int uid=user.getUid();
            int num=userService.getMessageNum(uid);
            if(num<=99)
                return String.valueOf(userService.getMessageNum(uid));
            else
                return "99+";
    }

    @ResponseBody
    @RequestMapping(value="/user/changeToRead",method = RequestMethod.POST)
    public void changeToRead(@RequestParam("infoId") int infoId){
        // 设为已读、
        userService.changestate(infoId);
        System.out.println("消息id"+infoId);
    }

    @ResponseBody
    @RequestMapping(value="/user/sendMessage",method = RequestMethod.POST)
    public int sendMessage(@RequestParam("senderId") int senderId,
                            @RequestParam("receiverId") int receiverId,
                            @RequestParam("content") String content){
        // 发送消息
        System.out.println(senderId+"发送给"+receiverId+"消息内容为："+content);
        return userService.sendMessage(senderId, receiverId, content);
    }

}
