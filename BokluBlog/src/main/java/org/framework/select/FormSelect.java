package org.framework.select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.framework.adminService.InterfHeaderLink;
import org.framework.model.HeaderLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FormSelect {
	
	@Autowired
	private InterfHeaderLink interfHeaderLink;
	
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
		
		List<HeaderLink> headerCategoriesData = interfHeaderLink.getHeaderLinkOrderBySequence("Active");
		headerCategoriesData.stream().forEach(headerSubSection->headerLinkCategories.put(headerSubSection.getId(), headerSubSection.getCategory()));
		return headerLinkCategories;
	}

}
