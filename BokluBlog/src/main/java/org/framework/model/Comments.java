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
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Post_Comment")
public class Comments {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COMMENT_ID")
	private Long id;
	
	@NotEmpty(message="Comment should not be empty.")
	@Column(name="Comment")
	private String comment;
	
	@Email
	@NotEmpty(message="Email is Required.")
	@Column(name="Email")
	private String email;
	
	@NotEmpty(message="Name is Required.")
	@Column(name="Name")
	private String name;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "HeaderLink_Post_Id", nullable = false)
	private HeaderLink headerLink;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		return "Comments [id=" + id + ", comment=" + comment + ", email=" + email + ", name=" + name + ", headerLink="
				+ headerLink + "]";
	}
	
}
