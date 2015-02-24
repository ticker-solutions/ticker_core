package solutions.ticker.core.dtos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CityRequest {
	
	private CountryDTO countryDTO;

	public CountryDTO getCountryDTO() {
		return countryDTO;
	}

	public void setCountryDTO(CountryDTO countryDTO) {
		this.countryDTO = countryDTO;
	}
	
	
}
