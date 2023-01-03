
public class NumberRange extends Validator<Integer> {
	// Defines the number range in which the age will be accepted, if the value is
	// lower than min or bigger than max returns an error

	private int min = 0;
	private int max = 0;

	NumberRange(int newMin, int newMax) {
		super();
		this.min = newMin;
		this.max = newMax;

	}

	// Constructors
	// Methods
	@Override
	public void isValid(Integer value) throws ValidationException {
		if (value < min || value > max) {
			throw new ValidationException("Error: Invalid number");
		}
	}
}
