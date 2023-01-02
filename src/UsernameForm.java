import java.util.*;

public class UsernameForm extends Form<String, Field<?>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7339335965446308580L;

	// Constructors
	UsernameForm() {
		super();
		this.map.put("username", new StringField("Username", new Validator[] { new Length(3) }));
		this.map.put("email", new StringField("Email", new Validator[] { new Required() }));
		this.map.put("age", new NumberField("Age", new Validator[] { new NumberRange(16, 99) }));
	}

	// Getters

	// Methods

	public void json() {

	}

	public void content() {
	}

	public Field<String> get(String key) {
		// TODO: Add exception if not on keys?
		if (this.map.containsKey(key)) {
			return (Field<String>) this.map.get(key);
		}
		return (Field<String>) this.map.get(key);
	}

	public void validate() {

	}
}
