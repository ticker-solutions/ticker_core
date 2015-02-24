package solutions.ticker.core.dtos;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class PersonResponseDTO {

	private ContextResponse contextResponse;
	private String token;
	private String personType;
	
	public ContextResponse getContextResponse() {
		return contextResponse;
	}
	public void setContextResponse(ContextResponse contextResponse) {
		this.contextResponse = contextResponse;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPersonType() {
		return personType;
	}
	public void setPersonType(String personType) {
		this.personType = personType;
	}
	
	
	
	
}
