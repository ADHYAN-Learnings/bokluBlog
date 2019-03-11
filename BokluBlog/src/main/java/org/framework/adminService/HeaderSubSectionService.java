package org.framework.adminService;

import java.util.List;

import org.framework.model.HeaderSubSection;
import org.framework.persistence.HeaderSubSectionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
@Service
public class HeaderSubSectionService  implements InterfHeaderSubSection {
	
	@Autowired
	private  HeaderSubSectionRepository headerSubSectionRepository;

	@Override
	public HeaderSubSection saveHeaderSubSection(HeaderSubSection headerSubSection) {
		return headerSubSectionRepository.save(headerSubSection);
	}

	@Override
	public List<HeaderSubSection> getHeaderSubSectionDetails() {
		return headerSubSectionRepository.findAll();
	}

	@Override
	public HeaderSubSection findBySubSectionId(Long subSectionId) {
		return headerSubSectionRepository.getOne(subSectionId);
	}

}
