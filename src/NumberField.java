import java.util.*;

public class NumberField extends Field<Number> {
	// T stands for "Type"
	private ArrayList<Number> nf = new ArrayList<Number>();
	private Validator[] validators;
	// Constructors

	NumberField() {

	}

	NumberField(String type, Validator v[]) { // Type is the attribute in the form
		super();
		this.validators = v;
	}

	// Getters
	@Override
	public ArrayList<Number> getField() {
		return this.nf;
	}

	// Methods
	@Override
	public void validateField() {
		for (Validator validator : this.validators) {
			System.out.println(nf + "" + validator.isValid(this.nf.get(0)));
		}
	}

	@Override
	void setData(Number num) {
		this.nf.add(num);
	}
}
