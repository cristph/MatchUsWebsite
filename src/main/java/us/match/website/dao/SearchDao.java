package us.match.website.dao;

import org.springframework.stereotype.Repository;
import us.match.website.model.Post;
import us.match.website.model.Project;
import us.match.website.model.User;

import java.util.List;

/**
 * Created by apple on 2015/7/28.
 */
public interface SearchDao {
    public List<User> searchUser(String key);
    public List<Project> searchProject(String key);
    public List<Post> searchPost(String key);
}
