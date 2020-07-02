package telran.lessons._46_ThreadsRace2.items;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import telran.lessons._46_ThreadsRace2.CompetitionService;
import telran.lessons._46_ThreadsRace2.Result;
import telran.lessons._46_ThreadsRace2.api.InputOutput;
import telran.lessons._46_ThreadsRace2.api.Item;
import telran.lessons._46_ThreadsRace2.dto.Competition;
import telran.lessons._46_ThreadsRace2.dto.Runner;

public class CompetitionItem implements Item {

	InputOutput io;

	public CompetitionItem(InputOutput io) {
		this.io = io;
	}

	@Override
	public String displayName() {
		return "New compatition";
	}

	@Override
	public void perform() {
		String name = io.inputName("Enter Name of Competition");
		int numberOfRunners = io.inputInteger("Enter number of runners in range 2 - 100 per.", 2, 100);
		int distance = io.inputInteger("Enter distance in range 10 - 42195 m", 10, 42195);

		var comp = new Competition<Result>(name, distance);

		Runner[] runners = new Runner[numberOfRunners];
		Lock runnerLock = new ReentrantLock(true);
		for (int i = 0; i < runners.length; i++) {
			runners[i] = new Runner(comp, runnerLock);
		}

		var compService = new CompetitionService(comp, runners);

		compService.start();
		compService.waitUntilEveryoneFinishes();

		compService.displayResultTable();
	}

}
