package org.framework.controller;

import java.util.List;

import org.framework.adminService.InterfBlogService;
import org.framework.adminService.InterfHeaderLink;
import org.framework.adminService.InterfHeaderSubSection;
import org.framework.model.Blog;
import org.framework.model.Comments;
import org.framework.model.HeaderLink;
import org.framework.model.HeaderSubSection;
import org.framework.service.InterfPostCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginLogoutImpl {
	private static final Logger logger = LoggerFactory.getLogger(LoginLogoutImpl.class);
	
	@Autowired
	private InterfHeaderLink interfHeaderLink;
	
	@Autowired
	private InterfBlogService interfBlogService;
	
	@Autowired
	private InterfPostCommentService interfPostCommentService;
	
	@Autowired
	private InterfHeaderSubSection interfHeaderSubSection;

	
	@RequestMapping(value = "/admin")
	public String getAdminLogin() {
	logger.debug(":::LoginLogoutImpl:::getAdminLogin:::");	
		return "adminLogin";
	}
	
	@RequestMapping(value="/boklu")
	public String getStore(Model model) {
	logger.debug(":::LoginLogoutImpl:::getStore:::");	
	List<HeaderLink> headerLinkWithSequence = interfHeaderLink.getHeaderLinkOrderBySequence("Active");
	List<HeaderSubSection> headerSubSectionData = interfHeaderSubSection.getHeaderSubSectionByStatus("Active");
	List<HeaderSubSection> headerSubSectionSubject = interfHeaderSubSection.getHeaderSubSectionBySequence(1);
    model.addAttribute("headerLinkWithSequence",headerLinkWithSequence); 
    model.addAttribute("headerSubSectionLinkData", headerSubSectionData);
    model.addAttribute("headerFirstSubject",headerSubSectionSubject);
		return "boklu";
	}
	
	@RequestMapping(value="/boklu/userLogin")
	public String getUserLogin() {
    logger.debug(":::LoginLogoutImpl::getUserLogin::");
		return "userLogin";
	}
	
	  @RequestMapping("/boklu/{headerSubject}/{subject}")
	   public ModelAndView getStoreDetails(@PathVariable("subject") String subject , Model model) {
		   logger.debug(":::::UserSideImplementation::::getStoreDetails::contentName::::"+subject);
		   Blog blogDetails = interfBlogService.findByheaderSubject(subject);

		   List<HeaderLink> headerLinkWithSequence = interfHeaderLink.getHeaderLinkOrderBySequence("Active");
		   List<HeaderSubSection> headerSubSectionData = interfHeaderSubSection.getHeaderSubSectionByStatus("Active");
		    model.addAttribute("headerLinkWithSequence",headerLinkWithSequence);
		    model.addAttribute("headerSubSectionLinkData", headerSubSectionData);
		    model.addAttribute("postComment",new Comments());
		    model.addAttribute("displayComments",interfPostCommentService.findByHeaderSubSectionOrderById(blogDetails.getHeaderSubject().getSubSectionId()));
		   return new ModelAndView("bokluTutorials","blog",blogDetails);
	   }
  
}
