package us.match.website.dao;

import org.springframework.stereotype.Service;
import us.match.website.model.User;

/**
 * Created by apple on 2015/7/10.
 */

public interface UserDao {
    public boolean addUser(User user);
    public boolean deleteUser(User user);
    public boolean updateUser(User user);
    public User findUser(String username);
}
