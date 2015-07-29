package us.match.website.service.serviceImpl;

import org.springframework.stereotype.Service;
import us.match.website.dao.PostDao;
import us.match.website.model.Post;
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

    @Override
    public void addPost(Post post) {
        postDao.addPost(post);
    }

    @Override
    public List<Post> getAllPost(String pid) {
        return null;
    }
}
