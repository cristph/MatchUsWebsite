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
import java.sql.Timestamp;
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

            Query query = session.createQuery("from User WHERE username='" + username + "'");

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
        String sql="select * from Project p where p.pid in"+
                "(select project_id from u_p where user_id="+uid+")";
        try {
            session.beginTransaction();
            Query query =session.createSQLQuery(sql);
            List<Object[]> object=query.list();
            for(Object[] o:object)
            {
                Project temp=new Project();
                temp.setPid((int) o[0]);
                temp.setModuel((String) o[1]);
                temp.setPicture((byte[]) o[2]);
                temp.setPinstruction((String) o[3]);
                temp.setReward((String) o[4]);
                temp.setSkill((String) o[5]);
                temp.setState((String) o[6]);
                temp.setSubject((String) o[7]);
                temp.setUpdatetime((Timestamp) o[8]);
                temp.setStarttime((Timestamp) o[9]);
                temp.setLocation((String) o[10]);
                temp.setEmail((String) o[11]);
                temp.setPhonenumber((String) o[12]);
                temp.setPname((String) o[13]);
                temp.setQq((String) o[14]);
                temp.setTelephone((String) o[15]);
                temp.setFax((String)o[16]);
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
        Session session = sessionFactory.openSession();
        User result =new User();
        long startTime = System.currentTimeMillis();//获取当前时间
        try {
            session.beginTransaction();
            Query query = session.createSQLQuery("select * from User WHERE uid="+id);
            List<Object[]> object=query.list();
            if(object.size()!=0){
                for(Object[] o:object){
                    result.setUid((int) o[0]);
                    result.setAddress((String)o[1]);
                    result.setBirthday((String)o[2]);
                    result.setEmail((String)o[3]);
                    result.setFace((byte[])o[4]);
                    result.setInstruction((String)o[5]);
                    result.setMajor((String)o[6]);
                    result.setMobilephone((String)o[7]);
                    result.setPassword((String)o[8]);
                    result.setQq((String)o[9]);
                    result.setRealname((String)o[10]);
                    result.setSex((String)o[11]);
                    result.setTelephone((String)o[12]);
                    result.setUniversity((String)o[13]);
                    result.setUsername((String)o[14]);
                    result.setFocusednum((int)o[15]);
                }
            }
            else{
                result=null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
            long endTime = System.currentTimeMillis();
            System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
            return result;
        }
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
    public User getbasicinfobyname(String user) {
        Session session = sessionFactory.openSession();
        User result =new User();
        long startTime = System.currentTimeMillis();//获取当前时间
        try {
            session.beginTransaction();
            Query query = session.createSQLQuery("select * from User WHERE username='" + user + "'"
            +"or email = '"+user+"'");
            List<Object[]> object=query.list();
            if(object.size()!=0){
                for(Object[] o:object){
                    result.setUid((int) o[0]);
                    result.setAddress((String)o[1]);
                    result.setBirthday((String)o[2]);
                    result.setEmail((String)o[3]);
                    result.setFace((byte[])o[4]);
                    result.setInstruction((String)o[5]);
                    result.setMajor((String)o[6]);
                    result.setMobilephone((String)o[7]);
                    result.setPassword((String)o[8]);
                    result.setQq((String)o[9]);
                    result.setRealname((String)o[10]);
                    result.setSex((String)o[11]);
                    result.setTelephone((String)o[12]);
                    result.setUniversity((String)o[13]);
                    result.setUsername((String)o[14]);
                    result.setFocusednum((int)o[15]);
                }
            }
            else{
                result=null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
            long endTime = System.currentTimeMillis();
            System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
            return result;
        }
    }

    @Override
    //得到关注用户的人
    public List<User> getfocuser(int id) {
        List<User> result=new ArrayList<User>();
        Session session = sessionFactory.openSession();
        String sql="select uid,username,email,university,address from User where uid IN " +
                "(select focuser_id from focuser_focused where focused_id="+id+")";
        try {
            session.beginTransaction();
            Query query =session.createSQLQuery(sql);
            List<Object[]> object=query.list();
            for(Object[] o:object)
            {
                User temp =new User();
                temp.setUid((int)o[0]);
                temp.setUsername((String) o[1]);
                temp.setEmail((String) o[2]);
                temp.setUniversity((String) o[3]);
                temp.setAddress((String)o[4]);
                result.add(temp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            return result;
        }
    }

    @Override
    //得到被用户关注的人
    public List<User> getfocused(int id) {
        List<User> result=new ArrayList<User>();
        Session session = sessionFactory.openSession();
        String sql="select uid,username,email,university,address from User where uid IN " +
                "(select focused_id from focuser_focused where focuser_id="+id+")";
        try {
            session.beginTransaction();
            Query query =session.createSQLQuery(sql);
            List<Object[]> object=query.list();
            for(Object[] o:object)
            {
                User temp =new User();
                temp.setUid((int)o[0]);
                temp.setUsername((String)o[1]);
                temp.setEmail((String)o[2]);
                temp.setUniversity((String)o[3]);
                temp.setAddress((String)o[4]);
                result.add(temp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            return result;
        }
    }

    @Override
    public List<Project> getpublishing(int id) {
        List<Project>  result =new ArrayList<Project>();
        Session session = sessionFactory.openSession();
        String sql="select * from Project where uid="+id;
        try{
            session.beginTransaction();
            Query query =session.createSQLQuery(sql);
            List<Object[]> object=query.list();
            for(Object[] o:object)
            {
                Project temp=new Project();
                temp.setPid((int) o[0]);
                temp.setModuel((String) o[1]);
                temp.setPicture((byte[]) o[2]);
                temp.setPinstruction((String) o[3]);
                temp.setReward((String) o[4]);
                temp.setSkill((String) o[5]);
                temp.setState((String) o[6]);
                temp.setSubject((String) o[7]);
                temp.setUpdatetime((Timestamp) o[8]);
                temp.setStarttime((Timestamp) o[9]);
                temp.setLocation((String) o[10]);
                temp.setEmail((String) o[11]);
                temp.setPhonenumber((String) o[12]);
                temp.setPname((String) o[13]);
                temp.setQq((String) o[14]);
                temp.setTelephone((String) o[15]);
                temp.setFax((String)o[16]);
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
