
public class NumberRange extends Validator {
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
	public boolean isValid(Object value) {
		if (value == null) {
			return true;
		}
		int number = (int) value;
		return number >= min && number <= max;
	}

	public boolean validateNR(int num) {
		String str;
		if (num < this.min) {
			str = "Error: lower than min.";
			return false;
		} else if (num > this.max) {
			str = "Error: bigger than max.";
			return false;
		} else {
			return true;
		}

	}
}
