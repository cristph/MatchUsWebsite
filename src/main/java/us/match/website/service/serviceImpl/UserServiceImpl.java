package us.match.website.service.serviceImpl;


import org.springframework.stereotype.Service;
import us.match.website.SpringContextsUtil;
import us.match.website.dao.ProjectDao;
import us.match.website.dao.UserDao;
import us.match.website.dao.daoImpl.ProjectDaoImpl;
import us.match.website.dao.daoImpl.UserDaoImpl;
import us.match.website.model.User;
import us.match.website.service.UserService;
import javax.annotation.Resource;



/**
 * Created by WH on 2015/7/10.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

//    @Resource
//    ProjectDaoImpl projectDaoImpl;
    private ProjectDao projectDao = ((ProjectDao) SpringContextsUtil.getBean("projectDaoImpl"));

    @Resource
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
