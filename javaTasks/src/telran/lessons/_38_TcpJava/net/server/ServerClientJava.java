package telran.lessons._38_TcpJava.net.server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import telran.lessons._38_TcpJava.net.RequestJava;
import telran.lessons._38_TcpJava.net.ResponseJava;

public class ServerClientJava implements Runnable {

	ObjectInputStream input;
	ObjectOutputStream output;
	Socket socket;
	ProtocolJava protocol;

	public ServerClientJava(Socket socket, ProtocolJava protocol) {
		this.socket = socket;
		this.protocol = protocol;

		try {
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {

			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void run() {

		try {
			while (true) {
				RequestJava request = (RequestJava) input.readObject();
				ResponseJava response = protocol.getResponse(request);
				output.writeObject(response);
			}
		} catch (EOFException e) {
			System.out.println("client closed connection");
		}

		catch (Exception e) {
			System.out.println("illegal closing exception");
			throw new RuntimeException(e.getMessage());
		}

	}

}
