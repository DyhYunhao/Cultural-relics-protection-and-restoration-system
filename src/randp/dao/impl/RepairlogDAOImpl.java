package randp.dao.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import randp.dao.RepairlogDAO;
import randp.entity.RepairlogEntity;

import java.util.List;

/**
 * Created by dyh on 2018/5/18.
 */
@Repository
public class RepairlogDAOImpl extends BaseDAOImpl<RepairlogEntity> implements RepairlogDAO{
    @Override
    public List<RepairlogEntity> getByFid(long fid){
        Query<RepairlogEntity> query = getSessionFactory().getCurrentSession().createQuery("from RepairlogEntity where rpid = " + fid);
        return query.list();
    }
}
