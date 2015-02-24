package solutions.ticker.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import solutions.ticker.core.dao.ICountryDAO;
import solutions.ticker.core.db.entities.CountryEntity;

public class CountryDAO implements ICountryDAO {

	public List<CountryEntity> getSACountries() {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("TickerCorePU");
	     EntityManager em = emf.createEntityManager();
	     	     
	     Query query = em.createQuery("select c from CountryEntity c where c.continent =?1");
	     try{
	    	 query.setParameter(1, "SA");
	    	 return query.getResultList();
	     }catch(NoResultException e){
	    	return null;
	     }	   
	}

}
