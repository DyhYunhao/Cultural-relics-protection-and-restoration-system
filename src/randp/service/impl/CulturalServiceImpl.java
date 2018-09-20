package randp.service.impl;

import org.springframework.stereotype.Service;
import randp.dao.CulturalDAO;
import randp.entity.CulrelicEntity;
import randp.service.CulturalService;

import java.util.List;

/**
 * Created by dyh on 2018/5/12.
 */
@Service
public class CulturalServiceImpl extends BaseServiceImpl<CulrelicEntity> implements CulturalService {
    @Override
    public List<CulrelicEntity> page(int page, int size) {
        return ((CulturalDAO)super.baseDAO).page(page,size);
    }

    @Override
    public long count() {
        return ((CulturalDAO)super.baseDAO).count();
    }
}
