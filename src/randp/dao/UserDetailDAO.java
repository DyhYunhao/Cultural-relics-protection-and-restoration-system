package randp.dao;

import randp.entity.UserdetailEntity;

/**
 * Created by dyh on 2018/4/10.
 */
public interface UserDetailDAO extends BaseDAO<UserdetailEntity> {
    UserdetailEntity verify(long uid);
}
