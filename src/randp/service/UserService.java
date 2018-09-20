package randp.service;

import randp.entity.UsersEntity;

/**
 * Created by dyh on 2018/4/10.
 */
public interface UserService extends BaseService<UsersEntity> {
    UsersEntity verify(String username, String password);
}
