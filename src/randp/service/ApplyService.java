package randp.service;

import randp.entity.ApplyEntity;

import java.util.List;

/**
 * Created by dyh on 2018/5/15.
 */
public interface ApplyService extends BaseService<ApplyEntity> {
    List<ApplyEntity> applypage(int page, int size);
    long count();
}
