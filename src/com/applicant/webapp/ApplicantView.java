package com.applicant.webapp;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the applicant_view database table.
 * 
 */
@Entity
@XmlRootElement(name="applicant")
@Table(name="applicant_view")
@NamedQueries({
	@NamedQuery(name = "ApplicantView.findAll", query = "SELECT a FROM ApplicantView a"),
    @NamedQuery(name = "ApplicantView.findByName", query = "SELECT a FROM Applicant a WHERE a.firstName = :firstName AND a.lastName = :lastName")
})
public class ApplicantView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "applicant_id")
	private Integer applicantId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_applied")
	private Date dateApplied;

	@Column(length=50)
	private String department;

	@Column(name="first_name", length=40)
	private String firstName;

	@Column(name="last_name", length=40)
	private String lastName;

	@Column(name="position_id")
	private Integer positionId;

	@Column(length=20)
	private String status;

	@Column(length=50)
	private String title;

	//bi-directional many-to-one association to WorkExperience
	@OneToMany(mappedBy="applicantView")
	private List<WorkExperience> workExperiences;

	//bi-directional many-to-one association to Education
	@OneToMany(mappedBy="applicantView")
	private List<Education> educations;

	public ApplicantView() {
	}
	
	public Integer getApplicantId() {
		return this.applicantId;
	}

	@XmlElement
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}

	public Date getDateApplied() {
		return this.dateApplied;
	}
	
	@XmlElement
	public void setDateApplied(Date dateApplied) {
		this.dateApplied = dateApplied;
	}

	public String getDepartment() {
		return this.department;
	}
	
	@XmlElement
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	@XmlElement
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}
	
	@XmlElement
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getPositionId() {
		return this.positionId;
	}
	
	@XmlElement
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getStatus() {
		return this.status;
	}
	
	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}
	
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	public List<WorkExperience> getWorkExperiences() {
		return this.workExperiences;
	}
	
	@XmlElement(name="workExperience")
	public void setWorkExperiences(List<WorkExperience> workExperiences) {
		this.workExperiences = workExperiences;
	}

	/*public WorkExperience addWorkExperience(WorkExperience workExperience) {
		getWorkExperiences().add(workExperience);
		workExperience.setApplicantView(this);

		return workExperience;
	}

	public WorkExperience removeWorkExperience(WorkExperience workExperience) {
		getWorkExperiences().remove(workExperience);
		workExperience.setApplicantView(null);

		return workExperience;
	}*/

	public List<Education> getEducations() {
		return this.educations;
	}

	@XmlElement(name = "education")
	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	/*public Education addEducation(Education education) {
		getEducations().add(education);
		education.setApplicantView(this);

		return education;
	}

	public Education removeEducation(Education education) {
		getEducations().remove(education);
		education.setApplicantView(null);

		return education;
	}*/

}