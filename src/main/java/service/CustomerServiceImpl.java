package service;

import base.service.BaseServiceImpl;
import model.Customer;
import org.hibernate.SessionFactory;
import repository.customer.CustomerRepository;

public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long, CustomerRepository>
    implements CustomerService{

    private final CustomerRepository customerRepository;

//    public CustomerServiceImpl(CustomerRepository customerRepository) {
//        super();
//        this.customerRepository = customerRepository;
//    }

    public CustomerServiceImpl(CustomerRepository customerRepository, SessionFactory sessionFactory) {
        super(customerRepository, sessionFactory);
        this.customerRepository = customerRepository;
    }





    @Override
    public Customer saveOrUpdate(Customer entity) {
        return customerRepository.saveOrUpdate(entity);
    }
}
