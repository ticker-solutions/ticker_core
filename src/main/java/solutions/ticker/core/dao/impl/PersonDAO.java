package solutions.ticker.core.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import solutions.ticker.core.dao.IPersonDAO;
import solutions.ticker.core.db.entities.PersonEntity;
import solutions.ticker.core.dtos.PersonDTO;
import solutions.ticker.core.dtos.PersonRequest;
import solutions.ticker.core.tools.DBSingleton;

public class PersonDAO implements IPersonDAO {

	public PersonEntity signOn(PersonDTO personDTO) throws NoResultException	{
	     
	     Query query = DBSingleton.getEntityManager().createQuery("select p  from PersonEntity p where p.email = ?1 and p.password = ?2");
	     query.setParameter(1, personDTO.getMail());
	     query.setParameter(2, personDTO.getPassword());
	     PersonEntity personEntity = null;
	     
	     personEntity = (PersonEntity)query.getSingleResult();
	     
	     return personEntity;
	}

	
	public List<PersonEntity> getPeopleByTeam(PersonRequest personRequest) throws NoResultException {
		
	     Query query = DBSingleton.getEntityManager().createQuery("select p  from PersonEntity p where p.personTypeEntity.name = ?1 and p.teamEntity.team_id = ?2");
	     query.setParameter(1, personRequest.getPersonDTO().getPersonType());
	     query.setParameter(2, personRequest.getTeamDTO().getTeam_id());
	     
	     return query.getResultList();
	}

}
