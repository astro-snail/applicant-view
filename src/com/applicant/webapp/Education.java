package com.applicant.webapp;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;


/**
 * The persistent class for the education database table.
 * 
 */
@Entity
@XmlRootElement
@Table(name="education")
@NamedQuery(name="Education.findAllForApplicant", query="SELECT e FROM Education e WHERE e.id.applicantId = :applicantId")
public class Education implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EducationPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_to")
	private Date dateTo;

	@Column(length=2147483647)
	private String details;

	@Column(name="educational_institution", length=50)
	private String educationalInstitution;

	//bi-directional many-to-one association to ApplicantView
	@ManyToOne
	@JoinColumn(name="applicant_id", referencedColumnName="applicant_id", nullable=false, insertable=false, updatable=false)
	private ApplicantView applicantView;

	public Education() {
	}

	public EducationPK getId() {
		return this.id;
	}

	@XmlElement
	public void setId(EducationPK id) {
		this.id = id;
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

	public String getEducationalInstitution() {
		return this.educationalInstitution;
	}
	@XmlElement
	public void setEducationalInstitution(String educationalInstitution) {
		this.educationalInstitution = educationalInstitution;
	}

	/*public ApplicantView getApplicantView() {
		return this.applicantView;
	}

	public void setApplicantView(ApplicantView applicantView) {
		this.applicantView = applicantView;
	}*/

}