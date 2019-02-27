package org.framework.persistence;

import org.framework.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<Comments , Long > {
 
}
