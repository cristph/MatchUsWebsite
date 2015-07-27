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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2015/7/23.
 */
@Repository
public class InfoDaoImpl implements InfoDao {
    @Resource
    SessionFactory sessionFactory;

    @Override
    public List<Information> getReadInfoById(int uid) {
        List<Information> result=new ArrayList<Information>();
        Session session = sessionFactory.openSession();
        String sql="select * from Information where receiverid= '"+uid+"' AND state= 0";
        try {
            session.beginTransaction();
            Query query =session.createSQLQuery(sql);
            List<Object[]> object=query.list();
            for(Object[] o:object)
            {
                Information temp =new Information();
                User r=new User();
                User s=new User();
                r.setUid((int)o[2]);
                s.setUid((int)o[3]);
                temp.setInfoid((int) o[0]);
                temp.setContext((String) o[1]);
                temp.setSendtime((Timestamp) o[4]);
                temp.setState((int)o[5]);
                temp.setReceiver(r);
                temp.setSender(s);
                result.add(temp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }

    @Override
    public List<Information> getNotReadInfoById(int uid) {
        List<Information> result=new ArrayList<Information>();
        Session session = sessionFactory.openSession();
        String sql="select * from Information where receiverid= '"+uid+"' AND state= 1";
        try {
            session.beginTransaction();
            Query query =session.createSQLQuery(sql);
            List<Object[]> object=query.list();
            for(Object[] o:object)
            {
                Information temp =new Information();
                User r=new User();
                User s=new User();
                r.setUid((int)o[2]);
                s.setUid((int)o[3]);
                temp.setInfoid((int) o[0]);
                temp.setContext((String) o[1]);
                temp.setSendtime((Timestamp)o[4]);
                temp.setState((int)o[5]);
                temp.setReceiver(r);
                temp.setSender(s);
                result.add(temp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
            System.out.println("___________"+result.size());
            return result;
        }
    }

    @Override
    public List<Information> getsendinfobyid(int uid) {
        List<Information> result=new ArrayList<Information>();
        Session session = sessionFactory.openSession();
        String sql="select * from Information where senderid= '"+uid+"'";
        try {
            session.beginTransaction();
            Query query =session.createSQLQuery(sql);
            List<Object[]> object=query.list();
            for(Object[] o:object)
            {
                Information temp =new Information();
                User r=new User();
                User s=new User();
                r.setUid((int)o[2]);
                s.setUid((int)o[3]);
                temp.setInfoid((int) o[0]);
                temp.setContext((String) o[1]);
                temp.setSendtime((Timestamp)o[4]);
                temp.setState((int)o[5]);
                temp.setSender(s);
                temp.setReceiver(r);
                result.add(temp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }

    @Override
    public int addinfo(String context, User sender,User receiver) {
            int result=1;
            Information info =new Information();
            info.setState(1);
            info.setContext(context);
            info.setReceiver(receiver);
            info.setSender(sender);
            Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(info);
            System.out.println("__________________????");
        } catch (Exception e) {
            result=0;
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
            System.out.println("_________________result");
            return result;
        }
    }
    @Override
    public boolean deleteinfo(Information info, User user) {
        return false;
    }
    
    @Override
    public boolean readInfo(int info) {
        boolean result =true;
        Session session = sessionFactory.openSession();
        String sql="update Information set state =0 where infoid = '"+info+"'";
        try{
            session.createSQLQuery(sql).executeUpdate();
        }catch(Exception e){
            result=false;
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
        }
        return result;
    }
}
