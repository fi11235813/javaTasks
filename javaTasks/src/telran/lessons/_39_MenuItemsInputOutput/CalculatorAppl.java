package telran.lessons._39_MenuItemsInputOutput;

import telran.lessons._39_MenuItemsInputOutput.Items.CalculatorItem;
import telran.lessons._39_MenuItemsInputOutput.Items.ExitItem;
import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._39_MenuItemsInputOutput.api.Item;
import telran.lessons._39_MenuItemsInputOutput.api.Menu;

public class CalculatorAppl {
	static InputOutput inputOutput = new ConsoleInputOutput();

	public static void main(String[] args) {
		Item[] items = { new CalculatorItem(inputOutput), new ExitItem() };

		Menu menu = new Menu(items, inputOutput);
		menu.menuRun();

	}
}
