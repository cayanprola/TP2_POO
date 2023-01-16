import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;


public class AccountFormTest {
    private static AccountForm generateForm() {
        AccountForm af = new AccountForm();
        Field<String> username = (Field<String>) af.map.get("username");
        Field<String> email = (Field<String>) af.map.get("email");
        Field<String> password = (Field<String>) af.map.get("password");

        username.getField().add("cayan");
        email.getField().add("cayangamer@gmail.com");
        password.getField().add("Cayan123!");

        return af;
    }

    @Test
    void testContent() {
        AccountForm af = generateForm();

        String validContent = "<form>\n" +
            "\t<label for='password'>password:</label>\n" +
            "\t<input name='password' type='text' value='Cayan123!'/><br>\n" +
            "\t<label for='email'>email:</label>\n" +
            "\t<input name='email' type='text' value='cayangamer@gmail.com'/><br>\n" +
            "\t<label for='username'>username:</label>\n" +
            "\t<input name='username' type='text' value='cayan'/><br>\n" +
        "</form>";

        assertEquals(validContent, af.content());
    }

    @Test
    void testJson() {
        AccountForm af = generateForm();

        String validContent = "{'password': 'Cayan123!', 'email': 'cayangamer@gmail.com', 'username': 'cayan'}";

        assertEquals(validContent, af.json());
    }

    @Test
    void testValidate() {
        AccountForm af = generateForm();
        af.validate();

        assertEquals(0, af.errors.size());
    }
}
