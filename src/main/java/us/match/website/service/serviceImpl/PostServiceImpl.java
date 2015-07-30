package us.match.website.service.serviceImpl;

import org.springframework.stereotype.Service;
import us.match.website.dao.PostDao;
import us.match.website.dao.ReplyDao;
import us.match.website.dao.UserDao;
import us.match.website.model.Post;
import us.match.website.model.Reply;
import us.match.website.service.PostService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2015/7/27.
 */
@Service
public class PostServiceImpl implements PostService{

    @Resource
    PostDao postDao;
    @Resource
    ReplyDao replyDao;

    @Resource
    UserDao userDao;

    @Override
    public void addPost(Post post) {
        postDao.addPost(post);
    }

    @Override
    public List<Post> getAllPost(int pid) {
        List<Post> result =postDao.getpostByProject(pid);
        for(Post r:result){
            r.setPoster(userDao.getUserbyid(r.getPoster().getUid()));
        }
        return result;
    }

    @Override
    public void addReply(Reply reply) {
        replyDao.AddReply(reply);
    }

    @Override
    public List<Reply> getAllReply(int postID) {
        List<Reply> result =replyDao.getReplybyPost(postID);
        for(Reply r:result){
            r.setReply_user(userDao.getUserbyid(r.getReply_user().getUid()));
        }
        return result;
    }

    @Override
    public Post getpostByPost(int pid) {
        return postDao.getpostByPost(pid);
    }
}
