package solutions.ticker.core.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import solutions.ticker.core.dao.ICountryDAO;
import solutions.ticker.core.db.entities.CountryEntity;
import solutions.ticker.core.tools.DBSingleton;

public class CountryDAO implements ICountryDAO  {

	public List<CountryEntity> getSACountries() throws NoResultException {	
	    Query query = DBSingleton.getEntityManager().createQuery("select c from CountryEntity c where c.continent =?1");    
	    query.setParameter(1, "SA");
	    return query.getResultList();
	}

}
