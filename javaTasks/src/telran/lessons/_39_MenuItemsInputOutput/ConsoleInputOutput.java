package telran.lessons._39_MenuItemsInputOutput;

import java.util.Scanner;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;

public class ConsoleInputOutput implements InputOutput {

	Scanner scanner = new Scanner(System.in);

	@Override
	public String inputString(String prompt) {
		displayLine(prompt);
		String res = scanner.nextLine();
		return res;
	}

	@Override
	public void display(Object obj) {
		System.out.println(obj);
	}

}
