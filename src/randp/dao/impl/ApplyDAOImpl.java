package randp.dao.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import randp.dao.ApplyDAO;
import randp.entity.ApplyEntity;

import java.util.List;

/**
 * Created by dyh on 2018/5/15.
 */
@Repository
public class ApplyDAOImpl extends BaseDAOImpl<ApplyEntity> implements ApplyDAO {
    @Override
    @SuppressWarnings("unchecked")
    public List<ApplyEntity> applypage(int page, int size) { //分页
        Query<ApplyEntity> query = getSessionFactory().getCurrentSession().createQuery("from ApplyEntity");
        query.setFirstResult(page*size);
        query.setMaxResults((page+1)*size);
        return query.list();
    }

    @Override
    public long count() {
        return (Long) getHibernateTemplate().find("select count(*) from ApplyEntity").get(0);
    }
}
