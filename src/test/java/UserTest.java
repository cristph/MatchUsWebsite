import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.match.website.dao.ProjectDao;
import us.match.website.dao.UserDao;
import us.match.website.model.Project;
import us.match.website.model.User;
import us.match.website.model.UserSkill;
import us.match.website.util.Identicon;
import us.match.website.util.MD5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by apple on 2015/7/10.
 */
public class UserTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserDao ud=(UserDao)context.getBean("userDaoImpl");
    ProjectDao pd=(ProjectDao)context.getBean("projectDaoImpl");
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
// public void testAdd(){
//     u.setPassword(MD5.toMD5(u.getPassword()));assertEquals(u.getUsername(), ud.addUser(u).getUsername());}
//        @Test
//        public void testfinduser(){
////            User user=ud.findUser("gjp");
//            User answer=new User();
//           answer.setPassword(MD5.toMD5("123"));
//           boolean m =user.getPassword().equals(answer.getPassword());
//           assertEquals(true, m);
//        }
//        @Test
//        public void testUpdate(){
//            User un=ud.findUser("gjp");
//            un.setAddress("nju");
//            assertEquals(true, ud.updateUser(un));
//      }
        @Test
        public void testgetidbyname(){assertEquals(13,ud.getidbyname("gjp"));}
        @Test
        public void testgetallproject(){
            assertEquals(1,ud.getUserProject(14).size());
        }
////        @Test
//        public void testsetskill(){
//                User user =ud.findUser("gjp");
//                List<UserSkill> u=new ArrayList<UserSkill>();
//                UserSkill m= new UserSkill();
//                m.setUser(user);
//                m.setSkillname("java");
//                m.setLevel(0);
//                UserSkill n= new UserSkill();
//                n.setUser(user);
//                n.setSkillname("c++");
//                n.setLevel(0);
//                u.add(m);
//                u.add(n);
//                assertEquals(2,ud.addSkill(user,u).getSkills().size());
//        }
//        @Test
//        public void testgetvyemail(){
//            assertEquals("gjp",ud.getuserbyemail("123456@qq.com").getUsername());
//        }
       @Test
        public void testaddproject(){
           User user =new User();
           user.setUid(70);
          Project p=new Project();
           p.setPid(10);
           assertEquals(true,ud.focusProject(p,user));
       }
    @Test
    public void testaddfocuser(){
        User gjp=new User();
        gjp.setUid(13);
        User ezio=new User();
        ezio.setUid(76);
        assertEquals(true, ud.addfocuser(gjp,ezio));}
    @Test
    public  void testgettopuser(){
        assertEquals(36,ud.gettopuser().size());
    }
    @Test
    public void testgetfocuser(){assertEquals(3,ud.getfocuser(13).size());}
    @Test
    public void testgetfocused(){assertEquals(1,ud.getfocused(13).size());}

}
