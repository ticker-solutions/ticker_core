package solutions.ticker.core.db.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class CompanyEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer company_id;
	private String name;
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="city_id")
	private CityEntity cityEntity;
	
	
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
	public CityEntity getCityEntity() {
		return cityEntity;
	}
	public void setCityEntity(CityEntity cityEntity) {
		this.cityEntity = cityEntity;
	}
	
	
}
