import connection.SessionFactorySingleton;
import model.Customer;
import model.DeliveryType;
import model.Fruit;
import model.Ordering;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utility.Menu;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Menu menu = new Menu();
        menu.signUp();


//        SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
//
//        Session session = sessionFactory.openSession();
//
//        Fruit fruit = new Fruit("apple");
//
//        Fruit fruit1 = new Fruit("gojesabz");
//
//        Collection<Ordering> orderings = new ArrayList<>();
//        Collection<Fruit> fruits = List.of(fruit1 , fruit);
//
//        Customer customer = new Customer("mamad" , "naseri" ,orderings);
//
//        Ordering ordering = new Ordering(customer ,fruits, DeliveryType.POST);
//        orderings.add(ordering);
//
//        Transaction transaction = session.beginTransaction();
//        session.persist(customer);
//
//        transaction.commit();

    }
}
