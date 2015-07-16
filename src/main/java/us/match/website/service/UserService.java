package us.match.website.service;

import us.match.website.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by WH on 2015/7/10.
 */
public interface UserService {
    public User login(String username,String password);
    public User logout(String username);
    public User register(User user);
    public User getBasicInfo(int userId);
    public User getBasicInfo(String userName);
    public User editUserInfo(User user);
    public List<User> getHotUsers();
}
