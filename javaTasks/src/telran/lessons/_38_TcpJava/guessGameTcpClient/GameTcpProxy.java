package telran.lessons._38_TcpJava.guessGameTcpClient;

import telran.lessons._38_TcpJava.net.TcpClientJava;
import java.io.*;

public class GameTcpProxy extends TcpClientJava implements GuessGame {

	public GameTcpProxy(String hostName, int port) {
		super(hostName, port);
	}

	@Override
	public String startGame() {
		return (String) sendRequest("start", "");
	}

	@Override
	public String prompt() {
		return (String) sendRequest("prompt", "");
	}

	@Override
	public String move(String userInput) {

		return (String) sendRequest("move", userInput);
	}

	@Override
	public boolean isFinished() {

		boolean res = sendRequest("is_finished", "");
//		if (res) {
//			try {
//				socket.close();
//			} catch (IOException e) {
//				throw new RuntimeException("Closing socket..." + e.getMessage());
//			}
//		}
		return res;
	}

}
