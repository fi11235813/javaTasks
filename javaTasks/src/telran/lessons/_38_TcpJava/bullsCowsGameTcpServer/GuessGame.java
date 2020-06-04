package telran.lessons._38_TcpJava.bullsCowsGameTcpServer;

public interface GuessGame {
	String startGame();

	String prompt();

	String move(String userInput);

	boolean isFinished();
}
