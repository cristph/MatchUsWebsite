package us.match.website.dao;

import us.match.website.model.Project;
import us.match.website.model.User;

/**
 * Created by apple on 2015/7/10.
 */
public interface ProjectDao {
    public boolean addProject(Project project);
    public boolean deleteProject(Project projetc);
    public boolean update(Project project);
    /*
    下面都是查找
     */
    public Project find();
}
