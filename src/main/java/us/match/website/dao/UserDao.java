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
    public User addSkill(User user,List<UserSkill> userskills);//实现还需要改动
    public boolean updateSkill(User user,List<UserSkill> userskills);//还没实现，暂时不知道接口是怎么样的
    public List<UserSkill> getallskills(String id);
    public boolean addfocuser(User focuser,User focused);//前面是fans，后面是被关注的人
    public List<User> gettopuser();
    public User getbasicinfobyname(String user);
    public List<User> getfocuser(int id);
    public List<User> getfocused(int id);
    public List<Project> getpublishing(int id);
}
