package us.match.website.service.serviceImpl;


import org.springframework.stereotype.Service;
import us.match.website.dao.UserDao;
import us.match.website.model.User;
import us.match.website.service.UserService;

import javax.annotation.Resource;


/**
 * Created by WH on 2015/7/10.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public User login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User userFromDao=userDao.findUser(username);
        if(userFromDao!=null){
            if(userFromDao.getPassword().equals(user.getPassword())){
                return user; //login success
            }else{
                return null; //login failed
            }
        }else {
            return null;  //user not existed
        }
    }

    @Override
    public User logout(String username) {
        User user = new User();
        user.setUsername(username);
        return user;
    }
}
