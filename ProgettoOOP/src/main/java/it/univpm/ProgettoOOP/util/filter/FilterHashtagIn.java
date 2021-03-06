package it.univpm.ProgettoOOP.util.filter;


import it.univpm.ProgettoOOP.model.Tweet;
import it.univpm.ProgettoOOP.util.other.Filter;
import it.univpm.ProgettoOOP.util.other.Filter2Compare;

/** Questa classe controlla se il tweet che gli viene passato
 *  contiene un numero X di hashtag compreso tra 2 valori, i quali vengono passati tramite param.
 *  
 *  @see Tweet
 *  @see Filter2Compare
 *  @see Filter
 *  
 *  @author Chiara Amalia Caporusso
 *  @author Piero Campitelli
*/

public class FilterHashtagIn extends Filter2Compare implements Filter{
	
	public FilterHashtagIn(Object param) {
		super(param);
	}
	
	public boolean filter(Tweet tweet) {
		for(int i=0; i<tweet.getEntities().size(); i++) {
			if(tweet.getEntities().get(i).getHashtags().size()>= param1 & tweet.getEntities().get(i).getHashtags().size()<= param2)
				return true;
		}
		return false;
	}
}
