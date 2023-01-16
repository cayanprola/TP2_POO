import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;


public class FullFormTest {

    private static FullForm generateForm() {
        FullForm ff = new FullForm();
        Field<String> firstname = (Field<String>) ff.map.get("firstname");
        Field<String> lastname = (Field<String>) ff.map.get("lastname");
        Field<String> username = (Field<String>) ff.map.get("username");
        Field<Integer> age = (Field<Integer>) ff.map.get("age");
        Field<String> email = (Field<String>) ff.map.get("email");
        Field<String> confirmemail = (Field<String>) ff.map.get("confirmemail");
        Field<String> password = (Field<String>) ff.map.get("password");
        Field<String> confirmpassword = (Field<String>) ff.map.get("confirmpassword");

        firstname.getField().add("diogo");
        lastname.getField().add("fernandes");
        username.getField().add("diogofern");
        age.getField().add(29);
        email.getField().add("diogofernandes@gmail.com");
        confirmemail.getField().add("diogofernandes@gmail.com");
        password.getField().add("Diogo@123");
        confirmpassword.getField().add("Diogo@123");

        return ff;
    }

    @Test
    void testContent() {
        FullForm ff = generateForm();

        String validContent = "<form>\n" +
            "\t<label for='firstname'>firstname:</label>\n" +
            "\t<input name='firstname' type='text' value='diogo'/><br>\n" +
            "\t<label for='password'>password:</label>\n" +
            "\t<input name='password' type='text' value='Diogo@123'/><br>\n" +
            "\t<label for='confirmpassword'>confirmpassword:</label>\n" +
            "\t<input name='confirmpassword' type='text' value='Diogo@123'/><br>\n" +
            "\t<label for='age'>age:</label>\n" +
            "\t<input name='age' type='number' value='29'/><br>\n" +
            "\t<label for='email'>email:</label>\n" +
            "\t<input name='email' type='text' value='diogofernandes@gmail.com'/><br>\n" +
            "\t<label for='lastname'>lastname:</label>\n" +
            "\t<input name='lastname' type='text' value='fernandes'/><br>\n" +
            "\t<label for='username'>username:</label>\n" +
            "\t<input name='username' type='text' value='diogofern'/><br>\n" +
            "\t<label for='confirmemail'>confirmemail:</label>\n" +
            "\t<input name='confirmemail' type='text' value='diogofernandes@gmail.com'/><br>\n" +
        "</form>";

        assertEquals(validContent, ff.content());
    }

    @Test
    void testJson() {
        FullForm ff = generateForm();

        String validContent = "{'firstname': 'diogo', 'password': 'Diogo@123', 'confirmpassword': 'Diogo@123', 'age': 29, 'email': 'diogofernandes@gmail.com', 'lastname': 'fernandes', 'username': 'diogofern', 'confirmemail': 'diogofernandes@gmail.com'}";

        assertEquals(validContent, ff.json());
    }

    @Test
    void testValidate() {
        FullForm ff = generateForm();
        ff.validate();

        assertEquals(0, ff.errors.size());
    }
}
