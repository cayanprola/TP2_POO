
public class EqualsVal extends Validator<String> {
	private Field<?> str;

	EqualsVal(Field<?> newStr) {
		this.str = newStr;

	}

	@Override
	public void isValid(String value) throws ValidationException {
		if (!value.equals(this.str.getField().get(0)))  {
			throw new ValidationException("Error: Values don't match");
		}
	}
}