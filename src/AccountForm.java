import java.io.*;
import java.util.*;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

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

	// Getters

	// Methods

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

	public void tipoField() {

	}

}
