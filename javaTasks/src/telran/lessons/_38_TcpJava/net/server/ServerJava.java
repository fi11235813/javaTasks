package telran.lessons._38_TcpJava.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerJava implements Runnable {

	ProtocolJava protocol;
	ServerSocket serverSocket;
	int port;

	public ServerJava(ProtocolJava protocol, int port) {
		super();
		this.protocol = protocol;
		this.port = port;
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				Socket socket = serverSocket.accept();
				ServerClientJava client = new ServerClientJava(socket, protocol);
				client.run();
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

}
