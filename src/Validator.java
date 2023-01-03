
public abstract class Validator {
	// Validates the Length, NumberRange and Required class
	public abstract boolean isValid(Object value);

	// Getters

	// Setters

	// Methods
//	public boolean validateNR(int num, int min, int max) {
//
//		if (num < min) {
//			System.out.println("Error: lower than min.");
//			return false;
//		} else if (num > max) {
//			System.out.println("Error: bigger than max.");
//			return false;
//		} else {
//			System.out.println("Number is in range.");
//			return true;
//		}
//
//	}
//
//	public void validateReq(String str) {
//		
//	}
//
//	public boolean validateLength(int length) {
//
//		if (sf.getField().toString().length() == length) {
//			System.out.println("Range is good.");
//			return true;
//		} else {
//			System.out.println("Error: value not in range.");
//			return false;
//		}
//	}
}
