package solutions.ticker.core.services.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import solutions.ticker.core.dtos.TeamResponse;
import solutions.ticker.core.managers.impl.TeamManager;

@Path("/teamEndpoint")
public class TeamEndpoint {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public TeamResponse getCompanies() {
		TeamManager teamManager = new TeamManager();
		return teamManager.getTeams();
	}
}
