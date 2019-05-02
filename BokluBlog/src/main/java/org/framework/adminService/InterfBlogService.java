package org.framework.adminService;

import java.util.List;

import org.framework.model.Blog;

public interface InterfBlogService {
	
	Blog save(Blog blog);
	List<Blog> getAllData();
	Blog findByBlogId(Long blogId);
	Blog findByheaderSubject(String subject);
    Long getCount();
}
