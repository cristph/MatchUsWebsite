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
    public List<Integer> getbysubject(String subject);
    public List<Integer>  getbymodule(String module);
    public List<Integer>  getbyskill(String skill);
    public List<Integer>  getbyreward(int maxmoney,int minmoney);
    public boolean addProject(Project project);
    public boolean deleteProject(Project projetc);
    public boolean updateProject(Project project);
}
