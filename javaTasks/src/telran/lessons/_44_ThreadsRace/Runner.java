package telran.lessons._44_ThreadsRace;

import java.util.concurrent.atomic.AtomicBoolean;

public class Runner extends Thread {
	private final int MIN_SLEEP_TIME = 2;
	private final int MAX_SLEEP_TIME = 5;
	private final int DISTANCE;
	private final String ID = getName();
	volatile static String winner = null;
	public static AtomicBoolean isWinner = new AtomicBoolean(false);

	public Runner(int d) {
		this.DISTANCE = d;
	}

	@Override
	public void run() {
		int deltaSleep = MAX_SLEEP_TIME - MIN_SLEEP_TIME + 1;
		for (int i = 0; i < DISTANCE; i++) {
			System.out.println(ID);
			try {
				sleep((long) (MIN_SLEEP_TIME + Math.random() * deltaSleep));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(isWinner.compareAndSet(false, true)) {
			winner = ID;
		}
	}

}
