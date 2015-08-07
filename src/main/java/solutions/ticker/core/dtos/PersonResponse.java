package solutions.ticker.core.dtos;

import java.util.List;

public class PersonResponse {

	private ContextResponse contextResponse;
	private PersonDTO personDTO;
	private List<PersonDTO> personDTOs;

	public ContextResponse getContextResponse() {
		return contextResponse;
	}

	public void setContextResponse(ContextResponse contextResponse) {
		this.contextResponse = contextResponse;
	}

	public PersonDTO getPersonDTO() {
		return personDTO;
	}

	public void setPersonDTO(PersonDTO personDTO) {
		this.personDTO = personDTO;
	}

	public List<PersonDTO> getPersonDTOs() {
		return personDTOs;
	}

	public void setPersonDTOs(List<PersonDTO> personDTOs) {
		this.personDTOs = personDTOs;
	}
	
}
