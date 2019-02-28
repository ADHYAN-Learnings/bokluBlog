package org.framework.persistence;

import java.util.List;

import org.framework.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<Comments , Long > {
	List<Comments> findAllByOrderByIdDesc();
 
}
