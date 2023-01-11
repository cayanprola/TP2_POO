import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ValidatorsTest {

	@ParameterizedTest(name = "#{index} - Run test with password = {0}")
	@MethodSource("validPasswordProvider")
	void test_password_regex_valid(String password) {
		try {
			new CheckPassword().isValid(password);
		} catch (ValidationException ve) {
			fail(ve.toString());
		}
		assertAll(() -> new CheckPassword().isValid(password));
	}

	@ParameterizedTest(name = "#{index} - Run test with password = {0}")
	@MethodSource("invalidPasswordProvider")
	void test_password_regex_invalid(String password) {
		try {
			new CheckPassword().isValid(password);
		} catch (ValidationException ve) {
			assertNotNull(ve);
		}
	}

	static Stream<String> validPasswordProvider() {
		return Stream.of("AAAbbbccc@123", "Hello world$123", "A!@#&()–a1", // test punctuation part 1
				"A[{}]:;',?/*a1", // test punctuation part 2
				"A~$^+=<>a1", // test symbols
				"0123456789$abcdefgAB", // test 20 chars
				"123Aa$Aa" // test 8 chars
		);
	}

	static Stream<String> invalidPasswordProvider() {
		return Stream.of("12345678", // invalid, only digit
				"abcdefgh", // invalid, only lowercase
				"ABCDEFGH", // invalid, only uppercase
				"abc123$$$", // invalid, at least one uppercase
				"ABC123$$$", // invalid, at least one lowercase
				"ABC$$$$$$", // invalid, at least one digit
				"java REGEX 123", // invalid, at least one special character
				"java REGEX 123 %", // invalid, % is not in the special character group []
				"________", // invalid
				"--------", // invalid
				" ", // empty
				""); // empty
	}

	static Stream<String> validEmail() {
		return Stream.of("username@domain.com", "user.name@domain.com", "user-name@domain.com", "username@domain.co.in",
				"user_name@domain.com");
	}

	static Stream<String> invalidEmail() {
		return Stream.of("username.@domain.com", ".user.name@domain.com", "user-name@domain.com.", "username@.com");
	}

	@ParameterizedTest(name = "#{index} - Run test with email = {0}")
	@MethodSource("validEmail")
	public void testUsingRFC5322Regex(String email) {
		try {
			new CheckEmail().isValid(email);
		} catch (ValidationException ve) {
			fail(ve.toString());
		}
		assertAll(() -> new CheckEmail().isValid(email));
	}

	@ParameterizedTest(name = "#{index} - Run test with email = {0}")
	@MethodSource("invalidEmail")
	public void testInvalidEmail(String email) {
		try {
			new CheckEmail().isValid(email);
		} catch (ValidationException ve) {
			assertNotNull(ve);
		}
	}

}
