package us.match.website;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by WH on 2015/7/10.
 */
public class IndexDelegate {

    private ModelAndView visitIndex(HttpServletRequest req,
                                    HttpServletResponse res){
        System.out.println("function exe!");
        return new ModelAndView("index","returnValue","999 nice");
    }
}
