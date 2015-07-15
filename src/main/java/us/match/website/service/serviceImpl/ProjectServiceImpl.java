package us.match.website.service.serviceImpl;

import org.springframework.stereotype.Service;
import us.match.website.dao.ProjectDao;
import us.match.website.dao.UserDao;
import us.match.website.dao.daoImpl.UserDaoImpl;
import us.match.website.model.Project;
import us.match.website.model.User;
import us.match.website.service.ProjectService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Master on 2015/7/12.
 */
@Service
public class ProjectServiceImpl implements ProjectService{

    @Resource
    ProjectDao projectDao;
    @Resource
    UserDao userDao;

    @Override
    public String addProject(Project pro) {
        String publisherName=pro.getPublisher().getUsername();
        User user=userDao.findUser(publisherName);

        boolean b=projectDao.addProject(pro,pro.getPublisher());
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

    @Override
    public List<Project> getAllProject() {

        return projectDao.getallProject();
    }
}
