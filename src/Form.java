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
	protected HashMap<String, Field<?>> map = new HashMap<String, Field<?>>();
	protected Required req = new Required();
	protected Length len = new Length(3, 10);
	protected NumberRange nr = new NumberRange(16, 99);
	protected CheckEmail ce = new CheckEmail();
	protected ArrayList<String> errors = new ArrayList<String>();
	
	
	// Constructors
	
	Form() {
		super();
	}

	// Getters

	// Methods

	


}
