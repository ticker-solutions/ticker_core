package solutions.ticker.core.managers.impl;

import java.util.ArrayList;
import java.util.List;

import solutions.ticker.core.constant.Status;
import solutions.ticker.core.dao.ICityDAO;
import solutions.ticker.core.dao.ICompanyDAO;
import solutions.ticker.core.dao.impl.CityDAO;
import solutions.ticker.core.dao.impl.CompanyDAO;
import solutions.ticker.core.db.entities.CityEntity;
import solutions.ticker.core.db.entities.CompanyEntity;
import solutions.ticker.core.dtos.CityDTO;
import solutions.ticker.core.dtos.CompanyDTO;
import solutions.ticker.core.dtos.CompanyRequest;
import solutions.ticker.core.dtos.CompanyResponse;
import solutions.ticker.core.dtos.ContextResponse;
import solutions.ticker.core.dtos.CountryDTO;
import solutions.ticker.core.managers.ICompanyManager;

public class CompanyManager implements ICompanyManager {

	
	
	public CompanyResponse getCompanies() {
		CompanyResponse companyResponse = new CompanyResponse();
		companyResponse.setContextResponse(new ContextResponse());
		
		ArrayList<CompanyDTO> companyDTOs = new ArrayList<CompanyDTO>();
		String status=Status.APPROVED.toString();
		ICompanyDAO companyDAO = new CompanyDAO();
		try{
			for(CompanyEntity companyEntity: companyDAO.getCompanies()){
				//get company information
				CompanyDTO companyDTO = new CompanyDTO();
				companyDTO.setCompany_id(companyEntity.getCompany_id());
				companyDTO.setName(companyEntity.getName());
				//get country information
				CountryDTO countryDTO = new CountryDTO();
				countryDTO.setCountry_id(companyEntity.getCityEntity().getCountryEntity().getCountry_id());
				countryDTO.setName(companyEntity.getCityEntity().getCountryEntity().getName());
				companyDTO.setCountryDTO(countryDTO);
				//get city infotmation
				CityDTO cityDTO = new CityDTO();
				cityDTO.setCity_id(companyEntity.getCityEntity().getCity_id());
				cityDTO.setName(companyEntity.getCityEntity().getName());
				companyDTO.setCityDTO(cityDTO);
				// add company dto
				companyDTOs.add(companyDTO);
			}
		}catch(Exception e){
			status=Status.ERROR.toString();
		}
		companyResponse.setCompanyDTOs(companyDTOs);
		companyResponse.getContextResponse().setStatus(status);
		
		return companyResponse;
	}


	public CompanyResponse createCompany(CompanyRequest companyRequest) {
		CompanyResponse companyResponse = new CompanyResponse();
		companyResponse.setContextResponse(new ContextResponse());
		
		String status=Status.APPROVED.toString();
		ICompanyDAO companyDAO = new CompanyDAO();
		ICityDAO cityDAO = new CityDAO();
		try{			
			CompanyEntity companyEntity = new CompanyEntity();
			CityEntity cityEntity = cityDAO.getCityById(companyRequest.getCompanyDTO().getCityDTO().getCity_id());
			cityEntity.setCountryEntity(null);
			companyEntity.setCityEntity(cityEntity);
			companyEntity.setName(companyRequest.getCompanyDTO().getName());
			companyDAO.createCompny(companyEntity);
		}catch(Exception e){
			e.printStackTrace();
			status=Status.ERROR.toString();
		}
		companyResponse.getContextResponse().setStatus(status);
		
		return companyResponse;
	}


	
	public CompanyResponse getAllCompaniesByCity(CompanyRequest companyRequest) {
		CompanyResponse companyResponse = new CompanyResponse();
		companyResponse.setContextResponse(new ContextResponse());
		
		ArrayList<CompanyDTO> companyDTOs = new ArrayList<CompanyDTO>();
		String status=Status.APPROVED.toString();
		ICompanyDAO companyDAO = new CompanyDAO();
		try{
			List<CompanyEntity> companyEntities = companyDAO.getAllCompaniesByCity(companyRequest.getCompanyDTO().getCityDTO().getCity_id());
			for(CompanyEntity companyEntity: companyEntities){
				CompanyDTO companyDTO = new CompanyDTO();
				companyDTO.setCompany_id(companyEntity.getCompany_id());
				companyDTO.setName(companyEntity.getName());
				companyDTOs.add(companyDTO);
			}
		}catch(Exception e){
			status=Status.ERROR.toString();
		}
		companyResponse.setCompanyDTOs(companyDTOs);
		companyResponse.getContextResponse().setStatus(status);
		
		return companyResponse;
	}

}
