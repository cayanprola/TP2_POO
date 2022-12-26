
public class NumberRange extends Validator {
	// Defines the number range in which the age will be accepted, if the value is
	// lower than min or bigger than max returns an error
	
	Field<Number> n = new NumberField();

	NumberRange(int min, int max) {

		int n = 0;
		
		if (n < min) {
			System.out.println("Error: less than min\r\n" + "");
		} else if (n > max) {
			System.out.println("Error: more than max\r\n" + "");
		}
	}
	// Constructors
	// Getters
	// Setters
	// Methods

}
