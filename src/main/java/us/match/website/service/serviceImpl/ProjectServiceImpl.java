package us.match.website.service.serviceImpl;

import org.springframework.stereotype.Service;
import us.match.website.dao.ProjectDao;
import us.match.website.model.Project;
import us.match.website.service.ProjectService;
import javax.annotation.Resource;
/**
 * Created by Seven on 15/7/12.
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    ProjectDao projectDao;

    public boolean addProject(Project project) {
        return projectDao.addProject(project);
    }
}
