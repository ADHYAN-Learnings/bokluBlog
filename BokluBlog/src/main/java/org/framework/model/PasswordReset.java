package org.framework.model;

import javax.validation.constraints.NotEmpty;;

public class PasswordReset {
	
	@NotEmpty(message="Please enter Email Id")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
