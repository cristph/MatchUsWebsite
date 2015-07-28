package us.match.website.service.serviceImpl;

import org.springframework.stereotype.Service;
import us.match.website.dao.PostDao;
import us.match.website.dao.ProjectDao;
import us.match.website.dao.SearchDao;
import us.match.website.dao.UserDao;
import us.match.website.model.Post;
import us.match.website.model.Project;
import us.match.website.model.User;
import us.match.website.service.SearchService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cristph on 2015/7/27.
 */

@Service
public class SearchServiceImpl implements SearchService{
    @Resource
    SearchDao searchDao;

    @Override
    public List<User> searchUser(String pattern) {
            return searchDao.searchUser(pattern);
    }

    @Override
    public List<Project> searchProject(String pattern) {
            return searchDao.searchProject(pattern);
    }

    @Override
    public List<Post> searchPost(String pattern) {
            return  searchDao.searchPost(pattern);
    }
}
