/**
 * 
 */
package PolygonFileVerif;

import java.util.ArrayList;

/**
 * @author Manon
 *
 */
public class Result {
	private boolean value;
	private ArrayList<String> errors;
	
	public Result() {
		this.value = false;
		this.errors = new ArrayList<>();
	}

	/**
	 * @return the value
	 */
	public boolean isValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(boolean value) {
		value = value;
	}

	/**
	 * @return the errors
	 */
	public ArrayList<String> getErrors() {
		return errors;
	}

	/**
	 * @param add an error to the result
	 */
	public void addErrors(String s) {
		errors.add(s);
	}

	
	
	
	
}
