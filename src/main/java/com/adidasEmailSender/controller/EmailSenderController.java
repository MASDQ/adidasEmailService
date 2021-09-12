package com.adidasEmailSender.controller;

import com.adidasEmailSender.services.EmailService;
import com.adidasEmailSender.common.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.InvalidParameterException;
import java.util.Calendar;

/**
 * Class Controller for email service
 */
@RestController
@RequestMapping(path="/email")
public class EmailSenderController {

    final static Logger logger = Logger.getLogger(EmailSenderController.class);

    @Autowired
    EmailService emailService;

    /**
     * Methot to mock send an email
     * @param email the email received to send the message
     * @return a message with the result of the email send
     * @throws Exception
     */
    @GetMapping(path = "/send/{email}")
    public String sendEmail(@PathVariable String email) throws Exception {
        logger.debug("sendEmail begin");
        try {
            if(email == null || email.isEmpty() || !email.contains("@")|| !email.contains(".com")){
                logger.debug("sendEmail wrong email received");
                throw new InvalidParameterException(Constants.Exception.WRONG_MAIL_RECEIVED);
            }
            logger.debug("sendEmail vali email receive");
            emailService.send(email);

            StringBuilder strResponse = new StringBuilder();
            strResponse.append(Constants.Email.EMAIL_SENT_MESSAGE_TO);
            strResponse.append(email);
            strResponse.append(Constants.Email.EMAIL_SENT_MESSAGE_ON);
            strResponse.append(Calendar.getInstance().getTime());

            logger.debug("sendEmail finish");
            return strResponse.toString();
        }
        catch (InvalidParameterException e) {
            logger.error("sendEmail invalid parameter exception");
            throw new InvalidParameterException(e.getMessage());
        }
        catch (Exception e) {
            logger.error("sendEmail unexpected exception");
            throw new Exception(e.getMessage());
        }

    }
}