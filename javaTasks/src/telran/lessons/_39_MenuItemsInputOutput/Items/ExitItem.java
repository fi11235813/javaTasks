package telran.lessons._39_MenuItemsInputOutput.Items;

import telran.lessons._39_MenuItemsInputOutput.api.Item;

public class ExitItem implements Item {

	@Override
	public String displayName() {
		return "Exit";
	}

	@Override
	public void perform() {
		System.out.println("You successfully left");
	}

	@Override
	public boolean isExit() {
		return true;
	}

}
