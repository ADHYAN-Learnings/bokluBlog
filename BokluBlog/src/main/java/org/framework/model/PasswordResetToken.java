package org.framework.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name="Password_Reset_Token")
public class PasswordResetToken {
	
	private static final int EXPIRATION = 60*24;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String token;
	
	@OneToOne(targetEntity = UserRegistration.class,fetch=FetchType.EAGER)
	@JoinColumn(nullable=false,name="Password_Reset_User_Registration_FK")
	private UserRegistration userRegistration;
	
	private Date expiryDate;
	
	public PasswordResetToken() {
		super();
	}

	public PasswordResetToken(final String token,final UserRegistration userRegistration) {
		super();
		this.token = token;
		this.userRegistration = userRegistration;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserRegistration getUserRegistration() {
		return userRegistration;
	}

	public void setUserRegistration(UserRegistration userRegistration) {
		this.userRegistration = userRegistration;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	private Date calculateExpiryDate(final int expiryTimeInMinutes) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(new Date().getTime());
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}
	
	 public void updateToken(final String token) {
	        this.token = token;
	        this.expiryDate = calculateExpiryDate(EXPIRATION);
	   }
	 
	 @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
	        result = prime * result + ((token == null) ? 0 : token.hashCode());
	        result = prime * result + ((userRegistration == null) ? 0 : userRegistration.hashCode());
	        return result;
	    }

	    @Override
	    public boolean equals(final Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final PasswordResetToken other = (PasswordResetToken) obj;
	        if (expiryDate == null) {
	            if (other.expiryDate != null) {
	                return false;
	            }
	        } else if (!expiryDate.equals(other.expiryDate)) {
	            return false;
	        }
	        if (token == null) {
	            if (other.token != null) {
	                return false;
	            }
	        } else if (!token.equals(other.token)) {
	            return false;
	        }
	        if (userRegistration == null) {
	            if (other.userRegistration != null) {
	                return false;
	            }
	        } else if (!userRegistration.equals(other.userRegistration)) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        final StringBuilder builder = new StringBuilder();
	        builder.append("Token [String=").append(token).append("]").append("[Expires").append(expiryDate).append("]");
	        return builder.toString();
	    }

	
	

}
