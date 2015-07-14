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
    UserDao ud=(UserDao)context.getBean("userDaoImpl");
    Project pro =new Project();
    @Before
    public void Setup(){
        pro.setPname("第三届青岛啤酒大学生微营销创意大赛");
        pro.setState(Project.states[2]);
        pro.setSubject("文案设计");
        pro.setModuel("比赛");
        pro.setReward(30000);
        pro.setSkill("");
    }
//  @Test
//  public void TestAdd(){
//        User user =ud.findUser("gjp");
//        assertEquals(true,pd.addProject(pro,user));
//    }
//    @Test
//    public void Testupdate(){
//        pro.setPid(5);
//        pro.setSubject("网站建设");
//        assertEquals(true, pd.updateProject(pro));
//    }
    @Test
    public void Testfindbyid(){
        assertEquals(5, pd.getbyid(5).getPid());
    }
    @Test
    public void  Testfindbyname(){
        assertEquals("第三届青岛啤酒大学生微营销创意大赛",pd.getbyname("第三届青岛啤酒大学生微营销创意大赛").getPname());
    }
    @Test
    public void Testgetbysubjectt(){
        assertEquals(1,pd.getbysubject("移动应用").size());
    }
    @Test
    public void Testgetbyreward(){ assertEquals(1,pd.getbyreward(10000, 25000).size());}
    @Test
    public void Testgetidbyname(){assertEquals(5,pd.getidbyname("第三届青岛啤酒大学生微营销创意大赛"));}
    @Test
    public void Testgetbymoduel(){assertEquals(4,pd.getbymodule("比赛").size());}
    @Test
    public void Testfetall(){
        assertEquals(4,pd.getallProject().size());}
}
