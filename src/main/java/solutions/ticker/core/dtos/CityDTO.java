package solutions.ticker.core.dtos;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class CityDTO {
	
	private Integer city_id;
	private String name;
	
	public Integer getCity_id() {
		return city_id;
	}
	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
