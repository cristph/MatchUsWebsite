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

import javax.annotation.Resource;


/**
 * Created by apple on 2015/7/10.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    SessionFactory sessionFactory;


    public boolean addUser(User user) {
        boolean result = true;
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
           result=false;
           e.printStackTrace();
       }
            return result;
        }

    @Override
    public boolean deleteUser(User user) {
        boolean result=true;
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            result=false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateUser(User user) {
        boolean result=true;
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findUser(String username) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            User result = (User) session.get(User.class, username);
            session.getTransaction().commit();
            session.close();
            return result;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
