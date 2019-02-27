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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Post_Comment")
public class Comments {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COMMENT_ID",nullable=false,unique=true)
	private Long Id;
	
	@Column(name="Comment")
	@NotNull(message="Comment should not be empty.")
	private String comment;
	
	@Column(name="Email")
	@NotNull(message="Email is Required.")
	@Email
	private String email;
	
	@Column(name="Name")
	@NotNull(message="Name is Required.")
	private String name;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "HeaderLink_Post_Id", nullable = false)
	private HeaderLink headerLink;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public HeaderLink getHeaderLink() {
		return headerLink;
	}

	public void setHeaderLink(HeaderLink headerLink) {
		this.headerLink = headerLink;
	}

	@Override
	public String toString() {
		return "Comments [comment=" + comment + ", email=" + email + ", name=" + name + ", headerLink=" + headerLink
				+ "]";
	}
}
