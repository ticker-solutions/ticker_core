package solutions.ticker.core.managers.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import solutions.ticker.core.db.entities.PersonEntity;
import solutions.ticker.core.dtos.ContextResponse;
import solutions.ticker.core.dtos.PersonRequestDTO;
import solutions.ticker.core.dtos.PersonResponseDTO;
import solutions.ticker.core.managers.IPersonManager;

public class PersonManager implements IPersonManager {
	
	public PersonResponseDTO signOn(PersonRequestDTO personDTO){
		 String status= "";
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("TickerCorePU");
	     EntityManager em = emf.createEntityManager();
	     
	     Query query = em.createQuery("select p  from PersonEntity p where p.email = ?1 and p.password = ?2");
	     query.setParameter(1, personDTO.getMail());
	     query.setParameter(2, personDTO.getPassword());
	     PersonEntity personEntity = null;
	     try{
	    	 personEntity = (PersonEntity)query.getSingleResult();
	     }catch(NoResultException e){
	    	status = "Error"; 
	     }
	     
	     
	     PersonResponseDTO personResponseDTO = new PersonResponseDTO();
	     personResponseDTO.setContextResponse(new ContextResponse());
	     
	     if(personEntity != null){
	    	 status = "Approved";
	    	 personResponseDTO.setToken("siga!");
	    	 personResponseDTO.setPersonType(personEntity.getPersonTypeEntity().getName());
	     }
	     personResponseDTO.getContextResponse().setStatus(status);
	     return personResponseDTO;
	}

	
}
