import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class UsernameFormTest {

	private static UsernameForm generateForm() {
		UsernameForm uf = new UsernameForm();
		Field<String> username = (Field<String>) uf.map.get("username");
		Field<String> email = (Field<String>) uf.map.get("email");
		Field<Integer> age = (Field<Integer>) uf.map.get("age");

		username.getField().add("diogo");
		email.getField().add("diogo@gmail.com");
		age.getField().add(29);

		return uf;
	}

	@Test
	void testContent() {
		UsernameForm uf = generateForm();

		String validContent = "<form>\n" +
			"\t<label for='email'>email:</label>\n" +
			"\t<input name='email' type='text' value='diogo@gmail.com'/><br>\n" +
			"\t<label for='age'>age:</label>\n" +
			"\t<input name='age' type='number' value='29'/><br>\n" +
			"\t<label for='username'>username:</label>\n" +
			"\t<input name='username' type='text' value='diogo'/><br>\n" +
		"</form>";

		assertEquals(validContent, uf.content());
	}

	@Test
	void testJson() {
		UsernameForm uf = generateForm();

		String validContent = "{'email': 'diogo@gmail.com', 'age': 29, 'username': 'diogo'}";

		assertEquals(validContent, uf.json());
	}

	@Test
	void testValidate() {
		UsernameForm uf = generateForm();
		uf.validate();

		assertEquals(0, uf.errors.size());
	}
}
