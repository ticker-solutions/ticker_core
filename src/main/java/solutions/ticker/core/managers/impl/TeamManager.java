package solutions.ticker.core.managers.impl;

import java.util.ArrayList;

import solutions.ticker.core.constant.Status;
import solutions.ticker.core.dao.ITeamDAO;
import solutions.ticker.core.dao.impl.TeamDAO;
import solutions.ticker.core.db.entities.TeamEntity;
import solutions.ticker.core.dtos.CityDTO;
import solutions.ticker.core.dtos.CompanyDTO;
import solutions.ticker.core.dtos.ContextResponse;
import solutions.ticker.core.dtos.CountryDTO;
import solutions.ticker.core.dtos.TeamDTO;
import solutions.ticker.core.dtos.TeamResponse;
import solutions.ticker.core.managers.ITeamManager;

public class TeamManager implements ITeamManager {

	@Override
	public TeamResponse getTeams() {
		TeamResponse teamResponse = new TeamResponse();
		teamResponse.setContextResponse(new ContextResponse());
		
		ArrayList<TeamDTO> teamDTOs = new ArrayList<TeamDTO>();
		String status=Status.APPROVED.toString();
		ITeamDAO teamDAO= new TeamDAO();
		try{
			for(TeamEntity teamEntity: teamDAO.getTeams()){
				//set team infotmation
				TeamDTO teamDTO = new TeamDTO();
				teamDTO.setName(teamEntity.getName());
				//set company information
				CompanyDTO companyDTO = new CompanyDTO();
				companyDTO.setCompany_id(teamEntity.getCompanyEntity().getCompany_id());
				companyDTO.setName(teamEntity.getCompanyEntity().getName());
				teamDTO.setCompanyDTO(companyDTO);
				//set country information
				CountryDTO countryDTO = new CountryDTO();
				countryDTO.setCountry_id(teamEntity.getCompanyEntity().getCityEntity().getCountryEntity().getCountry_id());
				countryDTO.setName(teamEntity.getCompanyEntity().getCityEntity().getCountryEntity().getName());
				teamDTO.setCountryDTO(countryDTO);
				//get city infotmation
				CityDTO cityDTO = new CityDTO();
				cityDTO.setCity_id(teamEntity.getCompanyEntity().getCityEntity().getCity_id());
				cityDTO.setName(teamEntity.getCompanyEntity().getCityEntity().getName());
				teamDTO.setCityDTO(cityDTO);
				// add company dto
				teamDTOs.add(teamDTO);
			}
		}catch(Exception e){
			status=Status.ERROR.toString();
		}
		teamResponse.setTeamDTOs(teamDTOs);
		teamResponse.getContextResponse().setStatus(status);
		
		return teamResponse;
	}

}
