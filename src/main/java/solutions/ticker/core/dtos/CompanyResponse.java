package solutions.ticker.core.dtos;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement
public class CompanyResponse {

	private ContextResponse contextResponse;
	private List<CompanyDTO> companyDTOs;
	
	public ContextResponse getContextResponse() {
		return contextResponse;
	}
	public void setContextResponse(ContextResponse contextResponse) {
		this.contextResponse = contextResponse;
	}
	public List<CompanyDTO> getCompanyDTOs() {
		return companyDTOs;
	}
	public void setCompanyDTOs(List<CompanyDTO> companyDTOs) {
		this.companyDTOs = companyDTOs;
	}
	
	
	
}
