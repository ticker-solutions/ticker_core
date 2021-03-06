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

//Plain old Java Object it does not extend as class or implements 
//an interface

//The class registers its methods for the HTTP GET request using the @GET annotation. 
//Using the @Produces annotation, it defines that it can deliver several MIME types,
//text, XML and HTML. 

//The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/personEndpoint")
public class PersonEndpoint {
	
	 // This method is called if XMLis request
	  @POST
	  @Produces({ MediaType.APPLICATION_JSON })
	  @Consumes({MediaType.APPLICATION_JSON})
	  public PersonResponse getPeopleByTeam(PersonRequest personRequest) {	
		  IPersonManager personManager = new PersonManager();		  
		  return personManager.getPeopleByTeam(personRequest);
	  }
	  
	  
	  
	
	
}
