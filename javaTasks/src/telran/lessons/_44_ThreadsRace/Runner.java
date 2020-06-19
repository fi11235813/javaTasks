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
		int deltaSleep = MAX_SLEEP_TIME - MIN_SLEEP_TIME + 1;
		for (int i = 0; i < DISTANCE; i++) {
			System.out.println("Runner" + N);
			try {
				sleep((long) (MIN_SLEEP_TIME + Math.random() * deltaSleep));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (winner == null) {
			winner = "Runner" + N;
		}

	}

}
