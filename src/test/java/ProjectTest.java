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
        pro.setState("Not ok");
    }
    @Test
    public void TestAdd(){
        assertEquals(true,pd.addProject(pro));
    }
}
