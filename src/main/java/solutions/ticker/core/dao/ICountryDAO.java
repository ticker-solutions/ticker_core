package solutions.ticker.core.dao;

import java.util.List;

import javax.persistence.NoResultException;

import solutions.ticker.core.db.entities.CountryEntity;

public interface ICountryDAO {

	public List<CountryEntity> getSACountries() throws NoResultException;
	
}
