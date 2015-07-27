package us.match.website.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import us.match.website.model.User;
import us.match.website.service.PostService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by cristph on 2015/7/27.
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Resource
    private PostService postService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String addPost(@RequestParam("topicTitle") String title,@RequestParam("topicContent") String content,HttpSession session){
        System.out.println("到达了 addPost了");
        User user=(User)session.getAttribute("user");
        if(user==null)
            return "false";
        return null;
    }
}
