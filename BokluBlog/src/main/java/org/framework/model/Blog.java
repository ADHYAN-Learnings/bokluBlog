package org.framework.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Lob;

@Entity
@Table(name="Blog")
public class Blog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Blog_Id")
	private Long blogId;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "Header_Category", nullable = false)
	private HeaderLink headerCategory;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "HeaderSubSection_Subject", nullable = false)
	private HeaderSubSection headerSubject;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "Previous_Link")
	private HeaderSubSection previousLink;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "Next_Link")
	private HeaderSubSection nextLink;
	
	@Column(name="Blog_Data")
	@Lob
	private String blogData;

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public HeaderLink getHeaderCategory() {
		return headerCategory;
	}

	public void setHeaderCategory(HeaderLink headerCategory) {
		this.headerCategory = headerCategory;
	}

	public HeaderSubSection getHeaderSubject() {
		return headerSubject;
	}

	public void setHeaderSubject(HeaderSubSection headerSubject) {
		this.headerSubject = headerSubject;
	}

	public HeaderSubSection getPreviousLink() {
		return previousLink;
	}

	public void setPreviousLink(HeaderSubSection previousLink) {
		this.previousLink = previousLink;
	}

	public HeaderSubSection getNextLink() {
		return nextLink;
	}

	public void setNextLink(HeaderSubSection nextLink) {
		this.nextLink = nextLink;
	}

	public String getBlogData() {
		return blogData;
	}

	public void setBlogData(String blogData) {
		this.blogData = blogData;
	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", headerCategory=" + headerCategory + ", headerSubject=" + headerSubject
				+ ", previousLink=" + previousLink + ", nextLink=" + nextLink + ", blogData=" + blogData + "]";
	}
}
