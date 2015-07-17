package us.match.website.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import us.match.website.dao.ProjectDao;
import us.match.website.model.Project;
import us.match.website.model.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Seven on 15/7/10.
 */
@Repository
public class ProjectDaoImpl implements ProjectDao {
    @Resource
    SessionFactory sessionFactory;

    @Override
    public Project getbyid(int id) {
        Project result=new Project();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            result=(Project)session.get(Project.class,id);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
        }
        return result;
    }

    @Override
    public Project getbyname(String pname) {
        Project result=new Project();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            Query query =session.createQuery("from Project where pname='"+pname+"'");
            List<Project> temp=query.list();
            if(temp.size()!=0){
                result=temp.get(0);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
        }
        return result;
    }

    @Override
    public int getidbyname(String name) {
        int result=0;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            Query query =session.createQuery("select pid from Project where pname='"+name+"'");
            List<Integer> temp=query.list();
            if(temp.size()!=0){
                result=temp.get(0);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
        }
        return result;
    }

    @Override
    public List<Project> getbysubject(String[] subject) {
        int len=subject.length;
        List<Project> result=new ArrayList<Project>();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            String hql="from Project where subject like";
            for(int i=0;i<len;i++){
                if(i!=len-1)
                    hql+="'%"+subject[i]+"%'"+" or subject like";
                else
                    hql+="'%"+subject[i]+"%'";
            }
            Query query =session.createQuery(hql);
            result=query.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
        }
        return result;
    }

    @Override
    public List<Project> getbymodule(String[] module) {
        int len=module.length;
        List<Project> result=new ArrayList<Project>();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            String hql="from Project where moduel like";
            for(int i=0;i<len;i++){
                if(i!=len-1)
                    hql+="'%"+module[i]+"%'"+" or moduel like";
                else
                    hql+="'%"+module[i]+"%'";
            }
            Query query =session.createQuery(hql);
            result=query.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
        }
        return result;
    }

    @Override
    public List<Project> getbyskill(String[] skill) {
        List<Project> result=new ArrayList<Project>();
        int len=skill.length;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            String hql="from Project where skill like";
            for(int i=0;i<len;i++){
                if(i!=len-1)
                    hql+="'%"+skill[i]+"%'"+" or skill like";
                else
                    hql+="'%"+skill[i]+"%'";
            }
            Query query =session.createQuery(hql);
            result=query.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
        }
        return result;
    }

    @Override
    public List<Project> getbyreward(int maxmoney, int minmoney) {
        List<Project> result=new ArrayList<Project>();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            Query query =session.createQuery("from Project where reward between "+maxmoney
            +"and "+minmoney);
            result=query.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
        }
        return result;
    }

    public boolean addProject(Project project,User user) {
        boolean result=true;
        Session session = sessionFactory.openSession();
        user.getPublishingprojects().add(project);
        project.setPublisher(user);
        session.save(project);
        try{
            session.beginTransaction();
            session.save(project);
        }catch(Exception e){
            result=false;
            e.printStackTrace();
        }finally {
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }

    public boolean deleteProject(Project project) {
        boolean result=true;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(project);
        }catch(Exception e){
            result=false;
            e.printStackTrace();
        }finally {
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }

    public boolean updateProject(Project project) {
        boolean result=true;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(project);
        }catch(Exception e){
            result=false;
            e.printStackTrace();
        }finally {
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }

    @Override
    public List<Project> getallProject() {
        List<Project> result=new ArrayList<Project>();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            Query query =session.createQuery("from Project order by updatetime desc");
            result=query.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
        }
        return result;
    }

    @Override
    public List<Project> findProject(String keyword) {
        List<Project> result=new ArrayList<Project>();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            String hql="from Project where skill like '%'"+keyword+"'%'";
            Query query =session.createQuery(hql);
            result=query.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
        }
        return result;
    }

}
