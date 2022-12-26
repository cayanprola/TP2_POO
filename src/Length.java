
public class Length extends Validator {
	// Used to define the length of the username

	private int length = 0;

	// Constructors
	Length(int newLength) {
		this.length = newLength;
	}

	// Getters
	public int getLength() {
		return this.length;
	}

	// Setters
	public void setLength(int newLength) {
		this.length = newLength;
	}
	// Methods
}
