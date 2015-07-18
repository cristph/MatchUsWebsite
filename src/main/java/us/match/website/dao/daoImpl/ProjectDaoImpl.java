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
            String sql="select pid,picture,pname,reward,skill,location,phonenumber,username from Project p,User u where (subject like";
            for(int i=0;i<len;i++){
                if(i!=len-1)
                    sql+="'%"+subject[i]+"%'"+" or subject like";
                else
                    sql+="'%"+subject[i]+"%'";
            }
            sql+=") AND u.uid=p.uid";
            Query query =session.createSQLQuery(sql);
            List<Object[]> object=query.list();

            for(Object[] o:object)
            {
                Project temp=new Project();
                temp.setPid((int) o[0]);
                temp.setPicture((String) o[1]);
                temp.setPname((String) o[2]);
                temp.setReward((String) o[3]);
                temp.setSkill((String) o[4]);
                temp.setLocation((String) o[5]);
                temp.setPhonenumber((String) o[6]);
                User user=new User();
                user.setUsername((String) o[7]);
                temp.setPublisher(user);
                result.add(temp);
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
    public List<Project> getbymodule(String[] module) {
        int len=module.length;
        List<Project> result=new ArrayList<Project>();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            String sql="select pid,picture,pname,reward,skill,location,phonenumber,username from Project p,User u where (moduel like";
            for(int i=0;i<len;i++){
                if(i!=len-1)
                    sql+="'%"+module[i]+"%'"+" or moduel like";
                else
                    sql+="'%"+module[i]+"%'";
            }
            sql+=") AND u.uid=p.uid";
            Query query =session.createSQLQuery(sql);
            List<Object[]> object=query.list();
            for(Object[] o:object)
            {
                Project temp=new Project();
                temp.setPid((int) o[0]);
                temp.setPicture((String) o[1]);
                temp.setPname((String) o[2]);
                temp.setReward((String) o[3]);
                temp.setSkill((String) o[4]);
                temp.setLocation((String) o[5]);
                User user=new User();
                user.setUsername((String) o[7]);
                temp.setPublisher(user);
                result.add(temp);
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
    public List<Project> getbyskill(String[] skill) {
        List<Project> result=new ArrayList<Project>();
        int len=skill.length;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            String sql="select pid,picture,pname,reward,skill,location,phonenumber,username from Project p,User u where (skill like";
            for(int i=0;i<len;i++){
                if(i!=len-1)
                    sql+="'%"+skill[i]+"%'"+" or skill like";
                else
                    sql+="'%"+skill[i]+"%'";
            }
            sql+=") AND u.uid=p.uid";

            Query query =session.createSQLQuery(sql);
            System.out.println("____________________" + sql);
            List<Object[]> object=query.list();
            for(Object[] o:object)
            {
                Project temp=new Project();
                temp.setPid((int) o[0]);
                temp.setPicture((String) o[1]);
                temp.setPname((String) o[2]);
                temp.setReward((String) o[3]);
                temp.setSkill((String) o[4]);
                temp.setLocation((String) o[5]);
                temp.setPhonenumber((String) o[6]);
                User user=new User();
                user.setUsername((String) o[7]);
                temp.setPublisher(user);
                result.add(temp);
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
    public List<Project> getbyreward(String reward) {
        List<Project> result=new ArrayList<Project>();
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            Query query =session.createSQLQuery("select pid,picture,pname,reward,skill,location,phonenumber,username from Project p,User u where p.uid=u.uid and reward='"+reward+"'");
            List<Object[]> object=query.list();
            for(Object[] o:object)
            {
                Project temp=new Project();
                temp.setPid((int) o[0]);
                temp.setPicture((String) o[1]);
                temp.setPname((String) o[2]);
                temp.setReward((String) o[3]);
                temp.setSkill((String) o[4]);
                temp.setLocation((String) o[5]);
                temp.setPhonenumber((String) o[6]);
                User user=new User();
                user.setUsername((String) o[7]);
                temp.setPublisher(user);
                result.add(temp);
            }
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
        long startTime = System.currentTimeMillis();//获取当前时间
        Session session = sessionFactory.openSession();
        project.setPublisher(user);
        session.save(project);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
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
        int userid=0;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            Query query =session.createSQLQuery("select pid,picture,pname,reward,skill,location,phonenumber,username from Project p,User u where p.uid=u.uid order by updatetime desc");
            List<Object[]> object=query.list();
            for(Object[] o:object)
            {
                Project temp=new Project();
                User u=new User();
                u.setUsername((String)o[7]);
                temp.setPid((int) o[0]);
                temp.setPicture((String) o[1]);
                temp.setPname((String) o[2]);
                temp.setReward((String) o[3]);
                temp.setSkill((String) o[4]);
                temp.setLocation((String) o[5]);
                temp.setPhonenumber((String) o[6]);
                temp.setPublisher(u);
                result.add(temp);
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
