package org.framework.listener;

import java.util.UUID;

import org.framework.model.OnRegistrationCompleteEvent;
import org.framework.model.UserRegistration;
import org.framework.service.InterfUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrationListener.class);

	@Autowired
	private InterfUserService service;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;
	
	@Override
	public void onApplicationEvent(OnRegistrationCompleteEvent event) {
	  this.confirmRegistration(event);
	}
	
	private void confirmRegistration(final OnRegistrationCompleteEvent event) {
		final UserRegistration userRegistration = event.getUserRegistration();
		final String token = UUID.randomUUID().toString();
		service.createVerificationTokenForUser(userRegistration, token);
		
		final SimpleMailMessage email = constructEmailMessage(event, userRegistration, token);
		javaMailSender.send(email);
	}

	private SimpleMailMessage constructEmailMessage(final OnRegistrationCompleteEvent event,
		final UserRegistration userRegistration,final String token) {
		final String recipientAddress = userRegistration.getEmail();
		final String subject = "Registration Confirmation";
		final String confirmationUrl = event.getAppUrl() +"/boklu/registrationConfirmation?token="+token;
		
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText("Please open the following URL to verify your account: \r\n"+confirmationUrl);
		email.setFrom(env.getProperty(env.getProperty("support.email")));
		return email;
	}

}
