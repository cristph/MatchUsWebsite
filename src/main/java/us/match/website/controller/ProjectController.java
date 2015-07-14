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
///////////////////////////////////////////////////////////////////////////////////
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProject(@RequestParam("pid") int pid,
                             @RequestParam("pinstruction") String pinstruction,
                             @RequestParam("pname")String pname,
                             @RequestParam(value = "datas[]") byte[] picture,
                             @RequestParam("state")String state,
                             @RequestParam("subject")String subject,
                             @RequestParam("moduel")String moduel,
                             @RequestParam("skill")String skill,
                             @RequestParam("reward")int reward,
                             @RequestParam("userName")String userName,
                             @RequestParam("location")String location,
                             @RequestParam("email")String email,
                             @RequestParam("phonenumber")String phoneNumber
                             )
    {
        Project pro=new Project();
        pro.setPid(pid);
        pro.setPinstruction(pinstruction);
        pro.setPname(pname);
        pro.setPicture(picture);
        pro.setState(state);
        pro.setSubject(subject);
        pro.setModuel(moduel);
        pro.setSkill(skill);
        pro.setReward(reward);
        pro.getPublisher().setUsername(userName);
        pro.setLocation(location);
        pro.setEmail(email);
        pro.setPhonenumber(phoneNumber);


        String result=projectService.addProject(pro);
        return result;
    }

    ///////////////////////////////////////////////////////////////////////////////

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteProject(@RequestParam("id") int id){
        Project pro=new Project();
        pro.setPid(id);
        String result=projectService.deleteProject(pro);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/update_Project",method = RequestMethod.POST)
    public String updateProject(@RequestParam("pid") int pid,
                                @RequestParam("pinstruction") String pinstruction,
                                @RequestParam("pname")String pname,
                                @RequestParam(value = "datas[]") byte[] picture,
                                @RequestParam("state")String state,
                                @RequestParam("subject")String subject,
                                @RequestParam("moduel")String moduel,
                                @RequestParam("skill")String skill,
                                @RequestParam("reward")int reward,
                                @RequestParam("userName")String userName,
                                @RequestParam("location")String location,
                                @RequestParam("email")String email,
                                @RequestParam("phonenumber")String phoneNumber
    {
        Project pro=new Project();
        pro.setPid(pid);
        pro.setPinstruction(pinstruction);
        pro.setPname(pname);
        pro.setPicture(picture);
        pro.setState(state);
        pro.setSubject(subject);
        pro.setModuel(moduel);
        pro.setSkill(skill);
        pro.setReward(reward);
        pro.getPublisher().setUsername(userName);
        pro.setLocation(location);
        pro.setEmail(email);
        pro.setPhonenumber(phoneNumber);

        String result=projectService.updateProject(pro);
        return result;
    }
////////////////////////////////////////////////////////////////////////////////////
    @ResponseBody
    @RequestMapping(value = "/query_project",method = RequestMethod.POST)
    public ArrayList<Project> query_project(){
        return null;
    }

//////////////////////////////////////////////////////////////////////////////////////
    @ResponseBody
    @RequestMapping(value="/getAllProject",method = RequestMethod.POST)
    public ArrayList<Project> getAllProject(){
       return  projectService.getAllProject();
    }




}
