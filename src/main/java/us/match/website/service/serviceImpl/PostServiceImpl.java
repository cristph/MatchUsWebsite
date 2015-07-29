package us.match.website.service.serviceImpl;

import org.springframework.stereotype.Service;
import us.match.website.dao.PostDao;
import us.match.website.dao.ReplyDao;
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

    @Override
    public void addPost(Post post) {
        postDao.addPost(post);
    }

    @Override
    public List<Post> getAllPost(int pid) {
       return postDao.getpostByProject(pid);
    }

    @Override
    public void addReply(Reply reply) {
        replyDao.AddReply(reply);
    }

    @Override
    public List<Reply> getAllReply(int postID) {
        return replyDao.getReplybyPost(postID);
    }
}
