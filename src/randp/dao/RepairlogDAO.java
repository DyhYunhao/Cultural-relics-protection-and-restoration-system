package randp.dao;

import randp.entity.RepairlogEntity;

import java.util.List;

/**
 * Created by dyh on 2018/5/18.
 */
public interface RepairlogDAO extends BaseDAO<RepairlogEntity> {
    List<RepairlogEntity> getByFid(long fid);
}
