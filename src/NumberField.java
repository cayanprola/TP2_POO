import java.util.*;

public class NumberField extends Field<Number> {
	// T stands for "Type"
	private ArrayList<Number> nf = new ArrayList<Number>();
	// Constructors

	NumberField() {

	}

	NumberField(String type, Validator v[]) { // Type is the attribute in the form
		super();
	}

	// Getters
	@Override
	public ArrayList<Number> getField() {
		return this.nf;
	}

	// Methods
	@Override
	public void validateField() {

	}

	@Override
	void setData(Number num) {
		this.nf.add(num);
		System.out.println(nf);
	}
}
