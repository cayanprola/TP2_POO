import java.util.*;

public class StringField extends Field<String> {
	// T stands for "Type"

	private ArrayList<String> sf = new ArrayList<String>();
	private Validator[] validators;

	// Constructors
	StringField() {

	}

	StringField(String type, Validator v[]) { // Type is the attribute in the form
		super();
		this.validators = v;
	}

	// Getters
	@Override
	public ArrayList<String> getField() {
		return this.sf;
	}

	// Setters
	// Dont need setters for arraylist, use getter + .add instead

	// Methods
	@Override
	public void validateField() {
		for (Validator validator : this.validators) {
			System.out.println(sf + "" + validator.isValid(this.sf.get(0)));
		}
	}

	@Override
	void setData(String string) {
		this.sf.add(string);
		
	}
}
