package telran.lessons._39_MenuItemsInputOutput.Items;

import telran.lessons._39_MenuItemsInputOutput.api.InputOutput;
import telran.lessons._39_MenuItemsInputOutput.api.Item;

public class CalculatorItem implements Item {
	InputOutput inputOutput;

	public CalculatorItem(InputOutput inputOutput) {
		super();
		this.inputOutput = inputOutput;
	}

	@Override
	public String displayName() {

		return "Divide two numbers";
	}

	@Override
	public void perform() {
		Integer n1 = inputOutput.inputInteger("Enter number", 1, 100);
		Integer n2 = inputOutput.inputInteger("Enter number", 0, 100);
		inputOutput.display(n1 / n2);

	}

}
