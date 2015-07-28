package us.match.website.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import us.match.website.dao.SearchDao;
import us.match.website.model.Post;
import us.match.website.model.Project;
import us.match.website.model.User;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2015/7/28.
 */
@Repository
public class SearchDaoImpl implements SearchDao {
    @Resource
    SessionFactory sessionFactory;

    @Override
    public List<User> searchUser(String key) {
        List<User> result=new ArrayList<User>();
        Session session = sessionFactory.openSession();
        String sql="select * from User where username like '%"+key+"%'";
        try{
            Query query =session.createSQLQuery(sql);
            List<Object[]> object=query.list();
            for(Object[] o:object){
                User temp=new User();
                temp.setUid((int) o[0]);
                temp.setAddress((String) o[1]);
                temp.setBirthday((String) o[2]);
                temp.setEmail((String) o[3]);
                temp.setFace((byte[]) o[4]);
                temp.setInstruction((String) o[5]);
                temp.setMajor((String) o[6]);
                temp.setMobilephone((String) o[7]);
                temp.setPassword((String) o[8]);
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
    public List<Project> searchProject(String key) {
        List<Project> result=new ArrayList<Project>();
        Session session = sessionFactory.openSession();
        String sql="select * from Project where pname like '%"+key+"%'";
        try{
            Query query =session.createSQLQuery(sql);
            List<Object[]> object=query.list();
            for(Object[] o:object){
                Project temp=new Project();
                temp.setPid((int) o[0]);
                temp.setPicture((String) o[1]);
                temp.setPname((String) o[2]);
                temp.setReward((String) o[3]);
                temp.setSkill((String) o[4]);
                temp.setLocation((String) o[5]);
                temp.setPhonenumber((String) o[6]);
                User user=new User();
                user.setUsername((String) o[7]);
                temp.setPublisher(user);
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
    public List<Post> searchPost(String key) {
        List<Post> result=new ArrayList<Post>();
        Session session = sessionFactory.openSession();
        String sql="select * from Post where post_title like '%"+key+"%'";
        try{
            Query query =session.createSQLQuery(sql);
            List<Object[]> object=query.list();
            for(Object[] o:object){
                Post temp=new Post();
                User temp1=new User();
                Project temp2=new Project();
                temp.setPost_id((int)o[0]);
                temp.setPost_content((String) o[1]);
                temp.setPost_createtime((Timestamp) o[2]);
                temp.setPost_ispay((int) o[3]);
                temp.setPost_title((String) o[4]);
                temp.setPost_updatetime((Timestamp) o[5]);
                temp.setIs_stick((int) o[8]);
                temp1.setUid((int) o[6]);
                temp2.setPid((int) o[7]);
                temp.setPoster(temp1);
                temp.setPost_match(temp2);
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
