package org.framework.model;

import java.io.Serializable;

public class CommentBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String comments;
	private String email;
	private String name;
	private Long headerSubSection;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getHeaderSubSection() {
		return headerSubSection;
	}
	public void setHeaderSubSection(Long headerSubSection) {
		this.headerSubSection = headerSubSection;
	}
	
	@Override
	public String toString() {
		return "CommentBean [id=" + id + ", comments=" + comments + ", email=" + email + ", name=" + name
				+ ", headerSubSection=" + headerSubSection + "]";
	}
}
