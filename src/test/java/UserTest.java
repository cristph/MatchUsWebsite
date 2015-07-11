import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.match.website.dao.UserDao;
import us.match.website.dao.daoImpl.UserDaoImpl;
import us.match.website.model.Project;
import us.match.website.model.User;
import org.junit.Ignore;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by apple on 2015/7/10.
 */
public class UserTest {
    static{
        File f=new File(".");
        System.out.println(f.getAbsolutePath());
    }
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserDao ud=(UserDao)context.getBean("userDaoImpl");

    User u=new User();
    @Before
    public void setUp(){
        try {
//            InputStream in = new FileInputStream("C:\\Users/Public/Pictures/Sample Pictures/1.jpg");
            byte[] photo = new byte[10];
//            in.read(photo);
//            in.close();
            u.setUsername("wh");
            u.setPassword("123");
            u.setNickname("wh");
            u.setInstruction("aaa");
            u.setRealname("wh");
            u.setSex("male");
            u.setBirthday("1");
            u.setFace(photo);
            u.setUniversity("nju");
            u.setMajor("software");
            u.setProinstruction("many works");
            u.setGoodat("java");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

   @Test
    public void testAdd(){
       assertEquals(false, ud.addUser(u));
    }
    @Test
    public void testfinduser(){
        User user=ud.findUser("wh");
        User answer=new User();
        answer.setPassword("123");
        boolean m =user.getPassword().equals(answer.getPassword());
        assertEquals(true,m);
    }
   @Test
    public void testDelete(){
       assertEquals(true,ud.deleteUser(u));
    }

//    @Ignore("Update() Not yet implemented")
//    @Test(timeout=1000)
//
//    public void testUpdate(){
//
//    }
}
