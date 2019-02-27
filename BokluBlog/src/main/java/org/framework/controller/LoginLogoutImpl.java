package org.framework.controller;

import java.util.List;

import org.framework.adminService.InterfHeaderLink;
import org.framework.model.Comments;
import org.framework.model.HeaderLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginLogoutImpl {
	private static final Logger logger = LoggerFactory.getLogger(LoginLogoutImpl.class);
	
	@Autowired
	private InterfHeaderLink interfHeaderLink;
	
	@RequestMapping(value = "/admin")
	public String getAdminLogin() {
	logger.debug(":::LoginLogoutImpl:::getAdminLogin:::");	
		return "adminLogin";
	}
	
	@RequestMapping(value="/boklu")
	public String getStore(Model model) {
	logger.debug(":::LoginLogoutImpl:::getStore:::");
	
	List<HeaderLink> headerLinkWithSequence = interfHeaderLink.getHeaderLinkOrderBySequence("Active");
    model.addAttribute("headerLinkWithSequence",headerLinkWithSequence); 
    model.addAttribute("postComment",new Comments());
		return "boklu";
	}
	
	@RequestMapping(value="/boklu/userLogin")
	public String getUserLogin() {
    logger.debug(":::LoginLogoutImpl::getUserLogin::");
		return "userLogin";
	}
}
