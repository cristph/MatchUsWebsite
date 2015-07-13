package us.match.website.controller;

/**
 * Created by Master on 2015/7/11.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import us.match.website.model.Project;
import us.match.website.service.ProjectService;

import javax.annotation.Resource;
import java.util.ArrayList;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Resource
    ProjectService projectService;

    @RequestMapping("/")
    public String project(){
        return "project";
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProject(@RequestParam("id") String id,
                             @RequestParam("pinstruction")String pinstruction,
                             @RequestParam("pname")String pname,
                             @RequestParam("publisherid")String publisherid,
                             @RequestParam("picture")byte[] picture,
                             @RequestParam("state")boolean state,
                             @RequestParam("subject")String subject,
                             @RequestParam("moduel")String moduel,
                             @RequestParam("skill")String skill,
                             @RequestParam("reward")String reward)
    {
        Project pro=new Project();
        pro.setId(id);
        pro.setPinstruction(pinstruction);
        pro.setPname(pname);
        pro.setPublisherid(publisherid);
        pro.setPicture(picture);
        pro.setState(state);
        pro.setSubject(subject);
        pro.setModuel(moduel);
        pro.setSkill(skill);
        pro.setReward(reward);

        String result=projectService.addProject(pro);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/delete_Project", method = RequestMethod.POST)
    public String deleteProject(@RequestParam("id") String id){
        Project pro=new Project();
        pro.setId(id);
        String result=projectService.deleteProject(pro);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/update_Project",method = RequestMethod.POST)
    public String updateProject(@RequestParam("id") String id,
                                @RequestParam("pinstruction")String pinstruction,
                                @RequestParam("pname")String pname,
                                @RequestParam("publisherid")String publisherid,
                                @RequestParam("picture")byte[] picture,
                                @RequestParam("state")boolean state,
                                @RequestParam("subject")String subject,
                                @RequestParam("moduel")String moduel,
                                @RequestParam("skill")String skill,
                                @RequestParam("reward")String reward)
    {
        Project pro=new Project();
        pro.setId(id);
        pro.setPinstruction(pinstruction);
        pro.setPname(pname);
        pro.setPublisherid(publisherid);
        pro.setPicture(picture);
        pro.setState(state);
        pro.setSubject(subject);
        pro.setModuel(moduel);
        pro.setSkill(skill);
        pro.setReward(reward);

        String result=projectService.updateProject(pro);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/query_project",method = RequestMethod.POST)
    public ArrayList<Project> query_project(){
        return null;
    }






}
