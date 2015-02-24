package solutions.ticker.core.dtos;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class CityRequest {
	
	private CountryDTO countryDTO;

	public CountryDTO getCountryDTO() {
		return countryDTO;
	}

	public void setCountryDTO(CountryDTO countryDTO) {
		this.countryDTO = countryDTO;
	}
	
	
}
