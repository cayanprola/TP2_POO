
public class Length extends Validator {
	// Used to define the length of the username

	private int length = 0;
	private String str;

	// Constructors
	Length(int newLength) {
		super();
		this.length = newLength;
//        if (validateLength(str, length) == false) {
//
//        }

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
