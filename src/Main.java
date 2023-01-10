import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Form<String, Field<?>> aform = new AccountForm();
	static Form<String, Field<?>> uform = new UsernameForm();

	public static void main(String[] args) {
		formSelect();

	}

	public void menu() {

	}

	public static void formSelect() {
		int op;
		System.out.println("Digite qual formulário deseja: ");
		System.out.println("1-UsernameForm 2-AccountForm.");
		op = sc.nextInt();
		switch (op) {
		case 1:
			fillUser();
			break;
		case 2:
			fillAcc();
			break;
		default:
			formSelect();
		}
	}

	public static void fillUser() {
		System.out.println("Insira um username de até 10 caracteres: ");
		uform.get("username").setData();
		System.out.println("Insira um email: ");
		uform.get("email").setData();
		System.out.println("Insira a idade: ");
		uform.get("age").setData();
		uform.validate();

		for (String err : uform.errors)
			System.out.println(err);
		System.out.println(uform.content());
		System.out.println(uform.json());
	}

	public static void fillAcc() {
		System.out.println("Insira um username de até 10 caracteres: ");
		aform.get("username").setData();
		System.out.println("Insira um email: ");
		aform.get("email").setData();
		System.out.println("Insira uma senha de no minimo 8 caracteres e no maximo 20.");
		System.out.println(
				"Deve possuir pelo menos um número, uma letra minúscula, uma letra maiúscula e um caracter especial.");
		aform.get("password").setData();
		aform.validate();

		for (String err : aform.errors)
			System.out.println(err);
		System.out.println(aform.content());
		System.out.println(aform.json());
	}
}
