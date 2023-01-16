import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.*;

public class ValidatorsTest {

	/* Testes para Password */

	@ParameterizedTest(name = "#{index} - Run test with password = {0}")
	@MethodSource("validPassword")
	void testValidPassword(String password) {
		try {
			new CheckPassword().isValid(password);
		} catch (ValidationException ve) {
			fail(ve.toString());
		}
		assertAll(() -> new CheckPassword().isValid(password));
	}

	@ParameterizedTest(name = "#{index} - Run test with password = {0}")
	@MethodSource("invalidPassword")
	void testInvalidPassword(String password) {
		try {
			new CheckPassword().isValid(password);
		} catch (ValidationException ve) {
			assertNotNull(ve);
		}
	}

	static Stream<String> validPassword() {
		return Stream.of("AAAbbbccc@123",
			"Hello world$123",
			"A!@#&()–a1", // test punctuation part 1
			"A[{}]:;',?/*a1", // test punctuation part 2
			"A~$^+=<>a1", // test symbols
			"0123456789$abcdefgAB", // test 20 chars
			"123Aa$Aa" // test 8 chars
		);
	}

	static Stream<String> invalidPassword() {
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
			""
		); // empty
	}

	/* Testes para Email */

	@ParameterizedTest(name = "#{index} - Run test with email = {0}")
	@MethodSource("validEmail")
	public void testValidEmail(String email) {
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

	static Stream<String> validEmail() {
		return Stream.of("username@domain.com",
				"user.name@domain.com",
				"user-name@domain.com",
				"username@domain.co.in",
				"user_name@domain.com"
		);
	}

	static Stream<String> invalidEmail() {
		return Stream.of("username.@domain.com",
				".user.name@domain.com",
				"user-name@domain.com.",
				"username@.com"
		);
	}

	/* Testes para Length */

	@ParameterizedTest(name = "#{index} - Run test with string = {0}")
	@MethodSource("validLength")
	public void testValidLength(String value) {
		try {
			new Length(3, 15).isValid(value);
		} catch (ValidationException ve) {
			fail(ve.toString());
		}
		assertAll(() -> new Length(3, 15).isValid(value));
	}

	@ParameterizedTest(name = "#{index} - Run test with string = {0}")
	@MethodSource("invalidLength")
	public void testInvalidLength(String value) {
		try {
			new Length(3, 15).isValid(value);
		} catch (ValidationException ve) {
			assertNotNull(ve);
		}
	}

	static Stream<String> validLength() {
		return Stream.of("diogo",
				"cayan",
				"aluno",
				"teste",
				"username1230",
				"root",
				"admin"
		);
	}

	static Stream<String> invalidLength() {
		return Stream.of("",
				"aa",
				"a1",
				"xd",
				".."
		);
	}

	/* Testes para Required */

	@org.junit.jupiter.api.Test
	public void testValidRequired() {
		try {
			new Required().isValid("teste");
		} catch (ValidationException ve) {
			fail(ve.toString());
		}
		assertAll(() -> new Required().isValid("teste"));
	}

	@org.junit.jupiter.api.Test
	public void testInvalidRequired() {
		try {
			new Required().isValid("");
		} catch (ValidationException ve) {
			assertNotNull(ve);
		}
	}

	/* Testes para NumberRange */

	@ParameterizedTest(name = "#{index} - Run test with number = {0}")
	@MethodSource("validNumberRange")
	public void testValidNumberRange(Integer value) {
		try {
			new NumberRange(16, 99).isValid(value);
		} catch (ValidationException ve) {
			fail(ve.toString());
		}
		assertAll(() -> new NumberRange(16, 99).isValid(value));
	}

	@ParameterizedTest(name = "#{index} - Run test with string = {0}")
	@MethodSource("invalidNumberRange")
	public void testInvalidNumberRange(Integer value) {
		try {
			new NumberRange(16, 99).isValid(value);
		} catch (ValidationException ve) {
			assertNotNull(ve);
		}
	}

	static Stream<Integer> validNumberRange() {
		return Stream.of(18,
				54,
				42,
				71,
				33,
				25
		);
	}

	static Stream<Integer> invalidNumberRange() {
		return Stream.of(0,
				-5,
				100,
				9,
				9471
		);
	}

	/* Testes para EqualsVal */

	@org.junit.jupiter.api.Test
	public void testValidEqualsVal() {
		HashMap<String, Field<String>> map = new HashMap<String, Field<String>>();
		map.put("email", new StringField("Email", new Validator[] {}));
		map.get("email").getField().add("teste@gmail.com");

		try {
			new EqualsVal(map.get("email")).isValid("teste@gmail.com");
		} catch (ValidationException ve) {
			fail(ve.toString());
		}
		assertAll(() -> new EqualsVal(map.get("email")).isValid("teste@gmail.com"));
	}

	@org.junit.jupiter.api.Test
	public void testInvalidEqualsVal() {
		HashMap<String, Field<String>> map = new HashMap<String, Field<String>>();
		map.put("email", new StringField("Email", new Validator[] {}));
		map.get("email").getField().add("teste@gmail.com");

		try {
			new EqualsVal(map.get("email")).isValid("error@gmail.com");
		} catch (ValidationException ve) {
			assertNotNull(ve);
		}
	}
}
