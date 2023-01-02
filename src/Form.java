import java.util.*;

public class Form<T, E> extends HashMap {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6477030723621143010L;
	/**
	 * 
	 */
	
	protected StringField sf = new StringField();
	protected NumberField nf = new NumberField();
	protected HashMap<T, E> map = new HashMap<T, E>();

	// Constructors
	Form() {
		super();
	}

	// Getters

//	public HashMap<String, Field<String>> getMap() {
//		return map;
//	}
//
//	public HashMap<String, Field<Number>> getMapNum() {
//		return map;
//	}

	// Setters
//	public void setMap(HashMap<String, Field<String>> map) {
//		this.map = map;
//	}
//
//	public void setMapNum(HashMap<String, Field<Number>> map) {
//		this.mapNum = map;
//	}

	// Methods

	public void json() {

	}

	public void content() {
	}

	public void validate() {
		
	}

	public void errors() {

	}

}
