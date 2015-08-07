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
import solutions.ticker.core.tools.DBSingleton;

public class CityDAO implements ICityDAO {

	public List<CityEntity> getCities(CityRequest cityRequest) {
		 
	     Query query = DBSingleton.getEntityManager().createQuery("select c from CityEntity c where c.countryEntity.country_id =?1 and c.population > ?2");
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

	public CityEntity getCityById(Integer cityId) {
		
	     try{
	    	 return DBSingleton.getEntityManager().find(CityEntity.class, cityId);
	     }catch(NoResultException e){
	    	return null;
	     }catch (Exception e) {
	    	 return null;
		}	   
	}

}
