package telran.lessons._46_ThreadsRace2.dto;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.locks.Lock;

import telran.lessons._46_ThreadsRace2.CompetitionResult;
import telran.lessons._46_ThreadsRace2.Result;

public class Runner extends Thread {
	private final int MIN_SLEEP_TIME = 2;
	private final int MAX_SLEEP_TIME = 5;
	private final Lock runnerLock;
	private final String name = getName();
	private Competition<Result> competition;
	
	public Runner(Competition<Result> competition, Lock runnerLock) {
		this.competition = competition;
		this.runnerLock = runnerLock;
	}

	@Override
	public void run() {
		int deltaSleep = MAX_SLEEP_TIME - MIN_SLEEP_TIME + 1;
		for (int i = 0; i < competition.getDISTANCE(); i++) {
			System.out.println(name);
			try {
				sleep((long) (MIN_SLEEP_TIME + Math.random() * deltaSleep));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		runnerLock.lock();
		try 
		{
			//System.err.println(name);
			fillResultTable();
		} 
		finally 
		{
			runnerLock.unlock();
		}

		
	}

	private void fillResultTable() {
		long time = ChronoUnit.MILLIS.between(competition.getStart(), Instant.now());
		competition.getResultsTable().add(new CompetitionResult(name, time));
	}
}
