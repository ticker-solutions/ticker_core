package solutions.ticker.core.db.test.integration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import solutions.ticker.core.db.entities.CompanyEntity;

public class CompanyTest {

	@Test
	public void testCompanyCreation(){
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("TickerCorePU");
	     EntityManager em = emf.createEntityManager();
	     EntityTransaction et= em.getTransaction();
	     
	     CompanyEntity companyEntity = new CompanyEntity();
	     companyEntity.setName("Ticker");
	     companyEntity.setCountry("Colombia");
	     companyEntity.setCity("Medellin");
	     
	     et.begin();
	     em.persist(companyEntity);
	     if(et !=null){
	    	 et.commit();
	     }
	}
}
