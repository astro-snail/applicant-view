package com.applicant.webapp;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-08-13T01:12:52.103+0200")
@StaticMetamodel(ApplicantView.class)
public class ApplicantView_ {
	public static volatile SingularAttribute<ApplicantView, Integer> applicantId;
	public static volatile SingularAttribute<ApplicantView, Date> dateApplied;
	public static volatile SingularAttribute<ApplicantView, String> department;
	public static volatile SingularAttribute<ApplicantView, String> firstName;
	public static volatile SingularAttribute<ApplicantView, String> lastName;
	public static volatile SingularAttribute<ApplicantView, Integer> positionId;
	public static volatile SingularAttribute<ApplicantView, String> status;
	public static volatile SingularAttribute<ApplicantView, String> title;
	public static volatile ListAttribute<ApplicantView, WorkExperience> workExperiences;
	public static volatile ListAttribute<ApplicantView, Education> educations;
}
