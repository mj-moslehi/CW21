package utility;

import lombok.NoArgsConstructor;
import model.Customer;
import service.CustomerService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Scanner;
import java.util.Set;

@NoArgsConstructor
public class Menu {
    private final CustomerService customerService = ApplicationContext.getCustomerService();
    private final Scanner scanner = new Scanner(System.in);
    // Create a validator factory and validator
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();

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
        System.out.println("last name: ");
        String lastName = scanner.nextLine();
        System.out.println("username: ");
        String username = scanner.nextLine();
        System.out.println("password: ");
        String password = scanner.nextLine();
        System.out.println("national code: ");
        String nationalCode = scanner.nextLine();
        System.out.println("phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("address: ");
        String address = scanner.nextLine();


//        Customer customer = new Customer(id, firstName);
//        Customer saved = customerService.saveOrUpdate(customer);
//        if (saved != null)
//            System.out.println("signed up successfully!");
//        else
//            System.out.println("Something went wrong, Please try again.");
        Customer customer = new Customer(id, firstName, lastName, username, password, nationalCode, phoneNumber, address);
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);

        if (violations.isEmpty()) {
            customerService.saveOrUpdate(customer);
            System.out.println("Valid user data provided.");
        } else {
            System.out.println("Invalid user data found:");
            for (ConstraintViolation<Customer> violation : violations) {
                System.out.println(violation.getMessage());
            }
        }

    }
}
