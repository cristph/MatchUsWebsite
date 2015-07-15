package us.match.website.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import us.match.website.model.User;
import us.match.website.service.UserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Master on 2015/7/11.
 */
@Controller
public class LoginController {

    @Resource
    UserService userService;

    @RequestMapping("")
    public String index(Model model, HttpSession session){
        User userInSession = (User)session.getAttribute("user");
        if (userInSession != null) {
            // 呈现已登陆状态
            model.addAttribute("user", userInSession);
        }
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletRequest request) {
        User u=userService.login(username,password);
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
    public String Register(@ModelAttribute User newUser, Model model){
        User u=userService.register(newUser);
        if(u==null){
            model.addAttribute("registerResult","regFailed");
            return "reg";
        }else{
            model.addAttribute("user",u);
            model.addAttribute("registerResult","regSuccess");
            return "redirect:user";
        }
    }
}
