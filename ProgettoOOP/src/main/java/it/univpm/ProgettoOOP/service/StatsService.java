package it.univpm.ProgettoOOP.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import it.univpm.ProgettoOOP.Exception.InternalGeneralException;
import it.univpm.ProgettoOOP.Exception.StatsNotFoundException;
import it.univpm.ProgettoOOP.model.Tweet;
import it.univpm.ProgettoOOP.util.other.StatsCalculator;

/** Rappresenta la classe statica che gestisce i calcoli di statistiche
 * @author Chiara Amalia Caporusso
 * @author Piero Campitelli
*/

public class StatsService {

	/** 
	 * package contenente le classi che implementato l'interfaccia StatsCalculator 
	 */
	private final static String path = "it.univpm.ProgettoOOP.util.stats.";
	
	
	/**
	 * Permette di istanziare un oggetto StatsCalculator dalle classi presenti nel 
	 * package it.univpm.ProgettoOOP.util.stats 
	 * @param     column campo su cui si vuole eseguire la stistica. 
	 * @param     tweets è l'array su cui si vuole eseguire la statistica.
	 * @return    un oggetto che implementa l'interfaccia StatsCalculator.
	 * @throws    StatsNotFoundException per il campo richiesto non è presente un StatsCalculator
	 * 			  nel package. 
	 * @throws    InternalGeneralException errori interni. (se si verifica è necessaria una 
	 * 			  revisione del codice)
	 */
	
	public static StatsCalculator instanceStatsCalculator(String column, ArrayList<Tweet> tweets) 
			throws InternalGeneralException, StatsNotFoundException {
		
		StatsCalculator statsCalculator;
		
	    String ClassStatsName = path.concat("Stats"+column);
	    
	    try {
	    	
	    	Class<?> cls = Class.forName(ClassStatsName); //seleziono la classe
		
	    	Constructor<?> ct = cls.getDeclaredConstructor(ArrayList.class); //seleziono il costruttore
	    
	    	statsCalculator =(StatsCalculator)ct.newInstance(tweets);  //instanzo oggetto StasCalulator
	    }

	    //entra qui se il nome di StatsCalculator non è corretto 
	    catch(ClassNotFoundException e){
	    	throw new StatsNotFoundException("Impossible to calculate statistics for the field: '"
	    			                         +column+"' does not exist");
	    }
		
	    //entra qui se sbagliate maiuscole e minuscole
	    catch(NoClassDefFoundError e){
	    	throw new StatsNotFoundException("Impossible to calculate statistics for the field: '"
	    			+column+"' probably uppercase and lowercase error");
	    }
	    
	    //altri errori interni (lato server)
	    catch( LinkageError | NoSuchMethodException | SecurityException |IllegalArgumentException  
	    	   | InstantiationException | IllegalAccessException | InvocationTargetException e ) {
	    	
	    	e.printStackTrace();
	    	throw new InternalGeneralException("try later");
	    }
	    
	    
	    return statsCalculator;
	    
	}
	
}