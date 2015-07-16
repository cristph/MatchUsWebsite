package us.match.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
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
import java.nio.Buffer;
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
    public User getBasicInfo(HttpServletRequest req,
                                     HttpServletResponse res){
        String name=req.getParameter("UserName");
        String pass=req.getParameter("Password");
        User user=userService.login(name,pass);
        return user;
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
