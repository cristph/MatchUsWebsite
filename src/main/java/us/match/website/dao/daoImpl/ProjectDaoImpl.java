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
    public List<Integer> getbysubject(String[] subject) {
        int len=subject.length;
        List<Integer> result=new ArrayList<Integer>();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            String hql="select pid from Project where subject like";
            for(int i=0;i<len;i++){
                if(i!=len-1)
                    hql+="'%"+subject[i]+"%'"+" or subject like";
                else
                    hql+="'%"+subject[i]+"%'";
            }
            System.out.println(">>>>"+hql);
//            hql.substring(0,hql.length()-8);
            System.out.println(">>>>"+hql);
            Query query =session.createQuery(hql);
            result=query.list();
            if(result.size()>0)
                System.out.println("________________________________"+hql);
            else
                System.out.println("________________________________"+"resultSet为空");


        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.getTransaction().commit();
            session.close();
        }
        return result;
    }

    @Override
    public List<Integer> getbymodule(String[] module) {
        int len=module.length;
        System.out.println(len+">");
        List<Integer> result=new ArrayList<Integer>();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            String hql="select pid from Project where moduel like";
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
    public List<Integer> getbyskill(String[] skill) {
        List<Integer> result=new ArrayList<Integer>();
        int len=skill.length;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            String hql="select pid from Project where skill like";
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
    public List<Integer> getbyreward(int maxmoney, int minmoney) {
        List<Integer> result=new ArrayList<Integer>();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            Query query =session.createQuery("select pid from Project where reward between "+maxmoney
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

}
