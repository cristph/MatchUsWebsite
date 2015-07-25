package us.match.website.dao;

import us.match.website.model.Project;
import us.match.website.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2015/7/25.
 */
public interface AdministratorDao {
    public boolean addAdmin(int uid,int pid);
    public boolean deleteAdmin(int uid,int pid);

    /*
        Query
     */
    public List<User> getProjectAdmin(int pid);
    public List<Project> getAdminProject(int uid);
}
