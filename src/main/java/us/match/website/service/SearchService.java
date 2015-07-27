package us.match.website.service;

import us.match.website.model.Post;
import us.match.website.model.Project;
import us.match.website.model.User;

import java.util.List;

/**
 * Created by cristph on 2015/7/27.
 */
public interface SearchService {
    public List<User> searchUser(String pattern);
    public List<Project> searchProject(String pattern);
    public List<Post> searchPost(String pattern);
}
