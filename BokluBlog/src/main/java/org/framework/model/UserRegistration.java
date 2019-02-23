/**
 * 
 */
package org.framework.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Table;
import javax.persistence.Column;
import org.framework.validation.PasswordMatches;


/**
 * @author Aditya
 *
 */
@Entity
@Table(name="USER_REGISTRATION")
@PasswordMatches 
public class UserRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Username is Required.")
	@Column(name="USERNAME")
	private String username;
	
	@Email
	@NotEmpty(message ="Email is Required.")
	@Column(name="Email_Id")
	private String email;
	
	@NotEmpty(message = "Password is Required.")
	@Column(name="PASSWORD")
	private String password;
	
	@Transient
	@NotEmpty(message="Password Confirmation is Required.")
	private String passwordConfirmation;
	
	@Column(name="CREATION_DATE")
	private Calendar created = Calendar.getInstance();
	
	@Column(name="ROLE")
	private String role = "ROLE_USER";
	
	@Column(name="ENABLED")
	private boolean enabled;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	public Calendar getCreated() {
		return created;
	}
	public void setCreated(Calendar created) {
		this.created = created;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "UserRegistration [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", passwordConfirmation=" + passwordConfirmation + ", created=" + created + ", role=" + role
				+ ", enabled=" + enabled + "]";
	}
}
