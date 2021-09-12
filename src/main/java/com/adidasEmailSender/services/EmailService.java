package com.adidasEmailSender.services;

import com.adidasEmailSender.common.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Class for send an email to certain destinatary
 */
@Service
public class EmailService {

    final static Logger logger = Logger.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    /**
     * Method to send an email throught JavaMailSender
     * @param to direction to send the email
     * @throws Exception
     */
    public void send(String to) throws Exception {
        logger.debug("EmailService begin");
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");

            helper.setFrom(Constants.Email.FROM);
            helper.setTo(to);
            helper.setSubject(Constants.Email.EMAIL_SEND_SUBJECT);
            mimeMessage.setContent(Constants.Email.EMAIL_SEND_MESSAGE, "text/html");
            logger.debug("EmailService configuration finishe");

           // mailSender.send(mimeMessage); //TODO problem to send email
            logger.debug("EmailService email sended");
        } catch (MessagingException e) {
            logger.error("EmailService messaging exception");
            throw new MessagingException(e.getMessage());
        }
        catch (Exception e){
            logger.error("EmailService unexpecte exception");
            throw new Exception(e.getMessage());
        }
        logger.debug("EmailService finish");
    }
}