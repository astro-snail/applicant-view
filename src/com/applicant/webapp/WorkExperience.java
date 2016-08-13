package com.applicant.webapp;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;


/**
 * The persistent class for the work_experience database table.
 * 
 */
@Entity
@XmlRootElement
@Table(name="work_experience")
@NamedQuery(name="WorkExperience.findAllForApplicant", query="SELECT w FROM WorkExperience w WHERE w.id.applicantId = :applicantId")
public class WorkExperience implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private WorkExperiencePK id;

	@Column(name="company_name", length=50)
	private String companyName;

	@Temporal(TemporalType.DATE)
	@Column(name="date_to")
	private Date dateTo;

	@Column(length=2147483647)
	private String details;

	@Column(length=50)
	private String position;

	//bi-directional many-to-one association to ApplicantView
	@ManyToOne
	@JoinColumn(name="applicant_id", referencedColumnName="applicant_id", nullable=false, insertable=false, updatable=false)
	private ApplicantView applicantView;

	public WorkExperience() {
	}

	public WorkExperiencePK getId() {
		return this.id;
	}
	@XmlElement
	public void setId(WorkExperiencePK id) {
		this.id = id;
	}

	public String getCompanyName() {
		return this.companyName;
	}
	@XmlElement
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getDateTo() {
		return this.dateTo;
	}
	@XmlElement
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public String getDetails() {
		return this.details;
	}
	@XmlElement
	public void setDetails(String details) {
		this.details = details;
	}

	public String getPosition() {
		return this.position;
	}
	@XmlElement
	public void setPosition(String position) {
		this.position = position;
	}

	/*public ApplicantView getApplicantView() {
		return this.applicantView;
	}

	public void setApplicantView(ApplicantView applicantView) {
		this.applicantView = applicantView;
	}*/

}