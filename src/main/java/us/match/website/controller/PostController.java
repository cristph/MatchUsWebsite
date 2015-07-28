package us.match.website.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import us.match.website.model.Post;
import us.match.website.model.Project;
import us.match.website.model.User;
import us.match.website.service.PostService;
import us.match.website.service.ProjectService;

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
    @Resource
    private ProjectService projectService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String addPost(
            @RequestParam("topicTitle") String title,
            @RequestParam("topicContent") String content,
            @RequestParam("post_id") String pid,
            @RequestParam("post_ispay") int post_ispay,
            @RequestParam("is_stick") int is_stick,
            HttpSession session){
        User user=(User)session.getAttribute("user");
        if(user==null) {
            return "fail";
        }
        Post post=new Post();
        Project project=projectService.getOneProject(Integer.parseInt(pid));

        post.setPoster(user);
        post.setPost_match(project);
        post.setPost_title(title);
        post.setPost_content(content);
        post.setIs_stick(post_ispay);
        post.setIs_stick(is_stick);
        postService.addPost(post);
        return "success";

    }
}
