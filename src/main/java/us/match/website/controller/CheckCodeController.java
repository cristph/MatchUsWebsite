package us.match.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import us.match.website.model.User;
import us.match.website.service.UserService;
import us.match.website.service.serviceImpl.IdentifyingCode;
import us.match.website.util.CheckCodeImage;
import us.match.website.util.MD5;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by WH on 2015/7/12.
 */

@Controller
public class CheckCodeController {

    @Resource
    UserService userService;

    @RequestMapping(value="/checkCode.jpg")
    public void getCheckCode(HttpServletRequest request,
                             HttpServletResponse response){
        //设置不缓存图片
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0) ;

        //指定生成的相应图片
        response.setContentType("image/jpeg") ;
        CheckCodeImage cci=new CheckCodeImage();
        request.getSession(true).setAttribute("checkCode", cci.getCodeString());
        try {
            ImageIO.write(cci.getImage(), "JPEG", response.getOutputStream()) ;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("输出验证码失败！");
        }
    }

    @ResponseBody
    @RequestMapping(value="/validate.do")
    public String validate(@RequestParam("sign_email") String email,
                           @RequestParam("sign_name") String name,
                           @RequestParam("sign_pswd") String password,
                           @RequestParam("userCheckCode") String code,
                            HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session == null ){
            return "false";
        }
        String checkCode=(String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        if(code!=null && code.length()>0 && code.toUpperCase().equals(checkCode) ){
            User user=new User();
            user.setUsername(email);
            user.setEmail(email);
            user.setNickname(name);
            user.setPassword(MD5.toMD5(password));
            User u=userService.register(user);
            if(u==null){
                return "RegisterFalse";
            }
            return "true";
        }else
            return "false";
    }


}
