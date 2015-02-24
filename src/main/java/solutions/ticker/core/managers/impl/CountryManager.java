package solutions.ticker.core.managers.impl;

import java.util.ArrayList;
import java.util.List;

import solutions.ticker.core.constant.Status;
import solutions.ticker.core.dao.impl.CountryDAO;
import solutions.ticker.core.db.entities.CountryEntity;
import solutions.ticker.core.dtos.ContextResponse;
import solutions.ticker.core.dtos.CountryDTO;
import solutions.ticker.core.dtos.CountryResponse;
import solutions.ticker.core.managers.ICountryManager;

public class CountryManager implements ICountryManager {

	public CountryResponse getAllSACountries() {
		CountryResponse countryResponse = new CountryResponse();
		countryResponse.setContextResponse(new ContextResponse());
		
		String status=Status.APPROVED.toString();
		List<CountryDTO> countryDTOs = new ArrayList<CountryDTO>();
		
		CountryDAO countryDAO = new CountryDAO();
		List<CountryEntity> countryEntities = countryDAO.getSACountries();
		try{
			for(CountryEntity countryEntity: countryEntities){
				CountryDTO countryDTO = new CountryDTO();
				countryDTO.setCountry_id(countryEntity.getCountry_id());
				countryDTO.setName(countryEntity.getName());
				countryDTOs.add(countryDTO);
			}
		}catch(Exception e){
			status=Status.ERROR.toString();
		}
		
		countryResponse.getContextResponse().setStatus(status);
		countryResponse.setCountryDTOs(countryDTOs);
		
		return countryResponse;
	}

}
