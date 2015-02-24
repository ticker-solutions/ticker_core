package solutions.ticker.core.managers;

import solutions.ticker.core.dtos.CityRequest;
import solutions.ticker.core.dtos.CityResponse;

public interface ICityManager {
	public CityResponse getCities(CityRequest cityRequest);		
}
