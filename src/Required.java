
public class Required extends Validator<String> {
	// Used to define values that must not be null, if null = error

	// Constructors
	Required() {
		super();

	}

	// Methods

	@Override
	public boolean isValid(String str) {
		if (str.length() <= 0) {
			return false;
		} else
			return true;
	}
	

}
