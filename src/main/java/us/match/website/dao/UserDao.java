package us.match.website.dao;

import us.match.website.model.User;

/**
 * Created by apple on 2015/7/10.
 */
public interface UserDao {
    public boolean addUser(User user);
    public boolean delete(User user);
    public boolean update(User user);
    /*
    下面都是查找
     */
    public User find();
}
