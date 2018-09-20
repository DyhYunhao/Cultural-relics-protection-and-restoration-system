package randp.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dyh on 2018/4/10.
 */
public interface BaseService<Entity> {
    Serializable save(Entity entity);
    void delete(Entity entity);
    void update(Entity entity);
    Entity getById(Serializable id);
    List<Entity> listAll();
    List<Entity> listByIds(Iterable<Serializable> ids);
    List<Entity> findListByMap(final Map<String, Object> map);
}
