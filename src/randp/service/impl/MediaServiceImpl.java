package randp.service.impl;

import org.springframework.stereotype.Service;
import randp.dao.MediaDAO;
import randp.entity.MediaEntity;
import randp.service.MediaService;

import java.util.List;

/**
 * Created by dyh on 2018/5/19.
 */
@Service
public class MediaServiceImpl extends BaseServiceImpl<MediaEntity> implements MediaService {
    @Override
    public List<MediaEntity> pagem(int page, int size) {
        return ((MediaDAO)super.baseDAO).pagem(page,size);
    }

    @Override
    public long count() {
        return ((MediaDAO)super.baseDAO).count();
    }
}
