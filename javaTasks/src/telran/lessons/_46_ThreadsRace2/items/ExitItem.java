package telran.lessons._46_ThreadsRace2.items;

import telran.lessons._46_ThreadsRace2.api.InputOutput;
import telran.lessons._46_ThreadsRace2.api.Item;

public class ExitItem implements Item {

	InputOutput io;

	public ExitItem(InputOutput io) {
		this.io = io;
	}

	@Override
	public String displayName() {
		return "Exit";
	}

	@Override
	public void perform() {
		
	}

	@Override
	public boolean isExit() {
		return true;
	}

}
