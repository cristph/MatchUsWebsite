package us.match.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import us.match.website.model.Project;
import us.match.website.service.FilterService;

import javax.annotation.Resource;
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

    @ResponseBody
    @RequestMapping(value = "/Category", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public List<Project> CategoryFilter(@RequestParam(value = "dataContent[]") Object[] dataContent) {
        long up = System.currentTimeMillis();
        String[] strings = new String[dataContent.length];
        for (int i = 0; i < dataContent.length; i++)
            strings[i] = dataContent[i].toString();
        ArrayList<String> chooseItem = new ArrayList<String>(Arrays.asList(strings));
        List<Project> list = filterService.filter(chooseItem);

        if (list.size() == 0) {
            Project p = new Project();
            p.setPid(-1);
            list.add(p);
        }
        System.out.println(System.currentTimeMillis()-up);
        return list;
    }

}
