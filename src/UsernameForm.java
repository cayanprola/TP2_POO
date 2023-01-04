
public class UsernameForm extends Form<String, Field<?>> {

	/**
	 * 
	 */

	// Constructors
	UsernameForm() {
		super();
		this.map.put("username", new StringField("Username", new Validator[] { new Required(), new Length(3, 10) }));
		this.map.put("email", new StringField("Email", new Validator[] { new Required(), new CheckEmail() }));
		this.map.put("age", new NumberField("Age", new Validator[] { new NumberRange(16, 99) }));

	}

	// Getters

	// Methods

}