package randp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import randp.dao.UserDAO;
import randp.entity.UsersEntity;
import randp.service.UserService;

import java.io.Serializable;

/**
 * Created by dyh on 2018/4/10.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UsersEntity> implements UserService{
    @Override
    public Serializable save(UsersEntity antUserEntity) {

        String password = antUserEntity.getPassword(); //加密
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        antUserEntity.setPassword(password);

        return super.save(antUserEntity);
    }
    @Override
    public UsersEntity verify(String username, String password) {
        return ((UserDAO)super.baseDAO).verify(username,DigestUtils.md5DigestAsHex(password.getBytes()));
    }
}
