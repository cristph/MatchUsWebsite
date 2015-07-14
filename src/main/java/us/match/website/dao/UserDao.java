package us.match.website.dao;

import org.springframework.stereotype.Service;
import us.match.website.model.Project;
import us.match.website.model.User;

import java.util.List;


/**
 * Created by apple on 2015/7/10.
 */

public interface UserDao {
    public User addUser(User user);
    public boolean deleteUser(User user);
    public boolean updateUser(User user);
    public User findUser(String username);
    public List<Project> getUserProject(int uid);
    public int getidbyname(String username);
    public boolean addProject(Project project,User user);
}
