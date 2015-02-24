package solutions.ticker.core.managers.impl;

import java.util.ArrayList;

import solutions.ticker.core.constant.Status;
import solutions.ticker.core.dao.ICompanyDAO;
import solutions.ticker.core.dao.impl.CompanyDAO;
import solutions.ticker.core.db.entities.CompanyEntity;
import solutions.ticker.core.dtos.CompanyDTO;
import solutions.ticker.core.dtos.CompanyResponse;
import solutions.ticker.core.dtos.ContextResponse;
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
