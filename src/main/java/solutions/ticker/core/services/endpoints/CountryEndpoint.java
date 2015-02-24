package solutions.ticker.core.services.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import solutions.ticker.core.dtos.CountryResponse;
import solutions.ticker.core.managers.impl.CountryManager;


@Path("/countryEndpoint")
public class CountryEndpoint {

	// This method is called if XMLis request
	  @GET
	  @Produces({ MediaType.APPLICATION_JSON })
	  @Consumes({MediaType.APPLICATION_JSON})
	  public CountryResponse getAllSACountries() {	
		  CountryManager countryManager = new CountryManager();
		  return countryManager.getAllSACountries();
	  }
}
