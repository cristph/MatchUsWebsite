package us.match.website.dao.daoImpl;

import us.match.website.dao.ReplyDao;
import us.match.website.model.Post;
import us.match.website.model.Reply;

import java.util.List;

/**
 * Created by apple on 2015/7/25.
 */
public class ReplyDaOImpl implements ReplyDao {

    @Override
    public boolean AddReply(Reply reply) {
        return false;
    }

    @Override
    public boolean DeleteReply(Reply reply) {
        return false;
    }

    @Override
    public List<Reply> getReplybyPost(Post post) {
        return null;
    }
}
