package us.match.website.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import us.match.website.dao.ProjectDao;
import us.match.website.model.Project;

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
    public List<Integer> getbysubject(String subject) {
        List<Integer> result=new ArrayList<Integer>();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            Query query =session.createQuery("select pid from Project where subject='"+subject+"'");
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
    public List<Integer> getbymodule(String module) {
        List<Integer> result=new ArrayList<Integer>();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            Query query =session.createQuery("select pid from Project where moduel='"+module+"'");
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
    public List<Integer> getbyskill(String skill) {
        List<Integer> result=new ArrayList<Integer>();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            Query query =session.createQuery("select pid from Project where skill='"+skill+"'");
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
    public List<Integer> getbyreward(int maxmoney, int minmoney) {
        List<Integer> result=new ArrayList<Integer>();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            Query query =session.createQuery("select pid from Project where reward between "+maxmoney
            +" and "+minmoney);
            result=query.list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
        }
        return result;
    }


    public boolean addProject(Project project) {
        boolean result=true;
        Session session = sessionFactory.openSession();
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

}
