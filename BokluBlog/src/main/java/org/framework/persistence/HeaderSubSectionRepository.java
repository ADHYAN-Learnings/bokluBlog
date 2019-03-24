package org.framework.persistence;

import java.util.List;

import org.framework.model.HeaderSubSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HeaderSubSectionRepository extends JpaRepository<HeaderSubSection,Long> {
	
	@Query(" select hs from HeaderSubSection hs where hs.headerCategory.id = ?1 ")
	List<HeaderSubSection> findByHeaderCategory(Long headerLinkId);

}
