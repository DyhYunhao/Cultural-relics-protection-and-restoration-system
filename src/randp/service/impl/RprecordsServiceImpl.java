package randp.service.impl;

import org.springframework.stereotype.Service;
import randp.dao.RprecordsDAO;
import randp.entity.RprecordsEntity;
import randp.service.RprecordsService;

import java.util.List;

/**
 * Created by dyh on 2018/5/15.
 */
@Service
public class RprecordsServiceImpl extends BaseServiceImpl<RprecordsEntity> implements RprecordsService {
    @Override
    public List<RprecordsEntity> page1(int page, int size) {
        return ((RprecordsDAO)super.baseDAO).page1(page,size);
    }

    @Override
    public long count() {
        return ((RprecordsDAO)super.baseDAO).count();
    }
}
