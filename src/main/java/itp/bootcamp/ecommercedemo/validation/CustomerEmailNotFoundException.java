package itp.bootcamp.ecommercedemo.validation;

public class CustomerEmailNotFoundException extends RuntimeException {
    public CustomerEmailNotFoundException() {
        super("Customer not found with given email.");
    }
}
