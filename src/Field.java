import java.util.*;

abstract class Field<T> {
	protected Scanner sc = new Scanner(System.in);
	// Testar usando interface e implements
	// T stands for "Type"
	// Constructors

	// Getters

	// Methods
	
	abstract ArrayList<T> getField();

	abstract ArrayList<String> validateField();
 
	abstract void setData();

}
