package telran.lessons._38_TcpJava.bullsCowsGameTcpServer;

import java.io.IOException;

import telran.lessons._38_TcpJava.net.server.ServerJava;

public class TcpBullsCowsAppl {

	private static final int PORT = 4000;

	public static void main(String[] args) throws IOException {
		GuessGame game = new BullsCowsGameImpl();
		ProtocolJavaImpl protocolJava = new ProtocolJavaImpl(game);
		ServerJava serverJava = new ServerJava(protocolJava, PORT);
		System.out.println("Server is listening on port " + PORT);
		serverJava.run();
	}
}
