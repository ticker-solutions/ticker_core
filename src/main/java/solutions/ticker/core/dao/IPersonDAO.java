package solutions.ticker.core.dao;

import java.util.List;

import javax.persistence.NoResultException;

import solutions.ticker.core.db.entities.PersonEntity;
import solutions.ticker.core.dtos.PersonDTO;
import solutions.ticker.core.dtos.PersonRequest;

public interface IPersonDAO {

	PersonEntity signOn(PersonDTO personDTO) throws NoResultException;	
	
	List<PersonEntity> getPeopleByTeam(PersonRequest personRequest) throws NoResultException;
	
}
