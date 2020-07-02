package telran.lessons._46_ThreadsRace2;

import java.time.Instant;

import telran.lessons._46_ThreadsRace2.dto.Competition;
import telran.lessons._46_ThreadsRace2.dto.Runner;

public class CompetitionService {
	private Competition<Result> competition;
	private Runner[] runners;
	
	public CompetitionService(Competition<Result> competition, Runner[] runners) {
		super();
		this.competition = competition;
		this.runners = runners;
	}
	
	public void start() {
		competition.setStart(Instant.now());
		for (int i = 0; i < runners.length; i++) {
			runners[i].start();
		}
	}
	
	public void waitUntilEveryoneFinishes() {
		for (int i = 0; i < runners.length; i++) {
			try {
				runners[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void displayResultTable() {
		System.out.println(" Place\t\t Name\t       Time");
		var results = competition.getResultsTable();
		
		for (int i = 0; i < results.size(); i++) {
			String str = String.format("  %s\t\t%s\t%d", i + 1, results.get(i).getName(), results.get(i).getTime());
			System.out.println(str);
		}
	}
	
}
