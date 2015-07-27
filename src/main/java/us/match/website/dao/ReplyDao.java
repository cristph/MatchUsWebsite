package us.match.website.dao;

import us.match.website.model.Post;
import us.match.website.model.Reply;

import java.util.List;

/**
 * Created by apple on 2015/7/25.
 */
public interface ReplyDao {
    public boolean AddReply(Reply reply);
    public boolean DeleteReply(Reply reply);
    /*
            Query
     */

    public List<Reply> getReplybyPost(int post_id);
}
