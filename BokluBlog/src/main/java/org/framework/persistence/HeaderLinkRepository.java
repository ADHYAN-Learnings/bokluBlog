package org.framework.persistence;


import java.util.List;

import org.framework.model.HeaderLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeaderLinkRepository extends JpaRepository<HeaderLink, Long> {
	
	List<HeaderLink>  findBystatusEqualsOrderBySequenceAsc(String status);
	HeaderLink  findByPath(String path);
}
