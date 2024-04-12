package utility;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;

public class CustomEmailValidator extends EmailValidator {
//    @Override
    private boolean isValid(String value, Object context) {
// Implement your custom email validation logic here
// Return true if the email is valid, false otherwise
// Example: Check if the domain exists, etc.
        return false;
    }
}