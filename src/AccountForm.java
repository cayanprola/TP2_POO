
public class AccountForm extends Form<String, Field<?>> {

	/**
	 * 
	 */

	// Constructors
	AccountForm() {
		super();
		this.map.put("username", new StringField("Username", new Validator[] { new Required(), new Length(3, 10) }));
		this.map.put("email", new StringField("Email", new Validator[] { new Required(), new CheckEmail() }));
		this.map.put("password", new StringField("Password", new Validator[] { new Required(), new CheckPassword() }));

	}

}
