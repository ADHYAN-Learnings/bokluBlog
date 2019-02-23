package org.framework.adminService;

import org.framework.model.HeaderLink;
import org.framework.persistence.HeaderLinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class HeaderLinkService implements InterfHeaderLink {
	
	private static final Logger logger = LoggerFactory.getLogger(HeaderLinkService.class);
	
	@Autowired
	private HeaderLinkRepository headerLinkRepository;

	@Override
	public HeaderLink saveHeaderLink(HeaderLink headerLink) {
		return headerLinkRepository.save(headerLink);
	}

	@Override
	public List<HeaderLink> getHeaderLinkOrderBySequence(String status) {
		return headerLinkRepository.findBystatusEqualsOrderBySequenceAsc(status);
	}

	

}
