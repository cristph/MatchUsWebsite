package us.match.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import us.match.website.model.User;
import us.match.website.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by WH on 2015/7/10.
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {
    /*处理访问个人信息的请求*/
    @Resource
    UserService userService;

    @RequestMapping("")
    public String getBasicInfo(Model model, HttpSession session){
        User usr = ((User) session.getAttribute("user"));
        model.addAttribute("user", usr);
        return "user/user";
    }
}
