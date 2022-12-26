import java.util.*;

public class StringField extends Field<String> {
	// T stands for "Type"
	private ArrayList<String> sf = new ArrayList<String>();

	// Constructors
	StringField() {

	}

	StringField(String type, Validator v[]) { // Type is the attribute in the form

	}

	// Getters
	@Override
	public ArrayList<String> getField() {
		return this.sf;
	}

	// Setters
	// Dont need setters for arraylist

	// Methods

}
