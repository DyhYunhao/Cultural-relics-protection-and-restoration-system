package randp.dao;

import randp.entity.MediaEntity;

import java.util.List;

/**
 * Created by dyh on 2018/5/19.
 */
public interface MediaDAO extends BaseDAO<MediaEntity> {
    List<MediaEntity> pagem(int page, int size);
    long count();
}
