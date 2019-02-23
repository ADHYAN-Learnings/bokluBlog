package org.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.framework.adminService.InterfHeaderLink;
import org.framework.model.HeaderLink;
import org.framework.model.OnRegistrationCompleteEvent;
import org.framework.model.UserRegistration;
import org.framework.select.FormSelect;
import org.framework.validation.EmailExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminSideImplementation {
	
private static final Logger logger = LoggerFactory.getLogger(AdminSideImplementation.class);

   @Autowired
   private FormSelect formSelect;
   
   @Autowired
   private InterfHeaderLink headerLink;
	
	@RequestMapping(value="/dashboard",method=RequestMethod.GET)
	public String getLandingPage() {
	logger.debug("::AdminSideImplementation:::getLandingPage:::");
		return "dashboard";
	}
	
	@RequestMapping(value="/headerLinks",method=RequestMethod.GET)
	public String getHeaderLinksTable() {
	logger.debug("::AdminSideImplementation:::getHeaderLinksTable:::");
		return "headerLinksTable";
	}
	
	@RequestMapping(value="/addHeaderLink",method=RequestMethod.GET)
	public ModelAndView addHeaderLink(Model model) {
	logger.debug("::AdminSideImplementation:::addHeaderLink:::");
	 model.addAttribute("statusSelect", formSelect.statusSelectTag());
	 model.addAttribute("sequenceSelect", formSelect.sequenceSelectTag());
	 
    return new ModelAndView("addHeaderLinks","headerData",new HeaderLink());
	}
	
	
	@RequestMapping(value="/saveHeaderLink",method=RequestMethod.POST) 
	public ModelAndView getSaveHeaderLink(@Valid final HeaderLink headerLinkBean ,final BindingResult result, 
			final RedirectAttributes redirectAttributes,Model model) { 
	   logger.debug("::::AdminSideImplementation::::getSaveHeaderLink::");
	  if(result.hasErrors()) {
	  logger.debug("You are inside result.hasError:::"+headerLinkBean.getCategory());
	  
	  model.addAttribute("statusSelect", formSelect.statusSelectTag());
	  model.addAttribute("sequenceSelect", formSelect.sequenceSelectTag()); 
	  
	  return new ModelAndView("addHeaderLinks","headerData",headerLinkBean); 
	  }
	  headerLink.saveHeaderLink(headerLinkBean); 
	  return new ModelAndView("redirect:/admin/headerLinks");
	   }
	
}
