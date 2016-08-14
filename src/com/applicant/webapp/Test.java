package com.applicant.webapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Test {
		
	public static void main( String[ ] args ) {

		/*try {
			/*Connection connection = WebService.getConnection();
			Map<String, String> dbProps = new HashMap<String, String>();
		    
			dbProps.put("javax.persistence.jdbc.url", connection.getMetaData().getURL());
			dbProps.put("javax.persistence.jdbc.driver", connection.getClass().getName());  
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(WebService.PERSISTENCE_UNIT_NAME, dbProps);
			EntityManager entityManager = entityManagerFactory.createEntityManager();
	    	    		
			Query query = entityManager.createNamedQuery("Applicant.findAll");
      
			List<Applicant> list = query.getResultList( );
      
			for( Applicant a:list ){
				System.out.print("Applicant ID: " + a.getApplicantId() + "\t");
				System.out.println("Applicant Name: " + a.getFirstName() + " " + a.getLastName());
      
				Query queryW = entityManager.createNamedQuery("WorkExperience.findAllForApplicant");
				queryW.setParameter("applicantId", a.getApplicantId());
         
				List<WorkExperience> listW = queryW.getResultList( );
         
				System.out.println("Work experience:");
				for( WorkExperience w:listW ){
					System.out.print(w.getId().getDateFrom());
					System.out.print("\t");
					System.out.println(w.getDateTo());
					System.out.println(w.getDetails());
				}
         
				Query queryE = entityManager.createNamedQuery("Education.findAllForApplicant");
				queryE.setParameter("applicantId", a.getApplicantId());
         
				List<Education> listE = queryE.getResultList( );
         
				System.out.println("Education:");
				for( Education e:listE ){
					System.out.print(e.getId().getDateFrom());
					System.out.print("\t");
					System.out.println(e.getDateTo());
					System.out.println(e.getDetails());
				}
			}
		} catch (SQLException e) {
			System.out.println("Cannot establish a database connection!");
			e.printStackTrace();
		}*/	
	} // main
} // Class
