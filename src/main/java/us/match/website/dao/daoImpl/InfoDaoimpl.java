package us.match.website.dao.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import us.match.website.dao.InfoDao;
import us.match.website.model.Information;
import us.match.website.model.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by apple on 2015/7/23.
 */
@Repository
public class InfoDaoimpl implements InfoDao {
    @Resource
    SessionFactory sessionFactory;

    @Override
    public List<Information> getinfobyid(int uid) {
        return null;
    }

    @Override
    public boolean addinfo(Information info, User user) {
        return false;
    }

    @Override
    public boolean deleteinfo(Information info, User user) {
        return false;
    }
}
