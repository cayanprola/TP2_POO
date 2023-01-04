import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPassword extends Validator<String> {

	@Override
	public void isValid(String str) throws ValidationException {
		String regex =
	            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches() == false) {
			throw new ValidationException("Error: Password is not valid");
		}
	}

}
