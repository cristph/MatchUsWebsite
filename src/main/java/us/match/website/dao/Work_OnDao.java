package us.match.website.dao;

import us.match.website.model.Project;
import us.match.website.model.Work_On;

/**
 * Created by apple on 2015/7/10.
 */
public interface Work_OnDao {
    public boolean addWO(Work_On wo);
    public boolean deleteWO(Work_On wo);
    public boolean updateWO(Work_On wo);

    public Work_On find();
}
