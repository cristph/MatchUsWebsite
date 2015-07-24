package us.match.website.service.serviceImpl;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import us.match.website.dao.InfoDao;
import us.match.website.dao.ProjectDao;
import us.match.website.dao.UserDao;
import us.match.website.model.Information;
import us.match.website.model.Message;
import us.match.website.model.Project;
import us.match.website.model.User;
import us.match.website.service.UserService;
import us.match.website.util.Identicon;
import us.match.website.util.MD5;

import javax.annotation.Resource;
import java.security.Timestamp;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Created by WH on 2015/7/10.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Resource
    InfoDao infoDao;

    @Override
    public User login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(MD5.toMD5(password));
        User userFromDao=userDao.getbasicinfobyname(username);
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
    public User editUserInfo(User user) {
        if(user==null)
            return null;
        User OutdatedUser=null;
        /*根据 uid 查找用户*/
        if(user.getUsername()!=null)
            OutdatedUser=userDao.getUserbyid(user.getUid());
        if(OutdatedUser==null)
            return null;
        /*OutDatedUser不为null*/
        /*更新用户名*/
        if(user.getUsername()!=null)
            OutdatedUser.setUsername(user.getUsername());
        /*更新性别*/
        if(user.getSex()!=null)
            OutdatedUser.setSex(user.getSex());
        /*更新大学*/
        if(user.getUniversity()!=null)
            OutdatedUser.setUniversity(user.getUniversity());
        /*更新专业*/
        if(user.getMajor()!=null)
            OutdatedUser.setMajor(user.getMajor());
        /*更新所在地*/
        if(user.getAddress()!=null)
            OutdatedUser.setAddress(user.getAddress());
        /*更新生日*/
        if(user.getBirthday()!=null)
            OutdatedUser.setBirthday(user.getBirthday());
        /*更新手机*/
        if(user.getMobilephone()!=null)
            OutdatedUser.setMobilephone(user.getMobilephone());
        /*更新电话*/
        if(user.getTelephone()!=null)
            OutdatedUser.setTelephone(user.getTelephone());
        /*更新Qq*/
        if(user.getQq()!=null)
            OutdatedUser.setQq(user.getQq());
        /*更新个人简介*/
        if(user.getInstruction()!=null)
            OutdatedUser.setInstruction(user.getInstruction());
        /*更新擅长*/
//        if(!OutdatedUser.getGoodat().equals(user.getGoodat())
//                && user.getGoodat()!=null)
//            OutdatedUser.setGoodat(user.getGoodat());
        if(userDao.updateUser(OutdatedUser))
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
        return userDao.getpublishing(userId);
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

    @Override
    public List<Project> getWorkingProjects(int userId) {
        return userDao.getUserProject(userId);
    }

    @Override
    public boolean addFollow(int id1, int id2) {
        User u1=new User();
        u1.setUid(id1);
        User u2=new User();
        u2.setUid(id2);
        return userDao.addfocuser(u1,u2);
    }

    @Override
    public boolean deleteFollow(int id1, int id2) {
        User u1=new User();
        u1.setUid(id1);
        User u2=new User();
        u2.setUid(id2);
        return userDao.deletefocuser(u1,u2);
    }

    @Override
    public List<Message> getReadMsg(int userId) {
        List<Information> infos=infoDao.getReadInfoById(userId);
        List<Message> msgs=new LinkedList<Message>();
        for(int i=0;i<infos.size();i++){
            Message msg=new Message();
            int s_id=infos.get(i).getSender().getUid();
            int r_id=infos.get(i).getReceiver().getUid();
            java.sql.Timestamp t=infos.get(i).getSendtime();
            User s=userDao.getUserbyid(s_id);
            User r=userDao.getUserbyid(r_id);
            msg.setSendName(s.getUsername());
            msg.setReceiverName(r.getUsername());
            msg.setContent(infos.get(i).getContext());
            msg.setTime(t.toString());
            msgs.add(msg);
        }
        return msgs;
    }

    @Override
    public List<Message> getNotReadMsg(int userId) {
        List<Information> infos=infoDao.getNotReadInfoById(userId);
        List<Message> msgs=new LinkedList<Message>();
        for(int i=0;i<infos.size();i++){
            Message msg=new Message();
            System.out.println("_________________"+infos.get(i).getSender().getUid());
            int s_id=infos.get(i).getSender().getUid();

            int r_id=infos.get(i).getReceiver().getUid();
            java.sql.Timestamp t=infos.get(i).getSendtime();
            User s=userDao.getUserbyid(s_id);
            User r=userDao.getUserbyid(r_id);
            msg.setSendName(s.getUsername());
            msg.setReceiverName(r.getUsername());
            msg.setContent(infos.get(i).getContext());
            msg.setTime(t.toString());
            msgs.add(msg);
        }
        return msgs;
    }

}
