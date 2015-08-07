package solutions.ticker.core.managers;

import solutions.ticker.core.dtos.TeamRequest;
import solutions.ticker.core.dtos.TeamResponse;

public interface ITeamManager {

	TeamResponse getTeams();
	
	TeamResponse createTeam(TeamRequest teamRequest);
	
	TeamResponse getAllTeamsByCompany(TeamRequest teamRequest);
}
