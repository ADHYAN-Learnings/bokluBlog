package org.framework.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

@Entity
@Table(name="Header_Link")
public class HeaderLink {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="HEADER_LINK_ID",nullable=false,unique=true)
	private Long id;
	
	@NotEmpty(message="Category is Required.")
	@Column(name="Category")
	private String category;
	
	@NotEmpty(message="Path is Required.")
	@Column(unique=true,name="Path")
	private String path;
	
	@Column(name="Status")
	private String status;
	
	@NotNull
	@Column(name="sequence")
	private int sequence;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return "HeaderLink [id=" + id + ", category=" + category + ", path=" + path + ", status=" + status
				+ ", sequence=" + sequence + "]";
	}
}
