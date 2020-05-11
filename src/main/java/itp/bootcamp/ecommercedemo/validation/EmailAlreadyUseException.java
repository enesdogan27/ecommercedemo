package itp.bootcamp.ecommercedemo.validation;

public class EmailAlreadyUseException extends RuntimeException {

    public EmailAlreadyUseException(final String msg) {
        super(msg);
    }
}
