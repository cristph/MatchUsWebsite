package us.match.website.service.serviceImpl;


import org.springframework.stereotype.Service;
import us.match.website.dao.UserDao;
import us.match.website.model.User;
import us.match.website.service.UserService;
import us.match.website.util.Identicon;
import us.match.website.util.MD5;

import javax.annotation.Resource;
import java.util.Map;


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
        user.setPassword(MD5.toMD5(password));
        User userFromDao=userDao.findUser(username);
        System.out.println("______________"+username+" "+user.getPassword());
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

    @Override
    public User register(User user) {
        user.setFace(Identicon.creat(Identicon.tohash(user.getUsername()),200));
        User u=userDao.addUser(user);
        if(u!=null){
            return u;
        }else
            return null;
    }

    @Override
    public Map getBasicInfo(String userId) {
        return null;
    }


}
