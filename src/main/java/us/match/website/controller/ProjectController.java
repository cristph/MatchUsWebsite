package us.match.website.controller;

/**
 * Created by Master on 2015/7/11.
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import us.match.website.model.Project;
import us.match.website.model.User;
import us.match.website.service.ProjectService;
import us.match.website.service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Resource
    ProjectService projectService;
    @Resource
    UserService userService;

    @RequestMapping("")
    public String project(Model model){
        List<Project> projects = projectService.getAllProject();
        model.addAttribute("projects", projects);
        System.out.println(projects.size());
        return "project/project";
    }
///////////////////////////////////////////////////////////////////////////////////

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProject(
                            @RequestParam("pinstruction") String pinstruction,
                             @RequestParam("pname")String pname,
                             @RequestParam("subject")String subject,
                            @RequestParam("reward")int reward,
                            @RequestParam("phonenumber")String phoneNumber,
                            @RequestParam("email")String email
                             //@RequestParam("userName")String userName
    )
    {
        Project pro=new Project();
        pro.setLocation("1111");
        pro.setPname("First Project injected");

        /*User user=userService.getBasicInfo(userName);
        String location=user.getAddress();
        String email=user.getEmail();
        String phoneNum=user.getMobilephone();

        pro.setPname(pname);
        pro.setPinstruction(pinstruction);
        pro.setSubject(subject);
        pro.setState("will");
        pro.setPublisher(user);
        pro.setReward(reward);
        //pro.setSkill(skill);
        pro.setLocation(location);
        pro.setEmail(email);
        pro.setPhonenumber(phoneNum);*/

        projectService.addProject(pro);

        return "/project/project";
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
                                @RequestParam("state")String state,
                                @RequestParam("subject")String subject,
                                @RequestParam("moduel")String moduel,
                                @RequestParam("skill")String skill,
                                @RequestParam("reward")int reward,
                                @RequestParam("userName")String userName,
                                @RequestParam("location")String location,
                                @RequestParam("email")String email,
                                @RequestParam("phonenumber")String phoneNumber)
    {
        Project pro=new Project();
        pro.setPid(pid);
        pro.setPinstruction(pinstruction);
        pro.setPname(pname);
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
    public List<Project> getAllProject(){
       return  projectService.getAllProject();
    }

    //@ResponseBody
    @RequestMapping(value = "/getOneProject")
    public String getOneProject(Model model)
    {
        model.addAttribute("pname","dddd");
        model.addAttribute("pid",100101);
        model.addAttribute("state","will");
        model.addAttribute("pinstruction","sdfsdfdf");
        model.addAttribute("publisher","sfdsdifj");
        model.addAttribute("subject","will");
        model.addAttribute("moduel","will");
        model.addAttribute("reward",2000);
        model.addAttribute("location","beijing");
        model.addAttribute("email","will");
        model.addAttribute("phoneNumber","10000");
        model.addAttribute("time","2000-01-01");

        return "project/show/projectInfo";
    }


}
