package us.match.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import us.match.website.model.Post;
import us.match.website.model.Project;
import us.match.website.model.User;
import us.match.website.service.SearchService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2015/7/27.
 */

@Controller
@RequestMapping("/search")
public class SearchController {

    @Resource
    SearchService searchService;

    @RequestMapping(value="/searchResult")
    public String getSearchResult(Model model,@RequestParam("pattern") String pattern){
//        List<Project> projectList=searchService.searchProject(pattern);
//        List<User> userList=searchService.searchUser(pattern);
//        List<Post> postList=searchService.searchPost(pattern);
//
//        model.addAttribute("projectList",projectList);
//        model.addAttribute("userList",userList);
//        model.addAttribute("postList",postList);
        return "searchResult";
    }
}
