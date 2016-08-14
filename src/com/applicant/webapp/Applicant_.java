package com.applicant.webapp;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-08-14T12:49:39.231+0200")
@StaticMetamodel(Applicant.class)
public class Applicant_ {
	public static volatile SingularAttribute<Applicant, Integer> applicantId;
	public static volatile SingularAttribute<Applicant, Date> dateApplied;
	public static volatile SingularAttribute<Applicant, String> department;
	public static volatile SingularAttribute<Applicant, String> firstName;
	public static volatile SingularAttribute<Applicant, String> lastName;
	public static volatile SingularAttribute<Applicant, Integer> positionId;
	public static volatile SingularAttribute<Applicant, String> status;
	public static volatile SingularAttribute<Applicant, String> title;
	public static volatile ListAttribute<Applicant, WorkExperience> workExperience;
	public static volatile ListAttribute<Applicant, Education> education;
}
