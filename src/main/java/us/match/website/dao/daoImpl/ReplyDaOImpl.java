package us.match.website.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import us.match.website.dao.ReplyDao;
import us.match.website.model.Post;
import us.match.website.model.Project;
import us.match.website.model.Reply;
import us.match.website.model.User;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2015/7/25.
 */
@Repository
public class ReplyDaOImpl implements ReplyDao {
    @Resource
    SessionFactory sessionFactory;

    @Override
    public boolean AddReply(Reply reply) {
        boolean result=true;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            String sql="insert into Reply(reply_content,post_id,uid) values('"+reply.getReply_content()+"',"+reply.getReply_post().getPost_id()+","+reply.getReply_user().getUid()+")";
            System.out.println(sql);
            session.createSQLQuery(sql).executeUpdate();
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
    public boolean DeleteReply(Reply reply) {
        boolean result=true;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(reply);
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
    public List<Reply> getReplybyPost(int post_id) {
        List<Reply> result=new ArrayList<Reply>();
        Session session = sessionFactory.openSession();
        String sql="select * from Reply where post_id= '"+post_id+"'";
        try {
            session.beginTransaction();
            Query query =session.createSQLQuery(sql);
            List<Object[]> object=query.list();
            for(Object[] o:object)
            {
                Reply temp=new Reply();
                Post  temp1=new Post();
                User  temp2=new User();
                temp.setReply_id((int)o[0]);
                temp.setReply_content((String) o[1]);
                temp.setReply_createtime((Timestamp)o[2]);
                temp1.setPost_id((int)o[3]);
                temp2.setUid((int)o[4]);
                temp.setReply_post(temp1);
                temp.setReply_user(temp2);
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
