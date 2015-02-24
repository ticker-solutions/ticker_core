package solutions.ticker.core.dtos;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement
public class CityResponse {

	private ContextResponse contextResponse;
	private List<CityDTO> cityDTOs;
	
	public ContextResponse getContextResponse() {
		return contextResponse;
	}
	public void setContextResponse(ContextResponse contextResponse) {
		this.contextResponse = contextResponse;
	}
	public List<CityDTO> getCityDTOs() {
		return cityDTOs;
	}
	public void setCityDTOs(List<CityDTO> cityDTOs) {
		this.cityDTOs = cityDTOs;
	}

	
	
}
