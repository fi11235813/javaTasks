package telran.lessons._44_ThreadsRace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadsRaceAppl {

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of runners");
		int numberOfRunners = getNumberOfInput(in);
		System.out.println("Enter distance");
		int distance = getNumberOfInput(in);

		Runner[] runners = new Runner[numberOfRunners];
		for (int i = 0; i < runners.length; i++) {
			runners[i] = new Runner(distance);
		}

		for (int i = 0; i < runners.length; i++) {
			runners[i].start();
		}

		for (int i = 0; i < runners.length; i++) {
			runners[i].join();
		}

		System.out.println("Congratulations " + Runner.winner + " you are the champion!");
	}

	private static int getNumberOfInput(BufferedReader in) {
		int res = 0;
		while (res == 0) {
			try {
				res = Integer.parseInt(in.readLine());

			} catch (NumberFormatException e) {
				System.out.println("Not a number, try again...");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}

}
