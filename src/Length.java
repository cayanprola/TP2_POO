
public class Length extends Validator<String>{
	// Used to define the length of the username

	private int min = 0;
	private int max = 0;

	// Constructors
	Length(int min, int max) {
		super();
		this.min = min;
		this.max = max;

	}

	Length(int min) {
		this(min, Integer.MAX_VALUE);
	}

	// Methods
	@Override
	public void isValid(String value) throws ValidationException {
		Integer len = value.length();
		if(len < min || len > max) {
			throw new ValidationException("Error: Invalid length");
		}
	}
}
