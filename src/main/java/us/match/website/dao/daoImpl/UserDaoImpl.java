package us.match.website.dao.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Source;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import us.match.website.dao.UserDao;
import us.match.website.model.User;
import us.match.website.util.MD5;

import javax.annotation.Resource;


/**
 * Created by apple on 2015/7/10.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    SessionFactory sessionFactory;

    public User addUser(User user) {
        User result=new User();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(user);
            User u =(User)session.get(User.class,user.getUsername());
        } catch (Exception e) {
           result=null;
           e.printStackTrace();
       }finally{
            session.getTransaction().commit();
            session.close();
            return result;
        }
        }

    @Override
    public boolean deleteUser(User user) {
        boolean result=true;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(user);
        }catch(Exception e){
            result=false;
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }

    @Override
    public boolean updateUser(User user) {
        boolean result=true;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(user);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }

    @Override
    public User findUser(String username) {
        User result=new User();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            result = (User) session.get(User.class, username);

        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }
}
