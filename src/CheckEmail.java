import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckEmail extends Validator<String> {

	@Override
	public boolean isValid(String str) {
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
