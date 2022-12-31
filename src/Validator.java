import java.util.*;

public class Validator {
	// Validates the Length, NumberRange and Required class
	Scanner sc = new Scanner(System.in);

	// Constructors

	// Getters

	// Setters

	// Methods
	public boolean validateNR(int num, int min, int max) {

		if (num < min) {
			System.out.println("Error: lower than min.");
			return false;
		} else if (num > max) {
			System.out.println("Error: bigger than max.");
			return false;
		} else {
			System.out.println("Number is in range.");
			return true;
		}

	}

	public void validateReq(String str, String at) {
		at = "@";
		if (str.length() == 0) {
			System.out.println("Error: Value empty.");
		} else {
			if (str.contains(at)) {
				System.out.println("Valid email");
			} else
				System.out.println("Error");
		}

	}

	public boolean validateLength(String str, int length) {
		if (str.length() == length) {
			System.out.println("Range is good.");
			return true;
		} else {
			System.out.println("Error: value not in range.");
			return false;
		}
	}
}
