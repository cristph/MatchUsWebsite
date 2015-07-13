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
import us.match.website.util.Identicon;
import us.match.website.util.MD5;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by apple on 2015/7/10.
 */
public class UserTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserDao ud=(UserDao)context.getBean("userDaoImpl");
    User u=new User();
    @Before
    public void setUp(){
        try {
//            InputStream in = new FileInputStream("C:\\Users/Public/Pictures/Sample Pictures/1.jpg");
//            in.read(photo);
//            in.close();
            u.setUid(1);
            u.setUsername("zzz");
            u.setPassword("123");
            u.setNickname("zy");
            u.setInstruction("aaa");
            u.setRealname("zy");
            u.setSex("male");
            u.setBirthday("1");
            u.setFace(Identicon.creat(Identicon.tohash(u.getUsername()),200));
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
       u.setPassword(MD5.toMD5(u.getPassword()));
       assertEquals(u.getUsername(), ud.addUser(u).getUsername());
    }
//   @Test
//    public void testfinduser(){
//        User user=ud.findUser("465033064@qq.com");
//        User answer=new User();
//        answer.setPassword(MD5.toMD5("123"));
//        boolean m =user.getPassword().equals(answer.getPassword());
//        assertEquals(true, m);
//    }
//   @Test
//   public void testUpdate(){
//       User un=ud.findUser("465033064@qq.com");
//       un.setGoodat("c++,java");
//       ud.updateUser(un);
//       assertEquals("c++,java",ud.findUser("465033064@qq.com").getGoodat());
//   }




  @Test
    public void testDelete(){
       assertEquals(true,ud.deleteUser(u));
    }


}
