package solutions.ticker.core.managers;

import solutions.ticker.core.dtos.CompanyRequest;
import solutions.ticker.core.dtos.CompanyResponse;

public interface ICompanyManager {

	CompanyResponse getCompanies();
	CompanyResponse createCompany(CompanyRequest companyRequest);
	
}
