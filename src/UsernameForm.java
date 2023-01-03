import java.io.*;
import java.util.*;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

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

		}
		if (req.isValid((String) this.map.get("email").getField().get(0)) == false) {
			this.addErrors("Error: Invalid email.");
		} 
		if (nr.isValid((int) this.map.get("age").getField().get(0)) == false) {
			this.addErrors("Errors: Invalid age");
		}
	}

	public void addErrors(String str) {
		errors.add(str);
	}
	
	

	public void printmap() {
		for (String key : this.map.keySet()) {
			System.out.println(key + ": " + this.map.get(key).getField());
		}
	}

}
