package utility;

import lombok.NoArgsConstructor;
import model.Customer;
import service.CustomerService;

import java.util.Scanner;

@NoArgsConstructor
public class Menu {
    private final CustomerService customerService = ApplicationContext.getCustomerService();
    private final Scanner scanner = new Scanner(System.in);

    public void menu(){
        signUp();
    }

    public void signUp(){
        System.out.println("--- Signing in ---");
        System.out.println("id: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("first name: ");
        String firstName = scanner.nextLine();
//        System.out.println("last name: ");
//        String lastName = scanner.nextLine();
//        System.out.println("username: ");
//        String username = scanner.nextLine();
//        System.out.println("password: ");
//        String password = scanner.nextLine();
//        System.out.println("national code: ");
//        String nationalCode = scanner.nextLine();
//        System.out.println("phone number: ");
//        String phoneNumber = scanner.nextLine();
//        System.out.println("address: ");
//        String address = scanner.nextLine();

//        Customer customer = new Customer(id, firstName, lastName, username, password, nationalCode, phoneNumber, address);
        Customer customer = new Customer(id, firstName);
        Customer saved = customerService.saveOrUpdate(customer);
        if (saved != null)
            System.out.println("signed up successfully!");
        else
            System.out.println("Something went wrong, Please try again.");
    }
}
