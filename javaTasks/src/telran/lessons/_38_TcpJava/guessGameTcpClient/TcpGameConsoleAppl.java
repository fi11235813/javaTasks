package telran.lessons._38_TcpJava.guessGameTcpClient;

import java.io.Closeable;
import java.util.Scanner;

import telran.lessons._38_TcpJava.bullsCowsGameTcpServer.BullsCowsGameImpl;

public class TcpGameConsoleAppl {
	static final String HOST = "localhost";
	static final int PORT = 4000;

	public static void main(String[] args) {
		boolean isTest = args.length > 0 && args[0].contentEquals("test");
		Scanner scanner = new Scanner(System.in);
		GuessGame gameProxy = new GameTcpProxy(HOST, PORT);
		System.out.println(runGames(isTest, scanner, gameProxy));
	}

	private static String runGames(boolean isTest, Scanner scanner, GuessGame gameProxy) {
		String consoleInput;
		String res = "";
		try {
			try {
				while (true) {
					System.out.println("Are you ready to start new game? yes/no");
					consoleInput = scanner.nextLine();
					if (!consoleInput.equals("yes")) {
						break;
					}
					String printForTest = gameProxy.startGame();
					if (isTest) {
						System.out.println(printForTest);
					}
					runGame(scanner, gameProxy);
				}
			} finally {
				if (gameProxy instanceof Closeable)
				((Closeable) gameProxy).close();
			}
		} catch (Exception e) {
			res = e.getMessage();
		}
		return res;
	}

	private static void runGame(Scanner scanner,  GuessGame gameProxy) {
		String consoleInput;
		while (true) {
			System.out.println(gameProxy.prompt());
			consoleInput = scanner.nextLine();
			if (consoleInput.equals("exit")) {
				break;
			}
			System.out.println(gameProxy.move(consoleInput));
			if (gameProxy.isFinished()) {
				break;
			}
		}
	}

}
