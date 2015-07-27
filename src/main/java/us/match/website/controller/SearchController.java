package us.match.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import us.match.website.service.SearchService;

import javax.annotation.Resource;

/**
 * Created by cristph on 2015/7/27.
 */

@Controller
@RequestMapping("/search")
public class SearchController {

    @Resource
    SearchService searchService;

    @ResponseBody
    @RequestMapping(value="/searchResult")
    public String getSearchResult(){
        return null;
    }
}
