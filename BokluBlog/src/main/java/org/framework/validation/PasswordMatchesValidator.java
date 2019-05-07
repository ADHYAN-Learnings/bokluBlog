package org.framework.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.framework.model.PasswordChange;
import org.framework.model.UserRegistration;
import org.springframework.security.core.context.SecurityContextHolder;


public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches,Object> {
		
	@Override
	public boolean isValid(final Object obj,final ConstraintValidatorContext context) {
		Object prinicipal = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		if(prinicipal.toString().equals("[ROLE_ADMIN]")){
			final PasswordChange passwordChange = (PasswordChange)obj;
			return passwordChange.getNewPassword().equals(passwordChange.getConfirmNewPassword());
		} else {
			final UserRegistration userRegistration = (UserRegistration)obj;
			return userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation());
	    } 
		
	}

}
