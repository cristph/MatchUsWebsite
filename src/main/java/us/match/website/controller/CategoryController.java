package us.match.website.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import us.match.website.model.Project;
import us.match.website.service.FilterService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by WH on 2015/7/10.
 */
@Controller
public class CategoryController {

    @Resource
    FilterService filterService;

    @RequestMapping(value="/Category",method= RequestMethod.POST)
    @ResponseBody
    public String CategoryFilter(@RequestParam(value="dataContent[]") Object[] dataContent,
                                 HttpServletResponse response)
            throws JsonProcessingException {
        response.setCharacterEncoding("utf-8");
        response.setHeader("charset","utf-8");
            String [] strings=new String[dataContent.length];
          for(int i=0;i<dataContent.length;i++)
            strings[i]=dataContent[i].toString();
        ArrayList<String> chooseItem=new ArrayList<String>( Arrays.asList(strings));
        List<Project> list=filterService.filter(chooseItem);
//        Project p=new Project();
//        p.setPid(20);
//        p.setPname("abc");
//        list.add(p);
  //      System.out.println(list.get(0).getPname()+list.size()+"listSize-----------");
        if(list.size()==0)
        {
            Project p=new Project();
            p.setPid(-1);
            list.add(p);
        }
        ObjectMapper mapper= new ObjectMapper();
        String Json=mapper.writeValueAsString(list);
        System.out.println(Json);
        return Json;
    }

}
