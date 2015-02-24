package solutions.ticker.core.dtos;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class CountryDTO {

	private Integer country_id;
	private String name;
	
	
	public Integer getCountry_id() {
		return country_id;
	}
	public void setCountry_id(Integer country_id) {
		this.country_id = country_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
