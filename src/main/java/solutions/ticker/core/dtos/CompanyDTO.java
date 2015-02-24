package solutions.ticker.core.dtos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CompanyDTO {
	
	private Integer company_id;
	private String name;
	
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
