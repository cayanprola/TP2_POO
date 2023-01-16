import java.util.*;

public class NumberField extends Field<Number> {
	// T stands for "Type"
	private ArrayList<Number> nf = new ArrayList<Number>();
	private Validator[] validators;
	// Constructors

	NumberField() {

	}

	NumberField(String type, Validator v[]) { // Type is the attribute in the form
		super();
		this.validators = v;
	}

	// Getters
	@Override
	public ArrayList<Number> getField() {
		return this.nf;
	}

	// Methods
	@Override
	public ArrayList<String> validateField() {
		ArrayList<String> errors = new ArrayList<>();
		for (Validator validator : this.validators) {
			try {
				validator.isValid(this.nf.get(0));
			} catch (ValidationException e) {
				errors.add(e.getMessage());
			}
		}
		return errors;
	}

	@Override
	void setData() {
		int num = sc.nextInt();

		this.nf.add(num);
	}
}
