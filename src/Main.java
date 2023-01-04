import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static AccountForm aform = new AccountForm();
	static UsernameForm uform = new UsernameForm();

	public static void main(String[] args) {
		formSelect();
		/*
		 * Main code do stor Implementar as classes baseado nesse codigo
		 * 
		 */

	}

	public void menu() {

	}

	public static void formSelect() {
		String op;
		System.out.println("Digite qual formulário deseja: ");
		System.out.println("UsernameForm ou AccountForm.");
		op = sc.next();
		switch (op) {
		case "UsernameForm":
			fillU();
			break;
		case "AccountForm":
			fillA();
			break;
		}
	}

	public static void fillU() {
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

	public static void fillA() {
		System.out.println("Insira um username de até 10 caracteres: ");
		aform.get("username").setData();
		System.out.println("Insira um email: ");
		aform.get("email").setData();
		System.out.println("Insira uma senha de no minimo 8 caracteres e no maximo 20.");
		System.out.println("Deve possuir pelo menos um número, uma letra minúscula, uma letra maiúscula e um caracter especial.");
		aform.get("password").setData();
		aform.validate();

		for (String err : aform.errors)
			System.out.println(err);
		System.out.println(aform.content());
		System.out.println(aform.json());
	}
}
