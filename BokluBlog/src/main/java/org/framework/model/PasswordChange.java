package org.framework.model;

import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import org.framework.validation.PasswordMatches;

@PasswordMatches
public class PasswordChange  {
		
	@NotEmpty(message="Password field should not be empty")
	private String  newPassword;
	
	@Transient
	private String  confirmNewPassword;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}
	
	

}
