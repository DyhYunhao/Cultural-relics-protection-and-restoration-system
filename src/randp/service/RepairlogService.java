package randp.service;

import randp.entity.RepairlogEntity;

import java.util.List;

/**
 * Created by dyh on 2018/5/18.
 */
public interface RepairlogService extends BaseService<RepairlogEntity> {
    List<RepairlogEntity> getByFid(long fid);
}
