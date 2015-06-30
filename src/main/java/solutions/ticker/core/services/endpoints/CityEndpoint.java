package solutions.ticker.core.services.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import solutions.ticker.core.dtos.CityRequest;
import solutions.ticker.core.dtos.CityResponse;
import solutions.ticker.core.managers.impl.CityManager;


@Path("/cityEndpoint")
public class CityEndpoint {

	// This method is called if XMLis request
		  @POST
		  @Produces({ MediaType.APPLICATION_JSON })
		  @Consumes({MediaType.APPLICATION_JSON})
		  public CityResponse getXML(final CityRequest cityRequest) {	
			  CityManager cityManager = new CityManager();
			  return cityManager.getCities(cityRequest);
		  }
		  
}
