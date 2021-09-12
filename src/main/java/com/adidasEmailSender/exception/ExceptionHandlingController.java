package com.adidasEmailSender.exception;

import com.adidasEmailSender.common.Constants;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.mail.MessagingException;
import java.security.InvalidParameterException;

/**
 * Class for Exception control
 */
@ControllerAdvice
public class ExceptionHandlingController {

    final static Logger logger = Logger.getLogger(ExceptionHandlingController.class);

    /**
     * Control of unexpected Exception
     * @param ex
     * @return an ResponseEntity with a message for an unexpecte exception
     */
    @ExceptionHandler(value=Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleError (Exception ex) {
        logger.error("Exception received ");
        logger.error("Exception cause "+ex.getCause());
        logger.error("Exception message "+ex.getMessage());
        return new ResponseEntity<>(Constants.Exception.EXCEPTION_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Control of Exception on sending an email
     * @param ex
     * @return an ResponseEntity with a message for email sending exception
     */
    @ExceptionHandler(value= MessagingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleError (MessagingException ex) {
        logger.error("MessagingException received ");
        logger.error("MessagingException cause "+ex.getCause());
        logger.error("MessagingException message "+ex.getMessage());
        return new ResponseEntity<>(Constants.Exception.MESSAGING_EXCEPTION_MESSAGE, HttpStatus.BAD_REQUEST);
    }

    /**
     * Exception controlling for invalid parameters exceptions
     * @param ex
     * @return a ResponseEntity with a message for invalid parameters exception
     */
    @ExceptionHandler(value= InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleError (InvalidParameterException ex) {
        logger.error("InvalidParameterException received ");
        logger.error("InvalidParameterException cause "+ex.getCause());
        logger.error("InvalidParameterException message "+ex.getMessage());
       return new ResponseEntity<>(Constants.Exception.INVALID_PARAMETER_EXCEPTION_MESSAGE, HttpStatus.BAD_REQUEST);
    }

}
