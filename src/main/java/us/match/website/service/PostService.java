package us.match.website.service;

import us.match.website.model.Post;

import java.util.List;

/**
 * Created by cristph on 2015/7/27.
 */
public interface PostService {
    public void addPost(Post post);
    public List<Post> getAllPost(int pid);
}
