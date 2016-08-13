package com.applicant.webapp;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-08-13T00:19:05.605+0200")
@StaticMetamodel(WorkExperience.class)
public class WorkExperience_ {
	public static volatile SingularAttribute<WorkExperience, WorkExperiencePK> id;
	public static volatile SingularAttribute<WorkExperience, String> companyName;
	public static volatile SingularAttribute<WorkExperience, Date> dateTo;
	public static volatile SingularAttribute<WorkExperience, String> details;
	public static volatile SingularAttribute<WorkExperience, String> position;
	public static volatile SingularAttribute<WorkExperience, ApplicantView> applicantView;
}
