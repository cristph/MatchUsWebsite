package us.match.website.service.serviceImpl;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import us.match.website.dao.ProjectDao;
import us.match.website.dao.UserDao;
import us.match.website.model.Project;
import us.match.website.model.User;
import us.match.website.service.UserService;
import us.match.website.util.Identicon;
import us.match.website.util.MD5;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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
        User userFromDao=userDao.loginjudge(username);
//        System.out.println("______________"+username+" "+user.getPassword());
        if(userFromDao!=null && user.getPassword()!=null){
            if(userFromDao.getPassword().equals(user.getPassword())){
                return userFromDao; //login success
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
        user.setFace(Identicon.creat(Identicon.tohash(user.getUsername()), 200));
        User u=userDao.addUser(user);

        if(u!=null){
            return u;
        }else
            return null;
    }

    @Override
    public User getBasicInfo(int userId) {
        User user=userDao.getUserbyid(userId);
        return user;
    }

    @Override
    public User getBasicInfo(String userName) {
        User user=userDao.findUser(userName);
        return user;
    }

    @Override
    public User editUserInfo(User user) {
        if(user==null)
            return null;
        User OutdatedUser=null;
        /*根据email查找用户*/
        if(user.getUsername()!=null)
            OutdatedUser=userDao.findUser(user.getEmail());
        if(OutdatedUser==null)
            return null;
        /*OutDatedUser不为null*/
        /*更新个人简介*/
        if(!OutdatedUser.getInstruction().equals(user.getInstruction())
                && user.getInstruction()!=null)
            OutdatedUser.setInstruction(user.getInstruction());
        /*更新生日*/
        if(!OutdatedUser.getBirthday().equals(user.getBirthday())
                && user.getBirthday()!=null)
            OutdatedUser.setBirthday(user.getBirthday());
        /*更新手机*/
        if(!OutdatedUser.getMobilephone().equals(user.getMobilephone())
                && user.getMobilephone()!=null)
            OutdatedUser.setMobilephone(user.getMobilephone());
        /*更新Qq*/
        if(!OutdatedUser.getQq().equals(user.getQq())
                && user.getQq()!=null)
            OutdatedUser.setQq(user.getQq());
        /*更新大学*/
        if(!OutdatedUser.getUniversity().equals(user.getUniversity())
                && user.getUniversity()!=null)
            OutdatedUser.setUniversity(user.getUniversity());
        /*更新专业*/
        if(!OutdatedUser.getMajor().equals(user.getMajor())
                && user.getMajor()!=null)
            OutdatedUser.setMajor(user.getMajor());
        /*更新擅长*/
//        if(!OutdatedUser.getGoodat().equals(user.getGoodat())
//                && user.getGoodat()!=null)
//            OutdatedUser.setGoodat(user.getGoodat());
        boolean  res=userDao.updateUser(OutdatedUser);
        if(res)
            return OutdatedUser;
        else
            return null;
    }

    @Override
    public List<User> getHotUsers() {
        List<User> list=userDao.gettopuser();
        return list;
    }

    public List<Project> getUserProject(int userId){
        return userDao.getUserProject(userId);
    }

    @Override
    public List<Project> getPublishing(int userId) {
        User u=userDao.getUserbyid(userId);
        return u.getPublishingprojects();
    }

    @Override
    public List<User> getFocus(int userId) {
//        User u=userDao.getUserbyid(userId);
        List<User> list=userDao.getfocuser(userId);
        for (User user : list) {
            user.setFocused(null);
            user.setFocuser(null);
            user.setPublishingprojects(null);
            user.setFace(null);
            user.setSkills(null);
        }
        return list;
    }

    @Override
    public List<User> getFocused(int userId) {
//        User u=userDao.getUserbyid(userId);
        List<User> list=userDao.getfocused(userId);
        for (User user : list) {
            user.setFocused(null);
            user.setFocuser(null);
            user.setPublishingprojects(null);
            user.setFace(null);
            user.setSkills(null);
        }
        return list;
    }


}
