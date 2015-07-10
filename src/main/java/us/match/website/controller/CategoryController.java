package us.match.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by WH on 2015/7/10.
 */
@Controller
public class CategoryController {
    @RequestMapping("/Category")
    public String CategoryFilter(HttpServletRequest request){
        String chooseItem=request.getParameter("choose");
        return "success";
    }

}
