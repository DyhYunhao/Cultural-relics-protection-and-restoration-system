package randp.dao;

import randp.entity.CulrelicEntity;

import java.util.List;

/**
 * Created by dyh on 2018/5/12.
 */
public interface CulturalDAO extends BaseDAO<CulrelicEntity> {
    List<CulrelicEntity> page(int page, int size);
    long count();
}
