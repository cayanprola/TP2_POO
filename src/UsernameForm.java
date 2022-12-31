import java.util.*;

public class UsernameForm extends Form<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7339335965446308580L;

	// Constructors
	UsernameForm() {
		super();
		this.map.put("username", new StringField("Username", new Validator[] { new Length(3) }));
		this.map.put("email", new StringField("Email", new Validator[] { new Required() }));
		this.mapNum.put("age", new NumberField("Age", new Validator[] { new NumberRange(16, 99) }));

	}

	// Getters

	// Setters
	@Override
	public void setData() { // Sets the data of the selected attribute

		getMapNum().put("age", nf);
		setMapNum(getMapNum());
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

	public void outputForm() {

	}
}
