package solutions.ticker.core.services.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import solutions.ticker.core.dtos.PersonRequest;
import solutions.ticker.core.dtos.PersonResponse;
import solutions.ticker.core.managers.IPersonManager;
import solutions.ticker.core.managers.impl.PersonManager;

@Path("/loginEndpoint")
public class LoginEndpoint {

	
	 // This method is called if XMLis request
	  @POST
	  @Produces({ MediaType.APPLICATION_JSON })
	  @Consumes({MediaType.APPLICATION_JSON})
	  public PersonResponse login(PersonRequest personRequest) {	
		  IPersonManager personManager = new PersonManager();		  
		  return personManager.signOn(personRequest);
	  }
	
}
