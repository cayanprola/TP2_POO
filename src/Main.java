import java.util.*;

public class Main {

	public static void main(String[] args) {
		


		/*
		 * Main code do stor Implementar as classes baseado nesse codigo
		 * 
		 */

		UsernameForm form = new UsernameForm();

		form.get("username").setData("tia");
		form.get("email").setData("tia@gmail.com");
		form.get("age").setData(55);
		form.validate();
		
//		for (String err : form.errors)
//			System.out.println(err);
		System.out.println(form.content());
		System.out.println(form.json());
	}

}
