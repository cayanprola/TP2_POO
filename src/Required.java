
public class Required extends Validator<String> {
	// Used to define values that must not be null, if null = error

	// Constructors
	Required() {
		super();

	}

	// Methods

	@Override
	public void isValid(String str) throws ValidationException {
		if (str.length() == 0) {
			throw new ValidationException("Error: Value is required");
		}
	}
	

}
