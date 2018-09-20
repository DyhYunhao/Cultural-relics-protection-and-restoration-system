package randp.service.impl;

import org.springframework.stereotype.Service;
import randp.dao.RepairlogDAO;
import randp.entity.RepairlogEntity;
import randp.service.RepairlogService;

import java.util.List;

/**
 * Created by dyh on 2018/5/18.
 */
@Service
public class RepairlogServiceImpl extends BaseServiceImpl<RepairlogEntity> implements RepairlogService{
    @Override
    public List<RepairlogEntity> getByFid(long fid){
        return ((RepairlogDAO)super.baseDAO).getByFid(fid);
    }
}
