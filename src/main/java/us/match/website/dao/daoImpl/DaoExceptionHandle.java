package us.match.website.dao.daoImpl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.match.website.dao.UserDao;
import us.match.website.model.User;
import us.match.website.util.Message;
import java.sql.SQLException;

/**
 * Created by WH on 2015/7/11.
 */
public class DaoExceptionHandle {

    public Message addUserException(){
        return Message.ADD_OUTOFRANGE;
    }

    public void  afterTest(JoinPoint point){
        System.out.println("abc");
    }


    UserDao userDao;

    public static void main(String[] args) {
        DaoExceptionHandle d=new DaoExceptionHandle();
        d.test();
    }
    public void test(){
        System.out.println("----begin---");
        userDao.testH();
        System.out.println("----after---");
    }
}
