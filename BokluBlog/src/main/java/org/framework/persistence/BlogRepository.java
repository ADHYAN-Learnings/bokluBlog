package org.framework.persistence;

import org.framework.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BlogRepository extends JpaRepository<Blog,Long> {
	
	@Query(" select b from Blog b where b.headerSubject.subject = ?1 ")
	Blog findByheaderSubject(String subject);

}
