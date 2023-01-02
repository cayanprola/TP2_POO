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

	@SuppressWarnings("unchecked")
	public <T> Field<T> get(String key) {
		// TODO: Add exception if not on keys?
		return (Field<T>) this.map.get(key);
	}

	public void validate() {
		for (String key : this.map.keySet()) {
			System.out.println(key + ": " + this.map.get(key).getField());
		}
		
//		new Length(3).validateLength(3);
	}
}
