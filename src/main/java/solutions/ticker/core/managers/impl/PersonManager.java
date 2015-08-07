package solutions.ticker.core.managers.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import solutions.ticker.core.constant.Status;
import solutions.ticker.core.dao.IPersonDAO;
import solutions.ticker.core.dao.impl.PersonDAO;
import solutions.ticker.core.db.entities.PersonEntity;
import solutions.ticker.core.dtos.ContextResponse;
import solutions.ticker.core.dtos.PersonDTO;
import solutions.ticker.core.dtos.PersonRequest;
import solutions.ticker.core.dtos.PersonResponse;
import solutions.ticker.core.managers.IPersonManager;

public class PersonManager implements IPersonManager {
	
	public PersonResponse signOn(PersonRequest personRequest)  {
		 
		 String status= "";		 
		 IPersonDAO personDAO = new PersonDAO();
		 PersonEntity personEntity=null;
		 try{
			 personEntity = personDAO.signOn(personRequest.getPersonDTO());
		 }catch(NoResultException e){
			 status=Status.ERROR.name();
		 }catch(Exception e){
			 status=Status.ERROR.name();
		 }
		 
	     
	     PersonResponse personResponse = new PersonResponse();
	     personResponse.setContextResponse(new ContextResponse());
	     
	     if(!status.equals(Status.ERROR.name())){
	    	 status = Status.APPROVED.name();
	    	 PersonDTO personDTO = new PersonDTO();
	    	 personDTO.setPersonType(personEntity.getPersonTypeEntity().getName());
	    	 personDTO.setToken("siga!");
	    	 personResponse.setPersonDTO(personDTO);
	     }
	     personResponse.getContextResponse().setStatus(status);
	     return personResponse;
	}

	
	public PersonResponse getPeopleByTeam(PersonRequest personRequest) {
		 String status= "";		 
		 IPersonDAO personDAO = new PersonDAO();
		 List<PersonEntity> personEntities = null;
		 try{
			 personEntities = personDAO.getPeopleByTeam(personRequest);			 
		 }catch(NoResultException e){
			 status=Status.ERROR.name();
		 }catch(Exception e){
			 status=Status.ERROR.name();
		 }
		 
	     
	     PersonResponse personResponse = new PersonResponse();
	     personResponse.setContextResponse(new ContextResponse());
	     
	     if(!status.equals(Status.ERROR.name())){
	    	 List<PersonDTO> personDTOs = new ArrayList<PersonDTO>();
	    	 for(PersonEntity personEntity: personEntities){
		    	 PersonDTO personDTO = new PersonDTO();
		    	 personDTO.setName(personEntity.getName());
		    	 personDTO.setLast_name(personEntity.getLast_name());
		    	 personDTO.setMail(personEntity.getEmail());
		    	 personDTOs.add(personDTO);
			 }
	    	 status = Status.APPROVED.name();

	    	 personResponse.setPersonDTOs(personDTOs);
	     }
	     personResponse.getContextResponse().setStatus(status);
	     return personResponse;
	}

}
