package telran.lessons._46_ThreadsRace2;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Runner extends Thread {
	private final int MIN_SLEEP_TIME = 2;
	private final int MAX_SLEEP_TIME = 5;
	private final int DISTANCE;
	private final String name = getName();
	volatile static StringBuilder sb = new StringBuilder();
	volatile static Instant start;
	volatile static int place;

	public Runner(int d) {
		this.DISTANCE = d;
	}

	@Override
	public void run() {
		int deltaSleep = MAX_SLEEP_TIME - MIN_SLEEP_TIME + 1;
		for (int i = 0; i < DISTANCE; i++) {
			System.out.println(name);
			try {
				sleep((long) (MIN_SLEEP_TIME + Math.random() * deltaSleep));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		fillResultTable(name, ChronoUnit.MILLIS.between(start, Instant.now()));
	}

	private static synchronized void fillResultTable(String id, long time) {
		place++;
		sb.append(place).append(". ").append(id).append(" ").append(time).append("\n");
	}
}
