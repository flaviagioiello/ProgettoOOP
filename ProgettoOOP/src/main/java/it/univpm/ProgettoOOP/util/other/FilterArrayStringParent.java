package it.univpm.ProgettoOOP.util.other;

import java.util.ArrayList;



public class FilterArrayStringParent {

	protected ArrayList<String> param = new ArrayList<String>();

	
	/** Costruttore 
	 * @param parametri deve essere un ArrayList String.
	 * @throws IllegalArgumentException parametri non è del tipo richiesto. 
	*/
	public FilterArrayStringParent(Object parameters) {
		
		if(parameters instanceof ArrayList<?>) {
			
			for(Object ele : (ArrayList<?>)parameters) {
				
				if(ele instanceof String) {
					param.add((String)ele);
				}else {
					throw new IllegalArgumentException("Type: String ");
				}
			}

		}else {			
			throw new IllegalArgumentException("Type: Array ");
		}
	}
	
	
	/** Set 
	 * @param parametri deve essere un ArrayList di stringhe
	 * @throws IllegalArgumentException parametri non è del tipo richiesto. 
	*/
	public void SetParametriFiltro(Object parameters) {
		
		
		if(parameters instanceof ArrayList<?>) {
			
			for(Object ele : (ArrayList<?>)parameters) {
				
				if(ele instanceof String) {
					param.add((String)ele);
				}else {
					throw new IllegalArgumentException("Type: String ");
				}
			}

		}else {			
			throw new IllegalArgumentException("Type: Array ");
		}
	}
	
	
}
