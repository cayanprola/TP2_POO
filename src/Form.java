import java.util.*;

public class Form<T> extends HashMap<Object, Object> {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Field<String> sf = new StringField();
	private Field<Number> nf = new NumberField();

	// Constructors
	Form() {

	}

	// Getters

	// Setters
	public void setData(T data) { // Sets the data of the selected attribute

	}

	// Methods

	public void json() {

	}

	public void content() {
	}

	public void get(String type) { // Defines a string for the type of attribute in the form
		if (type == "username") {

		} else if (type == "email") {

		} else if (type == "age") {

		}
	}

	public void validate() {

	}

}
