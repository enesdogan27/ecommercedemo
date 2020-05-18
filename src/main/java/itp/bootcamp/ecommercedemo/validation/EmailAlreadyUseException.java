package itp.bootcamp.ecommercedemo.validation;

public class EmailAlreadyUseException extends RuntimeException {

    public EmailAlreadyUseException() {
        super("This email address is in use. If you forgot your password please call" +
                " help center.");
    }
}
