package org.framework.service;

import org.framework.model.PasswordResetToken;
import org.framework.model.UserRegistration;
import org.framework.model.VerficationToken;
import org.framework.validation.EmailExistException;


public interface InterfUserService {
	
	UserRegistration registerNewUser(UserRegistration userRegistration) throws EmailExistException;
	
	void createVerificationTokenForUser(UserRegistration userRegistration, String token);
	
	VerficationToken getVerificationToken(String token);
	
	void saveRegisteredUser(UserRegistration userRegistration);
	
	UserRegistration findUserByEmail(String email);
	
	PasswordResetToken createPasswordResetTokenForUser(UserRegistration userRegistration,String token);
	
	PasswordResetToken getPasswordResetToken(String token);
	
	void ChangeUserPassword(UserRegistration userRegistration,String Password);
}
