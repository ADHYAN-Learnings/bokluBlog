package org.framework.functionalInterfaceImplementation;

import org.frameword.functionalInterface.AccessUsername;
import org.framework.model.UserRegistration;
import org.framework.service.InterfUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class GetLoginUserName implements AccessUsername  {
	
	@Autowired
	private InterfUserService userService;

	@Override
	public String getUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		final UserRegistration userRegistration =  userService.findUserByEmail(currentPrincipalName);
		
		return userRegistration.getUsername();
	}

}
