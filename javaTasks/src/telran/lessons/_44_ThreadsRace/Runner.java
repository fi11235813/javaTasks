package telran.lessons._44_ThreadsRace;

public class Runner extends Thread {
	private final int N;
	private final int MIN_SLEEP_TIME = 2;
	private final int MAX_SLEEP_TIME = 5;
	private final int DISTANCE;
	public static String winner = null;

	public Runner(int n, int d) {
		this.N = n;
		this.DISTANCE = d;
	}

	@Override
	public void run() {

		for (int i = 0; i < DISTANCE; i++) {
			System.out.println("Runner" + N);
			try {
				sleep(randomNumber(MIN_SLEEP_TIME, MAX_SLEEP_TIME));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (winner == null) {
			winner = "Runner" + N;
		}

	}

	private long randomNumber(int minSleepTime, int maxSleepTime) {
		return (long) (minSleepTime + Math.random() * (maxSleepTime - minSleepTime));
	}

}
