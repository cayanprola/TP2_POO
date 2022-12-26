import java.util.*;

public class UsernameForm extends Form {
	

	// Constructors
	UsernameForm() {
		super();
		this.put("username", new StringField("Username", new Validator[] { new Length(3) }));
		this.put("email", new StringField("Email", new Validator[] { new Required() }));
		this.put("age", new NumberField("Age", new Validator[] { new NumberRange(16, 99) }));

	}

	// Getters

	// Setters
	public void setData() {

	}

	// Methods

	public void json() {

	}

	public void content() {
	}

	public void get() {
	}

	public void validate() {

	}

}
