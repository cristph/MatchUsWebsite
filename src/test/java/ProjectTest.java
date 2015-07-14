import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.match.website.dao.ProjectDao;
import us.match.website.dao.UserDao;
import us.match.website.model.Project;
import us.match.website.model.User;

import static org.junit.Assert.assertEquals;

/**
 * Created by Seven on 15/7/11.
 */
public class ProjectTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    ProjectDao pd=(ProjectDao)context.getBean("projectDaoImpl");
    Project pro =new Project();
    @Before
    public void Setup(){
        pro.setPname("first project");
        pro.setState(Project.states[0]);
        pro.setSubject("移动应用");
        pro.setModuel("比赛");
        pro.setReward(100);
        pro.setSkill("j0ava");
    }
//  @Test
//  public void TestAdd(){
//        assertEquals(true,pd.addProject(pro));
//    }
    @Test
    public void Testupdate(){
        pro.setPid(4);
        pro.setSubject("网站建设");
        assertEquals(true, pd.updateProject(pro));
    }
    @Test
    public void Testfindbyid(){
        assertEquals(4, pd.getbyid(4).getPid());
    }
    @Test
    public void  Testfindbyname(){
        assertEquals("first project",pd.getbyname("first project").getPname());
    }
    @Test
    public void Testgetbysubjectt(){
        assertEquals(1,pd.getbysubject("移动应用").size());
    }
    @Test
    public void Testgetbyreward(){ assertEquals(1,pd.getbyreward(0, 2000).size());}
    @Test
    public void Testgetidbyname(){assertEquals(4,pd.getidbyname("first project"));}
    @Test
    public void Testgetbymoduel(){assertEquals(1,pd.getbymodule("比赛").size());}
}
