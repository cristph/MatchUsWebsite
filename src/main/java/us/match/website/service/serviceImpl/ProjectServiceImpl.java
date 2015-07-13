package us.match.website.service.serviceImpl;

import us.match.website.dao.ProjectDao;
import us.match.website.model.Project;
import us.match.website.service.ProjectService;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by Master on 2015/7/12.
 */
public class ProjectServiceImpl implements ProjectService{

    @Resource
    ProjectDao projectDao;

    @Override
    public String addProject(Project pro) {
        boolean b=projectDao.addProject(pro);
        String result="failed";
        if(b)
            result="success";

        return result;
    }

    @Override
    public String deleteProject(Project pro) {
        boolean b=projectDao.deleteProject(pro);
        String result="failed";
        if(b)
            result="success";

        return result;
    }

    @Override
    public String updateProject(Project pro) {
        boolean b=projectDao.updateProject(pro);
        String result="failed";
        if(b)
            result="success";

        return result;
    }

    @Override
    public ArrayList<Project> QueryProject(ArrayList<String> Subjects, ArrayList<String> moduel, ArrayList<String> skill, ArrayList<String> reward) {
        return null;
    }
}
