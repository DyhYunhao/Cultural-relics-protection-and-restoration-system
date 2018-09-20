package randp.dao.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import randp.dao.MediaDAO;
import randp.entity.MediaEntity;

import java.util.List;

/**
 * Created by dyh on 2018/5/19.
 */
@Repository
public class MediaDAOImpl extends BaseDAOImpl<MediaEntity> implements MediaDAO {
    @Override
    @SuppressWarnings("unchecked")
    public List<MediaEntity> pagem(int page, int size) { //分页
        Query<MediaEntity> query = getSessionFactory().getCurrentSession().createQuery("from MediaEntity");
        query.setFirstResult(page*size);
        query.setMaxResults((page+1)*size);
        return query.list();
    }

    @Override
    public long count() {
        return (Long) getHibernateTemplate().find("select count(*) from MediaEntity").get(0);
    }
}
