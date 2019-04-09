package org.framework.adminService;

import java.util.List;

import org.framework.model.CommentBean;
import org.framework.model.Comments;

public interface InterfCommentBean {
  List<CommentBean> getCommentDetailsById(Comments comments);
}
