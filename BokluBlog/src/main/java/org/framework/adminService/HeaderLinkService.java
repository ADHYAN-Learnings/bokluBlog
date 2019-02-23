package org.framework.adminService;

import org.framework.model.HeaderLink;
import org.framework.persistence.HeaderLinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class HeaderLinkService implements InterfHeaderLink {
	
	private static final Logger logger = LoggerFactory.getLogger(HeaderLinkService.class);
	
	
	private HeaderLinkRepository headerLinkRepository;

	@Override
	public HeaderLink saveHeaderLink(HeaderLink headerLink) {
		return headerLinkRepository.save(headerLink);
	}

	

}
