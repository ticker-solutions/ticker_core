package solutions.ticker.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import solutions.ticker.core.dao.ITeamDAO;
import solutions.ticker.core.db.entities.TeamEntity;

public class TeamDAO implements ITeamDAO {

	public List<TeamEntity> getTeams() {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("TickerCorePU");
	     EntityManager em = emf.createEntityManager();
	     	     	     
	     try{
	    	 Query query = em.createQuery("select c from TeamEntity c");
	    	 
	    	 return query.getResultList();
	     }catch(NoResultException e){
	    	return null;
	     }	   
	}

}
