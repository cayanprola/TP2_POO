import java.util.*;

public class NumberField extends Field<Integer> {
	// T stands for "Type"
	private ArrayList<Integer> nf = new ArrayList<Integer>();
	// Constructors

	NumberField() {

	}

	NumberField(String type, Validator v[]) { // Type is the attribute in the form
		super();
	}

	// Getters
	@Override
	public ArrayList<Integer> getField() {
		return this.nf;
	}

	// Methods
	@Override
	public void validateField() {

	}

	@Override
	void setData(Integer num) {
		this.nf.add(num);
	}
}
