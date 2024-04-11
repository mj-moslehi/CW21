package utility;

import connection.SessionFactorySingleton;
import org.hibernate.SessionFactory;
import repository.customer.CustomerRepositoryImpl;
import service.CustomerServiceImpl;

public class ApplicationContext {
    private static final SessionFactory SESSION_FACTORY;
    private static final CustomerRepositoryImpl CUSTOMER_REPOSITORY;
    private static final CustomerServiceImpl CUSTOMER_SERVICE;

    static {
        SESSION_FACTORY = SessionFactorySingleton.getInstance();
        CUSTOMER_REPOSITORY = new CustomerRepositoryImpl(SESSION_FACTORY);
        CUSTOMER_SERVICE = new CustomerServiceImpl(CUSTOMER_REPOSITORY, SESSION_FACTORY);
    }

    public static CustomerServiceImpl getCustomerService() {
        return CUSTOMER_SERVICE;
    }
}
