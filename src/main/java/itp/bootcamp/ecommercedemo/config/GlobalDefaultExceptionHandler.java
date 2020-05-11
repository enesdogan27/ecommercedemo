package itp.bootcamp.ecommercedemo.config;

import itp.bootcamp.ecommercedemo.validation.EmailAlreadyUseException;
import org.slf4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler(value = EmailAlreadyUseException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public void handleEmailAlreadyUseException(EmailAlreadyUseException e) {
        logger.error("Controller occurs an exception"+e);
    }


}
