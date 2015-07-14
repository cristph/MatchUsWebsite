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
    @RequestMapping(value = "/release", method = RequestMethod.POST)
    public String addProject(@RequestParam("proName") String  proName,
                             @RequestParam("proDetail")String proDetail,
                             @RequestParam("proCategory")String proCategory,
                             @RequestParam("proReward")int proReward,
                             @RequestParam("proTag")String proTag,
                             @RequestParam("proLoc")String proLoc,
                             @RequestParam("proTel")String proTel,
                             @RequestParam("proEmail")String proEmail
                             )
    {
        System.out.println("到达ProjectControler了！！！！");
        Project pro=new Project();
        pro.setPid(10000);
        pro.setPname(proName);
        pro.setReward(proReward);
        pro.setEmail(proEmail);
        pro.setState(Project.states[0]);
       // System.out.println(pro.getPid()+";"+pro.getPname()+";"+pro.getReward());
        System.out.println(proName+";"+proDetail+";"+proCategory+";"+proReward+";"+proTag+
                ";"+proLoc+";"+proTel+";"+proEmail);
        String result=projectService.addProject(pro);
        System.out.println("添加完了");
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/delete_Project", method = RequestMethod.POST)
    public String deleteProject(@RequestParam("id") int id){
        Project pro=new Project();
        pro.setPid(id);
        String result=projectService.deleteProject(pro);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/update_Project",method = RequestMethod.POST)
    public String updateProject(@RequestParam("id") int id,
                                @RequestParam("pinstruction")String pinstruction,
                                @RequestParam("pname")String pname,
                                @RequestParam("publisherid")String publisherid,
                                @RequestParam("picture")byte[] picture,
                                @RequestParam("state")String state,
                                @RequestParam("subject")String subject,
                                @RequestParam("moduel")String moduel,
                                @RequestParam("skill")String skill,
                                @RequestParam("reward")int reward)
    {
        Project pro=new Project();
        pro.setPid(id);
        pro.setPinstruction(pinstruction);
        pro.setPname(pname);
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
