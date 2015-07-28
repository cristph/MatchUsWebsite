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
import java.util.ArrayList;
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
        System.out.println(pattern);
        List<Project> projectList=searchService.searchProject(pattern);
        List<User> userList=searchService.searchUser(pattern);
        List<Post> postList=searchService.searchPost(pattern);

        model.addAttribute("projectList",projectList);
        model.addAttribute("userList",userList);
        model.addAttribute("postList",postList);

        System.out.println("result:"+projectList.size());
        if(projectList.size()>0){
            System.out.println(projectList.get(0).getPname());
        }

//        Project p1=new Project();
//        p1.setPname("p1");
//        p1.setPinstruction("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
//        User a=new User();
//        a.setUsername("hahaha");
//        p1.setPublisher(a);
//
//
//        Project p2=new Project();
//        p2.setPname("p2");
//        p2.setPinstruction("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
//        User b=new User();
//        b.setUsername("hehehe");
//        p2.setPublisher(a);
//
//        ArrayList<Project> projectList=new ArrayList<Project>();
//        projectList.add(p1);
//        projectList.add(p2);
//        model.addAttribute("projectList", projectList);
//
//        a.setUniversity("NJU");
//        b.setUniversity("PKU");
//        a.setSex("男");
//        b.setSex("女");
//        a.setInstruction("aliealie");
//        b.setInstruction("bilibili");
//        a.setMajor("C++");
//        b.setMajor("Java");
//        a.setWorkingprojects(projectList);
//        b.setWorkingprojects(projectList);
//        ArrayList<User> userList=new ArrayList<User>();
//        userList.add(a);
//        userList.add(b);
//        model.addAttribute("userList",userList);

        return "searchResult";
    }
}
