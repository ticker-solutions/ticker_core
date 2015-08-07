package solutions.ticker.core.db.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="person")
public class PersonEntity {

	@Id
	private Integer person_id;
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="person_type_id")
	private PersonTypeEntity personTypeEntity;
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="team_id")
	private TeamEntity teamEntity;
	private String name;
	private String last_name;
	private String email;	
	@Temporal(TemporalType.DATE)
	private Calendar date_of_birth; 
	private String password;
	
	public Integer getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Integer person_id) {
		this.person_id = person_id;
	}

	public PersonTypeEntity getPersonTypeEntity() {
		return personTypeEntity;
	}

	public void setPersonTypeEntity(PersonTypeEntity personTypeEntity) {
		this.personTypeEntity = personTypeEntity;
	}
	
	public TeamEntity getTeamEntity() {
		return teamEntity;
	}

	public void setTeamEntity(TeamEntity teamEntity) {
		this.teamEntity = teamEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Calendar date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
