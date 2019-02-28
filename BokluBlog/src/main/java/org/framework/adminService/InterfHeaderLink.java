package org.framework.adminService;

import java.util.List;

import org.framework.model.HeaderLink;

public interface InterfHeaderLink {
	
	HeaderLink saveHeaderLink(HeaderLink headerLink);
	List<HeaderLink>  getHeaderLinkOrderBySequence(String status);
	List<HeaderLink>  getHeaderLinkDetails();
	HeaderLink    getHeaderLinkById(Long id);
    HeaderLink    getHeaderLinkByPath(String path);
}
