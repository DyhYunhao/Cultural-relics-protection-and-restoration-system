package randp.dao.impl;

import org.springframework.stereotype.Repository;
import randp.dao.UserDAO;
import randp.entity.UsersEntity;

import java.util.List;

/**
 * Created by dyh on 2018/4/10.
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<UsersEntity> implements UserDAO {
    @Override
    public UsersEntity verify(String username, String password) {
        List list = getHibernateTemplate().find("from UsersEntity user where user.username = ? and user.password = ?",username,password);
        return list == null || list.isEmpty() ? null : (UsersEntity) list.get(0);
    }
}
