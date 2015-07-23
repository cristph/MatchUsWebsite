package us.match.website.service;

import us.match.website.model.Information;
import us.match.website.model.Message;
import us.match.website.model.Project;
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
    public User editUserInfo(User user);
    public List<User> getHotUsers();
    public List<Project> getUserProject(int userId);
    public List<Project> getPublishing(int userId);
    public List<User> getFocus(int userId);
    public List<User> getFocused(int userId);
    public List<Project> getWorkingProjects(int userId);
    public boolean addFollow(int id1,int id2);
    public boolean deleteFollow(int id1,int id2);
    public List<Message> getReadMsg(int userId);
    public List<Message> getNotReadMsg(int userId);

}
