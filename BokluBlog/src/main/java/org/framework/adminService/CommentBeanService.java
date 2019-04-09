package org.framework.adminService;

import java.util.ArrayList;
import java.util.List;

import org.framework.model.CommentBean;
import org.framework.model.Comments;
import org.framework.service.InterfPostCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentBeanService implements InterfCommentBean {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentBeanService.class);
	
	@Autowired
	private InterfPostCommentService interfPostCommentService;
	
	

	@Override
	public List<CommentBean> getCommentDetailsById(Comments comments) {
		
		List<Comments> commentsDetails = interfPostCommentService.findByHeaderSubSectionOrderById(comments.getHeaderSubSection().getSubSectionId());
		
		List<CommentBean> commentBeanDetails = new ArrayList<CommentBean>();
		CommentBean commentBean;
		for(Comments commentDetails : commentsDetails) {
			commentBean = new CommentBean();
			commentBean.setId(commentDetails.getId());
			commentBean.setName(commentDetails.getName());
			commentBean.setEmail(commentDetails.getEmail());
			commentBean.setComments(commentDetails.getComment());
			commentBean.setHeaderSubSection(commentDetails.getHeaderSubSection().getSubSectionId());
			commentBeanDetails.add(commentBean);
		}
		
		return commentBeanDetails;
	}

}
