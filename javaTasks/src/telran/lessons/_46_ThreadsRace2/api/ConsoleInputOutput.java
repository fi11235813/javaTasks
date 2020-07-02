package telran.lessons._46_ThreadsRace2.api;

import java.util.Scanner;

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
		System.out.print(obj);
	}

}
