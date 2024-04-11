package base.service;

import base.entity.BaseEntity;
import base.repository.BaseRepository;

import java.io.Serializable;

public interface BaseService <T extends BaseEntity<ID> , ID extends Serializable> {

    T saveOrUpdate(T entity);

    T findByUsername(String username);

    void deleteByUsername(String username);

}
