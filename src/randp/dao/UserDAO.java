package randp.dao;

import randp.entity.UsersEntity;

/**
 * Created by dyh on 2018/4/10.
 */
public interface UserDAO extends BaseDAO<UsersEntity> {
    UsersEntity verify(String username, String password);
}
