package solutions.ticker.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import solutions.ticker.core.db.entities.CityEntity;
import solutions.ticker.core.db.entities.CountryEntity;
import solutions.ticker.core.db.entities.PersonEntity;

public class DateUploader {

	public static void main(String[] args){
		populateCities();
	}
	
	
	public static void populateCities(){
		int count = 0;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TickerCorePU");
	     EntityManager em = emf.createEntityManager();
	     EntityTransaction et= em.getTransaction();
		
		Path wiki_path = Paths.get("C:/Users/gnewball/Desktop", "cities15000.txt");
		String[] cities = null;
		try {
			cities = new String(Files.readAllBytes(wiki_path)).split("\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String city: cities){
			 String[] cityFields = city.split("\t");
			 CountryEntity countryEntity = null;
		     Query query = em.createQuery("select c from CountryEntity c where c.iso=?1");
		     try{
		    	 query.setParameter(1, cityFields[8]);	 
		    	 countryEntity = (CountryEntity)query.getSingleResult();
		     }catch(NoResultException e){
			     System.err.println(e);
		    	 System.err.println(cityFields[8] + "didn't found");
		     }	
		     
		     CityEntity cityEntity = new CityEntity();
		     cityEntity.setName(cityFields[2]);
		     cityEntity.setCountryEntity(countryEntity);
		     cityEntity.setPopulation(new Long(cityFields[14]));
		     try{
			     et.begin();
			     em.persist(cityEntity);
			     if(et !=null){
			    	 et.commit();
			     }
			    }catch(Exception e){
			    	System.err.println(e);
			    }
		     System.out.println(++count);
		}
	}
	
	public static void populateCountries(){
		int counter = 0;
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("TickerCorePU");
	     EntityManager em = emf.createEntityManager();
	     EntityTransaction et= em.getTransaction();
		
		Path wiki_path = Paths.get("C:/Users/gnewball/Desktop", "countryInfo.txt");
		String[] countries = null;
		try {
			countries = new String(Files.readAllBytes(wiki_path)).split("\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String country: countries){
			String[] countryFields = country.split("\t");
			if(!country.startsWith("#")){
					     CountryEntity countryntity = new CountryEntity();
					     countryntity.setName(countryFields[4]);
					     countryntity.setIso(countryFields[0]);
					     countryntity.setContinent(countryFields[8]);
					     try{
					     et.begin();
					     em.persist(countryntity);
					     if(et !=null){
					    	 et.commit();
					    	 
					     }
					    }catch(Exception e){
					    	System.err.println(e);
					    	System.out.println(countryFields[0] +" "+ countryFields[4]);
					    }
			}
			System.out.println(++counter);
		}
		
		
	}
}
