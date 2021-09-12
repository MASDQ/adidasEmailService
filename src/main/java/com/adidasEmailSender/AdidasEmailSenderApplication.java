package com.adidasEmailSender;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main clas for the application
 */
@SpringBootApplication
public class AdidasEmailSenderApplication {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(AdidasEmailSenderApplication.class, args);
	}
	//TODO
	//seguridad
	//tests
}
