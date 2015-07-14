package us.match.website.controller;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import us.match.website.model.User;
import us.match.website.model.UserSkill;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ezio on 7/14/2015.
 */
@Controller
@RequestMapping("/user/settings")
public class UserSettingsController {

    @RequestMapping("")
    public String settings(Model model) {
        User user = new User();
        user.setUsername("姓名");
        user.setUniversity("NJU");
        user.setMajor("SE");
        user.setAddress("XianLin");
        user.setBirthday("19950101");
        user.setMobilephone("no mobilephone");
        user.setTelephone("no telphone");
        user.setQq("no qq");
        model.addAttribute("user", user);
        model.addAttribute("current_setting", "basic");
        return "user/settings/index";
    }

    @ResponseBody
    @RequestMapping(value = "/basic", method = RequestMethod.POST)
    public Map<String, Boolean> setBasic(@ModelAttribute User user) {
        return ImmutableMap.of("success", true);
    }




}
