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
	protected ArrayList<String> errors = new ArrayList<String>();

	// Constructors

	Form() {
		super();
	}

	public String json() {
		String json = "{";

		for (String key : this.map.keySet()) {
			if (json != "{") {
				json += ", ";
			}

			json += "'" + key + "': ";

			if (this.map.get(key).getClass().equals(new NumberField().getClass())) {
				// Number
				json += this.map.get(key).getField().get(0);
			} else {
				// Text
				json += "'" + this.map.get(key).getField().get(0) + "'";
			}
		}

		return json + "}";
	}

	public String content() {
		String form = "<form>\n";
		for (String key : this.map.keySet()) {
			form += "	<label for='" + key + "'>" + key + ":</label>\n";

			// Comparing class of value to know if its a StringField or NumberField.
			String type = "text";
			if (this.map.get(key).getClass().equals(new NumberField().getClass())) {
				type = "number";
			}
			form += "	<input name='" + key + "' type='" + type + "' value='" + this.map.get(key).getField().get(0)
					+ "'/><br>\n";
		}
		form += "</form>";

		return form;
	}

	@SuppressWarnings("unchecked")
	public <T> Field<T> get(String key) {
		// TODO: Add exception if not on keys?
		return (Field<T>) this.map.get(key);
	}

	public void validate() {
		for (String key : this.map.keySet()) {
			ArrayList<String> errors = this.map.get(key).validateField();
			for (String error : errors) {
				this.errors.add(error + " on " + key);
			}
		}
	}

	public void addErrors(String str) {
		errors.add(str);
	}
	// Getters

	// Methods

}
