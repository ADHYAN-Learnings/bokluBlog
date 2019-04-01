package org.framework.controller;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.frameword.functionalInterface.AccessUsername;
import org.framework.adminService.InterfBlogService;
import org.framework.adminService.InterfHeaderLink;
import org.framework.email.PasswordResetEmail;
import org.framework.model.Blog;
import org.framework.model.Comments;
import org.framework.model.HeaderLink;
import org.framework.model.OnRegistrationCompleteEvent;
import org.framework.model.PasswordReset;
import org.framework.model.PasswordResetToken;
import org.framework.model.UserRegistration;
import org.framework.model.VerficationToken;
import org.framework.service.InterfPostCommentService;
import org.framework.service.InterfUserService;
import org.framework.validation.EmailExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/boklu")
public class UserSideImplementation {
	
	private static final Logger logger = LoggerFactory.getLogger(UserSideImplementation.class);
	
	@Autowired
	private InterfUserService userService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
		
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AccessUsername accessUsername;
	
	@Autowired
	private InterfHeaderLink interfHeaderLink;
	
	@Autowired
	private InterfPostCommentService interfPostCommentService;
	
	@Autowired
	private InterfBlogService interfBlogService;
	
	
	
   @RequestMapping(value="/landingPage")
   public String getLandingPage(Model model) {
	   logger.debug(":::::UserSideImplementation::::getLandingPage:");
	   List<HeaderLink> headerLinkData = interfHeaderLink.getHeaderLinkOrderBySequence("Active");
	   model.addAttribute("username",accessUsername.getUsername());
	   model.addAttribute("headerLinkData", headerLinkData);
	   return "boklu";
   }
	
   @RequestMapping(value="/signup")
   public ModelAndView getUserRegistrationPage() {
	   logger.debug(":::::UserSideImplementation::::getUserRegistrationPage:");
	   return new ModelAndView("registration","userRegistration",new UserRegistration());
   }
   
   @RequestMapping(value="/register",method=RequestMethod.POST)
   public ModelAndView registerUser(@Valid final UserRegistration userRegistration,
		   final BindingResult result,HttpServletRequest request,final RedirectAttributes redirectAttributes) {
	   logger.debug(":::::UserSideImplementation::::registerUser:::");
	   if(result.hasErrors()) {
		   return new ModelAndView("registration","userRegistration",userRegistration);
	   }
	   try {
		   userRegistration.setEnabled(false);
		  final UserRegistration registeredUserRegistration = userService.registerNewUser(userRegistration);
		  final String appUrl = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		  eventPublisher.publishEvent(new OnRegistrationCompleteEvent(appUrl,registeredUserRegistration));
		  redirectAttributes.addFlashAttribute("activateAccountLinkMessage","Your account is successfully created. Please Verify your email by clicking on the link");
	   }catch(EmailExistException e) {
		   result.addError(new FieldError("user","email",e.getMessage()));
		   return new ModelAndView("registration","userRegistration",userRegistration);
	   }
	   return new ModelAndView("redirect:/boklu/userLogin");
	   
   }
   
   @RequestMapping(value="/registrationConfirmation")
   public ModelAndView registrationConfirmation(final Model model,@RequestParam("token") final String token,
		   final RedirectAttributes redirectAttributes) {
	   logger.debug("::UserSideImplementation::::registrationConfirmation:::");
	   final  VerficationToken verificationToken = userService.getVerificationToken(token);
	  
	  if(verificationToken == null) {
		  redirectAttributes.addFlashAttribute("accountInvalidMessage","Invalid account confirmation Token.");
		  return new ModelAndView("redirect:/boklu/userLogin");
	  }
	  
	  final UserRegistration userRegistration = verificationToken.getUserRegistration();
	  final Calendar calendar = Calendar.getInstance();
	  
	  if ((verificationToken.getExpiryDate().getTime() - calendar.getTime().getTime()) <= 0) {
          redirectAttributes.addFlashAttribute("registrationExpiredMessage", "Your registration token has expired. Please register again.");
          return new ModelAndView("redirect:/boklu/userLogin");
      }
	  
	  userRegistration.setEnabled(true);
	  userService.saveRegisteredUser(userRegistration);
	  redirectAttributes.addFlashAttribute("verifiedSuccess", "Your account is successfully activated.");
      return new ModelAndView("redirect:/boklu/userLogin");
   }
   
   @RequestMapping(value="/forgotPassword",method=RequestMethod.GET)
   public ModelAndView forgotPassword(final PasswordReset passwordReset) {
	   logger.debug(":::UserSideImplementation:::::::forgotPassword::");
	   return new ModelAndView("forgotPassword","passwordReset",new PasswordReset());
   }
   
   
   @RequestMapping(value="/passwordReset",method=RequestMethod.POST)
   @ResponseBody
   public ModelAndView resetPassword(final HttpServletRequest request,@Valid final PasswordReset passwordReset , 
		   final BindingResult result , final RedirectAttributes redirectAttributes) {
	  
	   if(result.hasErrors()) {
		   return new ModelAndView("forgotPassword","passwordReset",passwordReset);
	   }
	   final UserRegistration userRegistration = userService.findUserByEmail(passwordReset.getEmail());
	   
	   if(userRegistration !=null) {
		   final String token = UUID.randomUUID().toString();
		   userService.createPasswordResetTokenForUser(userRegistration, token);
		   final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		   final SimpleMailMessage email =  PasswordResetEmail.constructResetToken(appUrl, token, userRegistration);
		   mailSender.send(email);
		   
	   }
	    redirectAttributes.addFlashAttribute("passwordResetEmailMessage","You Should receive an Password Reset Email Shortly.");
	    return new ModelAndView("redirect:/boklu/userLogin");
   }
   
   @RequestMapping(value="/resetChangePassword",method=RequestMethod.GET)
   public ModelAndView resetChangePassword(@RequestParam("id") final long id, @RequestParam("token") final String token,
		   final RedirectAttributes redirectAttributes) {
	   final PasswordResetToken passwordResetToken = userService.getPasswordResetToken(token);
	   
	   if(passwordResetToken == null) {
		   redirectAttributes.addFlashAttribute("passResetMessage", "Invalid Reset Token of Password");
		   return new ModelAndView("redirect:/boklu/userLogin");
	   }
	   final UserRegistration userRegistration = passwordResetToken.getUserRegistration();
	   if(userRegistration.getId() != id) {
		   redirectAttributes.addFlashAttribute("passResetMessage", "Invalid Reset Token of Password");
		   return new ModelAndView("redirect:/boklu/userLogin");
	   }
	   final Calendar calendar = Calendar.getInstance();
	   if((passwordResetToken.getExpiryDate().getTime() - calendar.getTime().getTime())<=0) {
		   redirectAttributes.addFlashAttribute("errorMessage", "Your password reset token has expired");
           return new ModelAndView("redirect:/login");
	   }
	   
	   final Authentication authentication = new UsernamePasswordAuthenticationToken(userRegistration, null, userDetailsService.loadUserByUsername(userRegistration.getEmail()).getAuthorities());
	   SecurityContextHolder.getContext().setAuthentication(authentication);
	   
	   return new ModelAndView("redirect:/boklu/resetPassword");
   }
   
	
	  @RequestMapping(value="/savePasswordReset",method=RequestMethod.POST) 
	  @ResponseBody
	  public ModelAndView savePasswordReset(@RequestParam(value="password") final String password, 
			  @RequestParam(value="passwordConfirmation") final String passwordConfirmation, final RedirectAttributes redirectAttributes) { 
	  logger.debug(":::UserSideImplementation:::::savePasswordReset:::::::");
	  
	  if(password==null || password=="") {
		  redirectAttributes.addFlashAttribute("passwordResetError","Password field should not be empty.");
		  return new ModelAndView("redirect:/boklu/resetPassword");
	  }
	  if(!password.equals(passwordConfirmation)) {
		redirectAttributes.addFlashAttribute("passwordResetError", "Password do not match");
		return new ModelAndView("redirect:/boklu/resetPassword"); 
	  }
	  final UserRegistration userRegistration = (UserRegistration) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        userService.ChangeUserPassword(userRegistration, password);
	        redirectAttributes.addFlashAttribute("passwordResetEmailMessage", "Password Changed Successfully. ");
	  return new ModelAndView("redirect:/boklu/userLogin"); 
	  }
	 
	  @RequestMapping(value="/resetPassword")
		public String getDirectAccessResetPassword() {
	    logger.debug("::UserSideImplementation::getDirectAccessResetPassword::");
			return "resetPassword";
		}
		 
	   @RequestMapping(value="/saveComment",method=RequestMethod.POST)
	   public ModelAndView saveComment(@ModelAttribute("postComment") @Valid  final Comments comments ,final BindingResult result , Model model) {
		logger.debug(":::UserSideImplementation::::::saveComment:::"+comments.toString());
		
		if(result.hasErrors()) {
			List<HeaderLink> headerLinkWithSequence = interfHeaderLink.getHeaderLinkOrderBySequence("Active");
			model.addAttribute("headerLinkWithSequence",headerLinkWithSequence);
			List<Comments> displayComments = interfPostCommentService.getCommentBySequence();
			model.addAttribute("displayComments", displayComments);
			return new ModelAndView("boklu","postComment",comments);
		}
		
	      interfPostCommentService.saveComments(comments);
		    return new ModelAndView("redirect:/boklu/searchHeader/"+comments.getHeaderLink());
	    }
	
	   
	   @RequestMapping("/Spring Security/{subject}")
	   public ModelAndView getStoreDetails(@PathVariable("subject") String subject , Model model) {
		   logger.debug(":::::UserSideImplementation::::getStoreDetails::contentName::::"+subject);
		   Blog b = interfBlogService.findByheaderSubject(subject);
		   model.addAttribute("blog",interfBlogService.findByheaderSubject(subject));
		   List<HeaderLink> headerLinkWithSequence = interfHeaderLink.getHeaderLinkOrderBySequence("Active");
		    model.addAttribute("headerLinkWithSequence",headerLinkWithSequence); 
		    model.addAttribute("postComment",new Comments());
		   return new ModelAndView("boklu","blog",b);
	   }
   
	  

}


