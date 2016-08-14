package com.applicant.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/service")
public class WebService {
	
	public static final String PERSISTENCE_UNIT_NAME = "applicant-db";
	
	public static Connection getConnection() throws SQLException{ // public for the use in Test.java
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dbUrl = System.getenv("JDBC_DATABASE_URL");
		return DriverManager.getConnection(dbUrl);
	}

	private EntityManager getEntityManager(String persistenceUnitName) {
		Map<String, String> dbProps = new HashMap<String, String>();
		    
		try {
			Connection connection = getConnection();
			dbProps.put("javax.persistence.jdbc.url", connection.getMetaData().getURL());
			dbProps.put("javax.persistence.jdbc.driver", connection.getClass().getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		        
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, dbProps);
		return entityManagerFactory.createEntityManager();
	}
	
	@GET
    @Produces(MediaType.APPLICATION_XML)
	@Path("/applicants")
	public List<Applicant> getAll() {
		EntityManager entityManager = getEntityManager(PERSISTENCE_UNIT_NAME);
		Query query = entityManager.createNamedQuery("Applicant.findAll");
		return query.getResultList();	    
    }
	    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/applicants/{id}")
    public Applicant getById(@PathParam("id") int id) {
    	EntityManager entityManager = getEntityManager(PERSISTENCE_UNIT_NAME);
       	return entityManager.find(Applicant.class, id);
    }
 
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/applicants/{firstName}/{lastName}")
    public List<Applicant> findByName(@PathParam("firstName") String firstName,
    		                              @PathParam("lastName") String lastName) {
    	EntityManager entityManager = getEntityManager(PERSISTENCE_UNIT_NAME);
        Query query = entityManager.createNamedQuery("Applicant.findByName");
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/applicants/{id}/experience")
    public List<WorkExperience> findWorkExperience(@PathParam("id") int id) {
    	EntityManager entityManager = getEntityManager(PERSISTENCE_UNIT_NAME);
        Query query = entityManager.createNamedQuery("WorkExperience.findAllForApplicant");
        query.setParameter("applicantId", id);
        return query.getResultList();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/applicants/{id}/education")
    public List<Education> findEducation(@PathParam("id") int id) {
    	EntityManager entityManager = getEntityManager(PERSISTENCE_UNIT_NAME);
        Query query = entityManager.createNamedQuery("Education.findAllForApplicant");
        query.setParameter("applicantId", id);
        return query.getResultList();
    }
}
