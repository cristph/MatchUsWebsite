package us.match.website.service;

import us.match.website.model.Post;
import us.match.website.model.Reply;

import java.util.List;

/**
 * Created by cristph on 2015/7/27.
 */
public interface PostService {
    public void addPost(Post post);
    public List<Post> getAllPost(int pid);
    public void addReply(Reply reply);
    public List<Reply> getAllReply(int postID);
    public Post getpostByPost(int pid);
}
