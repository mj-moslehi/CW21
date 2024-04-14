package repository.customer;

import base.repository.BaseRepositoryImpl;
import model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long>
        implements CustomerRepository {

    private final SessionFactory sessionFactory;

    public CustomerRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Customer saveOrUpdate(Customer entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Customer customer = session.merge(entity);
            transaction.commit();
            return customer;
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
            return null;
        }
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
