package solutions.ticker.core.dtos;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement
public class TeamResponse {
	private ContextResponse contextResponse;
	private List<TeamDTO> teamDTOs;

	public ContextResponse getContextResponse() {
		return contextResponse;
	}

	public void setContextResponse(ContextResponse contextResponse) {
		this.contextResponse = contextResponse;
	}

	public List<TeamDTO> getTeamDTOs() {
		return teamDTOs;
	}

	public void setTeamDTOs(List<TeamDTO> teamDTOs) {
		this.teamDTOs = teamDTOs;
	}

	
}
