package solutions.ticker.core.dao;

import java.util.List;

import solutions.ticker.core.db.entities.CountryEntity;

public interface ICountryDAO {

	public List<CountryEntity> getSACountries();
	
}
