package itp.bootcamp.ecommercedemo.validation;

public class CustomerEmailNotFoundException extends RuntimeException {
    public CustomerEmailNotFoundException(final String msg) {
        super(msg);
    }
}
