package org.framework.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

@Entity
public class PasswordChange  {
	
	@Column(name="Old_Password")
	@NotEmpty(message="Password field should not be empty")
	private String  oldPassword;
	
	@Column(name="New_Password")
	@NotEmpty(message="Password field should not be empty")
	private String  newPassword;
	
	@Transient
	private String  confirmNewPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

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
