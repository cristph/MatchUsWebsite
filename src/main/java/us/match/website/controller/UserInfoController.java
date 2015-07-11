package us.match.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import us.match.website.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by WH on 2015/7/10.
 */
@Controller
public class UserInfoController extends MultiActionController{
    /*处理访问个人信息的请求*/
    @Resource
    UserService userService;

    public ModelAndView getBasicInfo(HttpServletRequest req,
                                     HttpServletResponse res){
        String name=req.getParameter("UserName");
        String pass=req.getParameter("Password");
        String result=userService.login(name,pass);
        ModelMap model = null;
        model.addAttribute("result",result);
        return new ModelAndView("path:handleok");
    }
}
