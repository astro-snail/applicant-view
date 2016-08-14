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
	
	private Connection getConnection() throws SQLException {
		String dbUrl = System.getenv("JDBC_DATABASE_URL");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
		}
		return DriverManager.getConnection(dbUrl);
	}
	
	private EntityManager getEntityManager(Connection connection) throws SQLException {
		Map<String, String> dbProps = new HashMap<String, String>();
						
		dbProps.put("javax.persistence.jdbc.url", connection.getMetaData().getURL());
		dbProps.put("javax.persistence.jdbc.driver", connection.getClass().getName());
						        
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("applicant-db", dbProps);
		return entityManagerFactory.createEntityManager();
	}
	
	@GET
    @Produces(MediaType.APPLICATION_XML)
	@Path("/applicants")
	public List<Applicant> getAll() {
		Connection connection = null;
		EntityManager entityManager = null;
		List<Applicant> resultList = null;
		try {
			connection = getConnection();
			entityManager = getEntityManager(connection);
			Query query = entityManager.createNamedQuery("Applicant.findAll");
	        resultList = query.getResultList();
		} catch (SQLException e) {
		} finally {
			try { 
				entityManager.close(); 
			} catch (Exception e) {}
			try {
				connection.close(); 
			} catch (Exception e) {}
		}
		return resultList;
	}
	    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/applicants/{id}")
    public Applicant getById(@PathParam("id") int id) {
    	Connection connection = null;
		EntityManager entityManager = null;
		Applicant result = null;
		try {
			connection = getConnection();
			entityManager = getEntityManager(connection);
			result = entityManager.find(Applicant.class, id);
		} catch (SQLException e) {
		} finally {
			try { 
				entityManager.close(); 
			} catch (Exception e) {}
			try {
				connection.close(); 
			} catch (Exception e) {}
		}
		return result;
    }
 
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/applicants/{firstName}/{lastName}")
    public List<Applicant> findByName(@PathParam("firstName") String firstName,
    		                          @PathParam("lastName") String lastName) {
    	Connection connection = null;
		EntityManager entityManager = null;
		List<Applicant> resultList = null;
		try {
			connection = getConnection();
			entityManager = getEntityManager(connection);
			Query query = entityManager.createNamedQuery("Applicant.findByName");
			query.setParameter("firstName", firstName);
	        query.setParameter("lastName", lastName);
	        resultList = query.getResultList();
		} catch (SQLException e) {
		} finally {
			try { 
				entityManager.close(); 
			} catch (Exception e) {}
			try {
				connection.close(); 
			} catch (Exception e) {}
		}
		return resultList;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/applicants/{id}/experience")
    public List<WorkExperience> findWorkExperience(@PathParam("id") int id) {
    	Connection connection = null;
		EntityManager entityManager = null;
		List<WorkExperience> resultList = null;
		try {
			connection = getConnection();
			entityManager = getEntityManager(connection);
			Query query = entityManager.createNamedQuery("WorkExperience.findAllForApplicant");
			query.setParameter("applicantId", id);
	        resultList = query.getResultList();
		} catch (SQLException e) {
		} finally {
			try { 
				entityManager.close(); 
			} catch (Exception e) {}
			try {
				connection.close(); 
			} catch (Exception e) {}
		}
		return resultList;
    }
	    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/applicants/{id}/education")
    public List<Education> findEducation(@PathParam("id") int id) {
    	Connection connection = null;
		EntityManager entityManager = null;
		List<Education> resultList = null;
		try {
			connection = getConnection();
			entityManager = getEntityManager(connection);
			Query query = entityManager.createNamedQuery("Education.findAllForApplicant");
			query.setParameter("applicantId", id);
	        resultList = query.getResultList();
		} catch (SQLException e) {
		} finally {
			try { 
				entityManager.close(); 
			} catch (Exception e) {}
			try {
				connection.close(); 
			} catch (Exception e) {}
		}
		return resultList;
    }
}
