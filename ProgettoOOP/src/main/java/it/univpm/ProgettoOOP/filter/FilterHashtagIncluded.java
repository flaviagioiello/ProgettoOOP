package it.univpm.ProgettoOOP.filter;

import it.univpm.ProgettoOOP.model.Entities;
import it.univpm.ProgettoOOP.model.Hashtag;
import it.univpm.ProgettoOOP.model.Tweet;
import it.univpm.ProgettoOOP.other.Filter1Compare;
import it.univpm.ProgettoOOP.other.Filter;

public class FilterHashtagIncluded extends Filter1Compare implements Filter{
	public FilterHashtagIncluded(Object paramCompare) {
		super(paramCompare);
	}
	
	public boolean filter(Tweet tweet) {
		Hashtag hashtags = new Hashtag();
		if((hashtags.getText()).equals(tweet.getEntities()) {
			return true;
	}
		return false;
		
	}
}
