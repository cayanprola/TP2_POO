import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static Form<String, Field<?>> aform = new AccountForm();
	static Form<String, Field<?>> uform = new UsernameForm();
	static Form<String, Field<?>> fform = new FullForm();

	public static void main(String[] args) {
		formSelect();
	}

	public void menu() {

	}

	public static void formSelect() {
		int op;
		System.out.println("Digite qual formulário deseja: ");
		System.out.println("1-UsernameForm 2-AccountForm 3-FullForm.");
		op = sc.nextInt();
		switch (op) {
		case 1:
			fillUser();
			break;
		case 2:
			fillAcc();
			break;
		case 3:
			fillFull();
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

	public static void fillFull() {
		System.out.println("Insira seu primeiro nome: ");
		fform.get("firstname").setData();
		System.out.println("Insira seu ultimo nome: ");
		fform.get("lastname").setData();
		System.out.println("Insira um username de até 10 caracteres: ");
		fform.get("username").setData();
		System.out.println("Insira a idade: ");
		fform.get("age").setData();
		System.out.println("Insira um email: ");
		fform.get("email").setData();
		System.out.println("Confirme o email: ");
		fform.get("confirmemail").setData();
		System.out.println("Insira uma senha de no minimo 8 caracteres e no maximo 20.");
		System.out.println(
				"Deve possuir pelo menos um número, uma letra minúscula, uma letra maiúscula e um caracter especial.");
		fform.get("password").setData();
		System.out.println("Confirme a sua senha: ");
		fform.get("confirmpassword").setData();
		fform.validate();

		for (String err : fform.errors)
			System.out.println(err);
		System.out.println(fform.content());
		System.out.println(fform.json());
	}
}

//cayanprola@gmail.com
//2Dfasjba23@