package solutions.ticker.core.dtos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContextResponse {

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
