package it.univpm.ProgettoOOP.util.filter;

import it.univpm.ProgettoOOP.model.Tweet;
import it.univpm.ProgettoOOP.util.other.Filter;
import it.univpm.ProgettoOOP.util.other.FilterArrayStringParent;

public class FilterLangIncluded extends FilterArrayStringParent implements Filter {

	public FilterLangIncluded(Object parametri) {                                  
		super(parametri);
	}
	
	public boolean filter(Tweet tweet) {
		for(String p: param) {
			if(tweet.getLang().equals(p)) {
				return true;
			}
		}
		return false;
	}
}