package org.framework.adminService;

import java.util.List;

import org.framework.model.Blog;
import org.framework.persistence.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BlogService implements InterfBlogService {
    
	@Autowired
	private BlogRepository blogRepository;
	
	@Override
	public Blog save(Blog blog) {
		return blogRepository.save(blog);
	}

	@Override
	public List<Blog> getAllData() {
		return blogRepository.findAll();
	}

	@Override
	public Blog findByBlogId(Long blogId) {
		return blogRepository.getOne(blogId);
	}

}
