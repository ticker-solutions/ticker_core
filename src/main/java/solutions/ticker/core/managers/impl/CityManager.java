package solutions.ticker.core.managers.impl;

import java.util.ArrayList;
import java.util.List;

import solutions.ticker.core.constant.Status;
import solutions.ticker.core.dao.ICityDAO;
import solutions.ticker.core.dao.impl.CityDAO;
import solutions.ticker.core.db.entities.CityEntity;
import solutions.ticker.core.dtos.CityDTO;
import solutions.ticker.core.dtos.CityRequest;
import solutions.ticker.core.dtos.CityResponse;
import solutions.ticker.core.dtos.ContextResponse;
import solutions.ticker.core.managers.ICityManager;

public class CityManager implements ICityManager {

	public CityResponse getCities(CityRequest cityRequest) {
		CityResponse cityResponse = new CityResponse();
		cityResponse.setContextResponse(new ContextResponse());
		
		ArrayList<CityDTO> cityDTOs = new ArrayList<CityDTO>();
		String status=Status.APPROVED.toString();
		ICityDAO cityDAO = new CityDAO();
		try{
			List<CityEntity> cityEntities = cityDAO.getCities(cityRequest);
			for(CityEntity cityEntity: cityEntities){
				CityDTO cityDTO = new CityDTO();
				cityDTO.setCity_id(cityEntity.getCity_id());
				cityDTO.setName(cityEntity.getName());
				cityDTOs.add(cityDTO);
			}
		}catch(Exception e){
			status=Status.ERROR.toString();
		}
		cityResponse.setCityDTOs(cityDTOs);
		cityResponse.getContextResponse().setStatus(status);
		
		return cityResponse;
	}

}
