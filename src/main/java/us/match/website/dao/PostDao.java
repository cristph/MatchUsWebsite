package us.match.website.dao;

import us.match.website.model.Post;

import java.util.List;

/**
 * Created by apple on 2015/7/25.
 */
public interface PostDao {
    public boolean addPost(Post post);
    public boolean deletePost(Post post);
    /*
            Query
     */
    public List<Post> getpostByProject(int pid);
    public Post getPostbyuserAndProject(int uid,int pid);
}
