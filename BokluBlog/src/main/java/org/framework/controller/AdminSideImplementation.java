package org.framework.controller;



import javax.validation.Valid;

import org.framework.adminService.InterfBlogService;
import org.framework.adminService.InterfFileUpload;
import org.framework.adminService.InterfHeaderLink;
import org.framework.adminService.InterfHeaderSubSection;
import org.framework.model.Blog;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.framework.model.HeaderSubSection;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/admin")
public class AdminSideImplementation {
	
private static final Logger logger = LoggerFactory.getLogger(AdminSideImplementation.class);

   @Autowired
   private FormSelect formSelect;
   
   @Autowired
   private InterfHeaderLink interfHeaderLink;
   
   @Autowired
   private InterfHeaderSubSection interfHeaderSubSection;
   
   @Autowired
   private InterfBlogService interfBlogService;
   
   @Autowired
   private InterfFileUpload interfFileUpload;
	
	@RequestMapping(value="/dashboard",method=RequestMethod.GET)
	public String getLandingPage() {
	logger.debug("::AdminSideImplementation:::getLandingPage:::");
		return "dashboard";
	}
	
	@RequestMapping(value="/headerLinks",method=RequestMethod.GET)
	public String getHeaderLinksTable(Model model) {
	logger.debug("::AdminSideImplementation:::getHeaderLinksTable:::");
	 model.addAttribute("headerLinkDetails", interfHeaderLink.getHeaderLinkDetails());
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
	public ModelAndView getSaveHeaderLink(@ModelAttribute("headerData") @Valid HeaderLink headerLink , BindingResult result, 
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
	
	 @RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	  public ModelAndView editHeaderLinkDetails(@PathVariable(value="id") Long id,Model model) {
		  model.addAttribute("statusSelect", formSelect.statusSelectTag());
		  model.addAttribute("sequenceSelect", formSelect.sequenceSelectTag());
		 return new ModelAndView("addHeaderLinks","headerData", interfHeaderLink.getHeaderLinkById(id));
	  }
	 
	 @GetMapping("/headerLinksSubSection")
	 public ModelAndView HeaderSubSection(Model model) {		 
		 return new ModelAndView("headerSubSectionTable","headerSubSectionData",interfHeaderSubSection.getHeaderSubSectionDetails());
	 }
	 
	 @GetMapping("/addSubSection")
	 public ModelAndView addSubSectionOfHeader(Model model) {
		 model.addAttribute("headerCategories",formSelect.headerLinkCategories());
		 model.addAttribute("statusSelect", formSelect.statusSelectTag());
		 model.addAttribute("sequenceSelect", formSelect.sequenceSelectTag());
		 return new ModelAndView("addHeaderSubSection","headerSubSectionData", new HeaderSubSection());
	 }
	 
	 @PostMapping("/saveHeaderSubSection")
	 public ModelAndView addHeaderSubSection(@ModelAttribute("headerSubSectionData") @Valid HeaderSubSection headerSubSection ,  BindingResult result,
			 final RedirectAttributes redirectAttributes,Model model) {
		 if(result.hasErrors()) {
			 model.addAttribute("headerCategories",formSelect.headerLinkCategories());
			 model.addAttribute("statusSelect", formSelect.statusSelectTag());
			 model.addAttribute("sequenceSelect", formSelect.sequenceSelectTag());
			 return new ModelAndView("addHeaderSubSection","headerSubSectionData",headerSubSection);
			 
		 }
		 interfHeaderSubSection.saveHeaderSubSection(headerSubSection);
		 return new ModelAndView("redirect:/admin/headerLinksSubSection");
	 }
	 
	 @GetMapping("/editHeaderSubSectionData/{subSectionId}")
	 public ModelAndView editHeaderSubSection(@PathVariable("subSectionId") Long subSectionId , Model model , HeaderSubSection headerSubSection) {
		 model.addAttribute("headerCategories",formSelect.headerLinkCategories());
		 model.addAttribute("statusSelect", formSelect.statusSelectTag());
		 model.addAttribute("sequenceSelect", formSelect.sequenceSelectTag());
		 return new ModelAndView("addHeaderSubSection","headerSubSectionData", interfHeaderSubSection.findBySubSectionId(subSectionId));
		 
	 }
	 
	 @GetMapping("/blog")
	 public ModelAndView blog(Model model,Blog blog) {
		 return new ModelAndView("blogTable","blogData",interfBlogService.getAllData());
	 }
	 
	 @GetMapping("/addBlog")
     public ModelAndView addBlog(Model model,Blog blog , BindingResult bindingResult) {
		 
		model.addAttribute("headerCategories",formSelect.headerLinkCategories());
		 return new ModelAndView("addBlog","blogData",blog);
	 }
	 
	 @PostMapping("/saveBlogDetails")
	 public ModelAndView saveBlogDetails(Model model,Blog blog,BindingResult bindingResult) {
		 interfBlogService.save(blog);
		 return new ModelAndView("redirect:/admin/blog");
	 }
	 
	 @PostMapping("/blogTest")
	 public ModelAndView testBlog(Model model,Blog blog) {
		 logger.debug(":::::"+blog.getBlogData());
		 return new ModelAndView("checkBlog","blog",blog);
	 }
	 
	 @GetMapping("/editblog/{blogId}")
	 public ModelAndView editBlogDetails(@PathVariable("blogId") Long blogId,Model model, Blog blog) {
		 Blog blogDetails = interfBlogService.findByBlogId(blogId);
		 model.addAttribute("headerCategories",formSelect.headerLinkCategories());
		 model.addAttribute("headerSubjectData",formSelect.headerSubject(blogDetails.getHeaderCategory().getId()));		 
		 return new ModelAndView("addBlog","blogData",blogDetails);
		 
	 }
	 
	 @GetMapping("/fileUpload")
	 public String fileUploadDisplayPage() {
		 return "fileUpload";
	 }
	 @PostMapping("/uploadFile")
	 public ModelAndView saveFile(Model model,@RequestParam("files") MultipartFile[] files , RedirectAttributes redirectAttributes) {
		 logger.debug(":::AdminSideImplementation:::::saveFile");
	     StringBuilder fileNames= new StringBuilder();
		 if(files.length<=0) {
			 redirectAttributes.addFlashAttribute("message", "Please Select a file to upload");
			 return new ModelAndView("redirect:/admin/fileUpload");
		 }
		  fileNames =  interfFileUpload.fileUpload(files);
		  redirectAttributes.addFlashAttribute("message","Files successfully uploaded "+fileNames);
		  
		 return new ModelAndView("redirect:/admin/fileUpload");
	 }
}
