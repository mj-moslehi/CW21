package base.service;

import base.entity.BaseEntity;
import base.repository.BaseRepository;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
public class BaseServiceImpl <T extends BaseEntity<ID> ,
        ID extends Serializable,
        R extends BaseRepository<T,ID>>
        implements BaseService<T,ID>{

    protected final R repository;

    @Override
    public T saveOrUpdate(T entity) {
        return repository.saveOrUpdate(entity);
    }

    @Override
    public T findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(
                        () ->new RuntimeException("entity not found :( ")
                );
    }

    @Override
    public void deleteByUsername(String username) {
        T foundedEntity = findByUsername(username);
        repository.delete(foundedEntity);
    }
}
