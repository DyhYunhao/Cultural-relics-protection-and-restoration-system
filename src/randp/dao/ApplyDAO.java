package randp.dao;

import randp.entity.ApplyEntity;

import java.util.List;

/**
 * Created by dyh on 2018/5/15.
 */
public interface ApplyDAO extends BaseDAO<ApplyEntity> {
    List<ApplyEntity> applypage(int page, int size);
    long count();
}
