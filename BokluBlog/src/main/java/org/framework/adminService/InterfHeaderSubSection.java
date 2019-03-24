package org.framework.adminService;

import java.util.List;

import org.framework.model.HeaderSubSection;

public interface InterfHeaderSubSection {

	HeaderSubSection saveHeaderSubSection(HeaderSubSection headerSubSection);
	List<HeaderSubSection> getHeaderSubSectionDetails();
	HeaderSubSection findBySubSectionId(Long subSectionId);
	
	List<HeaderSubSection> getHeaderSubSectionSubject(Long headerLinkId);
}
