package us.match.website.dao.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import us.match.website.dao.UserDao;
import us.match.website.model.User;

/**
 * Created by apple on 2015/7/10.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public boolean addUser(User user) {
//        boolean result=true;
//        try{
//            Session session = SessionFactory.Session();
//            session.beginTransaction();
//            session.save(user);
//            session.getTransaction().commit();
//            session.close();
////            sf.close();
//        }catch(Exception e){
//            result=false;
//            e.printStackTrace();
//        }
        return true;
    }

    @Override
    public boolean deleteUser(User user) {
        boolean result=true;
        try {
            Configuration cfg = new AnnotationConfiguration();
            SessionFactory sf = cfg.configure().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            session.close();
            sf.close();
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
            String id=user.getUsername();
            Configuration cfg = new AnnotationConfiguration();
            SessionFactory sf = cfg.configure().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            session.close();
            sf.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User find() {
        return null;
    }
}
