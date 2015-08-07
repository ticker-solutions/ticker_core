package solutions.ticker.core.tools;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBSingleton {

	private static EntityManager em;
	
	public static EntityManager getEntityManager(){
		   
		 if(em == null){
			 EntityManagerFactory emf = Persistence.createEntityManagerFactory("TickerCorePU");
		     em = emf.createEntityManager();
		 }else{
			 return em;
		 }
		 return em;
		 
	}
	
}
