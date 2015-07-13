package us.match.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import us.match.website.service.serviceImpl.IdentifyingCode;

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
    @RequestMapping(value="/checkCode.jpg")
    public void getCheckCode(HttpServletRequest request,
                             HttpServletResponse response,
                             Model model){
        //设置不缓存图片
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0) ;

        //指定生成的相应图片
        response.setContentType("image/jpeg") ;
        IdentifyingCode idCode = new IdentifyingCode();
        BufferedImage image =new BufferedImage(idCode.getWidth() , idCode.getHeight() , BufferedImage.TYPE_INT_BGR) ;
        Graphics2D g = image.createGraphics() ;
        //定义字体样式
        Font myFont = new Font("黑体" , Font.BOLD , 20) ;
        //设置字体
        g.setFont(myFont) ;

        g.setColor(idCode.getRandomColor(200, 250)) ;
        //绘制背景
        g.fillRect(0, 0, idCode.getWidth(), idCode.getHeight()) ;

        g.setColor(idCode.getRandomColor(180, 200)) ;
        idCode.drawRandomLines(g, 30) ;
        String codeString=idCode.drawRandomString(4, g) ;
        g.dispose() ;
        request.getSession(true).setAttribute("checkCode", codeString);
        try {
            ImageIO.write(image, "JPEG", response.getOutputStream()) ;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("输出验证码失败！");
        }
    }

    @ResponseBody
    @RequestMapping(value="/validate")
    public boolean validate(@RequestParam("userCheckCode") String code,
                            HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session == null){
            return false;
        }
        String checkCode=(String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        if(code!=null && code.length()>0 && code.toUpperCase().equals(checkCode) ){
            return true;
        }else
            return false;
    }


}