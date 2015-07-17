package solutions.ticker.core.services.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import solutions.ticker.core.dtos.CompanyRequest;
import solutions.ticker.core.dtos.CompanyResponse;
import solutions.ticker.core.managers.impl.CompanyManager;


@Path("/companyEndpoint")
public class CompanyEndpoint {

	// This method is called if XMLis request
		  @GET
		  @Produces({ MediaType.APPLICATION_JSON })
		  @Consumes({MediaType.APPLICATION_JSON})
		  public CompanyResponse getCompanies() {	
			  CompanyManager companyManager = new CompanyManager();
			  return companyManager.getCompanies();
		  }
		  
		  
		  @PUT
		  @Produces({ MediaType.APPLICATION_JSON })
		  @Consumes({MediaType.APPLICATION_JSON})
		  public CompanyResponse createCompany(CompanyRequest companyRequest) {	
			  CompanyManager companyManager = new CompanyManager();
			  return companyManager.createCompany(companyRequest);
		  }
		  
		  @POST
		  @Produces({ MediaType.APPLICATION_JSON })
		  @Consumes({MediaType.APPLICATION_JSON})
		  public CompanyResponse getAllCompaniesByCity(CompanyRequest companyRequest) {	
			  CompanyManager companyManager = new CompanyManager();
			  return companyManager.getAllCompaniesByCity(companyRequest);
		  }
	
}
