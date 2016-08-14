package com.applicant.webapp;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-08-14T13:10:18.598+0200")
@StaticMetamodel(Education.class)
public class Education_ {
	public static volatile SingularAttribute<Education, EducationPK> id;
	public static volatile SingularAttribute<Education, Date> dateTo;
	public static volatile SingularAttribute<Education, String> details;
	public static volatile SingularAttribute<Education, String> educationalInstitution;
	public static volatile SingularAttribute<Education, Applicant> applicant;
}
