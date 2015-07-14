package us.match.website.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import us.match.website.dao.UserSkillDao;
import us.match.website.model.UserSkill;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2015/7/14.
 */
@Repository
public class UserSkillDaoImpl implements UserSkillDao {
    @Resource
    SessionFactory sessionFactory;

    @Override
    public boolean AddSkill(UserSkill userskill) {
        boolean result=true;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(userskill);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }

    @Override
    public List<String> getSkills(String userid) {
        List<String> result=new ArrayList<String>();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("select skillname from UserSkill WHERE uid='"+userid+"'");
            result= query.list();
        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
            return result;
        }

    }
}
