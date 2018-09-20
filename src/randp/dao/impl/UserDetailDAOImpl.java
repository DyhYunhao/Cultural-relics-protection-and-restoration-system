package randp.dao.impl;

import org.springframework.stereotype.Repository;
import randp.dao.UserDetailDAO;
import randp.entity.UserdetailEntity;

import java.util.List;

/**
 * Created by dyh on 2018/4/10.
 */
@Repository
public class UserDetailDAOImpl extends BaseDAOImpl<UserdetailEntity> implements UserDetailDAO {
    @Override
    public UserdetailEntity verify(long uid) {
        List list = getHibernateTemplate().find("from UserdetailEntity user where user.uid = ?",uid);
        return list == null || list.isEmpty() ? null : (UserdetailEntity) list.get(0);
    }
}
