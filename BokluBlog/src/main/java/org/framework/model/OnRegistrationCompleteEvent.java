package org.framework.model;

import org.springframework.context.ApplicationEvent;

public class OnRegistrationCompleteEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private final String appUrl;
	private final UserRegistration userRegistration;

	public OnRegistrationCompleteEvent(final String appUrl,final UserRegistration userRegistration) {
		super(userRegistration);
		this.userRegistration = userRegistration;
		this.appUrl = appUrl;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public  UserRegistration getUserRegistration() {
		return userRegistration;
	}
	
	

}
