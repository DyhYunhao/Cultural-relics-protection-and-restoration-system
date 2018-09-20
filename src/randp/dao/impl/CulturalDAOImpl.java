package randp.dao.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import randp.dao.CulturalDAO;
import randp.entity.CulrelicEntity;

import java.util.List;

/**
 * Created by dyh on 2018/5/12.
 */
@Repository
public class CulturalDAOImpl extends BaseDAOImpl<CulrelicEntity> implements CulturalDAO {
    @Override
    @SuppressWarnings("unchecked")
    public List<CulrelicEntity> page(int page, int size) { //分页
        Query<CulrelicEntity> query = getSessionFactory().getCurrentSession().createQuery("from CulrelicEntity");
        query.setFirstResult(page*size);
        query.setMaxResults((page+1)*size);
        return query.list();
    }

    @Override
    public long count() {
        return (Long) getHibernateTemplate().find("select count(*) from CulrelicEntity").get(0);
    }

}
