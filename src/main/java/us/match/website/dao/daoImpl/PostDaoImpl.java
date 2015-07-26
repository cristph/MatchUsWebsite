package us.match.website.dao.daoImpl;

import us.match.website.dao.PostDao;
import us.match.website.model.Post;

import java.util.List;

/**
 * Created by apple on 2015/7/25.
 */
public class PostDaoImpl implements PostDao {

    @Override
    public boolean addPost(Post post) {
        return false;
    }

    @Override
    public boolean deletePost(Post post) {
        return false;
    }

    @Override
    public List<Post> getpostByProject(int pid) {
        return null;
    }

    @Override
    public Post getPostbyuserAndProject(int uid, int pid) {
        return null;
    }
}
