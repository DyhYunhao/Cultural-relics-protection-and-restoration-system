package randp.dao.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import randp.dao.RprecordsDAO;
import randp.entity.RprecordsEntity;

import java.util.List;

/**
 * Created by dyh on 2018/5/15.
 */
@Repository
public class RprecordsDAOImpl extends BaseDAOImpl<RprecordsEntity> implements RprecordsDAO {
    @Override
    @SuppressWarnings("unchecked")
    public List<RprecordsEntity> page1(int page, int size) { //分页
        Query<RprecordsEntity> query = getSessionFactory().getCurrentSession().createQuery("from RprecordsEntity");
        query.setFirstResult(page*size);
        query.setMaxResults((page+1)*size);
        return query.list();
    }

    @Override
    public long count() {
        return (Long) getHibernateTemplate().find("select count(*) from RprecordsEntity").get(0);
    }
}
