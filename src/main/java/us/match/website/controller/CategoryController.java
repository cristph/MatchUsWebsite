package us.match.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import us.match.website.model.Project;
import us.match.website.service.FilterService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public List<Project> CategoryFilter(@RequestParam(value="dataContent") String[] dataContent){
        ArrayList<String> chooseItem=new ArrayList<String>( Arrays.asList(dataContent));
        List<Project> list=filterService.filter(chooseItem);
        return list;
    }

}
