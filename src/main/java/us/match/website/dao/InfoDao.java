package us.match.website.dao;

import us.match.website.model.Information;
import us.match.website.model.User;

import java.util.List;

/**
 * Created by apple on 2015/7/23.
 */
public interface InfoDao {
    public List<Information> getReadInfoById(int uid);
    public List<Information> getNotReadInfoById(int uid);
    public List<Information> getsendinfobyid(int uid);
    public boolean addinfo(Information info,User sender,User receiver);
    public boolean deleteinfo(Information info,User user);
}
