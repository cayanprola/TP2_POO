import java.util.*;

public class Main {

	public static void main(String[] args) {

//		Form<Integer> f = new Form<Integer>();

//		Length l = new Length(5);
//		NumberRange nr = new NumberRange(16, 99);

		/*
		 * Main code do stor Implementar as classes baseado nesse codigo
		 * 
		 */

		UsernameForm form = new UsernameForm();

		form.get("email").setData("tia");
		form.get("email").setData("tia@gmail.com");
		form.get("age").setData(55);
//		form.validate();
//		for (String err : form.errors)
//			System.out.println(err);
//		System.out.println(form.content());
//		System.out.println(form.json());
	}

}
