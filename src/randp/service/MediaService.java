package randp.service;

import randp.entity.MediaEntity;

import java.util.List;

/**
 * Created by dyh on 2018/5/19.
 */
public interface MediaService extends BaseService<MediaEntity> {
    List<MediaEntity> pagem(int page, int size);
    long count();
}
