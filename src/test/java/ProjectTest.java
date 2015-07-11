import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Created by Seven on 15/7/11.
 */
public class ProjectTest {
    private static SessionFactory sf;

    @BeforeClass
    public static void beforeTest(){
        sf = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    @AfterClass
    public static void afterTest(){
        sf.close();
    }
}
