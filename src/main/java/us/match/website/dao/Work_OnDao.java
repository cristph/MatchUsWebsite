package us.match.website.dao;

import us.match.website.model.Project;
import us.match.website.model.Work_On;

/**
 * Created by apple on 2015/7/10.
 */
public interface Work_OnDao {
    public boolean addWO(Project project);
    public boolean deleteWO(Project projetc);
    public boolean updateWO(Project project);
    /*
    以下是查询方面的
     */
    public Work_On find();
}
