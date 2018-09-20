package randp.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import randp.dao.BaseDAO;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by dyh on 2018/4/10.
 */
@Repository
public abstract class BaseDAOImpl<Entity> extends HibernateDaoSupport implements BaseDAO<Entity> {

    private Class<Entity> entityClass;

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    public BaseDAOImpl(){
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType){
            Type[] params = ((ParameterizedType)type).getActualTypeArguments();
            if (params.length > 0)
                entityClass = (Class<Entity>) params[0];
        }
    }

    @Override
    public Serializable save(Entity entity) {
        return  getHibernateTemplate().save(entity);
    }

    @Override
    public void delete(Entity entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public void update(Entity entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public Entity getById(Serializable id) {
        return getHibernateTemplate().get(entityClass,id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Entity> listAll() {
        return (List<Entity>) getHibernateTemplate().find("from " + entityClass.getSimpleName());
    }

    @Override
    public List<Entity> listByIds(Iterable<Serializable> ids) {
        List<Entity> list = new LinkedList<Entity>();
        for (Serializable id : ids)
            list.add(getById(id));
        return list;
    }
    @Override
    public List<Entity> findListByMap(final Map<String, Object> map) {
        CriteriaBuilder criteriaBuilder = getSessionFactory().getCriteriaBuilder();

        CriteriaQuery<Entity> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<Entity> from = criteriaQuery.from(entityClass);
        List<Predicate> predicateList = new ArrayList<Predicate>();
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        for(Map.Entry<String, Object> entry : entrySet) {
            predicateList.add(criteriaBuilder.equal(from.get(entry.getKey()), entry.getValue()));
        }

        criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));


        TypedQuery<Entity> typedQuery = getSessionFactory().createEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}

