package telran.lessons._46_ThreadsRace2;

import telran.lessons._46_ThreadsRace2.api.ConsoleInputOutput;
import telran.lessons._46_ThreadsRace2.api.InputOutput;
import telran.lessons._46_ThreadsRace2.api.Item;
import telran.lessons._46_ThreadsRace2.api.Menu;
import telran.lessons._46_ThreadsRace2.items.CompetitionItem;
import telran.lessons._46_ThreadsRace2.items.ExitItem;


public class CompatitionController {
	
	public static void main(String[] args) {
		InputOutput io = new ConsoleInputOutput();
		Item[] items = {
				new CompetitionItem(io),
				new ExitItem(io)
		};
		
		Menu menu = new Menu(items, io);
		menu.run();
	}
	
}
