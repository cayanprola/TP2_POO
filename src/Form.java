import java.util.*;

public class Form<T, E> extends HashMap {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6477030723621143010L;
	/**
	 * 
	 */

	protected StringField sf = new StringField();
	protected NumberField nf = new NumberField();
	protected HashMap<T, E> map = new HashMap<T, E>();
	protected Required req = new Required();
	protected Length len = new Length(3);
	protected NumberRange nr = new NumberRange(16, 99);
	ArrayList<String> errors = new ArrayList<String>();

	// Constructors
	Form() {
		super();
	}

	// Getters

	// Methods

	public void validate() {

	}


}
