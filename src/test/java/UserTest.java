import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.match.website.dao.UserDao;
import us.match.website.model.User;
import us.match.website.util.Identicon;
import us.match.website.util.MD5;

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
            u.setUsername("gjp");
            u.setPassword("123");
            u.setInstruction("aaa");
            u.setRealname("gjp");
            u.setSex("male");
            u.setBirthday("1");
            u.setFace(Identicon.creat(Identicon.tohash(u.getUsername()), 200));
            u.setUniversity("nju");
            u.setMajor("software");
            u.setEmail("123456@qq.com");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

//  @Test
//  public void testAdd(){
//      u.setPassword(MD5.toMD5(u.getPassword()));
//     assertEquals(u.getUsername(), ud.addUser(u).getUsername());
//  }
        @Test
        public void testfinduser(){
            User user=ud.findUser("gjp");
            User answer=new User();
           answer.setPassword(MD5.toMD5("123"));
           boolean m =user.getPassword().equals(answer.getPassword());
           assertEquals(true, m);
        }
//        @Test
        public void testUpdate(){
          User un=ud.findUser("gjp");
          ud.updateUser(un);
      }
        @Test
        public void testgetidbyname(){assertEquals(12,ud.getidbyname("gjp"));}

}
