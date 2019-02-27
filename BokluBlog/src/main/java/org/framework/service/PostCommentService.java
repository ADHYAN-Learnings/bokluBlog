package org.framework.service;

import org.framework.model.Comments;
import org.framework.persistence.PostCommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class PostCommentService implements InterfPostCommentService {
	
	@Autowired
	private PostCommentRepository postCommentRepository;
	
	@Override
	public Comments saveComments(Comments comments) {
		return postCommentRepository.save(comments);
	}

}
