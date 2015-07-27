package us.match.website.service.serviceImpl;

import org.springframework.stereotype.Service;
import us.match.website.model.Post;
import us.match.website.model.Project;
import us.match.website.model.User;
import us.match.website.service.SearchService;

import java.util.List;

/**
 * Created by cristph on 2015/7/27.
 */

@Service
public class SearchServiceImpl implements SearchService{

    @Override
    public List<User> searchUser(String pattern) {
        return null;
    }

    @Override
    public List<Project> searchProject(String pattern) {
        return null;
    }

    @Override
    public List<Post> searchPost(String pattern) {
        return null;
    }
}
