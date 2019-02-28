package org.framework.service;

import java.util.List;

import org.framework.model.Comments;

public interface InterfPostCommentService {
   
  Comments saveComments(Comments comments);
  List<Comments> getCommentBySequence();
  }
