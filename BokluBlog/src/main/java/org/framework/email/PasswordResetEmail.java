/**
 * 
 */
package org.framework.email;

import org.framework.model.UserRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * @author Aditya
 *
 */
@Component
public class PasswordResetEmail implements EnvironmentAware {
	
	private static final Logger logger = LoggerFactory.getLogger(PasswordResetEmail.class);
	
	@Autowired
    private static Environment environment;
	
	public static SimpleMailMessage constructResetToken(final String contextPath,final String token,final UserRegistration userRegistration) {
		logger.debug(":::PasswordResetEmail::::::constructResetToken::::");
		final String url =  contextPath + "/boklu/resetChangePassword?id=" + userRegistration.getId() + "&token=" + token;
		final SimpleMailMessage email = new SimpleMailMessage();
	    email.setTo(userRegistration.getEmail());
	    email.setSubject("Reset Password");
	    email.setText("Please open the following URL to reset your password: \r\n" + url);
	    email.setFrom(environment.getProperty(environment.getProperty("support.email")));
	    return email;
	}

	@Override
	public void setEnvironment(Environment environment) {
		PasswordResetEmail.environment = environment;
	}

}
