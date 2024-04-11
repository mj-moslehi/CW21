package base.repository;

import base.entity.BaseEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.Optional;

public abstract class BaseRepositoryImpel<T extends BaseEntity<ID>, ID extends Serializable>
        implements BaseRepository<T, ID> {

    protected Session session;

    @Override
    public T saveOrUpdate(T entity) {
        beginTransaction();
        entity = saveWithoutTransaction(entity);
        commitTransaction();
        return entity;
    }

    @Override
    public Optional<T> findByUsername(String username) {
        return Optional.ofNullable(session.get(getEntityClass(), username));
    }

    @Override
    public void delete(T entity) {
        beginTransaction();
        session.remove(entity);
        commitTransaction();
    }

    @Override
    public void beginTransaction() {
        if (!session.getTransaction().isActive())
            session.beginTransaction();
    }

    @Override
    public void commitTransaction() {
        if (session.getTransaction().isActive())
            session.getTransaction().commit();
    }

    @Override
    public void rollback() {
        if (session.getTransaction().isActive())
            session.getTransaction().rollback();
    }

    private T saveWithoutTransaction(T entity) {

        if (entity.getId() == null) {
            session.persist(entity);
        } else {
            entity = session.merge(entity);
        }
        return entity;
    }

    public abstract Class<T> getEntityClass();

}
