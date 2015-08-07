package solutions.ticker.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import solutions.ticker.core.dao.ICompanyDAO;
import solutions.ticker.core.db.entities.CompanyEntity;
import solutions.ticker.core.tools.DBSingleton;

public class CompanyDAO implements ICompanyDAO {
	

	public List<CompanyEntity> getCompanies() {
		
	     try{
	    	 Query query = DBSingleton.getEntityManager().createQuery("select c from CompanyEntity c");
	    	 
	    	 return query.getResultList();
	     }catch(NoResultException e){
	    	return null;
	     }	   
	}

	public void createCompny(CompanyEntity companyEntity) {
		
	     try{   		    	 
	    	 DBSingleton.getEntityManager().getTransaction().begin();
	    	 DBSingleton.getEntityManager().persist(companyEntity);
	    	 DBSingleton.getEntityManager().getTransaction().commit();	
	     }catch(NoResultException e){
	    	 e.printStackTrace();
	     }	   
		
	}

	public CompanyEntity getCompanyById(Integer companyId) {
		
	     try{
	    	 return DBSingleton.getEntityManager().find(CompanyEntity.class, companyId);
	     }catch(NoResultException e){
	    	return null;
	     }catch (Exception e) {
	    	 return null;
		}	   
	}

	
	public List<CompanyEntity> getAllCompaniesByCity(Integer cityId) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("TickerCorePU");
	     EntityManager em = emf.createEntityManager();
	     	     
	     Query query = em.createQuery("select c from CompanyEntity c where c.cityEntity.city_id =?1");
	     try{
	    	 query.setParameter(1,cityId);
	    	 return query.getResultList();
	     }catch(NoResultException e){
	    	return null;
	     }catch (Exception e) {
	    	 return null;
		}	   
	}

}
