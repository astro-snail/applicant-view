package com.applicant.webapp;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

/**
 * The primary key class for the work_experience database table.
 * 
 */
@Embeddable
public class WorkExperiencePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="applicant_id", unique=true, nullable=false)
	private Integer applicantId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_from", unique=true, nullable=false)
	private java.util.Date dateFrom;

	public WorkExperiencePK() {
	}
	public Integer getApplicantId() {
		return this.applicantId;
	}
	@XmlElement
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
	public java.util.Date getDateFrom() {
		return this.dateFrom;
	}
	@XmlElement
	public void setDateFrom(java.util.Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof WorkExperiencePK)) {
			return false;
		}
		WorkExperiencePK castOther = (WorkExperiencePK)other;
		return 
			this.applicantId.equals(castOther.applicantId)
			&& this.dateFrom.equals(castOther.dateFrom);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.applicantId.hashCode();
		hash = hash * prime + this.dateFrom.hashCode();
		
		return hash;
	}
}