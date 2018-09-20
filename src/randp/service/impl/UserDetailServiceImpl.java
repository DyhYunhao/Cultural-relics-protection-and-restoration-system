package randp.service.impl;

import randp.entity.UserdetailEntity;
import randp.service.UserDetailService;

import java.io.Serializable;

/**
 * Created by dyh on 2018/5/9.
 */
public class UserDetailServiceImpl extends BaseServiceImpl<UserdetailEntity> implements UserDetailService {
    @Override
    public Serializable save(UserdetailEntity userdetailEntity) {

        return super.save(userdetailEntity);
    }

    @Override
    public UserdetailEntity verify(long uid) {
        return null;
    }
}
