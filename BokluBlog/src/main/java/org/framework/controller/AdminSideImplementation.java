package org.framework.controller;


import javax.validation.Valid;

import org.framework.adminService.InterfHeaderLink;
import org.framework.model.HeaderLink;
import org.framework.select.FormSelect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/admin")
public class AdminSideImplementation {
	
private static final Logger logger = LoggerFactory.getLogger(AdminSideImplementation.class);

   @Autowired
   private FormSelect formSelect;
   
   @Autowired
   private InterfHeaderLink interfHeaderLink;
	
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
	public ModelAndView getSaveHeaderLink(@ModelAttribute("headerData") @Valid  HeaderLink headerLink , BindingResult result, 
			final RedirectAttributes redirectAttributes,Model model) { 
	   logger.debug("::::AdminSideImplementation::::getSaveHeaderLink::"+headerLink.toString());
	  if(result.hasErrors()) { 
	  model.addAttribute("statusSelect", formSelect.statusSelectTag());
	  model.addAttribute("sequenceSelect", formSelect.sequenceSelectTag()); 
	  
	  return new ModelAndView("addHeaderLinks","headerData",headerLink); 
	  }
	  interfHeaderLink.saveHeaderLink(headerLink); 
	  return new ModelAndView("redirect:/admin/headerLinks");
	   }
	
}
