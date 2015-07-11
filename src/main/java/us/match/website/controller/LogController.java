package us.match.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import us.match.website.model.User;
import us.match.website.service.UserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Master on 2015/7/11.
 */
@Controller
public class LogController {

    @Resource
    UserService userService;

    @RequestMapping("/")
    public String main(Map<String, Object> model, HttpSession httpSession) {
        User sysUser = (User) httpSession.getAttribute("sysUser");

        if (sysUser != null) {
            model.put("sysUser", sysUser);
            return "index";
        } else {
            return "login";
        }
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String main(@RequestParam("account") String account,
                       @RequestParam("password") String password,
                       Map<String, Object> model, HttpSession httpSession) {
        User sysUser = userService.login(account, password);
        if (sysUser != null) {
            httpSession.setAttribute("sysUser", sysUser);
            model.put("sysUser", sysUser);
            return "index";
        } else {
            model.put("sysUser", null);
            return "login";
        }
    }

}
