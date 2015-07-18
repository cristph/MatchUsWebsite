package us.match.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import us.match.website.model.Project;
import us.match.website.model.User;
import us.match.website.service.ProjectService;
import us.match.website.service.UserService;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Master on 2015/7/11.
 */
@Controller
public class LoginController {

    @Resource
    UserService userService;

    @Resource
    ProjectService projectService;

    @RequestMapping("")
    public String index(Model model, HttpSession session){
        User userInSession = (User)session.getAttribute("user");
        if (userInSession != null) {
            // 呈现已登陆状态
            model.addAttribute("user", userInSession);
        }
        List<Project> list=projectService.getAllProject();
        list=list.subList(0,8);
        model.addAttribute("projects",list);

        List<User> users=null;
        users=userService.getHotUsers();
        model.addAttribute("hotUsers",users);
        model.addAttribute("hotUserReturn","True");

        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletRequest request) {
        User u=userService.login(username, password);

        if(u==null) {
            return "failed";
        }
        else {
            if (request.getParameter("remember") != null) {
                System.out.println("remember me is checked");
                // cookies 中保存用户名， 登陆序列，登陆token， 参考以下网址
                // http://justjavac.com/web/2012/04/13/can-you-do-the-login-function-on-the-web.html
            }
            request.getSession().setAttribute("user", u);
            return "success";
        }
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String Register(@ModelAttribute User newUser, Model model,HttpSession session){
        User u=userService.register(newUser);
        if(u==null){
            model.addAttribute("registerResult","regFailed");
            return "reg";
        }else{
            session.setAttribute("user",u);
            model.addAttribute("registerResult", "regSuccess");
            return "redirect:user";
        }
    }

    @RequestMapping(value="/hotUsers/userPhoto")
    public void getHotUserPhoto(HttpServletRequest request,
                                HttpServletResponse response,@RequestParam int oneHotUserId){
        //获取指定的user
        User u=userService.getBasicInfo(oneHotUserId);
        byte[] bytes=u.getFace();
        InputStream is=new ByteArrayInputStream(bytes);
        BufferedImage img=null;
        try {
            img= ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取头像失败！");
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



