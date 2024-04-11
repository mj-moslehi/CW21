import connection.SessionFactorySingleton;
import model.Customer;
import model.Fruit;
import model.Ordering;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

        Session session = sessionFactory.openSession();

        Fruit fruit = new Fruit("apple");

        Fruit fruit1 = new Fruit("gojesabz");

        Collection<Ordering> orderings = new ArrayList<>();
        Collection<Fruit> fruits = List.of(fruit1 , fruit);

        Ordering ordering = new Ordering("mamad",fruits);
        orderings.add(ordering);

        Customer customer = new Customer("mamad" , "naseri" ,orderings);


        Transaction transaction = session.beginTransaction();
        session.persist(customer);

        transaction.commit();

    }
}
