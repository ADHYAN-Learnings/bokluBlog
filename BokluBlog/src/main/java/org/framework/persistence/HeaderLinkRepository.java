package org.framework.persistence;


import java.util.List;
import java.util.Optional;

import org.framework.model.HeaderLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeaderLinkRepository extends JpaRepository<HeaderLink, Long> {
	
	List<HeaderLink>  findBystatusEqualsOrderBySequenceAsc(String status);
	Optional<HeaderLink>    findById(Long id);
}
