package base.repository;

import base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Optional;

public interface BaseRepository<T extends BaseEntity<ID>, ID extends Serializable> {

    T saveOrUpdate(T entity);

    Optional<T> findByUsername(String username);

    void delete (T entity);

    void beginTransaction();

    void commitTransaction();

    void rollback();

}
