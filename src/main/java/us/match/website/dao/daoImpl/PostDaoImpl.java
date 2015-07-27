package us.match.website.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import us.match.website.dao.PostDao;
import us.match.website.model.Administrator;
import us.match.website.model.Post;
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
public class PostDaoImpl implements PostDao {

    @Resource
    SessionFactory sessionFactory;

    @Override
    public boolean addPost(Post post) {
        boolean result=true;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(post);
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
    public boolean deletePost(Post post) {
        boolean result=true;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(post);
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
    public List<Post> getpostByProject(int pid) {
        List<Post> result=new ArrayList<Post>();
        Session session = sessionFactory.openSession();
        String sql="select * from Post where pid= '"+pid+"'";
        try {
            session.beginTransaction();
            Query query =session.createSQLQuery(sql);
            List<Object[]> object=query.list();
            for(Object[] o:object)
            {
                Post temp=new Post();
                User temp1=new User();
                Project temp2=new Project();
                temp.setPost_id((int)o[0]);
                temp.setPost_content((String) o[1]);
                temp.setPost_createtime((Timestamp) o[2]);
                temp.setPost_ispay((int) o[3]);
                temp.setPost_title((String) o[4]);
                temp.setPost_updatetime((Timestamp) o[5]);
                temp.setIs_stick((int)o[8]);
                temp1.setUid((int)o[6]);
                temp2.setPid((int)o[7]);
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
