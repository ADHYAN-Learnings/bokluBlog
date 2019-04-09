package org.framework.persistence;

import java.util.List;

import org.framework.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostCommentRepository extends JpaRepository<Comments , Long > {
	
	@Query(" select c from Comments c where c.headerSubSection.subSectionId=?1  order By c.id Desc ")
	List<Comments> findByHeaderSubSectionAndOrderById(Long headerSubSectionId);
 
}
