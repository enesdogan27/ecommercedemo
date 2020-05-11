package itp.bootcamp.ecommercedemo.config;

import itp.bootcamp.ecommercedemo.validation.CustomerEmailNotFoundException;
import itp.bootcamp.ecommercedemo.validation.EmailAlreadyUseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler(value = {EmailAlreadyUseException.class, CustomerEmailNotFoundException.class})

    public ResponseEntity handleEmailAlreadyUseException(Exception e) {
        logger.error("Controller occurs an exception"+e);
        return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
    }


}
