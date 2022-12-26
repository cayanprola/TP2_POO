import java.util.*;

public class NumberField extends Field<Number> {
	// T stands for "Type"
	private ArrayList<Number> nf = new ArrayList<Number>();
	// Constructors

	NumberField() {

	}

	NumberField(String type, Validator v[]) { // Type is the attribute in the form

	}

	// Getters
	@Override
	public ArrayList<Number> getField() {
		return this.nf;
	}

	// Setters
	// Methods
}
