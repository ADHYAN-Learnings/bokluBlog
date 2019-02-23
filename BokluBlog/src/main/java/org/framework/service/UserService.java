/**
 * 
 */
package org.framework.service;

import javax.transaction.Transactional;

import org.framework.model.PasswordResetToken;
import org.framework.model.UserRegistration;
import org.framework.model.VerficationToken;
import org.framework.persistence.PasswordResetTokenRepository;
import org.framework.persistence.UserRepository;
import org.framework.persistence.VerificationTokenRepository;
import org.framework.validation.EmailExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Aditya
 *
 */
@Service
@Transactional
public class UserService implements InterfUserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private VerificationTokenRepository verificationTokenRepository;
	
	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;

	@Override
	public UserRegistration registerNewUser(final UserRegistration userRegistration) throws EmailExistException {
		logger.debug("::::UserService::::::UserRegistration:::");
		
		if(emailExist(userRegistration.getEmail())) {
			throw new EmailExistException("There is an account with that email address: "+userRegistration.getEmail());
		}
	   userRegistration.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
		return userRepository.save(userRegistration);
	}
	
	private boolean emailExist(String email) {
		final UserRegistration userRegistration = userRepository.findByEmail(email);
		return userRegistration !=null;
	}

	@Override
	public void createVerificationTokenForUser(UserRegistration userRegistration, String token) {
		final VerficationToken myToken = new VerficationToken(token,userRegistration);
		verificationTokenRepository.save(myToken);
	}

	@Override
	public VerficationToken getVerificationToken(String token) {
		return verificationTokenRepository.findByToken(token);
	}

	@Override
	public void saveRegisteredUser(UserRegistration userRegistration) {
		userRepository.save(userRegistration);
	}

	@Override
	public UserRegistration findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public PasswordResetToken createPasswordResetTokenForUser(final UserRegistration userRegistration,final String token) {
		logger.debug(":::UserService::createPasswordResetTokenForUser::");
		final PasswordResetToken passwordResetToken = new PasswordResetToken(token,userRegistration);
		return passwordResetTokenRepository.save(passwordResetToken);
	}

	@Override
	public PasswordResetToken getPasswordResetToken(String token) {
		return passwordResetTokenRepository.findByToken(token);
	}

	@Override
	public void ChangeUserPassword(UserRegistration userRegistration, String password) {
		userRegistration.setPassword(passwordEncoder.encode(password));
		userRepository.save(userRegistration);
	}

	
}
