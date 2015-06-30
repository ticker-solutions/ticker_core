package solutions.ticker.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import solutions.ticker.core.dao.ICityDAO;
import solutions.ticker.core.db.entities.CityEntity;
import solutions.ticker.core.dtos.CityRequest;

public class CityDAO implements ICityDAO {

	public List<CityEntity> getCities(CityRequest cityRequest) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("TickerCorePU");
	     EntityManager em = emf.createEntityManager();
	     	     
	     Query query = em.createQuery("select c from CityEntity c where c.countryEntity.country_id =?1 and c.population > ?2");
	     try{
	    	 query.setParameter(1,cityRequest.getCountryDTO().getCountry_id());
	    	 query.setParameter(2,1000000);
	    	 return query.getResultList();
	     }catch(NoResultException e){
	    	return null;
	     }catch (Exception e) {
	    	 return null;
		}	   
	}

	@Override
	public CityEntity getCityById(Integer cityId) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("TickerCorePU");
	     EntityManager em = emf.createEntityManager();
	     
	     try{
	    	 return em.find(CityEntity.class, cityId);
	     }catch(NoResultException e){
	    	return null;
	     }catch (Exception e) {
	    	 return null;
		}	   
	}

}
