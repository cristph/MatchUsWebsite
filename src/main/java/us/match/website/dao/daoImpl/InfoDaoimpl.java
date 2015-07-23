package us.match.website.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import us.match.website.dao.InfoDao;
import us.match.website.model.Information;
import us.match.website.model.Project;
import us.match.website.model.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2015/7/23.
 */
@Repository
public class InfoDaoimpl implements InfoDao {
    @Resource
    SessionFactory sessionFactory;

    @Override
    public List<Information> getreadinfobyid(int uid) {
        List<Information> result=new ArrayList<Information>();
        Session session = sessionFactory.openSession();
        String sql="select i.infoid,i.context from ";
        try {
            session.beginTransaction();
            Query query =session.createSQLQuery(sql);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }

    @Override
    public List<Information> getreadedinfobyid(int uid) {
        return null;
    }

    @Override
    public List<Information> getsendinfobyid(int uid) {
        return null;
    }

    @Override
    public boolean addinfo(Information info, User sender,User receiver) {
        return false;
    }

    @Override
    public boolean deleteinfo(Information info, User user) {
        return false;
    }
}
