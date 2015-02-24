package solutions.ticker.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import solutions.ticker.core.dao.ICompanyDAO;
import solutions.ticker.core.db.entities.CompanyEntity;

public class CompanyDAO implements ICompanyDAO {

	public List<CompanyEntity> getCompanies() {
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("TickerCorePU");
	     EntityManager em = emf.createEntityManager();
	     	     
	     Query query = em.createQuery("select c from CompanyEntity c");
	     try{
	    	 return query.getResultList();
	     }catch(NoResultException e){
	    	return null;
	     }	   
	}

}
