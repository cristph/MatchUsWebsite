package us.match.website.service;

import us.match.website.model.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WH on 2015/7/10.
 */
public interface FilterService {
    /*过滤接口*/
    public List<Project> filter(ArrayList<String> keyWords);
}
