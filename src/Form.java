import java.util.*;

public class Form<T> extends HashMap<String, Field<T>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6477030723621143010L;
	/**
	 * 
	 */

	protected StringField sf = new StringField();
	protected NumberField nf = new NumberField();
	protected HashMap<String, Field<String>> map = new HashMap<String, Field<String>>();
	protected HashMap<String, Field<Number>> mapNum = new HashMap<String, Field<Number>>();
	// Constructors
	Form() {
		super();
	}

	// Getters

	public HashMap<String, Field<String>> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Field<String>> map) {
		this.map = map;
	}
	
	public HashMap<String, Field<Number>> getMapNum() {
		return mapNum;
	}

	public void setMapNum(HashMap<String, Field<Number>> map) {
		this.mapNum = map;
	}

	// Setters
	public void setData() { // Sets the data of the selected attribute
		
		
	}

	// Methods

	public void json() {

	}

	public void content() {
	}

	public void get() { // Defines a string for the type of attribute in the form
	}

	public void validate() {

	}
	public void errors() {
		
	}

}
