package us.match.website.dao;

import us.match.website.model.Project;
import us.match.website.model.Work_On;

/**
 * Created by apple on 2015/7/10.
 */
public interface Work_OnDao {
    public boolean addProject(Project project);
    public boolean deleteProject(Project projetc);
    public boolean update(Project project);
    /*
    以下是查询方面的
     */
    public Work_On find();
}
