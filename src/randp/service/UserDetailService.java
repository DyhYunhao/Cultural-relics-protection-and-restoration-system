package randp.service;

import randp.entity.UserdetailEntity;

/**
 * Created by dyh on 2018/5/9.
 */
public interface UserDetailService extends BaseService<UserdetailEntity> {
    UserdetailEntity verify(long uid);
}
