package org.framework.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginLogoutImpl {
	private static final Logger logger = LoggerFactory.getLogger(LoginLogoutImpl.class);
	
	@RequestMapping(value = "/admin")
	public String getAdminLogin() {
	logger.debug(":::LoginLogoutImpl:::getAdminLogin:::");	
		return "adminLogin";
	}
	
	@RequestMapping(value="/boklu")
	public String getStore() {
	logger.debug(":::LoginLogoutImpl:::getStore:::");	
		return "boklu";
	}
	
	@RequestMapping(value="/boklu/userLogin")
	public String getUserLogin() {
    logger.debug(":::LoginLogoutImpl::getUserLogin::");
		return "userLogin";
	}
}
