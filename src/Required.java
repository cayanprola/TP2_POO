import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Required extends Validator {
	// Used to define values that must not be null, if null = error

	// Constructors
	Required() {
		super();

	}

	// Methods
	@Override
	public boolean isValid(Object value) {
		return value != null && !value.toString().isEmpty();
	}

	public boolean validate(String str) {
		String regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches() == true) {
			return true;
		} else {
			return false;
		}
	}
}
