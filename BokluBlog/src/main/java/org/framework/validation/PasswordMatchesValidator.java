package org.framework.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.framework.model.UserRegistration;


public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches,Object> {
		
	@Override
	public boolean isValid(final Object obj,final ConstraintValidatorContext context) {
		final UserRegistration userRegistration = (UserRegistration)obj;
		return userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation());
	}

}
