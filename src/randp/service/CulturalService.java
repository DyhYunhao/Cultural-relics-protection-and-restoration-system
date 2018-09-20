package randp.service;

import randp.entity.CulrelicEntity;

import java.util.List;

/**
 * Created by dyh on 2018/5/12.
 */
public interface CulturalService extends BaseService<CulrelicEntity> {
    List<CulrelicEntity> page(int page, int size);
    long count();
}
