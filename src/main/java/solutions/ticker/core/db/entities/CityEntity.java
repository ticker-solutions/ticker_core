package solutions.ticker.core.db.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class CityEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int city_id;
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="country_id")
	private CountryEntity countryEntity;
	private String name;
	private long population;
	
	
	
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public CountryEntity getCountryEntity() {
		return countryEntity;
	}
	public void setCountryEntity(CountryEntity countryEntity) {
		this.countryEntity = countryEntity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	
	
	
}
