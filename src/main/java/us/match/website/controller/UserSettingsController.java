package us.match.website.controller;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import us.match.website.dao.UserDao;
import us.match.website.model.User;
import us.match.website.model.UserSkill;
import us.match.website.service.UserService;

import javax.annotation.Resource;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ezio on 7/14/2015.
 */
@Controller
@RequestMapping("/user/settings")
public class UserSettingsController {
    @Resource
    private UserService userService;
    @Resource
    private UserDao userDao;

    @RequestMapping("")
    public String settings(Model model) {
        return "user/settings/index";
    }

    @ResponseBody
    @RequestMapping(value = "/basic", method = RequestMethod.GET)
    public User getBasic(@RequestParam("username") String username) {
        User user = userDao.findUser(username);
        user.setFace(null);
        user.setSkills(null);
        user.setPublishingprojects(null);
        user.setWorkingprojects(null);
        return user;
    }
    @ResponseBody
    @RequestMapping(value = "/basic", method = RequestMethod.POST)
    public Map<String, Object> setBasic(
            @RequestParam("username") String username,
            @RequestParam("university") String university,
            @RequestParam("major") String major,
            @RequestParam("address") String address,
            @RequestParam("skills") String[] skills,
            @RequestParam("birthday") String brithday,
            @RequestParam("introduction") String introduction
    ) {
//        System.out.println(username);
//        System.out.println(university);
        System.out.println(major);
//        System.out.println(address);
//        System.out.println(skills);
//        System.out.println(brithday);
//        System.out.println(introduction);
        User user = new User();
        user.setUsername("new name");
        return ImmutableMap.of("success",true, "user", user);
    }


}
