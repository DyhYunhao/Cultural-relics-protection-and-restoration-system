package randp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import randp.dao.BaseDAO;
import randp.service.BaseService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dyh on 2018/4/10.
 */
@Service
public abstract class BaseServiceImpl<Entity> implements BaseService<Entity> {
    BaseDAO<Entity> baseDAO;

    @Autowired
    public void setBaseDAO(BaseDAO<Entity> baseDAO){
        System.out.println("Service : " + this.getClass().getSimpleName() + "  DAO:" + baseDAO.getClass().getName());
        this.baseDAO = baseDAO;
    }

    @Override
    public Serializable save(Entity entity) {
        return baseDAO.save(entity);
    }

    @Override
    public void delete(Entity entity) {
        baseDAO.delete(entity);
    }

    @Override
    public void update(Entity entity) {
        baseDAO.update(entity);
    }

    @Override
    public Entity getById(Serializable id) {
        return baseDAO.getById(id);
    }

    @Override
    public List<Entity> listAll() {
        return baseDAO.listAll();
    }

    @Override
    public List<Entity> listByIds(Iterable<Serializable> ids) {
        return baseDAO.listByIds(ids);
    }

    @Override
    public List<Entity> findListByMap(final Map<String, Object> map) {
        return baseDAO.findListByMap(map);
    }

}
