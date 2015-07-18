package us.match.website.dao;

import us.match.website.model.Project;
import us.match.website.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2015/7/10.
 */
public interface ProjectDao {
    public Project getbyid(int id);
    public Project getbyname(String pname);
    public int     getidbyname(String name);
    public List<Project> getbysubject(String[] subject);
    public List<Project>  getbymodule(String[] module);
    public List<Project>  getbyskill(String[] skill);
    public List<Project>  getbyreward(String reward);
    public boolean addProject(Project project,User user);
    public boolean deleteProject(Project projetc);
    public boolean updateProject(Project project);
    public List<Project>  getallProject();
    public List<Project>  findProject(String keyword);
}
