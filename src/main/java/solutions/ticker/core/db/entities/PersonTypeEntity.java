package solutions.ticker.core.db.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person_type")
public class PersonTypeEntity {

	@Id
	private Integer person_type_id;
	private String name;
	
	
	public Integer getPerson_type_id() {
		return person_type_id;
	}
	public void setPerson_type_id(Integer person_type_id) {
		this.person_type_id = person_type_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
