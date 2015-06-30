package solutions.ticker.core.dao;

import java.util.List;

import solutions.ticker.core.db.entities.CityEntity;
import solutions.ticker.core.dtos.CityRequest;

public interface ICityDAO {

	public List<CityEntity> getCities(CityRequest cityRequest);
	
	public CityEntity getCityById(Integer cityId);
	
}
