package solutions.ticker.core.services.endpoints;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import solutions.ticker.core.dtos.CompanyResponse;
import solutions.ticker.core.tools.FTPHelper;


@Path("/dreamsEndpoint")
public class DreamsEndpoint {

	
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public CompanyResponse getXML(FormDataMultiPart formParams) {	
		
		FTPHelper ftpHelper = new FTPHelper();
		
		List<FormDataBodyPart> parts= formParams.getFields("file");
		for (FormDataBodyPart part : parts) {
		    FormDataContentDisposition file = part.getFormDataContentDisposition();
		    InputStream fileInputStream = part.getValueAs(InputStream.class);
		    
//		    ftpHelper.uploadFile(cartoonifier.processFrame(fileInputStream),file.getFileName());
		}
		
		return null;
	  }
	
	

	  

	  
}
