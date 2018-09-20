package randp.service.impl;

import org.springframework.stereotype.Service;
import randp.dao.ApplyDAO;
import randp.entity.ApplyEntity;
import randp.service.ApplyService;

import java.util.List;

/**
 * Created by dyh on 2018/5/15.
 */
@Service
public class ApplyServiceImpl extends BaseServiceImpl<ApplyEntity> implements ApplyService{
    @Override
    public List<ApplyEntity> applypage(int page, int size) {
        return ((ApplyDAO)super.baseDAO).applypage(page,size);
    }

    @Override
    public long count() {
        return ((ApplyDAO)super.baseDAO).count();
    }
}
