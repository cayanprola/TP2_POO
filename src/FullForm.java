
public class FullForm extends Form<String, Field<?>> {

	/**
	 * 
	 */

	// Constructors
	FullForm() {
		super();
		this.map.put("firstname", new StringField("FirstName", new Validator[] { new Length(3, 10) }));
		this.map.put("lastname", new StringField("LastName", new Validator[] { new Length(3, 15) }));
		this.map.put("username", new StringField("Username", new Validator[] { new Required(), new Length(3, 10) }));
		this.map.put("age", new NumberField("Age", new Validator[] { new NumberRange(16, 99) }));
		this.map.put("email", new StringField("Email", new Validator[] { new Required(), new CheckEmail() }));
		this.map.put("confirmemail",
				new StringField("ConfirmEmail", new Validator[] { new EqualsVal(this.map.get("email")) }));
		this.map.put("password", new StringField("Password", new Validator[] { new Required(), new CheckPassword() }));
		this.map.put("confirmpassword",
				new StringField("ConfirmPassword", new Validator[] { new EqualsVal(this.map.get("password")) }));

	}

	// Getters

	// Methods

}
