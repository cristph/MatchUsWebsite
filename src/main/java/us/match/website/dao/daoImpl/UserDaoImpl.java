package us.match.website.dao.daoImpl;

import com.google.common.collect.ArrayListMultimap;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Source;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import us.match.website.dao.UserDao;
import us.match.website.model.Project;
import us.match.website.model.User;
import us.match.website.model.UserSkill;
import us.match.website.util.MD5;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


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
            result =(User)session.get(User.class,user.getUid());
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
            Query query=session.createQuery("from User WHERE username='"+username+"'");
            List<User> list= query.list();
            if(list.size()!=0){
                result=list.get(0);
            }
            else{
                result=null;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }

    @Override
    public List<Project> getUserProject(int uid) {
        List<Project>  result =new ArrayList<Project>();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            User temp=(User)session.get(User.class,uid);
            result=temp.getWorkingprojects();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }

    @Override
    public int getidbyname(String username) {
        int result =0;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query=session.createQuery("select uid from User WHERE username='"+username+"'");
            List<Integer> list= query.list();
            if(list.size()!=0) {
                result = list.get(0);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }

    @Override
    public boolean addProject(Project project,User user) {
        boolean result=true;
        user.getWorkingprojects().add(project);
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(user);
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
    public User getUserbyid(int id) {
        User result=new User();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            result=(User)session.get(User.class,id);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
        }
        return result;
    }

    @Override
    public User addSkill(User user, List<UserSkill> userskills) {
        user.setSkills(userskills);
        User result=user;
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
    public List<UserSkill> getallskills(String id) {
        List<UserSkill> result=new ArrayList<UserSkill>();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            User temp=(User)session.get(User.class,id);
            result=temp.getSkills();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
        }
        return result;
    }
    @Override
    public boolean addfocuser(User focuser,User focused) {
            boolean result=true;
            focuser.getFocuser().add(focused);
            focused.getFocused().add(focuser);
            focused.addfocused();
            Session session = sessionFactory.openSession();
            try{
                session.beginTransaction();
                session.update(focuser);
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                session.getTransaction().commit();
                session.close();
                return result;
            }
    }

    @Override
    public List<User> gettopuser() {
        List<User> result=new ArrayList<User>();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query=session.createSQLQuery("select uid,email,face,username from User order by focusednum desc");
            query.setFirstResult(0);
            query.setMaxResults(36);
            List<Object[]> object = query.list();
            for(Object[] o:object)
            {
                User temp=new User();
                temp.setUid((int)o[0]);
                temp.setEmail((String)o[1]);
                temp.setFace((byte[])o[2]);
                temp.setUsername((String)o[3]);
                result.add(temp);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }

    @Override
    public String loginjudge(String user) {
        Session session = sessionFactory.openSession();
        String  result=null;
        try {
            session.beginTransaction();
            Query query = session.createSQLQuery("select password from User WHERE username='" + user + "'"
            +"or email = '"+user+"'");
            List<Object[]> object=query.list();
            if(object.size()!=0){
                for(Object[] o:object){
                    result=(String)o[0];
                }
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
