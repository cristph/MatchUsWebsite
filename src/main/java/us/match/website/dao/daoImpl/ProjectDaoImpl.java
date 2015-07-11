package us.match.website.dao.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import us.match.website.dao.ProjectDao;
import us.match.website.model.Project;

import javax.annotation.Resource;

/**
 * Created by Seven on 15/7/10.
 */
@Repository
public class ProjectDaoImpl implements ProjectDao {
    @Resource
    SessionFactory sessionFactory;
    public boolean addProject(Project project) {
        boolean result=true;
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(project);
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            result=false;
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteProject(Project project) {
        boolean result=true;
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(project);
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            result=false;
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateProject(Project project) {
        boolean result=true;
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(project);
            session.getTransaction().commit();
            session.close();
        }catch(Exception e){
            result=false;
            e.printStackTrace();
        }
        return result;
    }

    public Project find() {
        return null;
    }
}
