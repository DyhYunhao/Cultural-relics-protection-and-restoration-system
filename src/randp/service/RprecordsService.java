package randp.service;

import randp.entity.RprecordsEntity;

import java.util.List;

/**
 * Created by dyh on 2018/5/15.
 */
public interface RprecordsService extends BaseService<RprecordsEntity> {
    List<RprecordsEntity> page1(int page, int size);
    long count();
}
