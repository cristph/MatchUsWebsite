package us.match.website.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import us.match.website.dao.AdministratorDao;
import us.match.website.model.Administrator;
import us.match.website.model.Information;
import us.match.website.model.Project;
import us.match.website.model.User;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2015/7/25.
 */
@Repository
public class AdministratorDaoImpl implements AdministratorDao {

    @Resource
    SessionFactory sessionFactory;

    @Override
    public boolean addAdmin(int uid, int pid) {
        boolean result=true;
        Administrator admin=new Administrator();
        admin.setUid(uid);
        admin.setPid(pid);
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(admin);
        }catch(Exception e){
            e.printStackTrace();
            result=false;
        }finally{
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }

    @Override
    public boolean deleteAdmin(int uid, int pid) {
        boolean result=true;
        Administrator admin=new Administrator();
        admin.setUid(uid);
        admin.setPid(pid);
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(admin);
        }catch(Exception e){
            e.printStackTrace();
            result=false;
        }finally{
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }

    /*
            Query
     */
    @Override
    public List<User> getProjectAdmin(int pid) {
        List<User> result=new ArrayList<User>();
        Session session = sessionFactory.openSession();
        String sql="select * from User where uid in "+
                "( select uid from Administrator where pid = '"+pid+"')";
        try {
            session.beginTransaction();
            Query query =session.createSQLQuery(sql);
            List<Object[]> object=query.list();
            for(Object[] o:object)
            {
                User temp =new User();
                temp.setUid((int) o[0]);
                temp.setAddress((String) o[1]);
                temp.setBirthday((String) o[2]);
                temp.setEmail((String) o[3]);
                temp.setFace((byte[]) o[4]);
                temp.setInstruction((String) o[5]);
                temp.setMajor((String) o[6]);
                temp.setMobilephone((String) o[7]);
                temp.setPassword((String) o[8]);
                temp.setQq((String) o[9]);
                temp.setRealname((String) o[10]);
                temp.setSex((String) o[11]);
                temp.setTelephone((String) o[12]);
                temp.setUniversity((String) o[13]);
                temp.setUsername((String) o[14]);
                temp.setFocusednum((int) o[15]);
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
    public List<Project> getAdminProject(int uid) {
        List<Project> result=new ArrayList<Project>();
        Session session = sessionFactory.openSession();
        String sql="select * from Project where pid in "+
                "( select pid from Administrator where uid = '"+uid+"')";
        try {
            session.beginTransaction();
            Query query =session.createSQLQuery(sql);
            List<Object[]> object=query.list();
            for(Object[] o:object)
            {
                Project temp=new Project();
                temp.setPid((int) o[0]);
                temp.setPicture((String) o[1]);
                temp.setPname((String) o[2]);
                temp.setReward((String) o[3]);
                temp.setSkill((String) o[4]);
                temp.setLocation((String) o[5]);
                temp.setPhonenumber((String) o[6]);
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
}
