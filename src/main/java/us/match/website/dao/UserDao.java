package us.match.website.dao;

import org.springframework.stereotype.Service;
import us.match.website.model.Project;
import us.match.website.model.User;
import us.match.website.model.UserSkill;

import java.util.List;
import java.util.Set;


/**
 * Created by apple on 2015/7/10.
 */

public interface UserDao {
    public User addUser(User user);
    public boolean deleteUser(User user);
    public boolean updateUser(User user);
    public List<Project> getUserProject(int uid);
    public int getidbyname(String username);
    public boolean focusProject(Project project,User user);
    public User getUserbyid(int id);
    public User addSkill(User user,List<UserSkill> userskills);
    public List<UserSkill> getallskills(String id);
    public boolean addfocuser(User focuser,User focused);
    public List<User> gettopuser();
    public User getbasicinfobyname(String user);
    public List<User> getfocuser(int id);
    public List<User> getfocused(int id);
    public List<Project> getpublishing(int id);
}
