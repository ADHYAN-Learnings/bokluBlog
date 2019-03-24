package org.framework.dependentListOfValues;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.framework.select.FormSelect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;


  @Controller 
  public class ListBoxController extends HttpServlet {
  

	private static final long serialVersionUID = 1L;

private static final Logger logger = LoggerFactory.getLogger(ListBoxController.class);
  
  @Autowired
  private FormSelect formSelect;
  
  @PostMapping("/list-load")
  @ResponseBody
  protected void dependentListOfValueLoad(HttpServletRequest request,HttpServletResponse response) throws ServletException , IOException {
  
   ListBoxUtilities.clearError();
   ListBoxUtilities.clearResponse();
   ListBoxUtilities.setResponse(new LinkedHashMap<String,Object>());
   
   Senders sender = null;
   try {
	   if(request.getParameter("sender") != null) {
		   sender = Senders.valueOf(request.getParameter("sender"));
	   }
	   
	   switch(sender) {
	    
	   case headerSubjectByHeaderCategory:{
		   try {
			   Long headerCategory = Long.parseLong(request.getParameter("headerCategory"));
			   Map<Long,String> headerCategoryDependentValues = formSelect.headerSubject( headerCategory);
			   ListBoxUtilities.getResponse().put("headerSubject",headerCategoryDependentValues);
			   ListBoxUtilities.getResponse().put("previousLink",headerCategoryDependentValues);
			   ListBoxUtilities.getResponse().put("nextLink",headerCategoryDependentValues);
		   } catch(Exception e) {
			   e.printStackTrace();
			   
		   }
		   break;
	   }
	   default : {
		   break;
	   }
	   }
	   
   } catch(Exception e) {
	   e.printStackTrace();
   }
   
   response.setContentType("application/json");
   if(ListBoxUtilities.getResponse().size()>0) {
	   ObjectMapper objectMapper = new ObjectMapper();
	   
	   try {
		   response.getWriter().write(objectMapper.writeValueAsString(ListBoxUtilities.getResponse()));
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
   }
  
  }
  
  static enum Senders {
	  headerSubjectByHeaderCategory;
  }
  
  }
 