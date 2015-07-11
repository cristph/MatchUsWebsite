package us.match.website.dao.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import us.match.website.dao.Work_OnDao;
import us.match.website.model.Project;
import us.match.website.model.Work_On;

import javax.annotation.Resource;

/**
 * Created by apple on 2015/7/11.
 */
@Repository
public class Work_OnDaoImpl implements Work_OnDao {
    @Resource
    SessionFactory sessionFactory;

    @Override
    public boolean addWO(Work_On wo) {
        boolean result=true;
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(wo);
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            result=false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteWO(Work_On wo) {
        boolean result=true;
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(wo);
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            result=false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateWO(Work_On wo) {
        boolean result=true;
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(wo);
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            result=false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Work_On find() {
        return null;
    }
}
