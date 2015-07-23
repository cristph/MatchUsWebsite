package us.match.website.dao;

import us.match.website.model.Information;
import us.match.website.model.User;

import java.util.List;

/**
 * Created by apple on 2015/7/23.
 */
public interface InfoDao {
    public List<Information> getinfobyid(int uid);
    public boolean addinfo(Information info,User user);
    public boolean deleteinfo(Information info,User user);
}
