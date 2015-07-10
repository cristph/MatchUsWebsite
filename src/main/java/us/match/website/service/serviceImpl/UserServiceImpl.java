package us.match.website.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.match.website.dao.UserDao;
import us.match.website.model.User;
import us.match.website.service.UserService;

/**
 * Created by WH on 2015/7/10.
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public String login(String username, String password) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        return "success";
    }

    @Override
    public String logout(String username) {
        User user=new User();
        user.setUsername(username);
        return "success";
    }
}