package us.match.website.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import us.match.website.model.User;
import us.match.website.model.UserSkill;
import us.match.website.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by Ezio on 7/14/2015.
 */
@Controller
@RequestMapping("/user/settings")
public class UserSettingsController {
    @Resource
    private UserService userService;

    @RequestMapping("")
    public String settings(Model model) {
        return "/user/settings/index";
    }

    @ResponseBody
    @RequestMapping(value = "/basic", method = RequestMethod.GET)
    public User getBasic(HttpSession session) {
        User u=(User)session.getAttribute("user");
        User user = userService.getBasicInfo(u.getUid());
        user.setPassword(null);
        return user;
    }
    @ResponseBody
    @RequestMapping(value = "/basic", method = RequestMethod.POST)
    public Map<String, Object> setBasic(HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        user.setUsername(request.getParameter("username"));
        user.setSex(request.getParameter("sex"));
        user.setUniversity(request.getParameter("university"));
        user.setMajor(request.getParameter("major"));
        user.setAddress(request.getParameter("address"));
//        user.setSkills()
        user.setBirthday(request.getParameter("birthday"));
        user.setMobilephone(request.getParameter("mobilephone"));
        user.setTelephone(request.getParameter("telephone"));
        user.setQq(request.getParameter("qq"));
        user.setInstruction(request.getParameter("instruction"));
        session.setAttribute("user",user);
        return ImmutableMap.of("success",true, "user", user);
    }


}
