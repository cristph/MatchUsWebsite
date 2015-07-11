package us.match.website.dao.daoImpl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import us.match.website.dao.UserDao;
import us.match.website.model.User;
import us.match.website.util.Message;
import java.sql.SQLException;

/**
 * Created by WH on 2015/7/11.
 */
@Aspect
public class DaoExceptionHandle {

    @Pointcut("execution(* us.match.website.dao.daoImpl.UserDaoImpl.addUser(..))")
    private void pointCut(){}

    @AfterThrowing(pointcut = "pointCut()",throwing="ex")
    public Message addUserException(JoinPoint joinPoint,Exception ex){
        if(ex instanceof SQLException){
            return Message.ADD_ALREADYEXISTED;
        }
        return Message.ADD_OUTOFRANGE;
    }

    @After("pointCut()")
    public void  afterTest(JoinPoint point){
        System.out.println("abc");
    }

    static UserDao userDao=new UserDaoImpl();

    public static void main(String[] args) {
        User u=new User();
        u.setUsername("shit");
        System.out.println("----begin---");
        userDao.addUser(u);
        System.out.println("----after---");
    }
}
