import java.util.*;

public class Main {

	public static void main(String[] args) {
		


		/*
		 * Main code do stor Implementar as classes baseado nesse codigo
		 * 
		 */

		UsernameForm form = new UsernameForm();

		form.get("username").setData("");
		form.get("email").setData("");
		form.get("age").setData(50);
		form.validate();
		
		for (String err : form.errors)
			System.out.println(err);
		System.out.println(form.content());
		System.out.println(form.json());
	}

}
