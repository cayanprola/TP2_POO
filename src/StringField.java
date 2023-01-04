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
	public ArrayList<String> validateField() {
		ArrayList<String> errors = new ArrayList<>();
		for (Validator validator : this.validators) {
			try {
				validator.isValid(this.sf.get(0));
			} catch (ValidationException e) {
				errors.add(e.getMessage());
			}
		}
		return errors;
	}

	@Override
	void setData() {
		String str = sc.next();

		this.sf.add(str);

	}
}
