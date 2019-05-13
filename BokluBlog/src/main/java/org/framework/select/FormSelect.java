package org.framework.select;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.framework.adminService.InterfHeaderLink;
import org.framework.adminService.InterfHeaderSubSection;
import org.framework.model.HeaderLink;
import org.framework.model.HeaderSubSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FormSelect {
	
	private final static String UPLOAD_DIRECTORY = "/resources/images/";

	HttpServletRequest request;
	
	public FormSelect(HttpServletRequest request) {
		super();
		this.request = request;
	}
	
	@Autowired
	private InterfHeaderLink interfHeaderLink;
	
	@Autowired
	private InterfHeaderSubSection interfHeaderSubSection;
	
	public Map<String,String> statusSelectTag() {
		Map<String,String> status = new HashMap<String,String>();
		status.put("Active", "Active");
		status.put("Inactive", "Inactive");
		
		return status;
	}
	
	public Map<Integer,String> sequenceSelectTag() {
		Map<Integer,String> sequence = new HashMap<Integer,String>();
		sequence.put(0, "--SELECT--");
		for(int i=1;i<=50;i++) {
			sequence.put(i, Integer.toString(i));
		}
		return sequence;
	}
	
	public Map<Long,String> headerLinkCategories(){
		Map<Long,String> headerLinkCategories = new HashMap<Long,String>();
		headerLinkCategories .put(0l,"----SELECT----");
		List<HeaderLink> headerCategoriesData = interfHeaderLink.getHeaderLinkOrderBySequence("Active");
		headerCategoriesData.stream().forEach(headerLink->headerLinkCategories.put(headerLink.getId(), headerLink.getCategory()));
		return headerLinkCategories;
	}
	
	public Map<Long,String> headerSubject(Long headerLinkId){
		Map<Long,String> headerSubject = new HashMap<Long,String>();
		headerSubject.put(0l,"----SELECT----");
		List<HeaderSubSection> headerSubjectData = interfHeaderSubSection.getHeaderSubSectionSubject(headerLinkId);
		headerSubjectData.stream().forEach(headerSubSection->headerSubject.put(headerSubSection.getSubSectionId(), headerSubSection.getSubject()));
		return headerSubject;
	}
	
	public Map<String,String> getListOfImageFolder() {
		Map<String,String> imageFolderList = new HashMap<String,String>();
		
		try {
			ServletContext servletContext = request.getServletContext();
			String directoryPath = servletContext.getRealPath(UPLOAD_DIRECTORY);
			File directory = new File(directoryPath);
			File[] fileList = directory.listFiles();
			
			for(File file: fileList) {
				if(file.isDirectory()) {
					imageFolderList.put(file.getName(), file.getName());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return imageFolderList;
	}
	

}
