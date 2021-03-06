package solutions.ticker.core.services.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import solutions.ticker.core.dtos.TeamRequest;
import solutions.ticker.core.dtos.TeamResponse;
import solutions.ticker.core.managers.ITeamManager;
import solutions.ticker.core.managers.impl.TeamManager;

@Path("/teamEndpoint")
public class TeamEndpoint {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public TeamResponse getTeams() {
		TeamManager teamManager = new TeamManager();
		return teamManager.getTeams();
	}

	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public TeamResponse createTeam(TeamRequest teamRequest) {
		ITeamManager teamManager= new TeamManager();
		return teamManager.createTeam(teamRequest);
	}
	
	  @POST
	  @Produces({ MediaType.APPLICATION_JSON })
	  @Consumes({MediaType.APPLICATION_JSON})
	  public TeamResponse getAllTeamsByCompany(TeamRequest teamRequest) {	
		  TeamManager teamManager = new TeamManager();
		  return teamManager.getAllTeamsByCompany(teamRequest);
	  }
	
}
