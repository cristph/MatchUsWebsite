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
            if(list.size()!=0){
                result=list.get(0);
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
        List<Project> temp= user.getWorkingprojects();
        temp.add(project);
        user.setWorkingprojects(temp);
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


}
