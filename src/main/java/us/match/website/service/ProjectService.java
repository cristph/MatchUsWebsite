package us.match.website.service;

import us.match.website.model.Project;

import java.util.ArrayList;

/**
 * Created by Master on 2015/7/11.
 */
public interface ProjectService {
    public String addProject(Project pro);
    public String deleteProject(Project pro);
    public String updateProject(Project pro);
    public ArrayList<Project> QueryProject(ArrayList<String> Subjects,ArrayList<String> moduel,ArrayList<String> skill,ArrayList<String> reward);
}
