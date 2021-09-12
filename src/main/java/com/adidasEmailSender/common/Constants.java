package com.adidasEmailSender.common;

import lombok.Getter;

/**
 * Class for Constans and messages used on the application
 */
public interface Constants {

    @Getter
     class Email{
        public static String FROM = "lawson.bashirian89@ethereal.email";
        public static String EMAIL_SENT_MESSAGE_TO = "Email sended successfully to ";
        public static String EMAIL_SENT_MESSAGE_ON = " on date ";
        public static String EMAIL_SEND_SUBJECT = "Email Confirmation";
        public static String EMAIL_SEND_MESSAGE = "Thank you for register!";
    }

    @Getter
    class Exception{
        public static String WRONG_MAIL_RECEIVED = "A Invalid email was received";
        public static String INVALID_PARAMETER_EXCEPTION_MESSAGE = "Invalid email";
        public static String MESSAGING_EXCEPTION_MESSAGE = "Error sening message to destinatary";
        public static String EXCEPTION_MESSAGE = "An unexpected error occour";
    }
}
