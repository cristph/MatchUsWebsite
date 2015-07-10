package us.match.website.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import us.match.website.IndexDelegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by WH on 2015/7/10.
 */
public class IndexController extends MultiActionController{
    public ModelAndView visitIndex(HttpServletRequest req,HttpServletResponse res){
        return new ModelAndView("index","returnValue","Hi Hi");
    }

}
