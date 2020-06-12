package telran.lessons._40_EmployeesClientApplication.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerJava implements Runnable {
	private ProtocolJava protocol;
	private ServerSocket serverSocket;

	public ServerJava(ProtocolJava protocol, int port) {
		this.protocol = protocol;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Server is listening on port " + port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				Socket socket = serverSocket.accept();
				new ServerClientJava(socket, protocol).run();
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
