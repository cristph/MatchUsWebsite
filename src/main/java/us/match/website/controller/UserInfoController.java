package us.match.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
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
        List<Project> list=userService.getPublishing(u.getUid());
        System.out.println(">>>>"+list.size());
        model.addAttribute("user", u);
        model.addAttribute("projectList",list);
        return "user/user";
    }

    @ResponseBody
    @RequestMapping(value="/user/releasedProjects",method = RequestMethod.POST)
    public List<Project> getReleased(HttpSession session,Model model,
                              @RequestParam("projectState") String projectState){
        System.out.println("function entered");
        if(projectState.equals("Done")){
            User u=(User)session.getAttribute("user");
            System.out.println("function exed");
            List<Project> list=userService.getPublishing(u.getUid());
            List<Project> newList=new LinkedList<Project>();
            for(int i=0;i<list.size();i++){
                if(!list.get(i).isState().equals("past"))
                    newList.add(list.get(i));
            }
//            model.addAttribute("projectList",newList);
            if(newList.size()==0){
                Project p=new Project();
                p.setPid(-1);
                newList.add(p);
            }
            return newList;
        }else{
            User u=(User)session.getAttribute("user");
            List<Project> list=userService.getPublishing(u.getUid());
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
        }

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

}
