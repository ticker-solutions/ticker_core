package solutions.ticker.core.db.test.integration;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import solutions.ticker.core.db.entities.CompanyEntity;
import solutions.ticker.core.db.entities.PersonEntity;


public class PersonTest {

	@Test
	public void maria_db_jpa_connection(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TickerCorePU");
        emf.createEntityManager();
        assertTrue(emf.isOpen());
	}
	
	@Test
	public void testPersonCreation(){
//		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("TickerCorePU");
//	     EntityManager em = emf.createEntityManager();
//	     EntityTransaction et= em.getTransaction();
//	     
//	     CompanyEntity companyEntity = em.find(CompanyEntity.class, 1);
//
//	     PersonEntity personEntity = new PersonEntity();
//	     personEntity.setDate_of_birth(Calendar.getInstance());
//	     personEntity.setEmail("gnewball11@gmail.com");
//	     personEntity.setName("Garry");
//	     personEntity.setLast_name("Newball");
//	     personEntity.setPassword("fdsds3342");
//	     
//	     et.begin();
//	     em.persist(personEntity);
//	     if(et !=null){
//	    	 et.commit();
//	     }
	 }	
	
	
	@Test
	public void testFindPersonsbyCriteria(){
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("TickerCorePU");
	     EntityManager em = emf.createEntityManager();
	     
	     Query query = em.createQuery("select p  from PersonEntity p where p.email = ?1 and p.password = ?2");
	     query.setParameter(1, "gnewball11@gmail.com");
	     query.setParameter(2, "newarch11*");
	     
	     PersonEntity personEntity = (PersonEntity)query.getSingleResult();
	     System.out.println(personEntity.getPersonTypeEntity().getName());
	 }
	
	
	
}
