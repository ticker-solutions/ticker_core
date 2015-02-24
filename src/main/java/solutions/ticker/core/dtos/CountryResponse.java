package solutions.ticker.core.dtos;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class CountryResponse {

	private ContextResponse contextResponse;
	private List<CountryDTO> countryDTOs;
	
	
	public ContextResponse getContextResponse() {
		return contextResponse;
	}
	public void setContextResponse(ContextResponse contextResponse) {
		this.contextResponse = contextResponse;
	}
	public List<CountryDTO> getCountryDTOs() {
		return countryDTOs;
	}
	public void setCountryDTOs(List<CountryDTO> countryDTOs) {
		this.countryDTOs = countryDTOs;
	}
	
	
	
}
