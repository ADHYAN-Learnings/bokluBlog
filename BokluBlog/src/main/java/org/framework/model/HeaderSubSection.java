package org.framework.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Header_Sub_Section")
public class HeaderSubSection {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Sub_Section_Id")
	private Long subSectionId;
	
	@Column(name="Subject")
	@NotEmpty(message="Subject is required")
	private String subject;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="Sequence")
	private int sequence;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "HeaderLink_Sub_Section_Id", nullable = false)
	private HeaderLink headerCategory;

	public Long getSubSectionId() {
		return subSectionId;
	}

	public void setSubSectionId(Long subSectionId) {
		this.subSectionId = subSectionId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HeaderLink getHeaderCategory() {
		return headerCategory;
	}
	
	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public void setHeaderCategory(HeaderLink headerCategory) {
		this.headerCategory = headerCategory;
	}

	@Override
	public String toString() {
		return "HeaderSubSection [subSectionId=" + subSectionId + ", subject=" + subject + ", status=" + status
				+ ", sequence=" + sequence + ", headerCategory=" + headerCategory + "]";
	}
}
